package UNIDAD_1.Boletin_1.Ej7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Gestiona {
	
	private static final Logger logger = LogManager.getLogger(Gestiona.class);
	
	public static void main(String[] args) {
		File directorio = new File("C:\\Users\\usuario1234\\Documents\\Prueba");
		Gestiona g = new Gestiona();
		List lista =g.buscar(directorio, "Pru");
		for (int i = 0; i < lista.size(); i++) {
			logger.info(lista.get(i));
		}
	}
	
	public List<File> buscar(File dir, String nombre) {
		List lista = new ArrayList<File>();
		contieneCadena(nombre, lista, dir);
		return lista;
	}
	
	public void contieneCadena(String nombre, List lista, File dir) {
		for (File f : dir.listFiles()) {
			if (f.isFile()) {
				if (f.getName().contains(nombre)) { 	
					lista.add(f);
				}
			}
			else if (f.isDirectory()) {
				if (f.getName().contains(nombre)) {
					lista.add(f);
				}
				contieneCadena(nombre, lista, f);
			}
		}
	}
}
