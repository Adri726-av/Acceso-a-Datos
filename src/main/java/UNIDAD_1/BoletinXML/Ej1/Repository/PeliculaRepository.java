package UNIDAD_1.BoletinXML.Ej1.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import UNIDAD_1.BoletinXML.Ej1.Exceptions.PeliculaException;
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
		Document doc = utiles.getDocumentFromXML("peliculas.xml");
		Element raiz = doc.getDocumentElement();
		List<Pelicula> peliculas = utiles.leerPeliculasDesdeXML(raiz);
		this.peliculas = peliculas;
		return this.peliculas;
	}
	
	@Override
	public void save(Pelicula peli) throws PeliculaException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(String titulo) throws PeliculaException {
		// TODO Auto-generated method stub

	}

}
