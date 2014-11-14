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
		assertTrue(sudoku.isValorEnFila(1, 1));
		assertFalse(sudoku.isValorEnFila(1, 2));
		assertTrue(sudoku.isValorEnFila(1, 3));
		assertFalse(sudoku.isValorEnFila(1, 4));
		
		assertFalse(sudoku.isValorEnFila(2, 1));
		assertTrue(sudoku.isValorEnFila(2, 2));
		assertFalse(sudoku.isValorEnFila(2, 3));
		assertTrue(sudoku.isValorEnFila(2, 4));
		
		assertTrue(sudoku.isValorEnFila(3, 1));
		assertTrue(sudoku.isValorEnFila(3, 2));
		assertFalse(sudoku.isValorEnFila(3, 3));
		assertFalse(sudoku.isValorEnFila(3, 4));
		
		assertFalse(sudoku.isValorEnFila(4, 1));
		assertTrue(sudoku.isValorEnFila(4, 2));
		assertTrue(sudoku.isValorEnFila(4, 3));
		assertFalse(sudoku.isValorEnFila(4, 4));
	}
	
	public void obtencionColumnasTestCase() {
		assertTrue(sudoku.isValorEnColumna(1, 1));
		assertTrue(sudoku.isValorEnColumna(1, 2));
		assertFalse(sudoku.isValorEnColumna(1, 3));
		assertFalse(sudoku.isValorEnColumna(1, 4));
		
		assertTrue(sudoku.isValorEnColumna(2, 1));
		assertTrue(sudoku.isValorEnColumna(2, 2));
		assertTrue(sudoku.isValorEnColumna(2, 3));
		assertFalse(sudoku.isValorEnColumna(2, 4));
		
		assertFalse(sudoku.isValorEnColumna(3, 1));
		assertTrue(sudoku.isValorEnColumna(3, 2));
		assertTrue(sudoku.isValorEnColumna(3, 3));
		assertFalse(sudoku.isValorEnColumna(3, 4));
		
		assertFalse(sudoku.isValorEnColumna(4, 1));
		assertFalse(sudoku.isValorEnColumna(4, 2));
		assertFalse(sudoku.isValorEnColumna(4, 3));
		assertTrue(sudoku.isValorEnColumna(4, 4));
	}
	
	public void obtencionCuadrantesTestCase() {
		assertTrue(sudoku.isValorEnCuadrante(1, 1));
		assertTrue(sudoku.isValorEnCuadrante(1, 2));
		assertTrue(sudoku.isValorEnCuadrante(1, 3));
		assertFalse(sudoku.isValorEnCuadrante(1, 4));
		
		assertFalse(sudoku.isValorEnCuadrante(2, 1));
		assertFalse(sudoku.isValorEnCuadrante(2, 2));
		assertFalse(sudoku.isValorEnCuadrante(2, 3));
		assertTrue(sudoku.isValorEnCuadrante(2, 4));
		
		assertTrue(sudoku.isValorEnCuadrante(3, 1));
		assertTrue(sudoku.isValorEnCuadrante(3, 2));
		assertFalse(sudoku.isValorEnCuadrante(3, 3));
		assertFalse(sudoku.isValorEnCuadrante(3, 4));
		
		assertFalse(sudoku.isValorEnCuadrante(4, 1));
		assertTrue(sudoku.isValorEnCuadrante(4, 2));
		assertTrue(sudoku.isValorEnCuadrante(4, 3));
		assertFalse(sudoku.isValorEnCuadrante(4, 4));
	}

}
