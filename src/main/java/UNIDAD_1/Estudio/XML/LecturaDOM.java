package UNIDAD_1.Estudio.XML;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class LecturaDOM {
	private static final String RUTA_RESOURCES = "src/main/resources/";
    public static void main(String[] args) {
    	UtilesDomXML utiles = new UtilesDomXML();
    	Document doc = utiles.getDocumentFromXML("libros.xml");
    	Element raiz = doc.getDocumentElement();
		List<Libro> libros = utiles.leerLibrosDesdeXML(raiz);
		for (Libro l: libros) {
			System.out.println(l);
		}
    }
}
