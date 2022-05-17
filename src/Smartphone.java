import org.json.JSONException;
import org.json.JSONObject;

public class Smartphone extends Movil {
	
	private String compania;
	private String red;
	
	/**
	 * @author Alex
	 * @param todos los datos escaneados anteriormente
	 * este constructor asigna todos los valores recibidos a un objeto por crear
	 */
	public Smartphone(int id, String tipo, String modelo, String marca, double precio, boolean habilitado, int stock,String procesador, int ram, String resolucion, int capacidad, boolean wifi, boolean bluetooth, int pulgadas,int megapixeles, String compania, String red) 
	{
		super(id, tipo, modelo, marca, precio, habilitado, stock, procesador, ram, resolucion, capacidad, wifi, bluetooth,pulgadas, megapixeles);
		setCompania(compania);
		setRed(red);
	}
	
	/**
	 * @author Alex
	 * este constructor asigna vacio a todos los valores de un objeto por crear
	 */
	public Smartphone() 
	{
		super(0, " ", " ", " ", 0, false, 0, " ", 0, " ", 0, false, false,0, 0);
		setCompania(" ");
		setRed(" ");
	}

	/**
	 * metodos gets y set para retornar el valor de los atributos de los metodos y asignarolos
	 * @author Alex
	 */
	public String getCompania() {return compania;}
	public String getRed() {return red;}
	public void setCompania(String compania) {this.compania = compania;}
	public void setRed(String red) {this.red = red;}
	
	/**
	 * @author Alex
	 * se obtienen, se agrupan todos los datos y se retornan
	 */
	@Override
	public String toString(){return super.toString() +"\nCompania: "+getCompania()+"\nRed: "+getRed()+"\n\n\n";}

	
	/**
	 * @author Fede
	 * el metodo obtiene todos los datos de un smartphone para crear un json y retornarlo
	 */
	public JSONObject getFormatoJSON() throws JSONException
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", getId());
		jsonObject.put("tipo", getTipo());
		jsonObject.put("modelo", getModelo());
		jsonObject.put("marca", getMarca());
		jsonObject.put("precio", getPrecio());
		jsonObject.put("habilitado", isHabilitado());
		jsonObject.put("stock", getStock());
		jsonObject.put("procesador", getProcesador());
		jsonObject.put("ram", getRam());
		jsonObject.put("resolucion", getResolucion());
		jsonObject.put("capacidad", getCapacidad());
		jsonObject.put("wifi", isWifi());
		jsonObject.put("bluetooth", isBluetooth());
		jsonObject.put("pulgadas", getPulgadas());
		jsonObject.put("megapixeles", getMegapixeles());
		jsonObject.put("compania", getCompania());
		jsonObject.put("red", getRed());		
		return jsonObject;		
	}	
}