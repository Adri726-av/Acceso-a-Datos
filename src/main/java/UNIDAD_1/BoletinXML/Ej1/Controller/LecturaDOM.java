package UNIDAD_1.BoletinXML.Ej1.Controller;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import UNIDAD_1.BoletinXML.Ej1.Models.Pelicula;
import UNIDAD_1.BoletinXML.Ej1.Repository.XMLDomPeliculas;

public class LecturaDOM {
	public static void main(String[] args) {
		XMLDomPeliculas utiles = new XMLDomPeliculas();
		Document doc = utiles.getDocumentFromXML("peliculas.xml");
		Element raiz = doc.getDocumentElement();
		List<Pelicula> peliculas = utiles.leerPeliculasDesdeXML(raiz);
		for (Pelicula pelicula : peliculas) {
			System.out.println(pelicula);
		}
	}
}
