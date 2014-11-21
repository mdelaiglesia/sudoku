package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sudoku.Posicion;
import sudoku.Sudoku;
import Implementaciones.Matriz;

public class SudokuTestCase {

	private Sudoku sudoku4x4;
	private Matriz<Integer> matriz4x4;
	private Integer n4;
	
	private Sudoku sudoku9x9;
	private Matriz<Integer> matriz9x9;
	private Integer n9;
	
	@Before
	public void setUp() throws Exception {
		//  1 2 3 4
		//  3 4 1 2
		//  2 1 4 3
		//  4 3 _ _
		n4 = 4;
		
		matriz4x4 = new Matriz<Integer>();
		matriz4x4.inicializarMatriz(n4);
		
		matriz4x4.setearValor(0, 0, 1);
		matriz4x4.setearValor(0, 1, 2);
		matriz4x4.setearValor(0, 2, 3);
		matriz4x4.setearValor(0, 3, 4);
		
		matriz4x4.setearValor(1, 0, 3);
		matriz4x4.setearValor(1, 1, 4);
		matriz4x4.setearValor(1, 2, 1);
		matriz4x4.setearValor(1, 3, 2);
		
		matriz4x4.setearValor(2, 0, 2);
		matriz4x4.setearValor(2, 1, 1);
		matriz4x4.setearValor(2, 2, 4);
		matriz4x4.setearValor(2, 3, 3);
		
		matriz4x4.setearValor(3, 0, 4);
		matriz4x4.setearValor(3, 1, 3);
		
		sudoku4x4 = new Sudoku(matriz4x4, matriz4x4.obtenerDimension());

		n9 = 9;
		
		matriz9x9 = new Matriz<Integer>();
		matriz9x9.inicializarMatriz(n9);
		
		matriz9x9.setearValor(0, 0, 4);
		matriz9x9.setearValor(0, 1, 2);
		matriz9x9.setearValor(0, 2, 5);
		matriz9x9.setearValor(0, 3, 7);
		matriz9x9.setearValor(0, 4, 1);
		matriz9x9.setearValor(0, 5, 6);
		matriz9x9.setearValor(0, 6, 8);
		matriz9x9.setearValor(0, 7, 3);		
		matriz9x9.setearValor(0, 8, 9);
		
		matriz9x9.setearValor(1, 0, 3);
		matriz9x9.setearValor(1, 1, 6);
		matriz9x9.setearValor(1, 2, 8);
		matriz9x9.setearValor(1, 3, 5);
		matriz9x9.setearValor(1, 4, 4);
		matriz9x9.setearValor(1, 5, 9);
		matriz9x9.setearValor(1, 6, 1);
		matriz9x9.setearValor(1, 7, 7);		
		matriz9x9.setearValor(1, 8, 2);
		
		matriz9x9.setearValor(2, 0, 1);
		matriz9x9.setearValor(2, 1, 9);
		matriz9x9.setearValor(2, 2, 7);
		matriz9x9.setearValor(2, 3, 3);
		matriz9x9.setearValor(2, 4, 8);
		matriz9x9.setearValor(2, 5, 2);
		matriz9x9.setearValor(2, 6, 6);
		matriz9x9.setearValor(2, 7, 5);		
		matriz9x9.setearValor(2, 8, 4);

		matriz9x9.setearValor(3, 0, 8);
		matriz9x9.setearValor(3, 1, 4);
		matriz9x9.setearValor(3, 2, 9);
		matriz9x9.setearValor(3, 3, 1);
		matriz9x9.setearValor(3, 4, 6);
		matriz9x9.setearValor(3, 5, 7);
		matriz9x9.setearValor(3, 6, 5);
		matriz9x9.setearValor(3, 7, 2);		
		matriz9x9.setearValor(3, 8, 3);

		matriz9x9.setearValor(4, 0, 5);
		matriz9x9.setearValor(4, 1, 3);
		matriz9x9.setearValor(4, 2, 1);
		matriz9x9.setearValor(4, 3, 2);
		matriz9x9.setearValor(4, 4, 9);
		matriz9x9.setearValor(4, 5, 4);
		matriz9x9.setearValor(4, 6, 7);
		matriz9x9.setearValor(4, 7, 6);		
		matriz9x9.setearValor(4, 8, 8);

		matriz9x9.setearValor(5, 0, 2);
		matriz9x9.setearValor(5, 1, 7);
		matriz9x9.setearValor(5, 2, 6);
		matriz9x9.setearValor(5, 3, 8);
		matriz9x9.setearValor(5, 4, 5);
		matriz9x9.setearValor(5, 5, 3);
		matriz9x9.setearValor(5, 6, 4);
		matriz9x9.setearValor(5, 7, 9);		
		matriz9x9.setearValor(5, 8, 1);

		matriz9x9.setearValor(6, 0, 9);
		matriz9x9.setearValor(6, 1, 1);
		matriz9x9.setearValor(6, 2, 2);
		matriz9x9.setearValor(6, 3, 6);
		matriz9x9.setearValor(6, 4, 7);
		matriz9x9.setearValor(6, 5, 8);
		matriz9x9.setearValor(6, 6, 3);
		matriz9x9.setearValor(6, 7, 4);		
		matriz9x9.setearValor(6, 8, 5);
		
		matriz9x9.setearValor(7, 0, 6);
		matriz9x9.setearValor(7, 1, 8);
		matriz9x9.setearValor(7, 2, 3);
		matriz9x9.setearValor(7, 3, 4);
		matriz9x9.setearValor(7, 4, 2);
		matriz9x9.setearValor(7, 5, 5);
		matriz9x9.setearValor(7, 6, 9);
		matriz9x9.setearValor(7, 7, 1);		
		matriz9x9.setearValor(7, 8, 7);

		matriz9x9.setearValor(8, 0, 7);
		matriz9x9.setearValor(8, 1, 5);
		matriz9x9.setearValor(8, 2, 4);
		matriz9x9.setearValor(8, 3, 9);

		// 4 2 5 7 1 6 8 3 9
		// 3 6 8 5 4 9 1 7 2
		// 1 9 7 3 8 2 6 5 4
		// 8 4 9 1 6 7 5 2 3
		// 5 3 1 2 9 4 7 6 8
		// 2 7 6 8 5 3 4 9 1
		// 9 1 2 6 7 8 3 4 5
		// 6 8 3 4 2 5 9 1 7
		// 7 5 4 9 _ _ _ _ _
		
		sudoku9x9 = new Sudoku(matriz9x9, matriz9x9.obtenerDimension());
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void imprimirMatriz9x9TestCase() {
		System.out.println("ACTIVIDAD 3: 9x9");
		sudoku9x9.imprimirMatriz();
	}

	@Test
	public void isValido9x9TestCase() {
		System.out.println("ACTIVIDAD 4: Caso válido 9x9");
		
		sudoku9x9.imprimirMatriz();
		
		assertTrue(sudoku9x9.isValido());	
	}
	
	@Test
	public void resolver9x9TestCase() {
		System.out.println("ACTIVIDAD 8: 9x9");
		System.out.println("Sin poda:");
		sudoku9x9.resolver();
	}
	
	@Test
	public void resolverConPoda9x9TestCase() {
		System.out.println("ACTIVIDAD 11: 9x9");
		System.out.println("Con poda:");
		sudoku9x9.resolverConPoda();
	}
	
	@Test
	public void imprimirMatrizTestCase() {
		System.out.println("ACTIVIDAD 3:");
		sudoku4x4.imprimirMatriz();
	}

	@Test
	public void isValidoTestCase() {
		System.out.println("ACTIVIDAD 4: Caso válido");
		
		sudoku4x4.imprimirMatriz();
		
		assertTrue(sudoku4x4.isValido());
	}

	@Test
	public void isNotValidoTestCase() {
		sudoku4x4.setearValor(1, 3, 1);
		
		System.out.println("ACTIVIDAD 4: Caso inválido");
		
		sudoku4x4.imprimirMatriz();
		
		assertFalse(sudoku4x4.isValido());
	}

	@Test
	public void calcularSiguientePosicionTestCase() {
		System.out.println("ACTIVIDAD 5:");
		
		Posicion posicionActual = new Posicion(0, 3, n4);
		System.out.println("Posicion actual: (" + posicionActual.fila + "," + posicionActual.fila + ")");
		
		Posicion siguiente = posicionActual.calcularSiguiente(posicionActual);
		System.out.println("Posicion siguiente: (" + siguiente.fila + "," + siguiente.fila + ")");
		System.out.println();
				
		assertEquals((int)siguiente.fila, 1);
		assertEquals((int)siguiente.columna, 0);
	}
	
	@Test
	public void resolverTestCase() {
		System.out.println("ACTIVIDAD 8:");
		System.out.println("Sin poda:");
		sudoku4x4.resolver();
	}
	
	@Test
	public void resolverConPodaTestCase() {
		System.out.println("ACTIVIDAD 11:");
		System.out.println("Con poda:");
		sudoku4x4.resolverConPoda();
	}
}
