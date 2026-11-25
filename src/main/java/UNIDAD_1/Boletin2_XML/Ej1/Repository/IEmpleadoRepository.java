package UNIDAD_1.Boletin2_XML.Ej1.Repository;

import java.util.List;

import UNIDAD_1.Boletin2_XML.Ej1.Exceptions.EmpleadoException;
import UNIDAD_1.Boletin2_XML.Ej1.Models.Empleado;

public interface IEmpleadoRepository {
	public List<Empleado> findAll() throws EmpleadoException;
	public void save(String nombreFichero, List<Empleado> empleados) throws EmpleadoException;
}
