package UNIDAD_1.BoletinXML.Ej1.Service;

import java.util.List;

import UNIDAD_1.BoletinXML.Ej1.Exceptions.PeliculaException;
import UNIDAD_1.BoletinXML.Ej1.Models.Pelicula;
import UNIDAD_1.BoletinXML.Ej1.Repository.IPeliculaRepository;
import UNIDAD_1.BoletinXML.Ej1.Repository.PeliculaRepository;

public class PeliculaService implements IPeliculaService {
	private List<Pelicula> peliculas;
	IPeliculaRepository repositorio;
	
	
	public PeliculaService(String ruta) {
		super();
		this.repositorio = new PeliculaRepository(ruta);
	}

	@Override
	public List<Pelicula> findAll(){
		return repositorio.findAll();
	}

	@Override
	public void save(Pelicula peli){
		
	}

	@Override
	public void deleteById(String titulo) {
		// TODO Auto-generated method stub
	}

}
