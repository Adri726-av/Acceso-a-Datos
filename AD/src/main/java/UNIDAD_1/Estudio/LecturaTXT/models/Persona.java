package UNIDAD_1.LecturaTXT.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Persona {
	String nombre ;
	List<Double> notas;

	public Persona(String nombre, List<Double> notas2) {
		super();
		this.nombre = nombre;
		this.notas = notas2;
	}

	public String getNombre() {
	return nombre;
	}

	public void setNombre(String nombre) {
	this.nombre = nombre;
	}

	public List<Double> getNotas() {
	return notas;
	}

	public void setNotas(List<Double> notas) {
	this.notas = notas;
	}
}