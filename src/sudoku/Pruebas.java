package sudoku;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Implementaciones.Matriz;

public class Pruebas {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//  1 3 . .
		//  2 . . 4
		//  . 1 2 .
		//  . 2 3 .
		Matriz<Integer> matriz = new Matriz<Integer>();
		matriz.inicializarMatriz(4);
		matriz.setearValor(0, 0, 1);
		matriz.setearValor(0, 1, 3);
		matriz.setearValor(1, 0, 2);
		matriz.setearValor(1, 3, 4);
		matriz.setearValor(2, 1, 1);
		matriz.setearValor(2, 2, 2);
		matriz.setearValor(3, 1, 2);
		matriz.setearValor(3, 2, 3);
		
		Sudoku sudoku = new Sudoku(matriz, matriz.obtenerDimension());
		
		assertEquals(sudoku.filas.obtenerValor(0, 0), Boolean.TRUE);
		assertEquals(sudoku.filas.obtenerValor(0, 2), Boolean.TRUE);
		assertEquals(sudoku.filas.obtenerValor(1, 1), Boolean.TRUE);
		assertEquals(sudoku.filas.obtenerValor(1, 3), Boolean.TRUE);
		assertEquals(sudoku.filas.obtenerValor(2, 0), Boolean.TRUE);
		assertEquals(sudoku.filas.obtenerValor(2, 1), Boolean.TRUE);
		assertEquals(sudoku.filas.obtenerValor(3, 1), Boolean.TRUE);
		assertEquals(sudoku.filas.obtenerValor(3, 2), Boolean.TRUE);
		
		assertEquals(sudoku.columnas.obtenerValor(0, 0), Boolean.TRUE);
		assertEquals(sudoku.columnas.obtenerValor(0, 1), Boolean.TRUE);
		assertEquals(sudoku.columnas.obtenerValor(1, 2), Boolean.TRUE);
		assertEquals(sudoku.columnas.obtenerValor(1, 0), Boolean.TRUE);
		assertEquals(sudoku.columnas.obtenerValor(1, 1), Boolean.TRUE);
		assertEquals(sudoku.columnas.obtenerValor(2, 1), Boolean.TRUE);
		assertEquals(sudoku.columnas.obtenerValor(2, 2), Boolean.TRUE);
		assertEquals(sudoku.columnas.obtenerValor(3, 3), Boolean.TRUE);
		
		assertEquals(sudoku.cuadrantes.obtenerValor(0, 0), Boolean.TRUE);
		assertEquals(sudoku.cuadrantes.obtenerValor(0, 2), Boolean.TRUE);
		assertEquals(sudoku.cuadrantes.obtenerValor(0, 1), Boolean.TRUE);
		assertEquals(sudoku.cuadrantes.obtenerValor(1, 3), Boolean.TRUE);
		assertEquals(sudoku.cuadrantes.obtenerValor(2, 0), Boolean.TRUE);
		assertEquals(sudoku.cuadrantes.obtenerValor(2, 1), Boolean.TRUE);
		assertEquals(sudoku.cuadrantes.obtenerValor(3, 1), Boolean.TRUE);
		assertEquals(sudoku.cuadrantes.obtenerValor(3, 2), Boolean.TRUE);
	}

}
