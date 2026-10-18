package UNIDAD_1.Boletin2_ClaseDiffFolder.models;

public class ResultadoComparacion {
	private String nombre;
	private ValorComparacion valor;
 
	public ResultadoComparacion(String nombre, ValorComparacion valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
 
	public String getNomFichero() {
		return nombre;
	}
 
	public ValorComparacion getValorComparacion() {
		return valor;
	}
}
