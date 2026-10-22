package UNIDAD_1.ArquitecturaTXT.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import UNIDAD_1.ArquitecturaTXT.models.Persona;

public class RepositorioPersonas implements IRepositorioPersonas{
	
	String separador;
	File fichero;
	List<Persona> personas;
	
	public RepositorioPersonas(String separador, File fichero, List<Persona> personas) {
		super();
		this.separador = separador;
		this.fichero = fichero;
		this.personas = personas;
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

	@Override
	public List<UNIDAD_1.LecturaTXT.models.Persona> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
