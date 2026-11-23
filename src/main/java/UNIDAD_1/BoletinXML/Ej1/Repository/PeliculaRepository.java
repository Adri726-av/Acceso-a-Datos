package UNIDAD_1.BoletinXML.Ej1.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import UNIDAD_1.BoletinXML.Ej1.Models.Pelicula;

public class PeliculaRepository implements IPeliculaRepository {
	private File archivo;
	private List<Pelicula> peliculas;

	public PeliculaRepository(String ruta) {
		super();
		this.archivo = new File(ruta);
		this.peliculas = new ArrayList<Pelicula>();
	}

	@Override
	public List<Pelicula> findAll(){
		XMLDomPeliculas utiles = new XMLDomPeliculas();
		this.peliculas = utiles.lecturaXML();
		return this.peliculas;
	}
	
	@Override
	public void save(Pelicula peli) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(String titulo) {
		// TODO Auto-generated method stub

	}

}
