package UNIDAD_1.Boletin3.Ejercicio2.repository;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import UNIDAD_1.Boletin3.Ejercicio2.models.Pais;

public class RepoPais {
	private File file;
	private List<Pais> lista;
	
	public RepoPais(File file) {
		super();
		this.file = file;
		this.lista = new ArrayList<>();
	}
	
	public List<String> leerCSV(String ruta) {
		List<String> paises = new ArrayList<>();
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(ruta);
			in = new Scanner(fichero);
			while (in.hasNext()) {
				String linea = in.nextLine();
				String [] campos = linea.split(",");
				
				String nombre;
				String continente;
				int poblacion;
				String idioma;
				String moneda;
				
				for (int i = 0; i < campos.length; i++) {
					if (i == 0) {
						nombre = campos[i];
					}
					else if (i == 1) {
						continente = campos[i];
					}
					else if (i == 2) {
						poblacion = Integer.parseInt(campos[i]);
					}
					else if (i == 3) {
						idioma = 
					}
				}
			}
		} catch (Exception e) {
			
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return paises;
	}
}
