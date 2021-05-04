package no.ntnu.imt3281.sudoku;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;

public class SudokuTest {

	@Test
	public void testEmptyConstructor() {
		Sudoku sudoku = new Sudoku();
		assertTrue(sudoku instanceof Sudoku);
	}

    @Test
    public void testInsertInt() {
        Sudoku sudoku = new Sudoku();
        sudoku.insertInt(9,8);
        assertEquals (Integer.valueOf(9),sudoku.brett[8]);
    }
    @Test
    public void testInsertCoord() {
        Sudoku sudoku = new Sudoku();
        sudoku.insertCoord(4,5, 9);
        assertEquals (Integer.valueOf(9),sudoku.brett[43]);
    }

    @Test
    public void testTest() {
    	Sudoku sudoku = new Sudoku();
        sudoku.temp();
        assertEquals (Integer.valueOf(5),sudoku.brett[0]);
        assertEquals (Integer.valueOf(8),sudoku.brett[70]);
        assertEquals (Integer.valueOf(9),sudoku.brett[80]);
    }

    @Test
    public void testIteratorRow() {
        Sudoku sudoku = new Sudoku();
        sudoku.temp();
        Iterator<Integer> iterator = sudoku.iteratorRow(0);
        int i = iterator.next();
        assertEquals (5,i);
        i = iterator.next();
        assertEquals (3,i);
    }
    
    @Test
    public void testIteratorColumn() {
    	Sudoku sudoku = new Sudoku();
        sudoku.temp();
        Iterator<Integer> iterator = sudoku.iteratorColumn(0);
        int i = iterator.next();
        assertEquals (5,i);
        i = iterator.next();
        assertEquals (6,i);
 
    }
    
    @Test
    public void testIteratorBlock() {
        Sudoku sudoku = new Sudoku();
        sudoku.temp();
        Iterator<Integer> iterator = sudoku.iteratorBlock(0);
        int i = iterator.next();
        assertEquals (5,i);
        i = iterator.next();
        assertEquals (3,i);
    }
    
    @Test
    public void testReplace() {
    	Sudoku sudoku = new Sudoku();
        sudoku.temp();
        sudoku.replaceNumber(5,9);
        assertEquals (Integer.valueOf(9),sudoku.brett[0]);
        assertEquals (Integer.valueOf(8),sudoku.brett[70]);
        assertEquals (Integer.valueOf(5),sudoku.brett[80]);
        
    }
    
    @Test
    public void testFlipVertical() {
    	Sudoku sudoku = new Sudoku();
        sudoku.temp();
        sudoku.flipVertical();
        assertEquals(Integer.valueOf(6), sudoku.brett[33]);
        assertEquals(Integer.valueOf(7), sudoku.brett[53]);
        assertEquals(Integer.valueOf(1), sudoku.brett[14]);
        assertEquals(Integer.valueOf(3), sudoku.brett[39]);
    }
    
    @Test
    public void testFlipHorizontal() {
    	Sudoku sudoku = new Sudoku();
        sudoku.temp();
        sudoku.flipHorizontal();
        assertEquals(Integer.valueOf(8), sudoku.brett[33]);
        assertEquals(Integer.valueOf(3), sudoku.brett[53]);
        assertEquals(Integer.valueOf(9), sudoku.brett[14]);
        assertEquals(Integer.valueOf(8), sudoku.brett[39]);
    }
    
    @Test
    public void testFlipDiagonalLeft() {
    	Sudoku sudoku = new Sudoku();
        sudoku.temp();
        sudoku.flipDiagonalLeft();
        assertEquals(Integer.valueOf(6), sudoku.brett[1]);
        assertEquals(Integer.valueOf(3), sudoku.brett[3]);
        assertEquals(Integer.valueOf(6), sudoku.brett[59]);
        assertEquals(Integer.valueOf(7), sudoku.brett[77]);
    }
    
    @Test
    public void testFlipDiagonalRight() {
    	Sudoku sudoku = new Sudoku();
        sudoku.temp();
        sudoku.flipDiagonalRight();
        assertEquals(Integer.valueOf(5), sudoku.brett[1]);
        assertEquals(Integer.valueOf(3), sudoku.brett[77]);
        assertEquals(Integer.valueOf(6), sudoku.brett[59]);
        assertEquals(Integer.valueOf(2), sudoku.brett[8]);
        assertEquals(Integer.valueOf(6), sudoku.brett[21]);

    }
    
    @Test (expected = BadNumberException.class)
    public void testCheckRow() throws BadNumberException {
	Sudoku sudoku = new Sudoku();
    sudoku.temp();
    sudoku.checkRow(1,0,5);
    }
    
    @Test (expected = BadNumberException.class)
    public void testCheckColumn() throws BadNumberException {
	Sudoku sudoku = new Sudoku();
    sudoku.temp();
    sudoku.checkColumn(0,1,5);
    }
    
    @Test (expected = BadNumberException.class)
    public void testCheckBlock() throws BadNumberException {
	Sudoku sudoku = new Sudoku();
    sudoku.temp();
    sudoku.checkBlock(1,0,5);
    }
    
    @Test
    public void testResetBoard() {
    	Sudoku sudoku = new Sudoku();
        sudoku.temp();
        sudoku.resetBoard();
        assertEquals(Integer.valueOf(-1), sudoku.brett[1]);
        assertEquals(Integer.valueOf(-1), sudoku.brett[3]);
        assertEquals(Integer.valueOf(-1), sudoku.brett[59]);
        assertEquals(Integer.valueOf(-1), sudoku.brett[77]);
    }
    
    @Test
    public void testisdone() {
	Sudoku sudoku = new Sudoku();
    sudoku.finalsudoku();
    assertTrue(sudoku.isdone());
    }
}
