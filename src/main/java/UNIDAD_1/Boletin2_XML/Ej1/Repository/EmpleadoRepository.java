package UNIDAD_1.Boletin2_XML.Ej1.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import UNIDAD_1.Boletin2_XML.Ej1.Exceptions.EmpleadoException;
import UNIDAD_1.Boletin2_XML.Ej1.Models.Empleado;

public class EmpleadoRepository implements IEmpleadoRepository {
	private List<Empleado> empleados;
	private UtilesXMLDom utiles;
	
	public EmpleadoRepository(String ruta) {
		super();
		this.empleados = new ArrayList<Empleado>();
		this.utiles = new UtilesXMLDom(ruta);
	}
	
	private List<Empleado> leerFichero() throws EmpleadoException {
		List<Empleado> lista = this.utiles.lecturaXML();
		this.empleados = lista;
		return this.empleados;
	}
	
	@Override
	public List<Empleado> findAll() throws EmpleadoException {
		return leerFichero();
	}
	
	private void escribirFichero(String nombreFichero, List<Empleado> empleados) throws EmpleadoException {
		this.utiles.escribeEmpleadosEnXML(nombreFichero, empleados);
	}
	
	@Override
	public void save(String nombreFichero, List<Empleado> empleados) throws EmpleadoException {
		escribirFichero(nombreFichero, empleados);
	}
	
}
