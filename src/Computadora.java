public abstract class Computadora extends ProductoInformatico {
	
	private String mother;
	private String placaDeVideo;
	
	/**
	 * @author Alex
	 * @param todos los datos escaneados anteriormente
	 * este constructor asigna todos los valores recibidos a un objeto por crear
	 */
	public Computadora(int id,String tipo, String modelo, String marca, double precio, boolean habilitado, int stock,String procesador, int ram, String resolucion, int capacidad, boolean wifi, boolean bluetooth,String mother, String placaDeVideo) 
	{
		super(id, tipo, modelo, marca, precio, habilitado, stock, procesador, ram, resolucion, capacidad, wifi, bluetooth);
		setMother(mother);
		setPlacaDeVideo(placaDeVideo);
	}
	
	/**
	 * @author Alex
	 * este constructor asigna vacio a todos los valores de un objeto por crear
	 */
	public Computadora() {
		
		super();
		setMother(" ");
		setPlacaDeVideo(" ");
	}

	/**
	 * metodos gets y set para retornar el valor de los atributos de los metodos y asignarolos
	 * @author Alex
	 */
	public String getMother() {return mother;}
	public String getPlacaDeVideo() {return placaDeVideo;}
	public void setMother(String mother) {this.mother = mother;}
	public void setPlacaDeVideo(String placaDeVideo) {this.placaDeVideo = placaDeVideo;}
	
	/**
	 * @author Alex
	 * se obtienen, se agrupan todos los datos y se retornan
	 */
	public String toString()
	{
		return super.toString()+ "\nMother: "+getMother()+"\nPlaca de video: " + getPlacaDeVideo();
	}
}