package UNIDAD_1.BoletinXML.Ej2.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import UNIDAD_1.BoletinXML.Ej2.Models.Producto;

public class XMLDomProductos {
	private static final String RUTA_RESOURCES = "src/main/resources/";
	public Document getDocumentFromXML(String nombreFichero) {
		// 1. Crear el analizador DOM
		Document doc = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
			builder = factory.newDocumentBuilder();
			try {
				doc = builder.parse(new File(RUTA_RESOURCES + nombreFichero));
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
        return doc;
	}
	
	public Producto fromElement2Producto(Element raiz) {
		int id = Integer.parseInt(raiz.getAttribute("id"));
		boolean enVenta = Boolean.parseBoolean(raiz.getAttribute("enVenta"));
		Element nombreElemento = (Element) raiz.getElementsByTagName("Nombre").item(0);
		String nombre = nombreElemento.getTextContent();
		Element precioElemento = (Element) raiz.getElementsByTagName("Precio").item(0);
		double precio = Double.parseDouble(precioElemento.getTextContent().trim());
		Element stockElemento = (Element) raiz.getElementsByTagName("Stock").item(0);
		int stock = Integer.parseInt(stockElemento.getTextContent().trim());
		Producto p = new Producto(id, enVenta, nombre, precio, stock);
		return p;
	}
	
	public List<Producto> leerProductosDesdeXML(Element raiz) {
		NodeList listaNodos = raiz.getElementsByTagName("Producto");
		List<Producto> productos = new ArrayList<>();
		for (int i = 0; i < listaNodos.getLength(); i++) {
			Element elementoProducto = (Element) listaNodos.item(i);
			Producto producto = fromElement2Producto(elementoProducto);
			productos.add(producto);
		}
		return productos;
	}
}
