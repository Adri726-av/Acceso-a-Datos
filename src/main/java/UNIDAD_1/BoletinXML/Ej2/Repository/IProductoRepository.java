package UNIDAD_1.BoletinXML.Ej2.Repository;

import java.util.List;

import UNIDAD_1.BoletinXML.Ej2.Models.Producto;

public interface IProductoRepository {
	public List<Producto> findAll();
}
