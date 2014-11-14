package sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Implementaciones.Matriz;

public class Sudoku {

	private int n = 4;	
	private Matriz<Integer> matriz;
	
	private Matriz<Boolean> filas;
	private Matriz<Boolean> columnas;
	private Matriz<Boolean> cuadrantes;
	
	private int[][] cuadrantesAux;
	
	public Sudoku(Matriz<Integer> matriz, int n) {
		this.n = n;
		
		this.matriz = new Matriz<Integer>();
		filas = new Matriz<Boolean>();
		columnas = new Matriz<Boolean>();
		cuadrantes = new Matriz<Boolean>();
		
		this.matriz = matriz;
		filas.inicializarMatriz(n);
		columnas.inicializarMatriz(n);
		cuadrantes.inicializarMatriz(n);
		
		inicializarMatricesAuxiliares();
	}
	
	/**
	 * Dice si el sudoku es v�lido
	 * @return verdadero en caso de ser v�lido, falso en caso contrario
	 */
	public Boolean isValido()
	{
		Boolean isValido = true;
		
		for (int i = 1; i <= n; i++) {
			Integer[] fila = getFila(i);
			Boolean isFilaValida = !contieneDuplicados(fila);
			
			Integer[] columna = getColumna(i);
			Boolean isColumnaValida = !contieneDuplicados(columna);
			
			Integer[] cuadrante = getCuadrante(i);
			Boolean isCuadranteValido = !contieneDuplicados(cuadrante);
			
			isValido &= isFilaValida && isColumnaValida && isCuadranteValido;
		}
		
		return isValido;
	}
	
	/**
	 * Obtiene del tablero la fila
	 * @param n�mero de fila (not zero-based)
	 * @return la fila ubicada en el n�mero recibido como par�metro
	 */
	public Integer[] getFila(int numero) {
		Integer[] fila = new Integer[n];
		
		for(int i = 0; i < n; i++) {
			if (this.filas.obtenerValor(numero - 1, i) != null)
				fila[i] = i + 1;
		}
		
		return fila;
	}
	
	/**
	 * Obtiene del tablero la columna
	 * @param n�mero de columna (not zero-based)
	 * @return la columna ubicada en el n�mero recibido como par�metro
	 */
	public Integer[] getColumna(int numero) {
		Integer[] columna = new Integer[n];
		
		for(int j = 0; j < n; j++) { 
			if (this.columnas.obtenerValor(j, numero - 1) != null)
				columna[j] = j + 1;
		}
		
		return columna;
	}
	
	/**
	 * Obtiene del tablero el cuadrante
	 * @param n�mero de cuadrante (not zero-based)
	 * @return el cuadrante ubicado en el n�mero recibido como par�metro
	 */
	public Integer[] getCuadrante(int numero) {
		Integer[] cuadrante = new Integer[n];
		
		for(int i = 0; i < n; i++) { 
			if (this.cuadrantes.obtenerValor(numero - 1, i) != null)
				cuadrante[i] = i + 1;
		}
		
		return cuadrante;
	}
	
	/**
	 * Dice si un valor est� contenido en una fila
	 * @param fila n�mero de fila (not zero-based)
	 * @param valor sobre el que se desea saber si est� o no contenido
	 * @return verdadero en caso de estar contenido, falso en caso contrario
	 */
	public Boolean filaContieneValor(int fila, int valor)
	{
		return Arrays.asList(this.getFila(fila)).contains(valor);
	}

	/**
	 * Dice si un valor est� contenido en una columna
	 * @param columna n�mero de columna (not zero-based)
	 * @param valor sobre el que se desea saber si est� o no contenido
	 * @return verdadero en caso de estar contenido, falso en caso contrario
	 */
	public Boolean columnaContieneValor(int columna, int valor)
	{
		return Arrays.asList(this.getColumna(columna)).contains(valor);
	}

	/**
	 * Dice si un valor est� contenido en un cuadrante
	 * @param cuandrante n�mero de cuadrante (not zero-based)
	 * @param valor sobre el que se desea saber si est� o no contenido
	 * @return verdadero en caso de estar contenido, falso en caso contrario
	 */
	public Boolean cuadranteContieneValor(int cuadrante, int valor)
	{
		return Arrays.asList(this.getCuadrante(cuadrante)).contains(valor);
	}
	
	public Boolean contieneDuplicados(Integer[] arreglo) {
		List<Integer> lista = Arrays.asList(arreglo);
		Set<Integer> set = new HashSet<Integer>();
        
		for (Integer valor : lista) {
            if (valor != null && !set.add(valor)) {
                return true;
            }
        }
		
        return false;
	}
	
	private void inicializarMatricesAuxiliares() {
		inicializarMatrizCalculoCuadrantes();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Integer valor = matriz.obtenerValor(i, j); 
				if (valor != null) {
					if (matriz.obtenerValor(i, j) == valor) {
						filas.setearValor(i, valor - 1, Boolean.TRUE);
						columnas.setearValor(valor - 1, j, Boolean.TRUE);
						cuadrantes.setearValor(calcularCuadrante(i, j), valor - 1, Boolean.TRUE);
					}
					else
					{
						filas.setearValor(i, valor - 1, Boolean.FALSE);
						columnas.setearValor(valor - 1, j, Boolean.FALSE);
						cuadrantes.setearValor(calcularCuadrante(i, j), valor - 1, Boolean.FALSE);						
					}
				}
			}
		}
	}
	
	private void inicializarMatrizCalculoCuadrantes() {
		cuadrantesAux = new int[(int)Math.sqrt(n)][(int)Math.sqrt(n)];
		
		int x = 0;
		for (int i = 0; i < Math.sqrt(n); i++) {
			for (int j = 0; j < Math.sqrt(n); j++) {
				cuadrantesAux[i][j] = x;
				x++;
			}
		}
	}
	
	private int calcularCuadrante(int i, int j) {
		int x = (int)(i / Math.sqrt(n));
		int y = (int)(j / Math.sqrt(n));
		
		return cuadrantesAux[x][y];
	}
	
}
