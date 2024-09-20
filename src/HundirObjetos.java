
import java.util.Scanner;


/**
 *  Clase principal del juego de Hundir la Flota
 * 	Permite a dos jugadores jugar a hundir la flota mediante peticiones de números
 * 	y muestras por consola de mapas en forma de arrays bidimensionales de caracteres
 */
public class HundirObjetos {
	
	/*
	 * Funciones de clase
	 */
	
	// MIRAR PATRÓN BÚSQUEDA CONTROLADOR: MVC
	
	/**
	 * Creación de un Scanner de recogida de datos por consola accesible globalmente
	 */
	public static Scanner teclado = new Scanner(System.in);
	
	/**
	 * Función para solicitar números dentro de un rango por consola
	 * @param valorMinimo, define el valor mínimo del rango
	 * @param valorMaximo, define el valor máximo del rango
	 * @return, devuelve el valor del númeor introducido
	 */
	public static int pedirNumero(int valorMinimo, int valorMaximo) {
		    
			int numero;
	
		    do 
		    {
		        System.out.println("Por favor, introduce un número entre " + valorMinimo + " y " + valorMaximo + ": ");
		        numero = teclado.nextInt();
		        if(numero < valorMinimo || numero > valorMaximo)
		        {
		        	System.out.println("Número introducido no válido.");
		        }
	
		    } 
		    while (numero < valorMinimo || numero > valorMaximo);
	
		    
		    return numero;
		         
		}
	
	/**
	 * Método main del juego de Hundir la Flota
	 * @param args
	 */
	public static void main(String[] args) {
		

		//Tamaño del mapa
		int filas = 8;
		int columnas = 8;
		
		//Selectores de posición de jugador
		int seleccionX = 0;
		int seleccionY = 0;
		
		//Selector de opciones
		int selectorJugador = 0;
		
		//Opciones de jugador
		int numeroDeBarcos = 1;
		int tamañoBarco1 = 3;
		int tamañoBarco2 = 4;
		int tamañoBarco3 = 5;
		int tamañoBarco4 = 5;
		int tamañoBarco5 = 5;
		
		
		/*
		 /**
		  * Código dedicado a la personalización de las partidas
		  *
		System.out.println("Podéis jugar una partida normal o personalizada. Introducid 1 para personalizar, "
				+ "cualquier otro número para no personalizar:");
		selectorJugador = teclado.nextInt();
		
		if(selectorJugador == 1)
		{
			System.out.println("Elegid el tamaño del mapa."
					+ "\n¿Cuántas filas queréis que tenga?");
			filas = Mapa.pedirNumero(6, 15);
			System.out.println("¿Y cuántas columnas?");
			columnas = Mapa.pedirNumero(6, 15);
			
			System.out.println("¿Con cuántos barcos queréis jugar? Las opciones dependen del tamaño del mapa.");
			if(filas < 9 || columnas < 9)
			{
				numeroDeBarcos = Mapa.pedirNumero(1, 3);
			}
			else if(filas < 12 || columnas < 12)
			{
				numeroDeBarcos = Mapa.pedirNumero(1, 4);
			}
			else
			{
				numeroDeBarcos = Mapa.pedirNumero(1, 5);
			}
			
			
			System.out.println("¿Queréis personalizar también el tamaño de cada barco? Introducid 1 para personalizar, "
					+ "cualquier otro número para no personalizar:");
			selectorJugador = teclado.nextInt();
			if(selectorJugador == 1)
			{
				System.out.println("Como máximo tendrán 6 casillas, mínimo 2");
				for(int i=0; i<numeroDeBarcos; i++)
				{
					switch(i)
					{
					case 0: System.out.println("Primer barco: ");
						tamañoBarco1 = Mapa.pedirNumero(2, 6);
						break;
					case 1: System.out.println("Primer barco: ");
						tamañoBarco2 = Mapa.pedirNumero(2, 6);
						break;
					case 2: System.out.println("Primer barco: ");
						tamañoBarco3 = Mapa.pedirNumero(2, 6);
						break;
					case 3: System.out.println("Primer barco: ");
						tamañoBarco4 = Mapa.pedirNumero(2, 6);
						break;
					case 4: System.out.println("Primer barco: ");
						tamañoBarco5 = Mapa.pedirNumero(2, 6);
						break;
					}
				}
			}				
		}
		*/
		
		
		// Construcción de los objetos Mapa
		Mapa mapaJugador1 = new Mapa(filas, columnas);
		Mapa mapaJugador2 = new Mapa(filas, columnas);
		
		//Muestra por consola de las instrucciones del juego
		System.out.println("Juguemos a hundir la flota.\n");
		System.out.println("Dos jugadores van a colocar " + numeroDeBarcos + " barco(s) cada uno. "
				+ "\nSe pedirá la orientación del barco y la posición en los ejes X e Y (horizontal "
				+ "y vertical) de su primera casilla para colocar cada barco.");
		System.out.println("\nPulsa enter para continuar");
		teclado.nextLine();
		
		//Comienza el colocado de barcos. Cada jugador coloca sus barcos en el mapa interno 
		//del oponente.
		//Se hacen llamadas al método Mapa.colocarBarco un número de veces igual a la cantidad
		//de barcos seleccionada para el juego
		System.out.println("Jugador 1, coloca tus barcos.\n");
		
		for(int i=0; i<numeroDeBarcos; i++)
		{
			switch(i)
			{
			case 0: mapaJugador2.colocarBarco(tamañoBarco1);
				break;
			case 1: mapaJugador2.colocarBarco(tamañoBarco2);
				break;
			case 2: mapaJugador2.colocarBarco(tamañoBarco3);
				break;
			case 3: mapaJugador2.colocarBarco(tamañoBarco4);
				break;
			case 4: mapaJugador2.colocarBarco(tamañoBarco5);
				break;
			}
		}

		
	
		
		System.out.println("Así ha quedado tu mapa. ¡No se lo enseñes al enemigo!\n");
		mapaJugador2.printMapa();
		System.out.println("\nPulsa enter para continuar");
		teclado.nextLine();
		teclado.nextLine();
		
		for (int i = 0; i < 70; ++i) System.out.println();
		
		System.out.println("Jugador 2, coloca tus barcos.\n");
		
		
		for(int i=0; i<numeroDeBarcos; i++)
		{
			switch(i)
			{
			case 0: mapaJugador1.colocarBarco(tamañoBarco1);
				break;
			case 1: mapaJugador1.colocarBarco(tamañoBarco2);
				break;
			case 2: mapaJugador1.colocarBarco(tamañoBarco3);
				break;
			case 3: mapaJugador1.colocarBarco(tamañoBarco4);
				break;
			case 4: mapaJugador1.colocarBarco(tamañoBarco5);
				break;
			}
		}
		
		System.out.println("Así ha quedado tu mapa. ¡No se lo enseñes al enemigo!\n");
		mapaJugador1.printMapa();
		
		System.out.println("\nPulsa enter para continuar");
		teclado.nextLine();
		teclado.nextLine();

		for (int i = 0; i < 70; ++i) System.out.println();
		
	
		//Fase de disparos haciendo uso del método Mapa.disparo
		//Bucle while que se ejcuta mientras ambos jugadores tengan algún barco sin hundir
		//(barcosHundidos < barcosColocados). Se alterna el jugador mediante una variable que suma
		//y resta uno en cada iteración
		//Las llamadas al método disparo se hacen ajustando la selección de coordenadas a -1
		//para ajustar que el mapa se muestra comenzando por la coordenada 1 para los ejes
		//X e Y, mientras que los mapas internos están basasdos en arrays, y por lo tanto sus
		//coordenadas comienzan en 0
		
		System.out.println("Vamos con los diparos. En el mapa:"
				+ "\nUna X es una casilla desconocida"
				+ "\nUna T es una casilla de barco tocada"
				+ "\nUna H es una casilla de barco hundido"
				+ "\nUna A es agua\n"
				+ "\nTe pediré eje X (horizontal) "
				+ "\ny eje Y (vertical).\n\n¡A jugar!");
		
		while(mapaJugador1.getBarcosHundidos() < mapaJugador1.getBarcosColocados() 
				&& mapaJugador2.getBarcosHundidos() < mapaJugador2.getBarcosColocados())
		{
			switch(selectorJugador)
			{
			case 0:
				System.out.println("\nJugador 1, te toca."
						+ "\nAsí está tu mapa: \n");
				mapaJugador1.printMapaDeJuego();
				
				System.out.println("\n¿Dónde quieres apuntar?");
				System.out.println("Eje X: ");
				seleccionX = pedirNumero(1, columnas);
				System.out.println("Eje Y: ");
				seleccionY = pedirNumero(1, filas);
				
		
				mapaJugador1.disparo(seleccionX-1, seleccionY-1);
				selectorJugador++;
				
				break;
				
			case 1:
				System.out.println("\nJugador 2, te toca."
						+ "\nAsí está tu mapa: \n");
				mapaJugador2.printMapaDeJuego();
				
				System.out.println("\n¿Dónde quieres apuntar?");
				System.out.println("Eje X: ");
				seleccionX = pedirNumero(1, columnas);
				System.out.println("Eje Y: ");
				seleccionY = pedirNumero(1, filas);
				
		
				mapaJugador2.disparo(seleccionX-1, seleccionY-1);
				selectorJugador--;
				
				break;
			}		
			
		}
		
		//Muestra del ganador y los mapas internos de ambos jugadores tras la partida
		if(mapaJugador1.getBarcosHundidos() == mapaJugador1.getBarcosColocados())
		{
			System.out.println("\n¡Jugador 1 ha hundido todos los barcos!\n");			
		}
		else
		{
			System.out.println("\n¡Jugador 2 ha hundido todos los barcos!\n");			
		}
		
		System.out.println("\nBarcos del jugador 1:\n");
		mapaJugador2.printMapa();
		
		System.out.println("\nBarcos del jugador 2:\n");
		mapaJugador1.printMapa();
		
	}
	

}
