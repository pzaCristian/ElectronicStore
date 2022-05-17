public abstract class Movil extends ProductoInformatico {

	private int pulgadas;
	private int megapixeles;
	
	/**
	 * @author Alex
	 * @param todos los datos escaneados anteriormente
	 * este constructor asigna todos los valores recibidos a un objeto por crear
	 */
	public Movil(int id, String tipo, String modelo, String marca, double precio, boolean habilitado, int stock, String procesador,int ram, String resolucion, int capacidad, boolean wifi, boolean bluetooth,int pulgadas,int megapixeles) 
	{
		super(id, tipo, modelo, marca, precio, habilitado, stock, procesador, ram, resolucion, capacidad, wifi, bluetooth);
	    setPulgadas(pulgadas);
	    setMegapixeles(megapixeles);
	}
	
	/**
	 * @author Alex
	 * se obtienen, se agrupan todos los datos y se retornan
	 */
	@Override
	public String toString() {
		return super.toString() + "\nPulgadas: " + getPulgadas() + "\nMegapixeles: " +getMegapixeles() ;
	}	

	/**
	 * metodos gets y set para retornar el valor de los atributos de los metodos y asignarolos
	 * @author Alex
	 */
	public int getPulgadas() {return pulgadas;}
	public void setPulgadas(int pulgadas) {	this.pulgadas = pulgadas;}
	public int getMegapixeles() {return megapixeles;}
	public void setMegapixeles(int megapixeles) {this.megapixeles = megapixeles;}	
}