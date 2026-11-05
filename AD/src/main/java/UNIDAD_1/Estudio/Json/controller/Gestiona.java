package UNIDAD_1.Json.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import UNIDAD_1.Json.models.Empleado;

public class Gestiona {
	
	private static final Logger logger = LogManager.getLogger(Gestiona.class);
	
	private static final String RUTA_FICHEROS = "src/main/resources";
	
	public static void main(String[] args) throws FileNotFoundException {
		Gestiona g = new Gestiona();
		g.leeEmpleado(RUTA_FICHEROS+"/empleado.json");
		
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		//g.escribeEmpleados(null, RUTA_FICHEROS);
		
	}
	
	public void leeEmpleado(String ruta) {
		FileReader fichero;
		try {
			fichero = new FileReader(RUTA_FICHEROS + "/empleado.json");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Empleado empleado = gson.fromJson(fichero, Empleado.class);
			System.out.println(empleado);
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void escribeEmpleados(List<Empleado> lista, String ruta) {
		
	}
	
	public void escribeEmpleado(Empleado empleado, String ruta) {// Convertir el objeto a JSON
		 Gson gson = new Gson();
		 String json = gson.toJson(empleado);
		 FileWriter fichero = null;
		 try {
			fichero = new FileWriter(ruta);
			fichero.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fichero != null) {
				try {
					fichero.close();
				} catch (IOException e) {
					System.out.println("Error al escribir empleado");
				}			
			}		
		}	   
	}
}
