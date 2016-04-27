package game;

public class Match {
	int height, width;
	String playerOne, playerTwo;
	GameBoard gb;
	int currentPlayer;

	public Match(String playerOne, String playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		gb = new GameBoard(12,12);
		currentPlayer = 1;
	}

	public int getGameBoardCols() {
		return gb.getBoard().length;
	}

	public int getGameBoardRows() {
		return gb.getBoard()[0].length;
	}

	/**
	 * Returns true if it is a valid move.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean makeMove(int x, int y) {
		boolean validMove = gb.makeMove(currentPlayer, x, y);
		if(validMove)
			currentPlayer = (currentPlayer == 1) ? 2 : 1;
		return validMove;
	}

	public int checkForVictor(int x, int y) {
		return gb.checkForVictor(x, y);
	}

	public int getPreviousPlayer() {
		return (currentPlayer == 1) ? 2 : 1;
	}

	public String getPlayerName(int playerNbr) {
		if(playerNbr == 1){
			return playerOne;
		}else if(playerNbr == 2){
			return playerTwo;
		}
		return "No name";
	}

}
