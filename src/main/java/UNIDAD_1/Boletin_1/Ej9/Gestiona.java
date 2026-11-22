package UNIDAD_1.Boletin_1.Ej9;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Gestiona {
	private static final Logger logger = LogManager.getLogger(Gestiona.class);
	
	public static void main(String[] args) {
		String ruta = "C:\\Users\\leonv\\Documents\\Mayor";
		File directorio = new File(ruta);
		Gestiona g = new Gestiona();
		g.borrarDirectorio(directorio);
	}
	
	public void borrarFicheros(File directorio) {
		for (File f : directorio.listFiles() ) {
			if(f.isFile()) {
				logger.debug("Nombre del fichero: " + f.getName());
				f.delete();
			}
		}
}
	
	public boolean borrarDirectorio(File dir) {
		boolean borrado = false;
		if (dir.isDirectory()) {
			File[] archivos = dir.listFiles();
			if (archivos.length == 0) {
				logger.info("El directorio esta vacío, procedo a eliminarlo");
				dir.delete();
				borrado = true;
			}
			else {
				logger.info("Estos son los archivos que se van a borrar: ");
				borrarFicheros(dir);
				dir.delete();
			}
		}
		return borrado;
	}
}
