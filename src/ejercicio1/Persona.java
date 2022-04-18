package ejercicio1;


public class Persona implements Comparable<Persona> {

	
	//atributos
	private String nombre;
	private String apellido;
	private String dni;
	
	//constructors
	public Persona(){
	
}
	
	public Persona(String nombre,String apellido,String dni){
		this.nombre =nombre;
		this.apellido=apellido;
		this.dni=dni;
	}
	public Persona(String nombre,String apellido){
		this.nombre =nombre;
		this.apellido=apellido;
	}
	
	
	

	//getters and setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

	

	@Override
	public String toString() {
		return "Persona, nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni;
	}

	@Override
	public int compareTo(Persona o) {
		return getApellido().compareTo(o.getApellido());
		
		//return o.apellido.compareTo(this.apellido);
		
	}
	
	public boolean equals(Object obj)
	{
		Persona objPersona;
		if(obj instanceof Persona)
		{
			objPersona = (Persona) obj;
			if(objPersona.getApellido() == this.getApellido())
			{
				return true;
			}
		}
		    return false;
	}
	
	public static void verificarDniInvalido(String dni) throws DniInvalido
	{
		if(!dni.matches("[0-9]+"))
		{
			throw new DniInvalido();
		}
	}
}

	
	
	
