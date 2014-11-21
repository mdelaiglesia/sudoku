package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sudoku.Posicion;
import sudoku.Sudoku;
import Implementaciones.Matriz;

public class SudokuTestCase {

	//  1 2 3 4
	//  3 4 1 2
	//  2 1 4 3
	//  4 3 _ _
	private Sudoku sudoku;
	
	private Matriz<Integer> matriz;
	
	private Integer n;
	
	@Before
	public void setUp() throws Exception {
		n = 4;
		
		matriz = new Matriz<Integer>();
		matriz.inicializarMatriz(n);
		
		matriz.setearValor(0, 0, 1);
		matriz.setearValor(0, 1, 2);
		matriz.setearValor(0, 2, 3);
		matriz.setearValor(0, 3, 4);
		
		matriz.setearValor(1, 0, 3);
		matriz.setearValor(1, 1, 4);
		matriz.setearValor(1, 2, 1);
		matriz.setearValor(1, 3, 2);
		
		matriz.setearValor(2, 0, 2);
		matriz.setearValor(2, 1, 1);
		matriz.setearValor(2, 2, 4);
		matriz.setearValor(2, 3, 3);
		
		matriz.setearValor(3, 0, 4);
		matriz.setearValor(3, 1, 3);
		
		sudoku = new Sudoku(matriz, matriz.obtenerDimension());
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	// ACTIVIDAD 3
	public void imprimirMatrizTestCase() {
		sudoku.imprimirMatriz();
	}
	

	@Test
	// ACTIVIDAD 2
	// ACTIVIDAD 4: Caso v�lido
	public void isValidoTestCase() {
		assertTrue(sudoku.isValido());
	}

	@Test
	// ACTIVIDAD 4: Caso inv�lido
	public void isValidoConModificacionTestCase() {
		sudoku.setearValor(1, 3, 1);
		
		assertFalse(sudoku.isValido());
	}

	@Test
	// ACTIVIDAD 5
	public void calcularSiguientePosicionTestCase() {
		Posicion posicionActual = new Posicion(0, 3, n);
		Posicion siguiente = posicionActual.calcularSiguiente(posicionActual);
		assertEquals((int)siguiente.fila, 1);
		assertEquals((int)siguiente.columna, 0);
	}
	
	@Test
	// ACTIVIDAD 8
	public void resolverTestCase() {
		System.out.println("Sin poda:");
		sudoku.resolver();
	}
	
	@Test
	// ACTIVIDAD 11
	public void resolverConPodaTestCase() {
		System.out.println("Con poda:");
		sudoku.resolverConPoda();
	}
	
	@Test
	public void obtencionFilasTestCase() {	
		assertTrue(sudoku.isValorEnFila(1, 1));
		assertTrue(sudoku.isValorEnFila(2, 1));
		assertTrue(sudoku.isValorEnFila(3, 1));
		assertTrue(sudoku.isValorEnFila(4, 1));
		
		assertTrue(sudoku.isValorEnFila(1, 2));
		assertTrue(sudoku.isValorEnFila(2, 2));
		assertTrue(sudoku.isValorEnFila(3, 2));
		assertTrue(sudoku.isValorEnFila(4, 2));
		
		assertTrue(sudoku.isValorEnFila(1, 3));
		assertTrue(sudoku.isValorEnFila(2, 3));
		assertTrue(sudoku.isValorEnFila(3, 3));
		assertTrue(sudoku.isValorEnFila(4, 3));
		
		assertFalse(sudoku.isValorEnFila(1, 4));
		assertFalse(sudoku.isValorEnFila(2, 4));
		assertTrue(sudoku.isValorEnFila(3, 4));
		assertTrue(sudoku.isValorEnFila(4, 4));
	}
	
	@Test
	public void obtencionColumnasTestCase() {
		assertTrue(sudoku.isValorEnColumna(1, 1));
		assertTrue(sudoku.isValorEnColumna(2, 1));
		assertTrue(sudoku.isValorEnColumna(3, 1));
		assertTrue(sudoku.isValorEnColumna(4, 1));
		
		assertTrue(sudoku.isValorEnColumna(1, 2));
		assertTrue(sudoku.isValorEnColumna(2, 2));
		assertTrue(sudoku.isValorEnColumna(3, 2));
		assertTrue(sudoku.isValorEnColumna(4, 2));
		
		assertTrue(sudoku.isValorEnColumna(1, 3));
		assertFalse(sudoku.isValorEnColumna(2, 3));
		assertTrue(sudoku.isValorEnColumna(3, 3));
		assertTrue(sudoku.isValorEnColumna(4, 3));
		
		assertFalse(sudoku.isValorEnColumna(1, 4));
		assertTrue(sudoku.isValorEnColumna(2, 4));
		assertTrue(sudoku.isValorEnColumna(3, 4));
		assertTrue(sudoku.isValorEnColumna(4, 4));
	}
	
	@Test
	public void obtencionCuadrantesTestCase() {
		assertTrue(sudoku.isValorEnCuadrante(1, 1));
		assertTrue(sudoku.isValorEnCuadrante(2, 1));
		assertTrue(sudoku.isValorEnCuadrante(3, 1));
		assertTrue(sudoku.isValorEnCuadrante(4, 1));
		
		assertTrue(sudoku.isValorEnCuadrante(1, 2));
		assertTrue(sudoku.isValorEnCuadrante(2, 2));
		assertTrue(sudoku.isValorEnCuadrante(3, 2));
		assertTrue(sudoku.isValorEnCuadrante(4, 2));
		
		assertTrue(sudoku.isValorEnCuadrante(1, 3));
		assertTrue(sudoku.isValorEnCuadrante(2, 3));
		assertTrue(sudoku.isValorEnCuadrante(3, 3));
		assertTrue(sudoku.isValorEnCuadrante(4, 3));
		
		assertFalse(sudoku.isValorEnCuadrante(1, 4));
		assertFalse(sudoku.isValorEnCuadrante(2, 4));
		assertTrue(sudoku.isValorEnCuadrante(3, 4));
		assertTrue(sudoku.isValorEnCuadrante(4, 4));
	}

}
