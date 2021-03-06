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
	}
	
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;		
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;		
		return true;
	}
	
	public static void VerificarDniInvalido(String dni) throws DniInvalido
	{
		if(!dni.matches("[0-9]+"))
		{
			throw new DniInvalido();
		}
	}
}

	
	
	
