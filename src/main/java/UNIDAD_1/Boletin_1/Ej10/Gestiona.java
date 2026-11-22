package UNIDAD_1.Boletin_1.Ej10;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Gestiona {
	private static final Logger logger = LogManager.getLogger(Gestiona.class);

    public static void main(String[] args) {
        String ruta = "C:\\Users\\leonv\\Documents\\Menor";
        File directorio = new File(ruta);

        Gestiona g = new Gestiona();
        g.organizarDirectorio(directorio);
    }

    public void organizarDirectorio(File directorio) {
        for (File f : directorio.listFiles()) {
            if (f.isFile()) {
                String nombre = f.getName();
                String extension = nombre.substring(nombre.lastIndexOf("."));

                File carpeta = new File(directorio, extension.substring(1));

                if (!carpeta.exists()) {
                    carpeta.mkdir();
                }

                File destino = new File(carpeta, nombre);

                int contador = 1;

                while (destino.exists()) {
                    String nombreNuevo = nombre.substring(0, nombre.lastIndexOf("."))
                            + "(" + contador + ")" + extension;

                    destino = new File(carpeta, nombreNuevo);
                    contador++;
                }

                logger.info("Moviendo fichero: " + nombre);
                f.renameTo(destino);
            }
        }
    }
}
