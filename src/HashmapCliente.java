import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HashmapCliente implements IListas {
	
	private HashMap<Integer, Cliente> ListaClientes;
	
	public HashmapCliente(){ListaClientes = new HashMap<Integer,Cliente>();}
	
	@Override
	public boolean agregar(Object obj)
	{		
		boolean flag = false;
		if(!ListaClientes.containsKey(((Cliente) obj).getDni()))
		{
			ListaClientes.put(((Cliente)obj).getDni(),(Cliente)obj);
			flag = true;
		}
		return flag;
	}
	
	public boolean comprobarCliente(int dni)
	{
		boolean flag = true;
		
		Iterator<Entry<Integer, Cliente>> it=ListaClientes.entrySet().iterator();

		while(it.hasNext()) 
		{
		  Entry<Integer, Cliente> me=(Entry<Integer, Cliente>) it.next();
		  
		  if(flag && me.getValue().getDni()==dni)
		  {
			flag = false;
		  }
		}
		return flag;			
	}

	@Override
	public String listar() 
	{
		StringBuilder builder = new StringBuilder();
		Iterator<Entry<Integer, Cliente>> it = ListaClientes.entrySet().iterator();
		
		while(it.hasNext())
		{
			Entry<Integer, Cliente> me = it.next();
			builder.append(me.getValue().toString());
		}
		return builder.toString();
	}

	public String listarRegistrosClientes(int dni) 
	{
		StringBuilder builder = new StringBuilder();
		Cliente aux = null;
		
		Iterator<Entry<Integer, Cliente>> it = ListaClientes.entrySet().iterator();
		
		while(it.hasNext())
		{
			Entry<Integer, Cliente> me = it.next();
			if(me.getKey()==dni)
			{
			  aux = me.getValue();
			  builder.append(aux.recorrerRegistro());
		    }
	    }
		return builder.toString();
	}
	
	public boolean agregarRegistro(int dni,RegistroCompras reg) 
	{
		Cliente aux = null;
		boolean flag = false;
		
		Iterator<Entry<Integer, Cliente>> it = ListaClientes.entrySet().iterator();
		
		while(it.hasNext())
		{
			Entry<Integer, Cliente> me = it.next();
			if(me.getKey()==dni)
			{
			  aux = me.getValue();
			  aux.agregarRegistro(reg);	
		      flag = true;
		    }
	    }
		return flag;
     }
	
	public void formatoJson() 
	{
		try
		{
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			
			Iterator<Entry<Integer, Cliente>> it = ListaClientes.entrySet().iterator();
			
			while(it.hasNext())
			{
				Entry<Integer, Cliente> me = it.next();
				jsonArray.put(me.getValue().getFormatoJSON());
			}
			
			jsonObject.put("clientes", jsonArray);
		    JsonUtiles.grabarClientes(jsonObject);
			
		}catch(JSONException e)
		{
			e.printStackTrace();	
		}
	}

	
	public Object buscar(String tipo, int id) {
		return null;
	}
	
	public void levantarJson() throws JSONException
	{
		Cliente cliente =null;
		RegistroCompras registroCompra =null;
		
		String respuesta = JsonUtiles.leerClientes();
		
		JSONObject jsonObject = new JSONObject(respuesta);
		JSONArray array = jsonObject.getJSONArray("clientes");
		
		for(int i =0;i<array.length();i++)
		{
			JSONObject obj = array.getJSONObject(i);
			 String nombre = obj.getString("nombre");
			 String apellido = obj.getString("apellido");
			 int dni = obj.getInt("dni");
		     int telefono = obj.getInt("telefono");
			 String domicilio = obj.getString("domicilio");
			 cliente = new Cliente(nombre,apellido,dni,telefono,domicilio);
			 
			 JSONArray jsonArray_reg = obj.getJSONArray("registros");
			 
			 for(int z=0;z<jsonArray_reg.length();z++)
			 {
				JSONObject obj_reg = jsonArray_reg.getJSONObject(z);
				int idCliente = obj_reg.getInt("ID Cliente");
			    String producto = obj_reg.getString("producto");
				int dia = obj_reg.getInt("dia");
			    int mes = obj_reg.getInt("mes");
				int anio = obj_reg.getInt("anio");
			    registroCompra = new RegistroCompras(idCliente,producto,dia,mes,anio);	
			    cliente.agregarRegistro(registroCompra);
			 }
			 agregar(cliente);
		}
	}	
}