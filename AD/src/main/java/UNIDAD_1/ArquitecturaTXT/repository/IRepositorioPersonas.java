package UNIDAD_1.ArquitecturaTXT.repository;

import java.util.List;

import UNIDAD_1.LecturaTXT.models.Persona;

public interface IRepositorioPersonas {
	List<Persona> findAll();
}
