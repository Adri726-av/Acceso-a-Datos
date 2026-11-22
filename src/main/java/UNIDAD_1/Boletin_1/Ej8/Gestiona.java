package UNIDAD_1.Boletin_1.Ej8;

import java.io.File;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Gestiona {
	
	private static final Logger logger = LogManager.getLogger(Gestiona.class);
	
	public static void main(String[] args) {
		File directorio = new File("C:\\Users\\usuario1234\\Documents\\Prueba");
		File[] lista = directorio.listFiles();
		Arrays.sort(lista, new ComparadorTamano());
		for (File f : lista) {
			logger.info(f.getName() + ": " + f.length());
		}
		
		
	}
}
