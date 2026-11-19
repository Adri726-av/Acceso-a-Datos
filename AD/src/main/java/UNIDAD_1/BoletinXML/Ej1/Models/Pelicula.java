package UNIDAD_1.BoletinXML.Ej1.Models;

import java.util.List;

public class Pelicula {
	private String titulo;
	private String duracion;
	private String genero;
	private String sinopsis;
	private List<Actor> actores;
	private String fecha;
	private String director;
	public Pelicula(String titulo, String duracion, String genero, String sinopsis, List<Actor> actores, String fecha,
			String director) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.genero = genero;
		this.sinopsis = sinopsis;
		this.actores = actores;
		this.fecha = fecha;
		this.director = director;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public List<Actor> getActores() {
		return actores;
	}
	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", duracion=" + duracion + ", genero=" + genero + ", sinopsis=" + sinopsis
				+ ", actores=" + actores + ", fecha=" + fecha + ", director=" + director + "]";
	}
}
