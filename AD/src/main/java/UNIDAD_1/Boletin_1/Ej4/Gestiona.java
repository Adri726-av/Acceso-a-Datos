package UNIDAD_1.Boletin_1.Ej4;

import java.io.File;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Gestiona {
	
	private static final Logger logger = LogManager.getLogger(Gestiona.class);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		logger.debug("Escribe la ruta: ");
		String ruta = "C:\\Users\\usuario1234\\Documents\\Prueba";
		sc.close();
		Gestiona g = new Gestiona();
		g.mostrarDirectorio(ruta);
	}
	
	public void mostrarDirectorio(String ruta) {
		File directorio = new File(ruta);
		for (File f : directorio.listFiles() ) {
			if (f.isDirectory()) {
				logger.debug("Entro en siguiente directorio...");
				mostrarDirectorio(f.getPath());
			}
			else if(f.isFile()) {
				logger.debug("La ruta del fichero: " + f.getPath());
				logger.debug("Nombre del fichero: " + f.getName());
			}
		}
	}
}
