
public class Barco {

	/**
	 * Atributo posición: array de dos filas donde cada pareja de números de coordenadas [n][0] y [n][1] 
	 * 					almacena las coordenadas X e Y respectivamente de cada casilla de un barco
	 */
	private int[][] posicion;
	/**
	 * Atributo numeroCasillas: número entero que representa la cantidad de casillas del barco
	 */
	private int numeroCasillas;
	/**
	 * Atributo contadorTocado: número entero que almacena la cantidad de veces que un barco ha sido 
	 * 					alcanzado en un disparo
	 */
	private int contadorTocado;
	
	
	//Constructor
	
	/**
	 * Constructor vacío de Barco, tamaño por defecto de 3 casillas
	 */
	public Barco() {
		this.posicion = new int[8][2];
		this.numeroCasillas = 3;
		this.contadorTocado = 0;
		
		for(int i=0; i < 8; i++)
		{
			posicion[i][0] = -1;
			posicion[i][1] = -1;
		}
	}
	
	/**
	 * Contructor completo parametrizado de Barco
	 * @param numeroCasillas, cantidad de casillas del Barco
	 */
	public Barco(int pNumeroCasillas) {
		this.posicion = new int[8][2];
		this.numeroCasillas = pNumeroCasillas;
		this.contadorTocado = 0;
		
		for(int i=0; i < 8; i++)
		{
			posicion[i][0] = -1;
			posicion[i][1] = -1;
		}
	}
	
	//Getters y setters
	
	public int getCoordenadaX (int x) {
		return posicion[x][0];
	}
	
	public int getCoordenadaY (int x) {
		return posicion[x][1];
	}
	
	public int getNumeroCasillas() {
		return this.numeroCasillas;
	}
	
	public void setNumeroCasillas(int numero) {
		this.numeroCasillas = numero;
	}
	
	public int getContadorTocado() {
		return this.contadorTocado;
	}
	
	public void setContadorTocado(int x) {
		this.contadorTocado = x;
	}
	
	
	
	public void barcoToString() {
		
		System.out.println("Barco de " + numeroCasillas + " casillas en las coordenadas: ");
		
		for(int i=0; i<2; i++)
		{
			if(i==0)
			{
				System.out.print("Coordenadas X: ");
			}
			else
			{
				System.out.print("Coordenadas Y: ");
			}
			
			for(int j=0; j<numeroCasillas; j++)
			{
				System.out.print(posicion[j][i] + " ");
			}
			System.out.println();
		}
		
		
		
	}
	
	
	//Metodos estándar
	
	
	public void posicionBarco(int x, int y, int direccion) {
		
		switch(direccion)
		{
		case 1: 
			for(int i=0; i<numeroCasillas; i++)
			{
				this.posicion[i][0] = x+i;
				this.posicion[i][1] = y;
			}
			break;
			
		case 2: 
			for(int i=0; i<numeroCasillas; i++)
			{
				this.posicion[i][0] = x;
				this.posicion[i][1] = y + i;
			}
			break;
		case 3: 
			for(int i=0; i<numeroCasillas; i++)
			{
				this.posicion[i][0] = x+i;
				this.posicion[i][1] = y+i;
			}
			break;
		case 4: 
			for(int i=0; i<numeroCasillas; i++)
			{
				this.posicion[i][0] = x-i;
				this.posicion[i][1] = y+i;
			}
			break;
		}
		
	}
	
	
	
}
