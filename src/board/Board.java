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
		board[1][0].setP(new Knight("d"));
		board[2][0].setP(new Bishop("d"));
		board[3][0].setP(new Queen("d"));
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


		//	THIS SHOULD PRODUCE CHECK MATE. FIGURE OUT WHERE TO PUT THIS!!!

		moveManager.setDarkKingChecked(false);
		moveManager.setLightKingChecked(false);
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

					//System.out.println("Uh oh, Light is in check!");
					moveManager.setLightKingChecked(true);

				}

				if(isDarkChecked(board[i][j])){
					//System.out.println("Uh oh, Dark is in check!");
					moveManager.setDarkKingChecked(true);
				}
			}
		}
	}

	/**
	 * 1. Loop through rows/columns of pieces
	 * 2. With each piece, loop through and attempt to move the piece to every tile, if it's valid, actually move it on the copied board
	 * 3. Check the current copied version of the board, to see if any dark pieces can now succesfully move to the light king.
	 * 4. If a move takes the king out of check, he is not in check mate.
	 * @param b
	 * @return
	 * @throws Exception
	 */
	public boolean checkCheckMateLight(Board b) throws Exception {

		//I THINK THE BOARD SHOULD BE COPIED EACH TIME
		for (int z = 0; z < b.board.length; z++) {
			for(int y = 0; y < b.board[z].length; y++){
				for (int i = 0; i < b.board.length; i++) {
					for(int j = 0; j < b.board[i].length; j++){

						Board tempBoard = b.copy(b.board);
						if(tempBoard.board[z][y].getP() != null){

							if(tempBoard.board[z][y].getP().move(tempBoard.board[z][y].getP(), tempBoard.board[i][j], tempBoard) && tempBoard.board[z][y].getP().getTeam().equals("l")){

								if(tempBoard.board[i][j].getP() == null || !tempBoard.board[i][j].getP().getTeam().equals("l")){
									tempBoard.board[i][j].setP(tempBoard.board[z][y].getP());
									tempBoard.board[z][y].setP(null);

									tempBoard.scanBoard();
									//So the current problem, tempBoard light king is in check but it still enters the method below

									if(!moveManager.getLightKingChecked()){
										//tempBoard.printBoard();

//										System.out.println(tempBoard.board[i][j].getP().getLetterloc()+"X");
//										System.out.println(tempBoard.board[i][j].getP().getNumloc() + "Y");
//
//										System.out.println("Hello");
//										System.out.println(moveManager.getLightKingChecked());
										moveManager.setLightKingCheckMate(false);
										
									}
									else 
										moveManager.setLightKingCheckMate(true);

								}
								//^ This will go through every possible map, now you need to check right after this with an if( any move made check false) then set checkmateLight to false;
								//else set checkmateLight = true
							}

						}
					}
				}

			}
		}
		if(moveManager.isLightKingCheckMate()){
			return true;
		}
		return false;
	}
	public boolean checkCheckMateDark(Board b) throws Exception {

		Board tempBoard = b.copy(b.board);
		for (int z = 0; z < tempBoard.board.length; z++) {
			for(int y = 0; y < tempBoard.board[z].length; y++){
				for (int i = 0; i < tempBoard.board.length; i++) {
					for(int j = 0; j < tempBoard.board[i].length; j++){
						if(tempBoard.board[z][y].getP() != null){

							if(tempBoard.board[z][y].getP().move(tempBoard.board[z][y].getP(), tempBoard.board[i][j], tempBoard) && tempBoard.board[z][y].getP().getTeam().equals("d")){
								tempBoard.board[i][j].setP(tempBoard.board[z][y].getP());
								tempBoard.board[z][y].setP(null);
								//should do every possible LEGAL move for every light piece on the board.
								//System.out.println("Checking if Dark is in Check Mate");
								tempBoard.scanBoardforCheckMate();


							}


						}

					}
				}

			}
		}
		if(moveManager.isDarkKingCheckMate()){
			return true;
		}
		return false;
	}
	public void scanBoardforCheckMate(){

		for (int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j].getP()!=null){ 
					board[i][j].getP().setLetterloc(i);
					board[i][j].getP().setNumloc(j);
					if(board[i][j].getP().getTeam() == "l" && board[i][j].getP().getPiece().equalsIgnoreCase("k")){



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
		boolean lightIsCheckMate = true;
		for (int i = 0; i < board.length; i++) {

			for(int j = 0; j < board[i].length; j++){

				if(!isLightChecked(board[i][j])){


					lightIsCheckMate = false;


				}
				//				else{  
				//					//Current Problem is that K is in checkmate, except it is not Checked...
				//					// through my current ^ method, if a rook can't reach light King, then it thinks that light is not in check
				//					
				//					
				//				
				//				}

				if(!isDarkChecked(board[i][j])){
					//

				}
				//				else{
				//					moveManager.setDarkKingCheckMate(false);
				//					return;
				//
				//				}


			}
		}

		moveManager.setLightKingCheckMate(lightIsCheckMate);



	}

	private boolean isDarkCheckMate(Tile tile) {

		return false;
	}
	private boolean isLightCheckMate(Tile t) {

		if(t.getP() != null){  //get every tile with a piece on the board
			for (int i = 0; i < board.length; i++) {
				for(int j = 0; j < board[i].length; j++){
					if(t.getP().move(t.getP(), this.board[i][j], this) && t.getP().getTeam().equals("l")){ //try to move every single light piece to every possible location
						if(isLightChecked(board[i][j])){ //Checks if any move you're doing that is legal for that piece, will leave you still in check

						}

					}
				}
			}
		}
		return false;
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
