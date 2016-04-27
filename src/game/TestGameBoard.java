package game;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGameBoard {

	@Test
	public void can_make_valid_move() {
		GameBoard gb = new GameBoard(10,10);
		assertTrue(gb.makeMove(1, 1, 1));
		assertEquals(1, gb.getBoard()[1][1]);
	}
	
	@Test
	public void can_not_make_invalid_move() {
		GameBoard gb = new GameBoard(10,10);
		gb.makeMove(1, 1, 1);
		assertFalse(gb.makeMove(2, 1, 1));
		assertEquals(1, gb.getBoard()[1][1]);
	}
	
	@Test
	public void can_give_vertical_victory() {
		GameBoard gb = new GameBoard(10,10);
		gb.makeMove(1, 0, 1);
		gb.makeMove(1, 0, 2);
		gb.makeMove(1, 0, 3);
		assertEquals(0, gb.checkForVerticalVictor(0, 3));
		gb.makeMove(1, 0, 4);
		assertEquals(1, gb.checkForVerticalVictor(0, 3));
	}
	
	@Test
	public void can_give_horizontal_victory() {
		GameBoard gb = new GameBoard(10,10);
		gb.makeMove(1, 1, 0);
		gb.makeMove(1, 2, 0);
		gb.makeMove(1, 3, 0);
		assertEquals(0, gb.checkForHorizontalVictor(3, 0));
		gb.makeMove(1, 4, 0);
		assertEquals(1, gb.checkForHorizontalVictor(3, 0));
	}
	
	@Test
	public void can_give_diagonal_victory_SE_to_NW() {
		GameBoard gb = new GameBoard(10,10);
		gb.makeMove(1, 4, 1);
		gb.makeMove(1, 3, 2);
		gb.makeMove(1, 2, 3);
		assertEquals(0, gb.checkForDiagonalVictor(2, 3));
		gb.makeMove(1, 1, 4);
		assertEquals(1, gb.checkForDiagonalVictor(1, 4));
	}
	
	@Test
	public void can_give_diagonal_victory_SW_to_NE() {
		GameBoard gb = new GameBoard(10,10);
		gb.makeMove(1, 1, 1);
		gb.makeMove(1, 2, 2);
		gb.makeMove(1, 3, 3);
		assertEquals(0, gb.checkForDiagonalVictor(3, 3));
		gb.makeMove(1, 4, 4);
		assertEquals(1, gb.checkForDiagonalVictor(4, 4));
	}
}

