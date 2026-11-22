package UNIDAD_1.Escritura;

import java.util.List;

public class Ejemplo {
	public void escribePersonas(List<Persona> personas, String rutaFichero) {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida; 
			ficheroSalida = new FileWriter(rutaFichero, StandardCharsets.UTF_8);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			for(PersonaF p: personas) {
 				out.printf(Locale.ENGLISH, "%-10s", p.getNombre());
				for (double nota : p.getNotas()) {
                out.printf(Locale.ENGLISH, "%6.2f", nota);
            }			}			
			catch (IOException e) { 	logger.debug("IOException");		}
		finally		{
			if (out!=null)
				out.close();
		}	}

}
