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
	
	//Constructors
	public Archivo() { }
	
	//Emanuel: Leer archivo y devolver un treeset
	public TreeSet<Persona> LeeArchivo(String ruta) {
		FileReader entrada;
		TreeSet<Persona> personas = new TreeSet<Persona>();
		BufferedReader miBuffer;
		try {
			entrada = new FileReader(ruta);
			miBuffer = new BufferedReader(entrada);
			String linea = miBuffer.readLine();
			while (linea != null) {
				String[] part  = linea.split("-",3) ;
				Persona persona = new Persona(part[0], part[1], part[2]);
				try 
				{
					Persona.VerificarDniInvalido(persona.getDni());
					
					Iterator<Persona> aux = personas.iterator();
					boolean aux2 = true;
					while(aux.hasNext()) {
						if(persona.compareTo((Persona)aux.next())==0) {
							aux2=false;
						}
					}
					if(aux2) {
						personas.add(persona);
					}
				}
				catch (DniInvalido e) 
				{
					e.printStackTrace();
				}
				linea = miBuffer.readLine();
			}
			miBuffer.close();
			entrada.close();
		} 
		catch (IOException e) {
			System.out.println("No se encontro el archivo");
			System.out.println(e);
		}
		catch (Exception e) {e.printStackTrace();}
		
		return personas;
	}
	
	public void GuardarArchivo(TreeSet<Persona> personas, File archivo) {
	      
		Iterator<Persona> ite = personas.iterator();
		
		FileWriter salidas;
		BufferedWriter bSalidas;
		
		try {
			
			salidas = new FileWriter(archivo,false);
			bSalidas = new BufferedWriter(salidas);
			String perso = new String();
			
			while (ite.hasNext()) {	
				Persona aux = (Persona)ite.next();
				perso = aux.getNombre()+"-"+aux.getApellido()+"-"+aux.getDni()+"\n";	
				bSalidas.write(perso);	
			}
			bSalidas.close();
			salidas.close();	
		}
		catch (Exception e) {
			e.printStackTrace();				
		}
	}
}
