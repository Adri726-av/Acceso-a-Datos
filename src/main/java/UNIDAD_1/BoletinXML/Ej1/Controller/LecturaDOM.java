package UNIDAD_1.BoletinXML.Ej1.Controller;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import UNIDAD_1.BoletinXML.Ej1.Models.Pelicula;
import UNIDAD_1.BoletinXML.Ej1.Repository.XMLDomPeliculas;
import UNIDAD_1.BoletinXML.Ej1.Service.IPeliculaService;
import UNIDAD_1.BoletinXML.Ej1.Service.PeliculaService;

public class LecturaDOM {
	public static void main(String[] args) {
		IPeliculaService servicio = new PeliculaService("src/main/resources/peliculas.xml");
		List<Pelicula> peliculas = servicio.findAll();
		System.out.println(peliculas);
	}
}
