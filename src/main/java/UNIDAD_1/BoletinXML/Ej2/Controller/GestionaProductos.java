package UNIDAD_1.BoletinXML.Ej2.Controller;

import java.util.List;

import UNIDAD_1.BoletinXML.Ej2.Models.Producto;
import UNIDAD_1.BoletinXML.Ej2.Service.IProductoService;
import UNIDAD_1.BoletinXML.Ej2.Service.ProductoService;

public class GestionaProductos {
	public static void main(String[] args) {
		IProductoService servicio = new ProductoService("src/main/resources/productos.xml");
		List<Producto> productos = servicio.findAll();
		for (Producto producto : productos) {
			System.out.println(producto);
		}
	}
}
