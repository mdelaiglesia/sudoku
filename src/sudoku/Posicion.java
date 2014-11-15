package sudoku;

public class Posicion {
	public Integer fila;
	public Integer columna;
	public Integer dimension;
	
	public Posicion() {
		this.fila = null;
		this.columna = null;
		this.dimension = null;
	}
	
	public Posicion(Integer fila, Integer columna, Integer dimension) {
		this.fila = fila;
		this.columna = columna;
		this.dimension = dimension;
	}
	
	public Posicion calcularSiguiente(Posicion posicion)
	{
		Posicion siguiente = new Posicion();
		siguiente.dimension = posicion.dimension;
		
		if (posicion.columna + 1 > dimension - 1) {
			siguiente.fila = posicion.fila + 1;
			siguiente.columna = 0;
		}
		else {
			siguiente.fila = posicion.fila;
			siguiente.columna = posicion.columna + 1;
		}
		
		return siguiente;
	}
}
