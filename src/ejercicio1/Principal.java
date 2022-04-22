package ejercicio1;

import java.io.File;
import java.util.TreeSet;

public class Principal {
	public static String ruta = "Personas.txt";
	public static String resultado = "Resultado.txt";
	
	public static void main(String[] args) {
		
		TreeSet<Persona> personas = new TreeSet<Persona>();
		Archivo archivoPersonas = new Archivo();
		
		personas = archivoPersonas.LeeArchivo(ruta);
		
		if (!personas.isEmpty()) {
			System.out.println("Archivo leido correctamente");
		} else {
			System.out.println("No se pudo leer el archivo");
		}
		
//		for (Persona persona : personas) {
//			System.out.println(persona.toString());
//		}
		File fileResultado = new File(resultado); 
		
		archivoPersonas.GuardarArchivo(personas,fileResultado);
		
	}

}
