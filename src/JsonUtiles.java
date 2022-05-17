//import java.io.File;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class JsonUtiles {
	
	public static void grabarproductos(JSONObject object) {
		try 
		{
			FileWriter file = new FileWriter("productos.json");
			file.write(object.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String leerProductos() 
	{
		String contenido = "";
		try 
		{
			contenido = new String(Files.readAllBytes(Paths.get("productos.json")));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return contenido;
	}
	
	public static void grabarClientes(JSONObject object) {
		try {
			FileWriter file = new FileWriter("clientes.json");
			file.write(object.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String leerClientes() 
	{
		String contenido = "";
		try 
		{
			contenido = new String(Files.readAllBytes(Paths.get("clientes.json")));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return contenido;
	}
	
	
	public static boolean verificarExistenciaArchivoProductos(){
		
		File file = new File("productos.json");		
		return file.exists();
	}
	 
    public static boolean verificarExistenciaArchivoClientes(){
		
		File file = new File("clientes.json");		
		return file.exists();
	}
	 
}
	
	
	/*
	 public char Preguntar(){
		
		System.out.println("\nDesea crearlo nuevamente? ");
		scan = new Scanner(System.in);
		char continuar = scan.next().charAt(0);		
		return continuar;
	}
	
	public boolean VerificarExistenciaArchivo(){
		
		File file = new File("admin.txt");		
		return file.exists();
	}
	 * */