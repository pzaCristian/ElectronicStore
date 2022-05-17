import java.util.Comparator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Catalogo implements IListas {

	private HashMap<String,TreeMap<Integer,Producto>>catalogo;

	/**
	 * @author Alex
	 * En el constructor de catalogo se le da el valor null al Hashmap que esta clase tiene como atributo
	 */
	public Catalogo()
	{
		catalogo = new HashMap<String,TreeMap<Integer,Producto>>();
	}

	/**
	 * @author Fede
	 * @param obj
	 * en el metodo se crea un treemap y se lo inicializa en null y una variable de tipo boolean en false, luego con el
	 * metodo comprobarIdAgregar, compraobamos si el id esta resgistrado  
	 */
	public boolean agregar(Object obj) 
	{
		TreeMap<Integer, Producto> treeMapAux = null;
		boolean agregarProducto=false;
		
		if(comprobarIdAgregar(((Producto) obj).getId()))  //comprueba si el id del producto que se desea ingresar ya existe en el treemap
		 {
			treeMapAux = catalogo.get(((Producto) obj).getTipo());
			if(catalogo.containsKey(((Producto) obj).getTipo()))                     //comprueba si contiene  la clave    
			{
				 treeMapAux.put(((Producto) obj).getId(),(Producto) obj);
				 catalogo.put(((Producto) obj).getTipo(),treeMapAux);
				 agregarProducto = true;
			}
			else
			{
			     treeMapAux = new TreeMap<>();
			     treeMapAux.put(((Producto) obj).getId(), (Producto) obj);
			     catalogo.put(((Producto) obj).getTipo(),treeMapAux);
			     agregarProducto = true;
		    }
		 }
		return agregarProducto;
	}
	
	/**
	 * Se recorre el treemap buscando del id del producto, si no existe retorna false
	 * @author Alex
	 * @return el resultado
	 */
	public boolean comprobarIdAgregar(int id)
	{
		boolean flag=true;		
        Iterator<Entry<String, TreeMap<Integer, Producto>>> it=catalogo.entrySet().iterator();
		
        while(flag && it.hasNext())
		{
		    Entry<String, TreeMap<Integer, Producto>> me=it.next();		
			TreeMap<Integer,Producto> treeAux = me.getValue();
		
			if(treeAux.containsKey(id))
			{
			    flag = false;
			}	
		}
		return flag;
	}
	
	
	/**
	 * @author Fede
	 * El metodo comprueba la existencia del prodcuto elegido si existe retorna false
	 * @param id es el codigo del producto
	 * @param tipo, es la categoria del producto
	 * @return el resultado de la busqueda
	 */
	public boolean comprobarIdCompra(int id,String tipo)
	{
		boolean flag=true;
        if(catalogo.containsKey(tipo))
		{ 
        	TreeMap<Integer,Producto> treeAux = catalogo.get(tipo);
		    if(treeAux.containsKey(id))
			{
		    	flag = false;
			}
    	}
		return flag;
	}
		
	/**
	 * @author Fede
	 * @return un string con todos los datos de todos los productos 
	 * se recibe el treemap ordenado y a medida que se se recorre se va armando el string para retornar
	 */
	@Override
	public String listar() //listar por precio menor a mayor
	{
		StringBuilder builder= new StringBuilder();
		Iterator<Entry<String, TreeMap<Integer, Producto>>> it=catalogo.entrySet().iterator();
		
		while(it.hasNext())
		{
			Entry<String, TreeMap<Integer, Producto>> me=it.next();
			TreeMap<Integer,Producto> treeAux = me.getValue();
			
			///recorro arbol
			Set<Entry<Integer, Producto>> entradas = entriesSortedByValues(treeAux);
			Iterator<Entry<Integer, Producto>> iteratorTree = entradas.iterator();
			String nombresProductos = "";
			
			while (iteratorTree.hasNext())
			{
				Entry<Integer, Producto> entradaTree = iteratorTree.next();
				nombresProductos += "\n"+entradaTree.getValue().toString();				
			}
			//fin de recorrer arbol
			
			builder.append(me.getKey()+nombresProductos);			
		}
		return builder.toString();
	}
	
	
	/**
	 * @author Fede
	 * este metodo ordena el treemap de loa prodcutos de menor a mayor por precio
	 * @param map 
	 * @return el treemap ordenado
	 */
	static <K,V extends Comparable<? super V>>
	SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) 
	{
	    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
	        new Comparator<Map.Entry<K,V>>() 
	        {
	            @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
	                int res = e1.getValue().compareTo(e2.getValue());
	                return res != 0 ? res : 1;
	            }
	        }
	    );
	    sortedEntries.addAll(map.entrySet());
	    return sortedEntries;
	}

	/**
	 * @author Fede
	 * @param stock es la cantidad que el administrador compro
	 * @param id es el codigo del producto a modificar
	 * en este metodo se recibe la cantidad comprada, y el id, para aumentar la cantidad disponible del producto
	 */
	public void aumentarStockProducto(int stock,int id)
	{
		Iterator<Entry<String, TreeMap<Integer, Producto>>> it=catalogo.entrySet().iterator();
		Producto aux = null;
        
		while(it.hasNext())
		{
			Entry<String, TreeMap<Integer, Producto>> me=it.next();
			TreeMap<Integer,Producto> treeAux = me.getValue();
			Iterator<Entry<Integer, Producto>> iter = treeAux.entrySet().iterator();
			
			while(iter.hasNext())
			{
				Entry<Integer, Producto> entradaTree=iter.next();
				if(entradaTree.getKey()==id)
				{
					aux = entradaTree.getValue();
					aux.aumentarStock(stock);
					treeAux.put(aux.getId(), aux);
					catalogo.put(me.getKey(), treeAux);
				}
			}
		}		
	}
	
	/**
	 * @author Fede
	 * @param tipo es la categoria de productos
	 * @return un string de todos los productos pertenecientes a la categoria recibida por parametro
	 * Mientras que se recorre el treemap y los productos pertenecen al tipo seleccionado, se agregan a un string
	 */
	public String listarTipo(String tipo) 
	{
		StringBuilder builder= new StringBuilder();
		
			if(catalogo.containsKey(tipo))
			{
			   TreeMap<Integer,Producto> treeAux = catalogo.get(tipo);
		
			   ///recorro arbol
			   Set<Entry<Integer, Producto>> entradas = entriesSortedByValues(treeAux);
			   Iterator<Entry<Integer, Producto>> iteratorTree = entradas.iterator();
			   String nombresProductos = "";
			
			   while (iteratorTree.hasNext())
			   {
				   Entry<Integer, Producto> entradaTree = iteratorTree.next();
				   nombresProductos += "\n"+entradaTree.getValue().toString();
				   builder.append(entradaTree.getKey()+nombresProductos);
			    }
			 //fin de recorrer arbol
			}	
		return builder.toString();
	}
		
	
	/**
	 * @author Fede
	 * @param tipo, categoria de producto seleccionada
	 * @param id codigo del producto elegido
	 * @return se retorna los datos del producto
	 * En este metodo se busca el producto que contenga los parametros pasados
	 * si se en cuentra, se retorna los datos
	 */
	public String nombreProducto (String tipo , int id) 
	{
		Iterator<Entry<String, TreeMap<Integer, Producto>>> it=catalogo.entrySet().iterator();
		Producto aux = null;
		String nombreProducto = "";
		
		while(it.hasNext())
		{
			Entry<String, TreeMap<Integer, Producto>> me=it.next();
			if(me.getKey().equals(tipo))
		    {
				TreeMap<Integer,Producto> treeAux = me.getValue();			
				Iterator<Entry<Integer, Producto>> iteratorTree = treeAux.entrySet().iterator();
				
				while(iteratorTree.hasNext())
				{
					Entry<Integer, Producto> entradaTree = iteratorTree.next();
					aux = entradaTree.getValue();
					
					if(aux.getId()==id)
						nombreProducto +=entradaTree.getValue().StringProducto();
				}
			}
		}
		return nombreProducto;
	}
	
	
	/**
	 * En este metodo se
	 * @param tipo que es la categoria elegida del producto a comprar
	 * @param id es el codigo que el producto seleccionado a comprar
	 * @param canti es la cantidad que el cliente compra, esto se resta con el stock del 
	 * 		  producto y se modifica
	 * @return
	 */
	public boolean comprar(String tipo,int id,int canti) 
	{
        Iterator<Entry<String, TreeMap<Integer, Producto>>> it=catalogo.entrySet().iterator();
		Producto aux = null;
		boolean flag = false; 
        
		while(it.hasNext())
		{
			Entry<String, TreeMap<Integer, Producto>> me=it.next();
			if(me.getKey().equals(tipo))
			{
				TreeMap<Integer,Producto> treeAux = me.getValue();
				
				Iterator<Entry<Integer, Producto>> iter = treeAux.entrySet().iterator();
				while(iter.hasNext())
				{
				    Entry<Integer, Producto> entradaTree=iter.next();
				    if(entradaTree.getKey()==id)
				    {
						aux = entradaTree.getValue();
						if(aux.disminuirStock(canti))
						{
							flag = true;
						}
						treeAux.put(aux.getId(), aux);
				    }
				}
				catalogo.put(tipo, treeAux);	
			}
		}
		return flag;		
	}
	
	
	/***
	 * @author Fede
	 * transforma los productos a formato json para luego guardarlos en un archivo
	 */
	public void formatoJson()
	{		
		try
		{
			JSONObject productos = new JSONObject();
			JSONArray televisores = new JSONArray();
			JSONArray smartphones = new JSONArray();
			JSONArray notebooks = new JSONArray();			
			
			Iterator<Entry<String, TreeMap<Integer, Producto>>> it=catalogo.entrySet().iterator();
			Producto aux = null;
			
			while(it.hasNext())
			{
				Entry<String, TreeMap<Integer, Producto>> me=it.next();
				TreeMap<Integer,Producto> treeAux = me.getValue();
					
				Iterator<Entry<Integer, Producto>> iter = treeAux.entrySet().iterator();
				while(iter.hasNext())
				{
					  Entry<Integer, Producto> entradaTree=iter.next();
					  aux =entradaTree.getValue();
					    if(aux.getTipo()=="televisor")
					    {
					    	televisores.put(aux.getFormatoJSON());
					    }
					    else if (aux.getTipo()=="smartphone")
					    {
					    	smartphones.put(aux.getFormatoJSON());
					    }
					    else if(aux.getTipo()=="notebook")
					    {
					    	notebooks.put(aux.getFormatoJSON());
					    }
				}
			}
			productos.put("televisores", televisores);
			productos.put("smartphones", smartphones);
			productos.put("notebook", notebooks);
			JsonUtiles.grabarproductos(productos);
		}
		catch(JSONException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author Fede
	 * este metodo lee los productos grabados en el archivo de productos en formato json
	 * @throws JSONException
	 */
	public void levantarJson() throws JSONException
	{
		String respuesta = JsonUtiles.leerProductos();
		
		JSONObject jsonObject = new JSONObject(respuesta);
		JSONArray array = jsonObject.getJSONArray("televisores");
		
		for(int i =0;i<array.length();i++)
		{
			JSONObject obj = array.getJSONObject(i);
			int id = obj.getInt("id");
			String tipo = obj.getString("tipo");
			String modelo = obj.getString("modelo");
			String marca = obj.getString("marca");
			double precio = obj.getDouble("precio");
			boolean habilitado = obj.getBoolean("habilitado");
			int stock = obj.getInt("stock");
			String resolucion = obj.getString("resolucion");
			int pulgadas = obj.getInt("pulgadas");
			boolean wifi = obj.getBoolean("wifi");
			Producto televisor = new Televisor(id,tipo,modelo,marca,precio,habilitado,stock,resolucion,pulgadas,wifi);
			agregar(televisor);
		}
		
		array = jsonObject.getJSONArray("smartphones");
		
		for(int i =0;i<array.length();i++)
		{
			JSONObject obj = array.getJSONObject(i);
			int id = obj.getInt("id");
			String tipo = obj.getString("tipo");
			String modelo = obj.getString("modelo");
			String marca = obj.getString("marca");
			double precio = obj.getDouble("precio");
			boolean habilitado = obj.getBoolean("habilitado");
			int stock = obj.getInt("stock");
			String procesador = obj.getString("procesador");
			int ram = obj.getInt("ram");
		    String resolucion = obj.getString("resolucion");
			int capacidad = obj.getInt("capacidad");
			boolean wifi = obj.getBoolean("wifi");
			boolean bluetooth = obj.getBoolean("bluetooth");
			int pulgadas = obj.getInt("pulgadas");
			int megapixeles = obj.getInt("megapixeles");
			String compania = obj.getString("compania");
			String red = obj.getString("red");
			Producto smartphone = new Smartphone(id, tipo, modelo, marca,  precio, habilitado, stock, procesador, ram, resolucion, capacidad, wifi, bluetooth, pulgadas, megapixeles, compania, red);
			agregar(smartphone);
		}		
	}
	
}