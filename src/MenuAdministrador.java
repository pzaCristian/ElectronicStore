import java.util.Scanner;

public class MenuAdministrador {
		
	/**
	 * @author Alex
	 * se creo un escaner para usarlo en todos los metodos de la clase, ya que en cada uno varia el tipo de dato a escanear
	 * */
	Scanner scan1 = new Scanner(System.in);
	
	/**
	 * @author Alex
	 * El metodo solo muestra mensajes para el administrador
	 */	
	public void  menu()
	{
		System.out.print("\n 1 - Mostrar Productos.");
		System.out.print("\n 2 - Mostrar Registros Clientes.");
		System.out.print("\n 3 - Cargar productos al sistema.");
		System.out.print("\n 4 - Cargar aumentar stock.");
		System.out.print("\n 0 - Salir");
	}
	
	/**
	 * @author Alex
	 * El metodo pide que ingrese una opcion, la escanea y la retorna
	 * @return la opcion escaneada para usarla en el metodo IniciarMenuAdministrador
	 */
	public int ingresarOpcion()
	{
		System.out.print("\nIngrese una opcion: ");
		int opcion = scan1.nextInt();
		return opcion;
	}

	
	/**
	 * @author Alex
	 * @param recibe el catalo de productos y el hashmap de los clientes cargados en el sistema
	 * El metodo crea un bojeto de tipo Fedalex para usar su metodo de pausa, para tener su ejecucion hasta que el usuario lo decida
	 * luego recibe la opcion escaneado en el metodo ingresarOpcion, para finalmente usarla en un switch y ejecutar la operacion correspondiente
	 * a ella
	 * */
	public void IniciarMenuAdministrador(Catalogo c, HashmapCliente cl) 
	{
		//CargarDatos cargar = new CargarDatos();
		//cargar.CargarProductos(c);
		Fedalex f = new Fedalex();		
		int opcion = 99;
		while(opcion != 0)				
		{
			menu();
			opcion = ingresarOpcion();
			switch(opcion)
			{
				case 1: System.out.print(c.listar()); f.Pausa(); break;
				
				case 2: MostrarRegistroClientes(cl);break;
				
				case 3: CargaManualmente(c); break;
				
				case 4: AgregarStock(c); break;
				
				case 0: SalirS();break;	
				
				default: System.out.println("\nLa opcion ingresada es incorrecta, intente nuevamente.\n");
			}
		}
		//return opcion;
	}
	
	
	/**
	 * @author Alex
	 * el metodo solo fue creado para dar un mensaje
	 * */
	public void SalirS(){System.out.print("\n\t\t\tSesion finalizada con exito.\n\n");}			
	
	
	/**
	 * @author Federico y Alex
	 * @param catalogo para trabajar con el 
	 * primero se escanea el id del producto a modificar su stock, usando el metodo comprobarIdAgregar del catalogo se comprueba su existencia, retorna 
	 * false si existe, en este caso pedira la cntidad que se compro y con el metodo aumentarStockProducto de catalogo se aumenta el stock de un producto
	 *  mediante su id, este producto no esta en el catalogo la operacion anterior no se ejecuta
	 * */
	public void AgregarStock(Catalogo c)
	{
		System.out.println("\nIngrese id del producto a aumentar stock: ");
		int idbuscar = scan1.nextInt();		 
		
		if(!c.comprobarIdAgregar(idbuscar))
		{
			System.out.println("\nCantidad que compro de este producto: ");
			int cantidadComprada = scan1.nextInt();
			c.aumentarStockProducto(cantidadComprada, idbuscar);	
		}
	}
	
	
	
	public void MostrarRegistroClientes(HashmapCliente c)
	{
		System.out.println("\nIngrese dni del cliente: ");
		int dniBuscar = scan1.nextInt();		 
		
		if(!c.comprobarCliente(dniBuscar))
			System.out.println(c.listarRegistrosClientes(dniBuscar));	
		else
			System.out.println("\nEl DNI del cliente ingresado, no existe.\n");
	}	
	
	
	/**
	 * @author Alex
	 * El metodo pide que ingrese una opcion, la escanea y la retorna
	 * @return la opcion escaneada para usarla en el metodo CargaManualmente
	 */
	public int elegirTipoProducto()
	{
		System.out.print("\n 1 - Televisores");
		System.out.print("\n 2 - Smartphone");
		System.out.print("\n 3 - Notebook");
		System.out.print("\nIngrese una opcion: ");
		int opcion= scan1.nextInt();
		return opcion;
	}
	
	
	/**
	 * @author Alex
	 * @param recibe el catalo de productos para trabajar con el
	 * El metodo crea un bojeto de tipo CargarDatos para usar sus metodo, depende que opcion de haya ingresado
	 * luego recibe la opcion escaneado en el metodo elegirTipoProducto, para finalmente usarla en un switch y ejecutar la operacion correspondiente
	 * a ella.
	 * */	
	public void CargaManualmente(Catalogo c)
	{
		//char letra = 's';
		
		//while(letra == 's')
		//{
			int cargar  = elegirTipoProducto();
			CargarDatos ca = new CargarDatos();
			
			switch(cargar)
			{
				case 1: ca.CargarTelevisor(c);break;
				
				case 2: ca.CargarSmartphone(c);break;
				
				case 3: ca.CargarNotebook(c);break;
				
				default: System.out.println("\n\t\tLa categoria elegida no es valida, reintente.\n");break;
			
			}
			
			//System.out.println("\nIngresar mas productos? Si o No");
			//letra = scan1.next().charAt(0);
		//}
	}
	
}