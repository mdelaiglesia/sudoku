package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sudoku.Sudoku;
import Implementaciones.Matriz;

public class SudokuTestCase {

	//  1 3 . .
	//  2 . . 4
	//  . 1 2 .
	//  . 2 3 .
	private Sudoku sudoku;
	
	@Before
	public void setUp() throws Exception {
		
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
		
		sudoku = new Sudoku(matriz, matriz.obtenerDimension());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void isValidoTestCase() {
		assertTrue(sudoku.isValido());
	}
	
	@Test
	public void obtencionFilasTestCase() {	
		assertTrue(sudoku.filaContieneValor(1, 1));
		assertFalse(sudoku.filaContieneValor(1, 2));
		assertTrue(sudoku.filaContieneValor(1, 3));
		assertFalse(sudoku.filaContieneValor(1, 4));
		
		assertFalse(sudoku.filaContieneValor(2, 1));
		assertTrue(sudoku.filaContieneValor(2, 2));
		assertFalse(sudoku.filaContieneValor(2, 3));
		assertTrue(sudoku.filaContieneValor(2, 4));
		
		assertTrue(sudoku.filaContieneValor(3, 1));
		assertTrue(sudoku.filaContieneValor(3, 2));
		assertFalse(sudoku.filaContieneValor(3, 3));
		assertFalse(sudoku.filaContieneValor(3, 4));
		
		assertFalse(sudoku.filaContieneValor(4, 1));
		assertTrue(sudoku.filaContieneValor(4, 2));
		assertTrue(sudoku.filaContieneValor(4, 3));
		assertFalse(sudoku.filaContieneValor(4, 4));
	}
	
	public void obtencionColumnasTestCase() {
		assertTrue(sudoku.columnaContieneValor(1, 1));
		assertTrue(sudoku.columnaContieneValor(1, 2));
		assertFalse(sudoku.columnaContieneValor(1, 3));
		assertFalse(sudoku.columnaContieneValor(1, 4));
		
		assertTrue(sudoku.columnaContieneValor(2, 1));
		assertTrue(sudoku.columnaContieneValor(2, 2));
		assertTrue(sudoku.columnaContieneValor(2, 3));
		assertFalse(sudoku.columnaContieneValor(2, 4));
		
		assertFalse(sudoku.columnaContieneValor(3, 1));
		assertTrue(sudoku.columnaContieneValor(3, 2));
		assertTrue(sudoku.columnaContieneValor(3, 3));
		assertFalse(sudoku.columnaContieneValor(3, 4));
		
		assertFalse(sudoku.columnaContieneValor(4, 1));
		assertFalse(sudoku.columnaContieneValor(4, 2));
		assertFalse(sudoku.columnaContieneValor(4, 3));
		assertTrue(sudoku.columnaContieneValor(4, 4));
	}
	
	public void obtencionCuadrantesTestCase() {
		assertTrue(sudoku.cuadranteContieneValor(1, 1));
		assertTrue(sudoku.cuadranteContieneValor(1, 2));
		assertTrue(sudoku.cuadranteContieneValor(1, 3));
		assertFalse(sudoku.cuadranteContieneValor(1, 4));
		
		assertFalse(sudoku.cuadranteContieneValor(2, 1));
		assertFalse(sudoku.cuadranteContieneValor(2, 2));
		assertFalse(sudoku.cuadranteContieneValor(2, 3));
		assertTrue(sudoku.cuadranteContieneValor(2, 4));
		
		assertTrue(sudoku.cuadranteContieneValor(3, 1));
		assertTrue(sudoku.cuadranteContieneValor(3, 2));
		assertFalse(sudoku.cuadranteContieneValor(3, 3));
		assertFalse(sudoku.cuadranteContieneValor(3, 4));
		
		assertFalse(sudoku.cuadranteContieneValor(4, 1));
		assertTrue(sudoku.cuadranteContieneValor(4, 2));
		assertTrue(sudoku.cuadranteContieneValor(4, 3));
		assertFalse(sudoku.cuadranteContieneValor(4, 4));
	}

}
