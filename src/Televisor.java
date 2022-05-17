import org.json.JSONException;
import org.json.JSONObject;

public class Televisor extends Pantalla {
	
	private boolean wifi;	

	/**
	 * @author Alex
	 * @param todos los datos escaneados anteriormente
	 * este constructor asigna todos los valores recibidos a un objeto por crear
	 */
	public Televisor(int id,String tipo, String modelo, String marca, double precio, boolean habilitado, int stock, String res,int pul, boolean wifi) {
		
		super(id,tipo, modelo, marca, precio, habilitado, stock, res, pul);
		setWifi(wifi);
	}

	/**
	 * @author Alex
	 * este constructor asigna vacio a todos los valores de un objeto por crear
	 */
	public Televisor() {
		
		super(0, " ", " ", " ", 0, false, 0, " ", 0);
		setWifi(false);
	}
	
	/**
	 * metodos gets y set para retornar el valor de los atributos de los metodos y asignarolos
	 * @author Alex
	 */
	public boolean isWifi() {return wifi;}		
	public void setWifi(boolean wifi) {this.wifi = wifi;}
	
	
	/**
	 * @author Alex
	 * transforma el boolean obtenido a un string
	 * @return string segun el boolean obtenido
	 */
	public String resWifi()
	{
		if(isWifi() == true)
			return "\nwifi: si\n";
		else
			return "\nwifi: no\n\n";	
	}
	
	/**
	 * @author Alex
	 * se obtienen, se agrupan todos los datos y se retornan
	 */
	@Override
	public String toString() {return super.toString()+resWifi();}
	
	
	/**
	 * @author Fede
	 * el metodo obtiene todos los datos de un televisor para crear un json y retornarlo
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
		jsonObject.put("resolucion", getResolucion());
		jsonObject.put("pulgadas", getPulgadas());
		jsonObject.put("wifi", isWifi());		
		return jsonObject;
	}	
}