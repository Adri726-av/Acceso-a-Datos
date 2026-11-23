package UNIDAD_1.ArquitecturaTXT.models;

import java.util.List;

public class Persona {
	Double notaMin;
	Double notaMax;
	String nombre;
	List<Double> notas;

	public Persona(String nombre, List<Double> notas) {
		super();
		setNombre(nombre);
        setNotas(notas);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
	}

	public List<Double> getNotas() {
		return notas;
	}

	public void setNotas(List<Double> notas) {
		if (notas != null) {
            for (Double nota : notas) {
                if (nota < notaMin || nota > notaMax) {
                    throw new IllegalArgumentException("Nota no válida: " + nota);
                }
            }
        }
        this.notas = notas;
	}

	@Override
	public String toString() {
		return "Persona{nombre='" + nombre + "', notas=" + notas + "}";
	}
	
	
}
