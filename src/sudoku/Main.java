package sudoku;

import Implementaciones.Matriz;

public class Main {

	public static void main(String[] args) {
		Matriz<Boolean> filas = null; 
		Matriz<Boolean> columnas = null; 
		Matriz<Boolean> cuadrantes = null;
		int n = 4;
		inicilizar(filas, columnas, cuadrantes, n);
	}
	
	//  1 3 . .
	//  2 . . 4
	//  . 1 2 .
	//  . 2 3 .
	public static void inicilizar(Matriz<Boolean> filas, Matriz<Boolean> columnas, Matriz<Boolean> cuadrantes, int n) {
		filas = new Matriz<Boolean>();
		filas.inicializarMatriz(n);
		inicializar(filas);
		filas.setearValor(0, 0, Boolean.TRUE);
		filas.setearValor(0, 2, Boolean.TRUE);
		filas.setearValor(1, 1, Boolean.TRUE);
		filas.setearValor(1, 3, Boolean.TRUE);
		filas.setearValor(2, 0, Boolean.TRUE);
		filas.setearValor(2, 1, Boolean.TRUE);
		filas.setearValor(3, 1, Boolean.TRUE);
		filas.setearValor(3, 2, Boolean.TRUE);
		
		columnas = new Matriz<Boolean>();
		columnas.inicializarMatriz(n);
		inicializar(columnas);
		columnas.setearValor(0, 0, Boolean.TRUE);
		columnas.setearValor(0, 1, Boolean.TRUE);
		columnas.setearValor(1, 0, Boolean.TRUE);
		columnas.setearValor(1, 1, Boolean.TRUE);
		columnas.setearValor(1, 2, Boolean.TRUE);
		columnas.setearValor(2, 1, Boolean.TRUE);
		columnas.setearValor(2, 2, Boolean.TRUE);
		columnas.setearValor(3, 3, Boolean.TRUE);
		
		cuadrantes = new Matriz<Boolean>();
		cuadrantes.inicializarMatriz(n);
		inicializar(cuadrantes);
		cuadrantes.setearValor(0, 0, Boolean.TRUE);
		cuadrantes.setearValor(0, 1, Boolean.TRUE);
		cuadrantes.setearValor(0, 2, Boolean.TRUE);
		cuadrantes.setearValor(1, 3, Boolean.TRUE);
		cuadrantes.setearValor(2, 0, Boolean.TRUE);
		cuadrantes.setearValor(2, 1, Boolean.TRUE);
		cuadrantes.setearValor(3, 1, Boolean.TRUE);
		cuadrantes.setearValor(3, 2, Boolean.TRUE);
	}
	
	public static void inicializar(Matriz<Boolean> matriz)
	{
		for (int i = 0; i < matriz.obtenerDimension(); i++){
			for (int j = 0; i < matriz.obtenerDimension(); i++){
				matriz.setearValor(i, j, Boolean.FALSE);
			}
		}
	}

}
