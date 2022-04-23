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
	public boolean Existe()
	{
		File archivo = new File(ruta); 
		if(archivo.exists())
		      return true;
		return false;
	}
	
	public void Lee_lineas() {
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
			String linea = miBuffer.readLine();
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
				String[] part  = linea.split("-") ;
				Persona persona = new Persona(part[0], part[1], part[2]);
				try 
				{
					Persona.verificarDniInvalido(persona.getDni());
					
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
		} catch (IOException e) {
			System.out.println("No se encontro el archivo");
			System.out.println(e);
		}
		catch (NullPointerException n) {}
		catch (ArrayIndexOutOfBoundsException a) {}
		return personas;
	}
	
	public void GuardarArchivo(TreeSet<Persona> personas, File archivo) {
	      
		Iterator<Persona> ite = personas.iterator();
		
		FileWriter salidas;
		BufferedWriter bSalidas;
		
		
		try {
			
			salidas = new FileWriter(archivo,true);
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
