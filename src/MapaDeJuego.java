
public class MapaDeJuego {
	
	//Atributos
	
	/**
	 * Atributo filas: define el número de filas del array
	 */
	private int filas;
	/**
	 * Atributo columnas: define el número de columnas del array
	 */
	private int columnas;
	/**
	 * Atributo mapa: array de caracteres con la representación gráfica del mapa de juego
	 */
	private char[][] mapa;
	
	public MapaDeJuego() {
		this.filas = 8;
		this.columnas = 8;
		this.mapa = new char[filas][columnas];
		
		mapa = inicializadorArray();
	}
	
	public MapaDeJuego(int filas, int columnas) {
		
		this.mapa = new char[filas][columnas];
		this.filas = filas;
		this.columnas = columnas;
		
		mapa = inicializadorArray();
		
	}
	
	
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
	
	
	//Métodos estándar
	
	/**
	 * @return Método que devuelve el array inicializado
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
	 * Método que muestra el mapa por consola formateado por líneass y columnas
	 * adaptable al tamaño del mapa
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

}
