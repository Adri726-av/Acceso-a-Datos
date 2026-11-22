package UNIDAD_1.BoletinXML.Ej1.Service;

import java.util.List;

import UNIDAD_1.BoletinXML.Ej1.Models.Pelicula;

public interface IPeliculaService {
	public List<Pelicula> findAll();
	public void save(Pelicula peli);
	public void deleteById(String titulo);
}
