public class Persona {
	
	private String nombre;
	private String Apellido;
	private int dni;
	
	/**
	 * metodos gets y set para retornar el valor de los atributos de los metodos y asignarolos
	 * @author Alex
	 */
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}	
	public String getApellido() {return Apellido;}
	public void setApellido(String apellido) {Apellido = apellido;}	
	public int getDni() {return dni;}
	public void setDni(int dni) {this.dni = dni;}	
	
	/**
	 * @author Alex
	 * @param todos los datos escaneados anteriormente
	 * este constructor asigna todos los valores recibidos a un objeto por crear
	 */
	public Persona(String nombre, String apellido, int dni) {
		
		setNombre(nombre);
		setApellido(apellido);
		setDni(dni);
	}
	
	/**
	 * @author Alex
	 * este constructor asigna vacio a todos los valores de un objeto por crear
	 */
	public Persona(){}
}