import org.json.JSONException;
import org.json.JSONObject;

public abstract class Producto implements Comparable<Producto>{
	
	private int id;
	private String tipo;
	private String modelo;
	private String marca;
	private double precio;
	private boolean habilitado;
	private int stock;
	
	/**
	 * @author Alex
	 * constructor por defecto, crea el objeto en vacio
	 */
	public Producto(){}
	
	
	/**
	 * @author Alex
	 * constructor, crea el objeto en con los datos anteriormente ingresados usando los metodos set de cada atributo
	 */
	public Producto(int id,String tipo,String modelo,String marca,double precio,boolean habilitado,int stock) {
		
		setId(id);
		setTipo(tipo);
		setModelo(modelo);
		setMarca(marca);
		setPrecio(precio);
		setHabilitado(habilitado);
		setStock(stock);
	}
	
	
	/**
	 * metodos gets y set para retornar el valor de los atributos de los metodos y asignarolos
	 * @author Alex
	 */
	public int getId() {return id;}	
	public void setId(int id) {this.id = id;}	
	public String getTipo() {return tipo;}
	public void setTipo(String tipo) {this.tipo = tipo;}
	public String getModelo() {return modelo;}	
	public void setModelo(String modelo) {this.modelo = modelo;}	
	public String getMarca() {return marca;}	
	public void setMarca(String marca) {this.marca = marca;}	
	public double getPrecio() {return precio;}	
	public void setPrecio(double precio) {this.precio = precio;}	
	public boolean isHabilitado() {return habilitado;}	
	public void setHabilitado(boolean habilitado) {this.habilitado = habilitado;}	
	public int getStock() {return stock;}	
	public void setStock(int stock) {this.stock = stock;}
	
	
	/**
	 * metodos que recibe la cantidad del producto que se compro y la suma con lo que habia de stock
	 * luego modifica el resultado de la suma al stock del producto
	 * @author Alex
	 */
	public void aumentarStock(int s)
	{
	  int nuevoStock = getStock()+ s; 
	  setStock(nuevoStock);
	}
	
	
	/**
	 * metodos que recibe la cantidad del producto que se compro y la resta con lo que habia de stock
	 * luego modifica el resultado de la resta al stock del producto
	 * @author Alex
	 */
	public boolean disminuirStock(int s)
	{
		boolean flag = false;
		
		if(s <= getStock())
		{
			setStock(getStock()-s);
			flag = true;
		}
		return flag;
	}
	
	/**
	 * @author Alex
	 * se obtienen, se agrupan todos los datos y se retornan
	 */
	@Override
	public String toString()
	{
		return "\nID: "+getId()+"\nTipo: "+getTipo()+"\nMarca: "+getMarca()+"\nModelo: "+getModelo()+"\nStock: "+getStock()+"\nPrecio: "+getPrecio()+"\n";
	}

	
	/**
	 * @author Alex
	 * se verifica que el id el objeto no este registrado en el sistema
	 * @return el resultado de la existencia, falso si no existe
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if(obj!=null && obj instanceof Producto)
		{
			Producto p = (Producto) obj;
			if(p.getId()==getId())
			{
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	
	/**
	 * @author Alex
	 * @return la info del prodcuto en formato string
	 */
	public String StringProducto() 
	{
		return getTipo()+" "+getMarca()+" "+getModelo();
	}

	/**
	 * @param o es un producto que se envia por parametro
 	 * @author Alex
	 * @return el resulado de la comparacion de precios del producto recibido con el actual
	 */
    @Override
    public int compareTo(Producto o) {
	    int resultado = 0;

	    if(getPrecio() == o.getPrecio())
	    {
		    return resultado;
	    }
	    else if(getPrecio() < o.getPrecio())
	    {
		    return resultado = -1;
	    }
	    else if(getPrecio() > o.getPrecio())
	    {
		    return resultado = 1;
	    }
	    return resultado;
    }

    
    @Override
    public int hashCode() {
	   return 1;
    }
    
    public abstract JSONObject getFormatoJSON() throws JSONException;
}