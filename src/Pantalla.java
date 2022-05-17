public abstract class Pantalla extends Producto{

	private String resolucion;
	private int pulgadas;
	
	/**
	 * @author Alex
	 * @param todos los datos escaneados anteriormente
	 * este constructor asigna todos los valores recibidos a un objeto por crear
	 */
    public Pantalla(int id,String tipo, String modelo,String marca,double precio,boolean habilitado,int stock, String res, int pul) {
		
		super(id, tipo, modelo, marca, precio,habilitado,stock);
		setResolucion(res);
		setPulgadas(pul);
	}
	
    /**
	 * metodos gets y set para retornar el valor de los atributos de los metodos y asignarolos
	 * @author Alex
	 */
	public void setResolucion(String res) {resolucion = res;}
	public void setPulgadas(int pul) {pulgadas = pul;}
	public String getResolucion(){return resolucion;}
	public int getPulgadas(){return pulgadas;}

	/**
	 * @author Alex
	 * se obtienen, se agrupan todos los datos y se retornan
	 */
	@Override
	public String toString(){return super.toString() + "Resolucion: "+getResolucion()+ "\nPulgadas: "+getPulgadas();}
	
	/**
	 * @author Fede
	 * compara que los obejeos no sean iguales
	 */
	@Override
	public int compareTo(Producto o) {
		return super.compareTo(o);
	}	
}