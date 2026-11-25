package UNIDAD_1.Boletin2_XML.Ej1.Service;

import java.util.List;

import UNIDAD_1.Boletin2_XML.Ej1.Models.Empleado;

public interface IEmpleadoService {
	public List<Empleado> findAll();
	public void save(String nombreFichero, List<Empleado> empleados);
}
