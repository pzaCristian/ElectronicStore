import java.util.Scanner;


public class MenuCliente {

	static Scanner scan;
	static int opcion;		
	
	public void  menu()
	{
		System.out.print("\n 1 - Mostrar Productos.");
		System.out.print("\n 2 - Quienes somos.");
		System.out.print("\n 3 - Creditos.");
		System.out.print("\n 0 - Salir");
	}
	
	public int ingresarOpcion()
	{
		scan = new Scanner(System.in);
		System.out.print("\nIngrese una opcion: ");
		opcion = scan.nextInt();
		return opcion;
	}

	public void iniciarMenuCliente(Catalogo c, HashmapCliente cl) 
	{
		//CargarDatos cargar = new CargarDatos();
		//cargar.CargarProductos(c);
		Fedalex f = new Fedalex();
		menu();
		opcion = ingresarOpcion();
		while(opcion != 0)				
		{
			switch(opcion)
			{
				case 1: System.out.print(c.listar()); iniciarCompra(c,cl); f.Pausa();iniciarMenuCliente(c,cl);break;
				
				case 2: f.QuienesSomos(); f.Pausa();iniciarMenuCliente(c,cl);iniciarMenuCliente(c,cl); break;
				
				case 3: f.Creditos(); f.Pausa();iniciarMenuCliente(c,cl);iniciarMenuCliente(c,cl); break;
					
				case 0:System.out.println(Salir());break;
				
				default: System.out.println("\nLa opcion ingresada es incorrecta, intente nuevamente.\n");
			}
		}
		//return opcion;
	}
	
	public void iniciarCompra(Catalogo c,HashmapCliente cl)
	{
		String tipo;
		int id=0;
		scan = new Scanner(System.in);
		String control;
		System.out.println("desea comprar algun producto: ");
        control= scan.next();
        if(control.equalsIgnoreCase("s"))
        {
        	elegirTipoProducto();
        	opcion = ingresarOpcion();
        	switch(opcion)
			{
				case 1: 
				    tipo = "televisor";cargarCompra(id,tipo,c,cl);break;
				case 2: 
					tipo = "smartphone";cargarCompra(id,tipo,c,cl);break;	
				case 3: 
					tipo = "notebook";cargarCompra(id,tipo,c,cl);break;					
				default:System.out.println("\nLa operacion ingresada es incorrecta, intente nuevamente.\n\n");break;	
			}   
        }        
	}
	
	public void cargarCompra(int id, String tipo, Catalogo cat, HashmapCliente cl)
	{
		System.out.println(cat.listarTipo(tipo));
		System.out.println("\n----------------------------\n");
		
		System.out.println("Id del producto que desea comprar:");
		 id= scan.nextInt();
		if(!cat.comprobarIdCompra(id,tipo))
		{
	       System.out.println("Cantidad: ");
	       int cantidad = scan.nextInt();
	       if(cat.comprar(tipo, id, cantidad))
	       {
	    	   System.out.println("Ingrese dni: ");
	           int dni = scan.nextInt();
		       System.out.println("Ingrese dia: ");
		       int dia = scan.nextInt();
		       System.out.println("Ingrese mes: ");
		       int mes = scan.nextInt();
		       System.out.println("Ingrese anio: ");
		       int anio = scan.nextInt();
	           String producto = cat.nombreProducto(tipo, id);
		       if(cl.comprobarCliente(dni))
    	       {
			       System.out.println("Ingrese nombre: ");
        	       String nombre = scan.next();
        	       System.out.println("Ingrese apellido: ");
    	           String apellido = scan.next();
    		       System.out.println("Ingrese telefono: ");
    		       int telefono = scan.nextInt();
    		       System.out.println("Ingrese domicilio: ");
    		       String domicilio = scan.next();
    		       Cliente cliente = new Cliente(nombre, apellido, dni, telefono, domicilio);
    		       RegistroCompras registro = new RegistroCompras(dni, producto, dia, mes, anio);
    		       cliente.agregarRegistro(registro);
    		       cl.agregar(cliente);
		  
    	       }else {
    		       RegistroCompras registro = new RegistroCompras(dni, producto, dia, mes, anio);
        	       cl.agregarRegistro(dni,registro);
    	       }
	       }else {
	    	System.out.println("\nNo disponemos del stock necesario");
	       }
		}else {
			System.out.println("\nId no disponible");
		}
	}
	
	
	public void elegirTipoProducto()
	{
		System.out.print("\n 1 - Televisores");
		System.out.print("\n 2 - Smartphone");
		System.out.print("\n 3 - Notebook");	
	}
	
	public String Salir() {return "\n\t\t\tGracias por su visita, vuelva pronto.\n\n";}
}
