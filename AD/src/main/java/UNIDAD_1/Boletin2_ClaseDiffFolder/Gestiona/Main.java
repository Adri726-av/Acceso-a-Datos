package UNIDAD_1.Boletin2_ClaseDiffFolder.Gestiona;

import java.util.Collection;

import UNIDAD_1.Boletin2_ClaseDiffFolder.exceptions.DiffFolderException;
import UNIDAD_1.Boletin2_ClaseDiffFolder.models.DiffFolder;
import UNIDAD_1.Boletin2_ClaseDiffFolder.models.ResultadoComparacion;

public class Main {
	public static void main(String[] args) {
		try {
			DiffFolder diff = new DiffFolder("C:\\Users\\leonv\\Documents\\Mayor", "C:\\Users\\leonv\\Documents\\Menor");
			Collection<ResultadoComparacion> resultados = diff.comparame();
			for (ResultadoComparacion r : resultados) {
				System.out.println(r.getNomFichero() + " -> " + r.getValorComparacion());
			}
		} catch (DiffFolderException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
