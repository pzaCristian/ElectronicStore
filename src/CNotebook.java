import org.json.JSONException;
import org.json.JSONObject;

public class CNotebook extends Computadora {

	/**
	 * @author Alex
	 * @param todos los datos escaneados anteriormente
	 * este constructor asigna todos los valores recibidos a un objeto por crear
	 */
	public CNotebook(int id, String tipo, String modelo, String marca, double precio, boolean habilitado, int stock,String procesador, int ram, String resolucion, int capacidad, boolean wifi, boolean bluetooth,String mother, String placaDeVideo) 
	{
		super(id, tipo, modelo, marca, precio, habilitado, stock, procesador, ram, resolucion, capacidad, wifi, bluetooth, mother,placaDeVideo);
	}
	
	/**
	 * @author Alex
	 * este constructor asigna vacio a todos los valores de un objeto por crear
	 */
	public CNotebook(){}

	
	/**
	 * @author Fede
	 * el metodo obtiene todos los datos de una noteebok para crear un json y retornarlo
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
		jsonObject.put("mother", getMother());
		jsonObject.put("placa de video", getPlacaDeVideo());		
		return jsonObject;		
	}	
}