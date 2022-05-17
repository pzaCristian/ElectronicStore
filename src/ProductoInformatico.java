public abstract class ProductoInformatico extends Producto{
	
	private String procesador;
	private int ram;
	private String resolucion;
	private int capacidad;
	private boolean wifi;
	private boolean bluetooth;
	
	public ProductoInformatico(int id,String tipo, String modelo,String marca,double precio,boolean habilitado,int stock,String procesador, int ram, String resolucion, int capacidad, boolean wifi,boolean bluetooth)
	{
		super(id,tipo,modelo,marca,precio,habilitado,stock);
		this.procesador = procesador;
		this.ram = ram;
		this.resolucion = resolucion;
		this.capacidad = capacidad;
		this.wifi = wifi;
		this.bluetooth = bluetooth;
	}
	
	public ProductoInformatico() {
		
		super();
		setProcesador("");
		setRam(0); 
		setResolucion("");
		setCapacidad(0);
		setWifi(false);
		setBluetooth(false);
	}
	
	public String resWifi()
	{
		if(isWifi() == true)
			return "wifi: si\n";
		else
			return "wifi: no\n\n";	
	}
	
	public String resbluetooth()
	{
		if(isWifi() == true)
			return "bluetooth: si\n";
		else
			return "bluetooth: no\n\n";	
	}

	public String getProcesador() {return procesador;}

	public void setProcesador(String procesador) {this.procesador = procesador;}

	public int getRam() {return ram;}

	public void setRam(int ram) {this.ram = ram;}

	public String getResolucion() {return resolucion;}

	public void setResolucion(String resolucion) {this.resolucion = resolucion;}

	public int getCapacidad() {return capacidad;}

	public void setCapacidad(int capacidad) {this.capacidad = capacidad;}

	public boolean isWifi() {return wifi;}

	public void setWifi(boolean wifi) {this.wifi = wifi;}

	public boolean isBluetooth() {return bluetooth;}

	public void setBluetooth(boolean bluetooth) {this.bluetooth = bluetooth;}
	

}