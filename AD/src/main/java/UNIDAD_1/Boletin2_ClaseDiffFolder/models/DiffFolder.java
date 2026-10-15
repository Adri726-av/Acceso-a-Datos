package UNIDAD_1.Boletin2_ClaseDiffFolder.models;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import UNIDAD_1.Boletin2_ClaseDiffFolder.exceptions.GestionFicherosException;

public class DiffFolder {
	File directorio1;
	File directorio2;
	
	
	
	public DiffFolder(String ruta1, String ruta2) throws GestionFicherosException{
		super();
		this.directorio1 = new File(ruta1);
		this.directorio2 = new File(ruta2);
		
		if (directorio1 != null && directorio2 != null && directorio1.isDirectory() && directorio2.isDirectory()) {
			setFolders(directorio1, directorio2);
		}
		else {
			throw new GestionFicherosException("No es un directorio");
		}
	}

	public void setFolders(File dir1, File dir2) throws GestionFicherosException {
		this.directorio1 = dir1;
		this.directorio2 = dir2;
	}

	public File getDirectorio1() {
		return directorio1;
	}

	public void setDirectorio1(File directorio1) {
		this.directorio1 = directorio1;
	}

	public File getDirectorio2() {
		return directorio2;
	}

	public void setDirectorio2(File directorio2) {
		this.directorio2 = directorio2;
	}
	
	public Set<ResultadoComparacion> comparame(File dir1, File dir2){
		Set<ResultadoComparacion> coleccion = new HashSet<>();
		File[] lista = dir1.listFiles();
		File[] lista2 = dir2.listFiles();
		int num = lista.length;
		int num2 = lista2.length;
		for (File l: lista) {
			
		}
		if (num > num2) {
			coleccion.add(lista);
		}
		return coleccion;
	}
}
