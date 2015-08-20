package board;


import java.util.Arrays;

import pieces.*;


public class Board {

	public Tile[][] board = new Tile[8][8];
	
	
	public Board(){
		
		for (int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = new Tile();
				board[i][j].setXcoord(i);
				board[i][j].setYcoord(j);
			}
		}
		//FIGURE OUT HOW TO CHANGE THE PIECES LETTER AND NUM LOC on moves 
		//scan board 
		board[2][2].setP(new Knight("d"));
		board[0][4].setP(new Knight("d"));
		board[0][0].setP(new Rook("d"));
		board[1][0].setP(new Knight("d"));
		board[2][0].setP(new Bishop("d"));
		board[3][0].setP(new Queen("d"));
		board[4][0].setP(new King("d"));
		board[5][0].setP(new Bishop("d"));
		board[6][0].setP(new Knight("d"));
		board[7][0].setP(new Rook("d"));
		board[0][7].setP(new Rook("l"));
		board[1][7].setP(new Knight("l"));
		board[2][7].setP(new Bishop("l"));
		board[3][7].setP(new King("l"));
		board[4][7].setP(new Queen("l"));
		board[5][7].setP(new Bishop("l"));
		board[6][7].setP(new Knight("l"));
		board[7][7].setP(new Rook("l"));
	
	}
	public void scanBoard(){
		
		for (int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j].getP()!=null){
					board[i][j].getP().setLetterloc(i);
					board[i][j].getP().setNumloc(j);
				}
				
			}
		}
	}
	
	public void printBoard(){
		
		String boardS = "";
		boardS += "    a   b   c   d   e   f   g   h \n";
		boardS += "   ===============================\n";
		boardS += "1 | "+ board[0][0] + " | " + board[1][0] + " | " + board[2][0] + " | " + board[3][0] + " | " + board[4][0]+ " | " + board[5][0] + " | " + board[6][0] + " | " + board[7][0] + " |" +"\n";
		boardS += "2 | "+ board[0][1] + " | " + board[1][1] + " | " + board[2][1] + " | " + board[3][1] + " | " + board[4][1]+ " | " + board[5][1] + " | " + board[6][1] + " | " + board[7][1] + " |" + "\n";
		boardS += "3 | "+ board[0][2] + " | " + board[1][2] + " | " + board[2][2] + " | " + board[3][2] + " | " + board[4][2]+ " | " + board[5][2] + " | " + board[6][2] + " | " + board[7][2] + " |" +"\n";
		boardS += "4 | "+ board[0][3] + " | " + board[1][3] + " | " + board[2][3] + " | " + board[3][3] + " | " + board[4][3]+ " | " + board[5][3] + " | " + board[6][3] + " | " + board[7][3] + " |" +"\n";
		boardS += "5 | "+ board[0][4] + " | " + board[1][4] + " | " + board[2][4] + " | " + board[3][4] + " | " + board[4][4]+ " | " + board[5][4] + " | " + board[6][4] + " | " + board[7][4] + " |" +"\n";
		boardS += "6 | "+ board[0][5] + " | " + board[1][5] + " | " + board[2][5] + " | " + board[3][5] + " | " + board[4][5]+ " | " + board[5][5] + " | " + board[6][5] + " | " + board[7][5] + " |" +"\n";
		boardS += "7 | "+ board[0][6] + " | " + board[1][6] + " | " + board[2][6] + " | " + board[3][6] + " | " + board[4][6]+ " | " + board[5][6] + " | " + board[6][6] + " | " + board[7][6] + " |" +"\n";
		boardS += "8 | "+ board[0][7] + " | " + board[1][7] + " | " + board[2][7] + " | " + board[3][7] + " | " + board[4][7]+ " | " + board[5][7] + " | " + board[6][7] + " | " + board[7][7] + " |" +"\n";
		boardS += "   ===============================\n";

		System.out.println(boardS.replace("null", "-"));
	}
	

}
