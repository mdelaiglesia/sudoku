package sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

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
	
	public Matriz<Integer> resolverSudoku() {
		
		Posicion posicionActual = new Posicion(0, 0, n);
		
		return backtracking(posicionActual, 0);
	}

	private Matriz<Integer> backtracking(Posicion posicionActual, int ubicados) {
		
		if ((n * n) == ubicados)
		{
			if (isValido()) {
				return matriz;
			}
			else {
				return null;
			}
		}
		
		for (int valor = 1; valor <= n; valor++) {
			
			if (isCandidato(posicionActual.fila, posicionActual.columna)) {
				setearValor(posicionActual.fila + 1, posicionActual.columna + 1, valor);
				imprimirMatriz(matriz);
			}
			
			Posicion siguiente = posicionActual.calcularSiguiente(posicionActual);
			Matriz<Integer> resultado = backtracking(siguiente, ++ubicados);
			
			if (resultado != null)
				return resultado;
			
			setearValor(posicionActual.fila + 1, posicionActual.columna + 1, null);
			ubicados--;
			
			imprimirMatriz(matriz);
		}
	
		return null;
	}
	
	private Boolean isCandidato(int fila, int columna) {
		
		if (matriz.obtenerValor(fila, columna) == null)
			return true;
		
		return false;
	}

	public void setearValor(int i, int j, Integer nuevoValor) {
		if (nuevoValor != null) {
			matriz.setearValor(i - 1, j - 1, nuevoValor);
			filas.setearValor(i - 1, nuevoValor - 1, true);
			columnas.setearValor(j - 1, nuevoValor - 1, true);
			cuadrantes.setearValor(calcularCuadrante(i - 1, j - 1), nuevoValor - 1, true);
		}
		else {
			Integer valorAntiguo = matriz.obtenerValor(i - 1, j - 1);
			
			filas.setearValor(i - 1, valorAntiguo - 1, false);
			columnas.setearValor(j - 1, valorAntiguo - 1, false);
			cuadrantes.setearValor(calcularCuadrante(i - 1, j - 1), valorAntiguo - 1, false);
			
			matriz.setearValor(i - 1, j - 1, nuevoValor);
		}
	}
	
	/**
	 * Dice si el sudoku es válido
	 * @return verdadero en caso de ser válido, falso en caso contrario
	 */
	public Boolean isValido()
	{
		Boolean isValido = true;
		
		for (int i = 1; i <= n; i++) {
			Integer[] fila = getFila(i);
			Boolean isFilaValida = !hasDuplicates(fila);
			
			Integer[] columna = getColumna(i);
			Boolean isColumnaValida = !hasDuplicates(columna);
			
			Integer[] cuadrante = getCuadrante(i);
			Boolean isCuadranteValido = !hasDuplicates(cuadrante);
			
			isValido &= isFilaValida && isColumnaValida && isCuadranteValido;
		}
		
		return isValido;
	}
	
	public void imprimirMatriz(Matriz<Integer> matriz) {
		Integer valor;
		for(int i = 0; i < n; i++) { 
			for(int j = 0; j < n; j++) { 
				valor = matriz.obtenerValor(i, j);
				
				if (valor != null) 
					System.out.print(valor + " ");
				else
					System.out.print("_" + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Obtiene del tablero la fila
	 * @param número de fila (not zero-based)
	 * @return la fila ubicada en el número recibido como parámetro
	 */
	public Integer[] getFila(int numero) {
		Integer[] fila = new Integer[n];
		
		for(int i = 0; i < n; i++) {
			fila[i] = this.matriz.obtenerValor(numero - 1, i);
		}
		
		return fila;
	}
	
	/**
	 * Obtiene del tablero la columna
	 * @param número de columna (not zero-based)
	 * @return la columna ubicada en el número recibido como parámetro
	 */
	public Integer[] getColumna(int numero) {
		Integer[] columna = new Integer[n];
		
		for(int i = 0; i < n; i++) {
			columna[i] = this.matriz.obtenerValor(i, numero - 1);
		}
		
		return columna;
	}
	
	/**
	 * Obtiene del tablero el cuadrante
	 * @param número de cuadrante (not zero-based)
	 * @return el cuadrante ubicado en el número recibido como parámetro
	 */
	public Integer[] getCuadrante(int numero) {
		Integer[] cuadrante = new Integer[n];
		
		int indice = 0;
		
		Posicion rangoFila = new Posicion();
		Posicion rangoColumna = new Posicion();
		calcularRango(numero, rangoFila, rangoColumna);
		
		Integer filaDesde = rangoFila.fila;
		Integer filaHasta = rangoFila.columna;
		
		Integer columnaDesde = rangoColumna.fila;
		Integer columnaHasta = rangoColumna.columna;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i >= filaDesde && i < filaHasta && j >= columnaDesde && j < columnaHasta) {
					cuadrante[indice] = this.matriz.obtenerValor(i, j);
					indice++;
				}
			}
		}
		
		return cuadrante;
	}
	
	/**
	 * Dice si un valor está contenido en una fila
	 * @param valor sobre el que se desea saber si está o no contenido
	 * @param fila número de fila (not zero-based)
	 * @return verdadero en caso de estar contenido, falso en caso contrario
	 */
	public Boolean isValorEnFila(int valor, int fila)
	{
		return Arrays.asList(this.getFila(fila)).contains(valor);
	}

	/**
	 * Dice si un valor está contenido en una columna
	 * @param valor sobre el que se desea saber si está o no contenido
	 * @param columna número de columna (not zero-based)
	 * @return verdadero en caso de estar contenido, falso en caso contrario
	 */
	public Boolean isValorEnColumna(int valor, int columna)
	{
		return Arrays.asList(this.getColumna(columna)).contains(valor);
	}

	/**
	 * Dice si un valor está contenido en un cuadrante
	 * @param valor sobre el que se desea saber si está o no contenido
	 * @param cuandrante número de cuadrante (not zero-based)
	 * @return verdadero en caso de estar contenido, falso en caso contrario
	 */
	public Boolean isValorEnCuadrante(int valor, int cuadrante)
	{
		return Arrays.asList(this.getCuadrante(cuadrante)).contains(valor);
	}
	
	private Boolean hasDuplicates(Integer[] arreglo) {
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

	private void calcularRango(int cuadrante, Posicion rangoFila, Posicion rangoColumna) {
		for(int i = 0; i < Math.sqrt(n); i++){
			for(int j = 0; j < Math.sqrt(n); j++){
				if (cuadrantesAux[i][j] == cuadrante - 1) {
					
					int filaDesde = (int)(i * Math.sqrt(n));
					int filaHasta = (int)((i + 1) * Math.sqrt(n));
					rangoFila.fila = filaDesde;
					rangoFila.columna = filaHasta;
					
					int columnaDesde = (int)(j * Math.sqrt(n));
					int columnaHasta = (int)((j + 1) * Math.sqrt(n));
					rangoColumna.fila = columnaDesde;
					rangoColumna.columna = columnaHasta;
					
					return;
				}
			}
		}
	}
}
