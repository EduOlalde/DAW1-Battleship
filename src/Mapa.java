/**
 * Clase Mapa que contiene los atributos y métodos asociados al juego de hundir la flota
 */
public class Mapa {
	
	// Atributos
	/**
	 * Atributo filas: define el número de filas de los arrays
	 */
	private int filas;
	/**
	 * Atributo columnas: define el numero de columnas de los arrays
	 */
	private int columnas;
	/**
	 * Atributo mapa: array de caracteres con la representación gráfica del mapa interno de juego
	 */
	private char[][] mapa;
	/**
	 *  Atributo mapaDeJuego: objeto MapaDeJuego con el mapa que se muestra a los jugadores durante el juego
	 */
	private MapaDeJuego mapaDeJuego;
	
	/**
	 * Atributos Barco 1 a 5: objetos Barco que definen las características de los barcos colocados
	 */
	private Barco barco1;
	private Barco barco2;
	private Barco barco3;
	private Barco barco4;
	private Barco barco5;
	
	/**
	 * Atributo barcosColocados: número de barcos colocados en el Mapa
	 */
	private int barcosColocados;
	/**
	 * Atributo barcosHundidos: número de barcos hundidos en el Mapa
	 */
	private int barcosHundidos;

	
	
	// Constructores
	
	/**
	 * Constructor vacío con valores por defecto (tamaño de mapa de 
	 * 8 filas y columnas)
	 */
	public Mapa() {
		this.filas = 8;
		this.columnas = 8;
		this.mapa = new char[filas][columnas];
		this.barcosColocados = 0;
		this.barcosHundidos = 0;
		
		this.barco1 = new Barco(0);
		this.barco2 = new Barco(0);
		this.barco3 = new Barco(0);
		this.barco4 = new Barco(0);
		this.barco5 = new Barco(0);
		
		this.mapaDeJuego = new MapaDeJuego(8,8);
		
		mapa = inicializadorArray();
	}
	
	
	/**
	 * Constructor parcial personalizable en tamaño con barcos por defecto
	 * @param filas: Ajusta el número de filas
	 * @param columnas: Ajusta el número de columnas
	 */
	public Mapa(int filas, int columnas) {
			
		this.mapa = new char[filas][columnas];
		this.filas = filas;
		this.columnas = columnas;
		this.barcosColocados = 0;
		this.barcosHundidos = 0;
		
		this.barco1 = new Barco(0);
		this.barco2 = new Barco(0);
		this.barco3 = new Barco(0);
		this.barco4 = new Barco(0);
		this.barco5 = new Barco(0);
		
		this.mapaDeJuego = new MapaDeJuego(filas,columnas);
		
		mapa = inicializadorArray();
		
	}
		
	// Setters y Getters
	
	/**
	 * Conjunto de getters y setters para cada atributo
	 * @return
	 */
	public int getFilas(){
		return this.filas;
	}
	
	public void setFilass(int pFilas) {
		this.filas = pFilas;
	}
	
	public int getColumnas(){
		return this.columnas;
	}
	
	public void setColumnas(int pColumnas) {
		this.filas = pColumnas;
	}
	
	public char[][] getMapa(){
		return this.mapa;
	}
	
	public void setMapa(char[][] pMapa) {
		this.mapa = pMapa;
	}
	
	public int getBarcosColocados() {
		return barcosColocados;
	}
	
	public void setBarcosColocados(int pBarcosColocados) {
		this.barcosColocados = pBarcosColocados;
	}
	
	public int getBarcosHundidos() {
		return barcosHundidos;
	}
	
	public void setBarcosHundidos(int pBarcosHundidos) {
		this.barcosHundidos = pBarcosHundidos;
	}
	
	
	/**
	 * Getter que devuelve el contendo de una coordenada del mapa
	 * @param x
	 * @param y
	 * @return char contenido en la coordenada
	 */
	public char getCoorMapa(int x, int y) {
		return this.mapa[x][y];
	}
	
	/**
	 * Setter que modifica el contendo de una coordenada del mapa
	 * @param x
	 * @param y
	 */
	public void setCoorMapa(int x, int y, char caracter) {
		this.mapa[x][y] = caracter;
	}
	
	/**
	 * Getter para una coordenada del mapa de juego
	 * @param x: Valor del eje X
	 * @param y: Valor del eje Y
	 * @return: Devuelve el contenido de esa coordenada
	 */
	public char getCoorMapaDeJuego(int x, int y) {
		return this.mapaDeJuego.getCoorMapa(x, y);
	}
	
	public void setCoorMapaDeJuego(int x, int y, char caracter) {
		this.mapaDeJuego.setCoorMapa(x, y, caracter);
	}
	
	/**
	 * 
	 * @param x indica el numero de la casilla que se quiere obtener (1º, 2ª, 3ª, etc.)
	 * @param barco indica el número identificador del barco (1, 2, 3 para barco1, barco2, barco3....
	 * @return
	 */
	public int getCoordenadaXBarco(int x, int barco) {
		int coordenada = 0;
		switch(barco) {
		case 1:
			coordenada = this.barco1.getCoordenadaX(x);
			break;
		case 2:
			coordenada = this.barco2.getCoordenadaX(x);
			break;
		case 3:
			coordenada = this.barco3.getCoordenadaX(x);
			break;
		}
		return coordenada;
		
	}
	
	/**
	 * 
	 * @param x indica el numero de la casilla que se quiere obtener (1º, 2ª, 3ª, etc.)
	 * @param barco indica el número identificador del barco (1, 2, 3 para barco1, barco2, barco3...)
	 * @return
	 */
	public int getCoordenadaYBarco(int x, int barco) {
		int coordenada = 0;
		switch(barco) {
		case 1:
			coordenada = this.barco1.getCoordenadaY(x);
			break;
		case 2:
			coordenada = this.barco2.getCoordenadaY(x);
			break;
		case 3:
			coordenada = this.barco3.getCoordenadaY(x);
			break;
		}
		return coordenada;
		
	}
	
	
	/**
	 * 
	 * @param barco define de qué barco quieres obtener el número de casillas
	 * @return el número de casillas
	 */
	public int getNumeroCasillas(int barco) {
		int numeroCasillas = 0;
		switch(barco) {
		case 1:
			numeroCasillas = this.barco1.getNumeroCasillas();
			break;
		case 2:
			numeroCasillas = this.barco2.getNumeroCasillas();
			break;
		case 3:
			numeroCasillas = this.barco3.getNumeroCasillas();
			break;
		case 4:
			numeroCasillas = this.barco4.getNumeroCasillas();
			break;
		case 5:
			numeroCasillas = this.barco5.getNumeroCasillas();
			break;
		}
		
		return numeroCasillas;
	}
	
	/**
	 * @deprecated setter inservible
	 * @param numero indica el nuevo número 
	 * @param barco define de qué barco vas a modificar el número de casillas
	 */
	public void setNumeroCasillas(int numero, int barco) {
		switch(barco) {
		case 1:
			this.barco1.setNumeroCasillas(numero);
			break;
		case 2:
			this.barco2.setNumeroCasillas(numero);
			break;
		case 3:
			this.barco3.setNumeroCasillas(numero);
			break;
		case 4:
			this.barco4.setNumeroCasillas(numero);
			break;
		case 5:
			this.barco5.setNumeroCasillas(numero);
			break;
		}
	}
	
	
/**
 * 
 * @param barco indica el número del barco del que queremos la información
 * @return la cantidad de veces que se ha conseguido un tocado en el barco
 */
	public int getContadorTocado(int barco) {
		int numeroCasillas = 0;
		switch(barco) {
		case 1:
			numeroCasillas = this.barco1.getContadorTocado();
			break;
		case 2:
			numeroCasillas = this.barco2.getContadorTocado();
			break;
		case 3:
			numeroCasillas = this.barco3.getContadorTocado();
			break;
		case 4:
			numeroCasillas = this.barco4.getContadorTocado();
			break;
		case 5:
			numeroCasillas = this.barco5.getContadorTocado();
			break;
		}
		
		return numeroCasillas;
	}
	
	/**
	 * 
	 * @param numero indica el nuevo número para el contador
	 * @param barco indica el barco a modificar
	 */
	public void setContadorTocado(int numero, int barco) {
		switch(barco) {
		case 1:
			this.barco1.setContadorTocado(numero);
			break;
		case 2:
			this.barco2.setContadorTocado(numero);
			break;
		case 3:
			this.barco3.setContadorTocado(numero);
			break;
		case 4:
			this.barco4.setContadorTocado(numero);
			break;
		case 5:
			this.barco5.setContadorTocado(numero);
			break;
		}
	}
		
	
	
	// Métodos estándar
	
	/**
	 * @return Método que devuelve el array inicializado al valor base 'X'
	 */
	public char[][] inicializadorArray() {
		
		for(int i=0; i<columnas; i++)
		{
			for(int j=0; j<filas; j++)
			{
				mapa[i][j] = 'X';
			}
			
		}
		
		return mapa;
	}
	
	
	/**
	 * Método que muestra el mapa interno del objeto Mapa actualpor consola formateado 
	 * por líneass y columnas adaptable al tamaño del mapa
	 */
	public void printMapa() {
		System.out.print("    ");
		for(int i=0; i<columnas; i++)
		{
			if(i<9)
			{
				System.out.print((i+1 + "  "));
			}
			else
			{
				System.out.print((i+1 + " "));
			}
		}
		System.out.println();
		System.out.println();
		for(int i=0; i<filas; i++)
		{
			if(i<9)
			{
				System.out.print((i+1 + "  "));
			}
			else
			{
				System.out.print((i+1 + " "));
			}
			
			
			for(int j=0; j<columnas; j++)
			{
				System.out.print(" " + mapa[j][i] + " ");
			}
			System.out.println();
		}	
	}
	
	/**
	 * Método que muestra por consola el mapa de juego perteneciente al objeto Mapa actual.
	 */
	public void printMapaDeJuego() {
		this.mapaDeJuego.printMapa();
	}
	
	public boolean checkSolapa(char[][] array, int x, int y) {
		boolean check = false;	
		if(array[x][y] == 'O')
		{
			check = true;
		}
		return check;
	}
	
	
	/**
	 * Método que ejecuta la colocación de un barco. Tiene las funciones de pedir la orientación
	 * y coordenadas de la primera casillas, comprueba si hay alguna casillas de otro barco actualmente 
	 * colocado en alguna de las coordenadas, y de no haberlo, modifica los caracteres del mapa del jugador,
	 * además de asignar las coordenadas al siguiente atributo Barco vacío.
	 * @param teclado: El método utiliza el Scanner del método principal
	 * @param casillas: Parámetro que asigna el tamaño del barco en número de casillas
	 */
public void colocarBarco (int casillas){
		
		int seleccionX = 0;
		int seleccionY = 0;
		int orientacion = 0;
		boolean checkSolapa = false;
		Barco barcoAux = new Barco(casillas);
		
		
		System.out.println("Vas a colocar un barco de " + casillas + " casillas.\n");
		
		//Bucle do/while que comprueba que se repite si se está intentando poner un barco
		//solapado con otro.
		do {
			//Llamada al método printMapa para mostrar el estado actual del mapa.
			System.out.println("Así está tu mapa:\n");
			printMapa();
			
			
			//Booleano de comprobación de si se está intentando colocar un barco encima de otro.
			//Esta variable determina cuaándo se termina el bucle de colocación de barco
			checkSolapa = false;
			
			System.out.println("\n¿Lo quieres poner en horizontal (1), vertical (2), o diagonal (3)? " 
			+ "\nIntroduce el número de tu selección.");
			orientacion = HundirObjetos.pedirNumero(1, 3);
			
			//Selector de dirección de posición del barco basado en la selección del jugador
			switch(orientacion)
			{
			
			//Caso horizontal
			
			case 1:
				//Cada caso pide al jugador las coordenadas para la primera casilla
				//limitádolas de formas que el barco no pueda salirse del mapa
				System.out.println("\n¿En qué posición del eje X?"); 
				seleccionX = HundirObjetos.pedirNumero(1, columnas-casillas+1);
				
				System.out.println("En qué posición del eje Y?");
				seleccionY = HundirObjetos.pedirNumero(1, filas);
				
				//Llamada al método checkSolapa,que compprueba si el arco que se está intentando
				//colocar actualmente se solapa con uno colocado anteriormente
				//Se usa una estructura que comprueba cada posición en la que se va a poner el barco.
				//Si alguna de las posiciones ya contenía un barco, el booleano checkSolapa se hace "true".
				//En caso de que esto ocurra al menos una vez, checkSolapa2 se hace true, y no permite colocar
				//el barco.
			
				
				for(int i=0; i<=casillas-1 && checkSolapa == false; i++)
				{				
					checkSolapa = checkSolapa(mapa, seleccionX + i-1, seleccionY-1);						
				}
		
				//Si es false, se ejecuta la colocación del barco cambiando cada casilla de la X original a una O.
				if(checkSolapa == false)
				{
					for(int i=0; i<=casillas-1; i++)
					{			
							mapa[seleccionX + i-1][seleccionY-1] = 'O';	
					}
					barcoAux.posicionBarco(seleccionX-1, seleccionY-1, 1);
					
				}
				
				break;
				
			//Caso vertical
				
			case 2:
				
				System.out.println("\n¿En qué posición del eje X?"); 
				seleccionX = HundirObjetos.pedirNumero(1, columnas);
				
				System.out.println("En qué posición del eje Y?");
				seleccionY = HundirObjetos.pedirNumero(1, filas-casillas+1);	
							
				for(int i=0; i<=casillas-1 && checkSolapa == false; i++)
				{
					checkSolapa = checkSolapa(mapa, seleccionX -1, seleccionY+i-1);		
				
				}
				
				
				if(checkSolapa == false)
				{
					for(int i=0; i<=casillas-1; i++)
					{		
							mapa[seleccionX-1][seleccionY+i-1] = 'O';	
					}
					barcoAux.posicionBarco(seleccionX-1, seleccionY-1, 2);
				}
				break;
			
			//Caso diagonal
				
			case 3:
				
				System.out.println("¿Hacia la derecha (1) o izquierda (2)?");
				orientacion = HundirObjetos.pedirNumero(1, 2);
				
				switch(orientacion)
				{
				case 1:
					System.out.println("\n¿En qué posición del eje X?"); 
					seleccionX = HundirObjetos.pedirNumero(1, columnas-casillas+1);
					
					System.out.println("En qué posición del eje Y?");
					seleccionY = HundirObjetos.pedirNumero(1, filas-casillas+1);
					
				
					
					for(int i=0; i<=casillas-1 && checkSolapa == false; i++)
					{	
						checkSolapa = checkSolapa(mapa, seleccionX + i - 1, seleccionY + i - 1);
					}
					
					
					if(checkSolapa == false)
					{
						for(int i=0; i<=casillas-1; i++)
						{
						
							mapa[seleccionX + i - 1][seleccionY + i - 1] = 'O';	
						}
						barcoAux.posicionBarco(seleccionX-1, seleccionY-1, 3);
					}
					
					break;
				case 2:
					System.out.println("\n¿En qué posición del eje X?"); 
					seleccionX = HundirObjetos.pedirNumero(casillas, columnas);
					
					System.out.println("En qué posición del eje Y?");
					seleccionY = HundirObjetos.pedirNumero(1, filas-casillas+1);
		
					for(int i=0; i<=casillas-1 && checkSolapa == false; i++)
					{						
						checkSolapa = checkSolapa(mapa, seleccionX - i - 1, seleccionY + i - 1);
					}
				
					
					if(checkSolapa == false)
					{
						for(int i=0; i<=casillas-1; i++)
						{
						
							mapa[seleccionX - i - 1][seleccionY + i - 1] = 'O';
						}
						barcoAux.posicionBarco(seleccionX-1, seleccionY-1, 4);
					}
					break;
					
				}
					
			}	
			
			if(checkSolapa == true)
			{
				System.out.println("Estás intentando poner un barco encima de otro, elige posición de nuevo.");
				System.out.println();
			}
			else
			{
				System.out.println("¡Barco colocado!\n");
				
				switch(barcosColocados+1)
				{
				case 1:
					this.barco1 = barcoAux;
					break;
				case 2:
					this.barco2 = barcoAux;
					break;
				case 3:
					this.barco3 = barcoAux;
					break;
				}	
			}
			
		}
		while(checkSolapa == true);
		this.barcosColocados++;

	}


/**
 * Método que se ejecuta cuando un barco ha sido tocado en el mapa. 
 * El método busca qué barco ha sido tocado, aumenta su contador de tocado
 * y comprueba si ha sido hundido.
 * @param x coordenada X a buscar
 * @param y coordenada y a buscar
 * @return array de 2 celdas, donde la celda 0 indica el barco que ha sido tocado
 * 			y la celda 1 indica si está hundido (0 = no hundido, 1 = hundido)
 */
public int[] barcoTocado(int x, int y) {
	int[] barcoTocado = new int[2];
	
	for(int j = 1; j <= barcosColocados; j++)
	{
		for(int i=0; i<getNumeroCasillas(j); i++)
		{
			if(x == getCoordenadaXBarco(i,j) && y == getCoordenadaYBarco(i,j))
			{
				barcoTocado[0] = j;
				setContadorTocado((getContadorTocado(j)+1),j);
				if(getNumeroCasillas(j) == getContadorTocado(j))
					{
						barcoTocado[1] = 1;
					};
			}
		}
	}	
	return barcoTocado;
}


/**
 * Método que ejecuta un "disparo" a una casilla, devolviendo el resultado del disparo por mensaje en
 * consola, modificando los mapas del jugador y de juego, y aisgnando el estado de tocado o hundido
 * al barco adecuado si es que un barco ha sido tocado.
 */
public void disparo(int x, int y) {

	int[] tocado = new int[2];
	
	switch(getCoorMapa(x, y))
	{
	case 'O':
		
		tocado = barcoTocado(x, y);
			
		if(tocado[1] == 1)
		{
			barcosHundidos++;
			System.out.println("¡Hundido!");

			for(int i=0; i<getNumeroCasillas(tocado[0]); i++)
			{
				setCoorMapaDeJuego(getCoordenadaXBarco(i, tocado[0]), getCoordenadaYBarco(i, tocado[0]), 'H');
			}
			for(int i=0; i<getNumeroCasillas(tocado[0]); i++)
			{
				setCoorMapa(getCoordenadaXBarco(i, tocado[0]), getCoordenadaYBarco(i, tocado[0]), 'H');
			}
			
		}
		else
		{
			System.out.println("¡Tocado!");
			setCoorMapaDeJuego(x, y, 'T');
			setCoorMapa(x, y, 'T');
		}
		break;
	
	case 'X':
		System.out.println("¡Agua!");
		setCoorMapaDeJuego(x, y, 'A');
		setCoorMapa(x, y, 'A');
		break;
		
	case 'A':
		System.out.println("¡Ya habías disparado aquí!");
		break;
		
	case 'T':
		System.out.println("¡Ya habías disparado aquí!");
		break;
		
	case 'H':
		System.out.println("¡Ya habías disparado aquí!");
		break;
	}	
	

	
	System.out.println();
}


}
