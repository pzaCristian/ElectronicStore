import org.json.JSONException;
import org.json.JSONObject;

public class RegistroCompras{
	
	private int idCliente;
	private String producto;
	private int dia;
	private int mes;
	private int anio;
	
	/**
	 * metodos gets y set para retornar el valor de los atributos de los metodos y asignarolos
	 * @author Alex
	 */
	String getProducto() {return producto;}
	int getIdcliente() {return idCliente;}
	int getDia() {return dia;}
	int getMes() {return mes;}
	int getAnio() {return anio;}
	
	
	/**
	 * @author Alex
	 * @param todos los datos escaneados anteriormente
	 * este constructor asigna todos los valores recibidos a un objeto por crear
	 */
	public RegistroCompras(int idCliente,String producto, int dia, int mes, int anio) 
	{
		super();
		this.idCliente = idCliente;
		this.producto = producto;
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	
	/**
	 * @author Alex
	 * se obtienen, se agrupan todos los datos y se retornan
	 */
	@Override
	public String toString()
	{
		return "\nDNI Cliente: "+getIdcliente()+"\nFecha: "+getDia()+"/"+getMes()+"/"+getAnio()+"\nProducto: "+getProducto();
	}
	
	/**
	 * @author Fede
	 * el metodo obtiene todos los datos de un televisor para crear un json y retornarlo
	 */
	public JSONObject getFormatoJSON() throws JSONException
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("ID Cliente", getIdcliente());
		jsonObject.put("producto", getProducto());
		jsonObject.put("dia", getDia());
		jsonObject.put("mes", getMes());
		jsonObject.put("anio", getAnio());		
		return jsonObject;
	}	
}