package game;

public class GameBoard {
	private int[][] gameBoard;

	public GameBoard(int height, int width) {
		gameBoard = new int[height][width];
	}

	public boolean makeMove(int player, int x, int y) {
		if (gameBoard[x][y] == 0) {
			gameBoard[x][y] = player;
			return true;
		}
		return false;
	}

	public int[][] getBoard() {
		return gameBoard;
	}

	public int checkForVictor(int x, int y) {
		int diagonal1 = checkForDiagonalVictor1(x, y);
		int diagonal2 = checkForDiagonalVictor2(x, y);
		int horizontal = checkForHorizontalVictor(x, y);
		int vertical = checkForVerticalVictor(x, y);
		if(diagonal1 != 0){
			return diagonal1;
		}else if(diagonal2 != 0){
			return diagonal2;
		}else if(horizontal != 0){
			return horizontal;
		}else if(vertical != 0){
			return vertical;
		}else{
			return 0;
		}
	}

	protected int checkForHorizontalVictor(int x, int y) {
		int minX = x - 4 < 0 ? 0 : x - 4;
		int maxX = x + 4 > gameBoard.length ? 0 : x + 4;
		int counter = 0;
		int currentPlayer = 0;
		for (int tempX = minX; tempX < maxX; tempX++) {
			if (currentPlayer != 0 && currentPlayer == gameBoard[tempX][y]) {
				counter++;
				if (counter == 4)
					break;
			} else {
				currentPlayer = gameBoard[tempX][y];
				counter = 1;
			}
		}
		if (counter == 4)
			return currentPlayer;
		return 0;
	}

	protected int checkForVerticalVictor(int x, int y) {
		int minY = y - 4 < 0 ? 0 : y - 4;
		int maxY = y + 4 > gameBoard[0].length ? 0 : y + 4;
		int counter = 0;
		int currentPlayer = 0;
		for (int tempY = minY; tempY < maxY; tempY++) {
			if (currentPlayer != 0 && currentPlayer == gameBoard[x][tempY]) {
				counter++;
				if (counter == 4)
					break;
			} else {
				currentPlayer = gameBoard[x][tempY];
				counter = 1;
			}
		}
		if (counter == 4){
			return currentPlayer;			
		}
		return 0;
	}
	
	public Object checkForDiagonalVictor(int x, int y) {
		int one = checkForDiagonalVictor1(x, y);
		int two = checkForDiagonalVictor2(x, y);
		System.out.println("lol");
		if(one != 0) return one;
		if(two != 0) return two;
		return 0;
	}
	
	/**
	 * 
	 * From south-west to north-east
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private int checkForDiagonalVictor1(int x, int y) {
		int minX = x - 4 < 0 ? 0 : x - 4;
		int maxX = x + 4 > gameBoard.length ? 0 : x + 4;
		int minY = y - 4 < 0 ? 0 : y - 4;
		int maxY = y + 4 > gameBoard[0].length ? 0 : y + 4;
		int counter = 0;
		int currentPlayer = 0;
		int tempX = minX;
		int tempY = minY;
		while (tempX < maxX && tempY < maxY) {
			if (currentPlayer != 0 && currentPlayer == gameBoard[tempX][tempY]) {
				counter++;
				if (counter == 4)
					break;
			} else {
				currentPlayer = gameBoard[tempX][tempY];
				counter = 1;
			}
			tempX++;
			tempY++;
		}
		if (counter == 4)
			return currentPlayer;
		return 0;

	}

	/**
	 * 
	 * From south-east to north-west
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private int checkForDiagonalVictor2(int x, int y) {
		int minX = x - 4 < 0 ? 0 : x - 4;
		int maxX = x + 4 > gameBoard.length ? 0 : x + 4;
		int minY = y - 4 < 0 ? 0 : y - 4;
		int maxY = y + 4 > gameBoard[0].length ? 0 : y + 4;
		int counter = 0;
		int currentPlayer = 0;
		int tempX = maxX;
		int tempY = minY;
		while (tempX > minX && tempY < maxY) {
			System.out.println("Player:  " + currentPlayer + " X " + tempX + " Y " + tempY);
			if (currentPlayer != 0 && currentPlayer == gameBoard[tempX][tempY]) {
				counter++;
				if (counter == 4)
					break;
			} else {
				currentPlayer = gameBoard[tempX][tempY];
				counter = 1;
			}
			tempX--;
			tempY++;
		}
		if (counter == 4)
			return currentPlayer;
		return 0;

	}
}
