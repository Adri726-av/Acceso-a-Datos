package UNIDAD_1.BoletinXML.Ej1.Repository;

import java.util.List;

import UNIDAD_1.BoletinXML.Ej1.Exceptions.PeliculaException;
import UNIDAD_1.BoletinXML.Ej1.Models.Pelicula;

public interface IPeliculaRepository {
	public List<Pelicula> findAll();
	public void save(Pelicula peli);
	public void deleteById(String titulo);
}
