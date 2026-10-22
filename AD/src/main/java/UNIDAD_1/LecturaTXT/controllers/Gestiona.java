package UNIDAD_1.LecturaTXT.controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import UNIDAD_1.LecturaTXT.models.Persona;

public class Gestiona {
	private static final Logger logger.info = LogManager.getLogger(Gestiona.class);
	
	public static void main(String[] args) {
		Gestiona g = new Gestiona();
		String ruta = "C:\\Users\\usuario1234\\Documents\\Persona.txt";
		try {
			List<Persona> personas = g.leePersona(ruta);
			for (int i = 0; i < personas.size(); i++) {
				Persona p = personas.get(i);
				logger.info("Alumno: " + p.getNombre());
				for (int f = 0; f < p.getNotas().size() ; f++) {
					logger.info("Nota: " + p.getNotas().get(f));
				}
			}
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
	}
	
	public List<Persona> leePersona(String ruta) throws FileNotFoundException {
		List<Persona> personas = new ArrayList<Persona>();
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(ruta);
			in = new Scanner(fichero);
			in.useLocale(Locale.ENGLISH);
			while (in.hasNext()) { 
				String nombre = in.next();
				List<Double> notas = new ArrayList<>();
				while (in.hasNextDouble()) {
					Double nota = in.nextDouble();
					notas.add(nota);
				}
				Persona p = new Persona(nombre, notas);
				personas.add(p);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return personas;
	}
}
