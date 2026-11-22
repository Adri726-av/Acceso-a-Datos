package UNIDAD_1.BoletinXML.Ej2.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import UNIDAD_1.BoletinXML.Ej2.Models.Producto;

public class ProductoRepository implements IProductoRepository {
	private File archivo;
	private List<Producto> productos;
	
	public ProductoRepository(String ruta) {
		super();
		this.archivo = new File(ruta);
		this.productos = new ArrayList<Producto>();
	}

	@Override
	public List<Producto> findAll() {
		XMLDomProductos utiles = new XMLDomProductos();
		Document doc = utiles.getDocumentFromXML("productos.xml");
		Element raiz = doc.getDocumentElement();
		List<Producto> productos = utiles.leerProductosDesdeXML(raiz);
		this.productos = productos;
		return this.productos;
	}
}
