import java.util.Scanner;
import org.json.JSONException;

public class IniciarPrograma {
	
	private Scanner s = new Scanner(System.in);	
	
	public IniciarPrograma(){}	
	
	public void Ejecucion(){
		IngresoComo();
	}	
	
	public int MostrarMenu(){
		
		System.out.println("\n\t\t\t< BIENVENIDO A FEDALEX >\n");
		System.out.println("Opcion 1: Ingresar como cliente.");
		System.out.println("Opcion 2: Ingresar como administrador.");
		System.out.println("Opcion 0: Salir.");
		System.out.println("\nEjecutar la operacion: ");
		return s.nextInt();
	}
	
	public int IngresoComo()//(char nueva)
	{
		
		MenuCliente cliente = new MenuCliente();
		MenuAdministrador administrador = new MenuAdministrador();
		Catalogo catalogo1 = new Catalogo();
		int op = 99; 
		HashmapCliente clientes1 = new HashmapCliente();
		
		try
		{
			if(JsonUtiles.verificarExistenciaArchivoProductos())
			{
				catalogo1.levantarJson();
			}
		} 
		catch (JSONException e) {
			e.printStackTrace();
		}
		try
		{
			if(JsonUtiles.verificarExistenciaArchivoClientes())
			{
				clientes1.levantarJson();
			}
		} 
		catch (JSONException e) {
			e.printStackTrace();
		}
		
		while(op != 0)// && nueva != 'n')
		{
			op = MostrarMenu();	
			switch(op)
			{
				case 1: //op = cliente.iniciarMenuCliente(catalogo1, clientes1);
						cliente.iniciarMenuCliente(catalogo1, clientes1);
						break;
					
				case 2: //op = administrador.IniciarMenuAdministrador(catalogo1, clientes1);
						administrador.IniciarMenuAdministrador(catalogo1, clientes1);
					break;				
				
				case 0: catalogo1.formatoJson();clientes1.formatoJson();System.out.println("\n\t\t\t\tCerrando sesion ...");
						Despedida();
						break;
					
				default:System.out.println("\nLa operacion ingresada es incorrecta, intente nuevamente.\n\n");
						break;						
			}
		}		
		return op;
	}
		
	public void Despedida()
	{
		System.out.println("\n\t\t\t\t Sesion finalizada.");
		System.out.println("\n\t\t\t     Gracias por visitar Fedalex.\n");		
	}

}