package UNIDAD_1.Estudio.XML;

public class Libro {
	private String id;
	private String categoria;
	private String titulo;
	private String autor;
	public Libro() {
		super();
	}
	public Libro(String titulo) {
		super();
		this.titulo = titulo;
	}
	public Libro(String autor, String titulo) {
		super();
		this.autor = autor;
		this.titulo = titulo;
	}
	public Libro(String id, String categoria, String titulo, String autor) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.titulo = titulo;
		this.autor = autor;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	@Override
	public String toString() {
		return "Libro [id=" + id + ", categoria=" + categoria + ", titulo=" + titulo + ", autor=" + autor + "]";
	}
	
	
}
