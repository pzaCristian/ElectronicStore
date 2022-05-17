import java.util.Scanner;

public class CargarDatos {
	
	public static Scanner scan = new Scanner(System.in);
	
	/**
	 * @author Alex
	 * El constructor de Cargardatos crea productos con datos precargados y por ultimo
	 * los agrega al catalogo, esto nos ayudo a cargar datos al sistema rapidamente para
	 * probar si funcionaba correctamente el catalgo 
	 * @param catalogo 
	 */
	///Constructor
	public CargarDatos() 
	{
		
	} 
	public void CargarProductos(Catalogo c) 
	{
		// Catalogo c= new Catalogo();		
		Televisor t1 = new Televisor(1, "televisor", "zxc45", "Jumanji", 56000, true, 5, "ultrahd", 45, true);
		CNotebook n1 = new CNotebook(2, "CNotebook", "aliali", "alienwar", 25000, true, 10 , "I 5", 16, "2k", 1000, true, true, "gigabyte", "rtx 2080ti");		
		Smartphone s1 = new Smartphone(3, "smartphone", "g5", "motorola", 5000, false, 3, "snap3", 5, "fullhd", 16, true, false, 7,13, "claro", "5g"); 
		
		Televisor t2 = new Televisor(4, "televisor", "juy45", "LG", 6000, true, 2, "ultrahd", 45, true);
		CNotebook n2 = new CNotebook(5, "CNotebook", "aliali", "alienwar", 65000, true, 1 , "I 9", 16, "2k", 2000, true, true, "msi", "rtx 2070ti");		
		Smartphone s2 = new Smartphone(6, "smartphone", "85jk", "motorola", 1000, false, 3, "suap", 5, "fullhd", 16, false, true, 7,8, "movistar", "4g"); 
		
		Televisor t3 = new Televisor(7, "televisor", "minimal", "sentey", 86000, true, 5, "ultrahd", 45, true);
		CNotebook n3 = new CNotebook(8, "CNotebook", "animalprint", "alienwar", 35000, false, 9 , "I 3", 16, "2k", 4000, true, false, "dell", "rtx 2060ti");		
		Smartphone s3 = new Smartphone(9, "smartphone", "switch", "kyocera", 3000, true, 3, "snap3", 5, "fullhd", 16, false, true, 7,21, "personal", "6g"); 
		
		Televisor t4 = new Televisor(10, "televisor", "coscu", "Jumanji", 6000, true, 5, "ultrahd", 45, true);
		CNotebook n4 = new CNotebook(11, "CNotebook", "gtc", "samsung", 15000, true, 20 , "I 5", 16, "2k", 500, true, true, "gigabyte", "rtx 1080ti");		
		Smartphone s4 = new Smartphone(12, "smartphone", "4x4x4", "mankie", 9000, true, 31, "fb3", 5, "fullhd", 16, true, true, 7,16, "movistar", "5g");
		
		Televisor t5 = new Televisor(13, "televisor", "super", "Tisue", 91000, false, 15, "ultrahd", 45, true);
		CNotebook n5 = new CNotebook(14, "CNotebook", "thermal", "steam", 2000, true, 12 , "I 7", 16, "2k", 1000, false, true, "msi", "rtx 3080ti");		
		Smartphone s5 = new Smartphone(15, "smartphone", "argentinium", "origin", 45000, false, 3, "tew45", 5, "fullhd", 16, true, false, 7,16, "claro", "3g"); 
		
		// a estos 3 productos no los debe cargar porque el id que tienen ya esta ingresado
		Televisor t0 = new Televisor(13, "televisor", "replay", "Repeti2", 92000, false, 60, "ultrahd", 55, true);
		Televisor t00 = new Televisor(13, "televisor", "replay2", "Repeti2", 96000, false, 55, "ultrahd", 65, true);
		Televisor t000 = new Televisor(13, "televisor", "replay3", "Repeti2", 93000, false, 32, "ultrahd", 75, true);		
		
		c.agregar(t1); c.agregar(s1); c.agregar(n1);		
		c.agregar(t2); c.agregar(s2); c.agregar(n2);
		c.agregar(t3); c.agregar(s3); c.agregar(n3);
		c.agregar(t4); c.agregar(s4); c.agregar(n4);		
		c.agregar(t5); c.agregar(s5); c.agregar(n5);		
		
		c.agregar(t0); c.agregar(t00); c.agregar(t000);					
	}	
		
		/**
		 * @author Alex
		 * El metodo pide todos los datos necesario para luego enviarselo al constructor de
		 * un smartphone crea uno con esos datos y lo agrega al catalogo recibido  
		 * @param catalogo 
		 */
		public void CargarSmartphone(Catalogo c)
		{
			boolean habilitado, wifi, bluetooth;
			int id, stock, ram, capacidad;
			String tipo, modelo, procesador, marca, resolucion,compania, red;
			int pulgadas, megapixeles;
			double precio;
			do
			{
			System.out.println("\nID:");
			id = scan.nextInt();
			}while(!c.comprobarIdAgregar(id));
			
			habilitado = true;
			tipo = "smartphone";
			
			System.out.println("\nModelo:");
			modelo = scan.next();
			
			System.out.println("\nCompania:");
			compania = scan.next();
			
			System.out.println("\nRed:");
			red = scan.next();
					
			System.out.println("\nProcesador: ");
			procesador = scan.next();
					
			System.out.println("\nMarca: ");
			marca = scan.next();
					
			System.out.println("\nResolucion: ");
			resolucion = scan.next();
					
			System.out.println("\nMegapixeles: ");
			megapixeles = scan.nextInt();
					
			System.out.println("\nPulgadas: ");
			pulgadas = scan.nextInt();
					
			System.out.println("\nStock: ");
			stock = scan.nextInt();
					
			System.out.println("\nCapacidad de ram: ");
			ram = scan.nextInt();
			
			System.out.println("\nAlmacenamiento: ");
			capacidad = scan.nextInt();
			
			System.out.println("\nTiene bluetooth: ");
			char blue = scan.next().charAt(0);
			if(blue == 's')
				bluetooth = true;
			else
				bluetooth = false;
			
			System.out.println("\nTiene WIFI: ");
			char wi = scan.next().charAt(0);
			if(wi == 's')
				wifi = true;
			else
				wifi = false;
		
			System.out.println("\nPrecio: ");
			precio = scan.nextDouble();	

			Smartphone smartphone = new Smartphone(id, tipo, modelo, marca, precio, habilitado, stock, procesador, ram, resolucion, capacidad, wifi, bluetooth, pulgadas, megapixeles, compania, red); 
					
			c.agregar(smartphone);
		}
		
		/**
		 * @author Alex
		 * El metodo pide todos los datos necesario para luego enviarselo al constructor de
		 * una notebook crea uno con esos datos y lo agrega al catalogo recibido  
		 * @param catalogo 
		 */
		public void CargarNotebook(Catalogo c)
		{
			boolean habilitado, wifi, bluetooth;
			int id, stock, ram, capacidad;
			String tipo, modelo, procesador, marca, resolucion,mother,placaDeVideo;
			double precio;
			
			do
			{
			System.out.println("\nID:");
			id = scan.nextInt();
			}while(!c.comprobarIdAgregar(id));
			
			habilitado = true;
			tipo = "notebook";
			
			System.out.println("\nModelo:");
			modelo = scan.next();
					
			System.out.println("\nProcesador: ");
			procesador = scan.next();
					
			System.out.println("\nMarca: ");
			marca = scan.next();
					
			System.out.println("\nResolucion: ");
			resolucion = scan.next();
					
			System.out.println("\nPlaca madre: ");
			mother = scan.next();
					
			System.out.println("\nPlaca de video: ");
			placaDeVideo = scan.next();
					
			System.out.println("\nStock: ");
			stock = scan.nextInt();
					
			System.out.println("\nCapacidad de ram: ");
			ram = scan.nextInt();
			
			System.out.println("\nAlmacenamiento: ");
			capacidad = scan.nextInt();
			
			System.out.println("\nTiene bluetooth: ");
			char blue = scan.next().charAt(0);
			if(blue == 's')
				bluetooth = true;
			else
				bluetooth = false;
			
			System.out.println("\nTiene WIFI: ");
			char wi = scan.next().charAt(0);
			if(wi == 's')
				wifi = true;
			else
				wifi = false;
		
			System.out.println("\nPrecio: ");
			precio = scan.nextDouble();	

			CNotebook notebook = new CNotebook(id, tipo, modelo, marca, precio, habilitado, stock, procesador, ram, resolucion, capacidad, wifi, bluetooth, mother, placaDeVideo);
			c.agregar(notebook);
		}
		
		
		/**
		 * @author Alex
		 * El metodo pide todos los datos necesario para luego enviarselo al constructor de
		 * un televisor crea uno con esos datos y lo agrega al catalogo recibido  
		 * @param catalogo 
		 */		
		public void CargarTelevisor(Catalogo c) {
			
			boolean habilitado, wifi;
			int id, stock, pulgadas;
			String tipo, modelo, marca, resolucion;			
			double precio;
			
			do
			{
				System.out.println("\nID:");
				id = scan.nextInt();
			}while(!c.comprobarIdAgregar(id));
			
			habilitado = true;
			tipo = "televisor";
			
			System.out.println("\nModelo:");
			modelo = scan.next();
			
			
			System.out.println("\nMarca: ");
			marca = scan.next();
					
			System.out.println("\nResolucion: ");
			resolucion = scan.next();
					
			
			System.out.println("\nPulgadas: ");
			pulgadas = scan.nextInt();
					
			System.out.println("\nStock: ");
			stock = scan.nextInt();
					
			System.out.println("\nTiene WIFI: ");
			char wi = scan.next().charAt(0);
			if(wi == 's')
				wifi = true;
			else
				wifi = false;
		
			System.out.println("\nPrecio: ");
			precio = scan.nextDouble();	
							
			Televisor tele = new Televisor(id, tipo, modelo, marca, precio, habilitado, stock, resolucion, pulgadas, wifi);
			c.agregar(tele);			
		}		
}