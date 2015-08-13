package board;


import java.util.Arrays;

import pieces.Piece;
import pieces.Rook;

public class Board {

	public Tile[][] board = new Tile[8][8];
	
	
	public Board(){
		
		for (int i = 0; i < board.length; i++) {
			for(int j = 0; i < board[i].length-1; i++){
				board[i][j] = new Tile(); 
			}
		}
	}
		
	
	public void printBoard(){
		
		String boardS = "";
		boardS += "     a   b  c  d   e  f  g  h \n";
		boardS += "    ================\n";
		boardS += "8 | "+ board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " + board[0][3] + " | " + board[0][4]+ " | " + board[0][5] + " | " + board[0][6] + " | " + board[0][7] + " |" +"\n";
		boardS += "7 | "+ board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " | " + board[1][4]+ " | " + board[1][5] + " | " + board[1][6] + " | " + board[1][7] + " |" + "\n";
		boardS += "6 | "+ board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " | " + board[2][4]+ " | " + board[2][5] + " | " + board[2][6] + " | " + board[2][7] + " |" +"\n";
		boardS += "5 | "+ board[3][0] + " | " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " | " + board[3][4]+ " | " + board[3][5] + " | " + board[3][6] + " | " + board[3][7] + " |" +"\n";
		boardS += "4 | "+ board[4][0] + " | " + board[4][1] + " | " + board[4][2] + " | " + board[4][3] + " | " + board[4][4]+ " | " + board[4][5] + " | " + board[4][6] + " | " + board[4][7] + " |" +"\n";
		boardS += "3 | "+ board[5][0] + " | " + board[5][1] + " | " + board[5][2] + " | " + board[5][3] + " | " + board[5][4]+ " | " + board[5][5] + " | " + board[5][6] + " | " + board[5][7] + " |" +"\n";
		boardS += "2 | "+ board[6][0] + " | " + board[6][1] + " | " + board[6][2] + " | " + board[6][3] + " | " + board[6][4]+ " | " + board[6][5] + " | " + board[6][6] + " | " + board[6][7] + " |" +"\n";
		boardS += "1 | "+ board[7][0] + " | " + board[7][1] + " | " + board[7][2] + " | " + board[7][3] + " | " + board[7][4]+ " | " + board[7][5] + " | " + board[7][6] + " | " + board[7][7] + " |" +"\n";
		boardS += "    ================\n";

		System.out.println(boardS.replace("null", "-"));
	}
	

}
