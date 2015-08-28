package board;


import java.util.Arrays;

import mainmenu.moveManager;
import pieces.*;


public class Board {

	moveManager mManager = new moveManager();

	public Tile[][] board = new Tile[8][8];
	int lKingx = 0;
	int lKingy = 0;
	int dKingx = 0;
	int dKingy = 0;



	public int getlKingx() {
		return lKingx;
	}
	public void setlKingx(int lKingx) {
		this.lKingx = lKingx;
	}
	public int getlKingy() {
		return lKingy;
	}
	public void setlKingy(int lKingy) {
		this.lKingy = lKingy;
	}
	public int getdKingx() {
		return dKingx;
	}
	public void setdKingx(int dKingx) {
		this.dKingx = dKingx;
	}
	public int getdKingy() {
		return dKingy;
	}
	public void setdKingy(int dKingy) {
		this.dKingy = dKingy;
	}

	public Board(){

		for (int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = new Tile();
				board[i][j].setXcoord(i);
				board[i][j].setYcoord(j);
			}
		}
		//
		//
		//		board[2][2].setP(new Knight("d"));
		//		board[3][2].setP(new Knight("d"));
		//		board[6][2].setP(new Knight("d"));

		board[0][0].setP(new Rook("d"));
//		board[1][0].setP(new Knight("d"));
//		board[2][0].setP(new Bishop("d"));
//		board[3][0].setP(new Queen("d"));
		board[4][0].setP(new King("d"));
		board[5][0].setP(new Bishop("d"));
		board[6][0].setP(new Knight("d"));
		board[7][0].setP(new Rook("d"));


		board[0][1].setP(new Pawn("d"));
		board[1][1].setP(new Pawn("d"));
		board[2][1].setP(new Pawn("d"));
		board[3][1].setP(new Pawn("d"));
		board[4][1].setP(new Pawn("d"));
		board[5][1].setP(new Pawn("d"));
		board[6][1].setP(new Pawn("d"));
		board[7][1].setP(new Pawn("d"));

		board[0][7].setP(new Rook("l"));
		board[1][7].setP(new Knight("l"));
		board[2][7].setP(new Bishop("l"));
		board[4][7].setP(new King("l"));
		board[3][7].setP(new Queen("l"));
		board[5][7].setP(new Bishop("l"));
		board[6][7].setP(new Knight("l"));
		board[7][7].setP(new Rook("l"));


		board[0][6].setP(new Pawn("l"));
		board[1][6].setP(new Pawn("l"));
		board[2][6].setP(new Pawn("l"));
		board[3][6].setP(new Pawn("l"));
		board[4][6].setP(new Pawn("l"));
		board[5][6].setP(new Pawn("l"));
		board[6][6].setP(new Pawn("l"));
		board[7][6].setP(new Pawn("l"));

	}
	public void scanBoard(){
		mManager.setDarkKingChecked(false);
		mManager.setLightKingChecked(false);
		for (int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j].getP()!=null){ // THE ULTIMATE BUG HAS BEEN FOUND, FIND WHERE KING IS. THEN RUN LOOP AGAIN
					board[i][j].getP().setLetterloc(i);
					board[i][j].getP().setNumloc(j);
					if(board[i][j].getP().getTeam() == "l" && board[i][j].getP().getPiece().equalsIgnoreCase("k")){
						/*
						   LOOP THROUGH EACH TILE, GET THE PIECE, SEE IF YOU CAN MOVE TO THE KING BY PASSING THE KING x King Y shit 
						   you made above. Something weird with pawns that Tyler said just figure it out.
						 */


						this.lKingx = i;
						this.lKingy = j;


					}
					else if(board[i][j].getP().getTeam() == "d" && board[i][j].getP().getPiece().equalsIgnoreCase("k")){
						this.dKingx = i;
						this.dKingy = j;
					}

				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++){
				if(isLightChecked(board[i][j])){

					System.out.println("Uh oh, Light is in check!");
					mManager.setLightKingChecked(true);

				}

				if(isDarkChecked(board[i][j])){
					System.out.println("Uh oh, Dark is in check!");
					mManager.setDarkKingChecked(true);
				}
			}
		}
	}

	public Board copy(Tile[][] b){
		Board tempBoard = new Board();

		for (int i = 0; i < tempBoard.board.length; i++) {
			for(int j = 0; j < tempBoard.board[i].length; j++){
				tempBoard.board[i][j] = new Tile();
				tempBoard.board[i][j].setXcoord(i);
				tempBoard.board[i][j].setYcoord(j);
			}
		}

		for (int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[i].length; j++){
				if(b[i][j].getP()!=null){
					tempBoard.board[i][j].setP(b[i][j].getP());
					//					tempBoard[i][j].getP().setLetterloc(i);
					//					tempBoard[i][j].getP().setNumloc(j);
					if(tempBoard.board[i][j].getP().getTeam() == "l" && tempBoard.board[i][j].getP().getPiece().equalsIgnoreCase("k")){
						/*
						   LOOP THROUGH EACH TILE, GET THE PIECE, SEE IF YOU CAN MOVE TO THE KING BY PASSING THE KING x King Y shit 
						   you made above. Something weird with pawns that Tyler said just figure it out.
						 */


						this.lKingx = i;
						this.lKingy = j;


					}
					else if(tempBoard.board[i][j].getP().getTeam() == "d" && tempBoard.board[i][j].getP().getPiece().equalsIgnoreCase("k")){
						this.dKingx = i;
						this.dKingy = j;
					}

				}
			}
		}
		return tempBoard;

	}

	public boolean isDarkChecked(Tile t){
		if(t.getP() != null){
			if(t.getP().move(t.getP(), board[this.dKingx][this.dKingy], this) && t.getP().getTeam().equals("l")){
				return true;
			}
		}
		return false;

	}
	public boolean isLightChecked(Tile t){
		if(t.getP() != null){
//			System.out.println("Checking if light king is in check from "+ t.getP()+ " at x: " +(t.getXcoord()) + " and y: "+ t.getYcoord() );
//			System.out.println(lKingx +" "+lKingy);
			if(t.getP().move(t.getP(), this.board[this.lKingx][this.lKingy], this) && t.getP().getTeam().equals("d")){  // <----- MAJOR ISSUE. The bishop logic is messed I believe
				
				return true;
			}
		}
		return false;

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
