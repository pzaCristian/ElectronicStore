import java.util.Scanner;

public class Fedalex {
	
	private Scanner s;
	 char letra;

	public void QuienesSomos()
	{
	    System.out.print("\n\t\t\t Fedalex es la cadena lider en entretenimiento y electrodomesticos ");
	    System.out.print("\n\t\t\t de la Argentina,con sucursales en todo el pais. Trabajamos con el");
	    System.out.print("\n\t\t\t compromiso de brindar un asesoramiento personalizado y eficiente");
	    System.out.print("\n\t\t\t para que disfrutes de una muy buena experiencia de compra. Ademas");
	    System.out.print("\n\t\t\t ofrecemos las promociones y ofertas mas atractivas para acceder");
	    System.out.print("\n\t\t\t facilmente a la ultima tecnologia y a al confort que estas buscando.");
	    System.out.print("\n\t\t\t Fuimos precursores en e-commerce, una herramienta fundamental para");
	    System.out.print("\n\t\t\t que todo el mundo pueda buscar, comparar y comprar mejor desde internet.");
	    System.out.print("\n\t\t\t contamos con la logistica necesaria para llegar a cualquier rincon y del");
	    System.out.print("\n\t\t\t pais y un servicio tecnico orientado a solucionar cualquier inconveniente");
	    System.out.print("\n\t\t\t despues de la compra de cualquier producto. Por todas estas razones, a la");
	    System.out.print("\n\t\t\t hora de buscar tecnologia, entretenimiento, no des mas vueltas, veni a Fedalex.\n");
	}	
	
	public void Creditos()
	{
		System.out.print("      ===========================================================================================================");
		System.out.print("\n\t\t\t\t    FEDALEXSOFT\n\n   \t\t\t EMPRESA DE VENTAS DE ELECTODOMESTICOS.\n");
		System.out.print("\n\t\t\t\tAGRADECE AL LOS PROGRAMADORES:\n");
		System.out.print("\n\t\t\t    <> Palmieri Federico.\n");
		System.out.print("\n\t\t\t    <> Echeverria Alex. \n");
		System.out.print("\n\t\tPOR DISENIAR UNA PAGINA WEB DE LA EMPRESA Y ASI EXTENDER NUESTRO MERCADO VIA ONLINE.\n");
		System.out.print("      ===========================================================================================================\n");
	}
	
	public void Pausa() {
		
		s = new Scanner(System.in);
		System.out.println("\n\nPara continuar ingrese un caracter ... ");
		letra = s.next().charAt(0);
	}
}