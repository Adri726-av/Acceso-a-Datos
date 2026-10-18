package UNIDAD_1.Boletin2_ClaseDiffFolder.models;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import UNIDAD_1.Boletin2_ClaseDiffFolder.exceptions.DiffFolderException;

public class DiffFolder {
	private static final Logger logger = LogManager.getLogger(DiffFolder.class);
	 
	private File directorio1;
	private File directorio2;
 
	public DiffFolder(String ruta1, String ruta2) throws DiffFolderException {
		setFolders(new File(ruta1), new File(ruta2));
	}
 
	public void setFolders(File folder1, File folder2) throws DiffFolderException {
		if (folder1 != null && folder2 != null && folder1.isDirectory() && folder2.isDirectory()) {
			this.directorio1 = folder1;
			this.directorio2 = folder2;
		} else {
			throw new DiffFolderException("No es un directorio");
		}
	}
 
	public File getFolder1() {
		return directorio1;
	}
 
	public File getFolder2() {
		return directorio2;
	}
 
	public Collection<ResultadoComparacion> comparame() {
		List<ResultadoComparacion> coleccion = new ArrayList<>();
 
		List<File> lista = listaFicheros(directorio1);
		List<File> lista2 = listaFicheros(directorio2);
		int num = lista.size();
		int num2 = lista2.size();
 
		if (num >= num2) {
			recorre(lista, coleccion);
			recorre(lista2, coleccion);
		} else {
			recorre(lista2, coleccion);
			recorre(lista, coleccion);
		}
		return coleccion;
	}
 
	private List<File> listaFicheros(File dir) {
		List<File> ficheros = new ArrayList<>();
		File[] todo = dir.listFiles();
		for (File f : todo) {
			if (f.isFile()) {
				ficheros.add(f);
			}
		}
		return ficheros;
	}
 
	private void recorre(List<File> lista, List<ResultadoComparacion> coleccion) {
		for (File l : lista) {
			String nombre = l.getName();
			if (!yaEstaEnLaColeccion(nombre, coleccion)) {
				coleccion.add(comparaNombre(nombre));
			}
		}
	}
 
	private boolean yaEstaEnLaColeccion(String nombre, List<ResultadoComparacion> coleccion) {
		boolean esta = false;
		for (ResultadoComparacion r : coleccion) {
			if (r.getNomFichero().equals(nombre)) {
				esta = true;
			}
		}
		return esta;
	}
 
	private ResultadoComparacion comparaNombre(String nombre) {
		File f1 = new File(directorio1, nombre);
		File f2 = new File(directorio2, nombre);
		ValorComparacion valor;
		try {
			valor = comparaFichero(f1, f2);
		} catch (DiffFolderException e) {
			logger.error(e.getMessage());
			if (f1.exists()) {
				valor = ValorComparacion.FALTA_EN_2;
			} else {
				valor = ValorComparacion.FALTA_EN_1;
			}
		}
		return new ResultadoComparacion(nombre, valor);
	}
 
	private ValorComparacion comparaFichero(File f1, File f2) throws DiffFolderException {
		if (!f1.exists()) {
			throw new DiffFolderException("El fichero " + f1.getName() + " no existe en " + directorio1);
		}
		if (!f2.exists()) {
			throw new DiffFolderException("El fichero " + f2.getName() + " no existe en " + directorio2);
		}
 
		long fecha1 = f1.lastModified();
		long fecha2 = f2.lastModified();
 
		if (fecha1 == fecha2) {
			return ValorComparacion.IGUALES;
		} else if (fecha1 > fecha2) {
			return ValorComparacion.MENOS_NUEVO_EN_1;
		} else {
			return ValorComparacion.MENOS_NUEVO_EN_2;
		}
	}
}
