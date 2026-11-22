package UNIDAD_1.BoletinXML.Ej2.Service;

import java.util.List;

import UNIDAD_1.BoletinXML.Ej2.Models.Producto;
import UNIDAD_1.BoletinXML.Ej2.Repository.IProductoRepository;
import UNIDAD_1.BoletinXML.Ej2.Repository.ProductoRepository;

public class ProductoService implements IProductoService {
	private List<Producto> productos;
	IProductoRepository repositorio;
	
	public ProductoService(String ruta) {
		super();
		this.repositorio = new ProductoRepository(ruta);
	}

	@Override
	public List<Producto> findAll() {
		List<Producto> productos = repositorio.findAll();
		this.productos = productos;
		return this.productos;
	}
}
