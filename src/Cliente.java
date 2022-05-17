import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Cliente extends Persona{
	
	private int tel;
	private String domicilio;
	ArrayList<RegistroCompras>registro;
	
	/**
	 * @author Alex
	 * este constructor recibe los datos de un cliente para crearlo
	 * */
	public Cliente(String nombre, String apellido, int dni, int tel, String domicilio){
		
		super(nombre, apellido, dni);
		setTelefono(tel);
		setDomicilio(domicilio);
		registro = new ArrayList<RegistroCompras>();
	}

	
	/**
	 * @author Alex
	 * estos metodos se utilizan para asiganar valores a un objeto
	 * recibe los datos por parametros para trabajar
	 */
	public void setDomicilio(String domicilio) {this.domicilio = domicilio;}
	public void setTelefono(int tel) {this.tel = tel;}	
	public int getTelefono() {return tel;}
	public String getDomicilio() {return domicilio;}
	
	
	/**
	 * @author Alex
	 * este metodo compara los dni de los clientes, si existe o es nuevo
	 * @param obj, luego se instancia a cliente
	 */
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Cliente && obj != null)
		{
			Cliente c = (Cliente)obj;
			if(c.getDni() == getDni())
			{
				return true;				
			}
			else 
				return false;
		}			
		return false;
	}
	
	/**
	 * @author Fede
	 * el metodo recibe un registro de compra para agregarlos xon los demas
	 * @param r
	 */
	public void agregarRegistro(RegistroCompras r)
	{
		registro.add(r);
	}
	
	
	/**
	 * @author Fede
	 * mientras que ecorre el arraylist de registro va armando el string para retornar
	 * @return el string armado que contiene todos los datos 
	 */
	public String recorrerRegistro()
	{
		StringBuilder builder = new StringBuilder();	
		for(RegistroCompras r : registro)
		{
			builder.append(r.toString());
		}
		return builder.toString();
	}
	
	
	/**
	 * @author Alex
	 * @return toda la informacion de un cliente en formato de string
	 */
	@Override
	public String toString() 
	{
		return "\n.Nombre: "+getNombre()+"\n.Apellido: "+getApellido()+"\n.Dni: "+getDni()+"\n.Telefono: "+getTelefono()+"\n.Domicilio: "+getDomicilio();
	}
	
	
	/**
	 * @author Fede
	 * @return un json con todos los datos de un cliente
	 * @throws JSONException
	 * el metodo arma con los datos de un cliente y sus registros un json
	 */
	public JSONObject getFormatoJSON() throws JSONException
	{
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray_registro = new JSONArray();
		jsonObject.put("nombre", getNombre());
		jsonObject.put("apellido", getApellido());
		jsonObject.put("dni", getDni());
		jsonObject.put("telefono", getTelefono());
		jsonObject.put("domicilio", getDomicilio());
		for(RegistroCompras c : registro)
		{
			jsonArray_registro.put(c.getFormatoJSON());
		}
		jsonObject.put("registros",jsonArray_registro);
		return jsonObject;		
	}

}