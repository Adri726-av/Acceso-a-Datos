package UNIDAD_1.Estudio.XML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.events.Attribute;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class UtilesDomXML {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return doc;
	}
	
	public Libro fromElement2Libro(Element raiz) {
		Element tituloElemento = (Element) raiz.getElementsByTagName("titulo").item(0);
		Element autorElemento = (Element) raiz.getElementsByTagName("autor").item(0);
		String id =  raiz.getAttribute("id");
		String categoria = raiz.getAttribute("categoria");
		String titulo = tituloElemento.getTextContent();
		String autor = autorElemento.getTextContent();
		Libro libro = new Libro(id, categoria, titulo, autor);
		return libro;
	}
	
	public List<Libro> leerLibrosDesdeXML(Element raiz) {
	    // 1. Obtener todos los elementos <libro>
	    NodeList listaNodos = raiz.getElementsByTagName("libro");
	    // 2. Crear la colección de libros
	    List<Libro> libros = new ArrayList<Libro>();
	    // 3. Recorrer los elementos <libro>
	    for (int i = 0; i < listaNodos.getLength(); i++) {
	        Element elementoLibro = (Element) listaNodos.item(i);
	        // 4. Convertir el elemento en un objeto Libro
	        Libro libro = fromElement2Libro(elementoLibro);
	        // 5. Añadir el libro a la colección
	        libros.add(libro);
	    }
	    return libros;
	}
}
