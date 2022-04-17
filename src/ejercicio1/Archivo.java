package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

public class Archivo {
	
	//Atributos
	private String ruta;
	
	//Getters & setters
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	//Constructors
	public Archivo() {
		
	}
	
	public Archivo(String ruta) {
		
		this.ruta = ruta;
	}

	//Metodos
	public boolean existe()
	{
		File archivo = new File(ruta); 
		if(archivo.exists())
		      return true;
		return false;
	}
	
	public void lee_lineas() {
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
		   String linea = "";
			while (linea != null) {
				String[] parts = linea.split("-");
				if(parts[0] != "") {
				System.out.print("Nombre: " + parts[0] + " ");
				
				System.out.print("Apellido: " + parts[1] + " ");
				System.out.println();
				}
				linea = miBuffer.readLine();
			}
			miBuffer.close();
			entrada.close();

		} catch (IOException e) {
			System.out.println("No se encontro el archivo");
		}
	}
	
}
