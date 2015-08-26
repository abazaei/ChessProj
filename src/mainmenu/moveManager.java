package mainmenu;

import java.util.regex.Matcher;

import pieces.*;

import java.util.regex.Pattern;

import board.Board;
import board.Tile;

public class moveManager {

	boolean LightTeam = true;

	public moveManager(){

	}

	public void moveReader(String string, Board board) throws Exception{




		Matcher singmove = Pattern.compile("([a-hA-H])([1-8])([a-hA-H])([1-8])(\\*)?").matcher(string);
		singmove.find();
		System.out.println(LightTeam);
		Tile tileOrigin = board.board[(int)singmove.group(1).toLowerCase().charAt(0)-97][(int)singmove.group(2).charAt(0)-49];


		if(LightTeam && tileOrigin.getP().getTeam().equals("l")){

			if(string.length() == 4 || string.length() == 5){
				if(placeMove(string,board)){
					LightTeam = false;
				}
				else if(singleMove(string,board)){
					System.out.println("Hello");
					LightTeam = false;
				}

				else
					System.out.println("Invalid Command!");
			}
			else
				if(doubleMove(string,board)){
					LightTeam = false;
				}
				else 
					System.out.println("Invalid Command");

		}
		else if(LightTeam == false && tileOrigin.getP().getTeam().equals("d")){

			if(string.length() == 4 || string.length() == 5){
				if(placeMove(string,board)){
					LightTeam = true;
				}
				else if(singleMove(string,board)){
					LightTeam = true;
				}

				else
					System.out.println("Invalid Command!");
			}
			else
				if(doubleMove(string,board)){
					LightTeam = true;
				}
				else 
					System.out.println("Invalid Command");

		}
		else
			throw new Exception("It is not your turn!");
	}


	public boolean placeMove(String string,Board b) throws Exception{
		Piece p;

		Matcher placepiece = Pattern.compile("([KQNBRPkqnbrp])([ldLD])([a-hA-H])([1-8])").matcher(string);
		if(!placepiece.matches()){
			return false;
		}
		if (placepiece.group(2).equalsIgnoreCase("l")){


			if(placepiece.group(1).equalsIgnoreCase("k")){
				p = new King("l");

			}
			else if(placepiece.group(1).equalsIgnoreCase("q")){
				p = new Queen("l");

			}
			else if(placepiece.group(1).equalsIgnoreCase("n")){
				p = new Knight("l");

			}
			else if(placepiece.group(1).equalsIgnoreCase("b")){
				p = new Bishop("l");
			}
			else if(placepiece.group(1).equalsIgnoreCase("r")){
				p = new Rook("l");

			}
			else if(placepiece.group(1).equalsIgnoreCase("p")){
				p = new Pawn("l");

			}

			else {
				return false;
			}

			if(placepiece.group(3).equalsIgnoreCase("a")){
				p.setLetterloc(0);
				p.setFullletterloc("A");

			}
			else if(placepiece.group(3).equalsIgnoreCase("b")){
				p.setLetterloc(1);
				p.setFullletterloc("B");
			}
			else if(placepiece.group(3).equalsIgnoreCase("c")){
				p.setLetterloc(2);
				p.setFullletterloc("C");
			}
			else if(placepiece.group(3).equalsIgnoreCase("d")){
				p.setLetterloc(3);
				p.setFullletterloc("D");
			}
			else if(placepiece.group(3).equalsIgnoreCase("e")){
				p.setLetterloc(4);
				p.setFullletterloc("E");
			}
			else if(placepiece.group(3).equalsIgnoreCase("f")){
				p.setLetterloc(5);
				p.setFullletterloc("F");
			}
			else if(placepiece.group(3).equalsIgnoreCase("g")){
				p.setLetterloc(6);
				p.setFullletterloc("G");
			}
			else if(placepiece.group(3).equalsIgnoreCase("h")){
				p.setLetterloc(7);
				p.setFullletterloc("H");
			}
			else {
				return false;
			}
			if(placepiece.group(4).equalsIgnoreCase("1")){
				p.setNumloc(0);
			}
			else if(placepiece.group(4).equalsIgnoreCase("2")){
				p.setNumloc(1);
			}
			else if(placepiece.group(4).equalsIgnoreCase("3")){
				p.setNumloc(2);
			}
			else if(placepiece.group(4).equalsIgnoreCase("4")){
				p.setNumloc(3);
			}
			else if(placepiece.group(4).equalsIgnoreCase("5")){
				p.setNumloc(4);
			}
			else if(placepiece.group(4).equalsIgnoreCase("6")){
				p.setNumloc(5);
			}
			else if(placepiece.group(4).equalsIgnoreCase("7")){
				p.setNumloc(6);
			}
			else if(placepiece.group(4).equalsIgnoreCase("8")){
				p.setNumloc(7);
			}
			else 
				return false;
			p.setTeam("l");
			p.setFullteam("Light ");


		}
		else if (placepiece.group(2).equalsIgnoreCase("d")){


			if(placepiece.group(1).equalsIgnoreCase("k")){
				p = new King("d");

			}
			else if(placepiece.group(1).equalsIgnoreCase("q")){
				p = new Queen("d");

			}
			else if(placepiece.group(1).equalsIgnoreCase("n")){
				p = new Knight("d");

			}
			else if(placepiece.group(1).equalsIgnoreCase("b")){
				p = new Bishop("d");
			}
			else if(placepiece.group(1).equalsIgnoreCase("r")){
				p = new Rook("d");

			}
			else if(placepiece.group(1).equalsIgnoreCase("p")){
				p = new Pawn("d");

			}

			else {
				return false;
			}

			if(placepiece.group(3).equalsIgnoreCase("a")){
				p.setLetterloc(0);
				p.setFullletterloc("A");

			}
			else if(placepiece.group(3).equalsIgnoreCase("b")){
				p.setLetterloc(1);
				p.setFullletterloc("B");
			}
			else if(placepiece.group(3).equalsIgnoreCase("c")){
				p.setLetterloc(2);
				p.setFullletterloc("C");
			}
			else if(placepiece.group(3).equalsIgnoreCase("d")){
				p.setLetterloc(3);
				p.setFullletterloc("D");
			}
			else if(placepiece.group(3).equalsIgnoreCase("e")){
				p.setLetterloc(4);
				p.setFullletterloc("E");
			}
			else if(placepiece.group(3).equalsIgnoreCase("f")){
				p.setLetterloc(5);
				p.setFullletterloc("F");
			}
			else if(placepiece.group(3).equalsIgnoreCase("g")){
				p.setLetterloc(6);
				p.setFullletterloc("G");
			}
			else if(placepiece.group(3).equalsIgnoreCase("h")){
				p.setLetterloc(7);
				p.setFullletterloc("H");
			}
			else {
				return false;
			}
			if(placepiece.group(4).equalsIgnoreCase("1")){
				p.setNumloc(0);
			}
			else if(placepiece.group(4).equalsIgnoreCase("2")){
				p.setNumloc(1);
			}
			else if(placepiece.group(4).equalsIgnoreCase("3")){
				p.setNumloc(2);
			}
			else if(placepiece.group(4).equalsIgnoreCase("4")){
				p.setNumloc(3);
			}
			else if(placepiece.group(4).equalsIgnoreCase("5")){
				p.setNumloc(4);
			}
			else if(placepiece.group(4).equalsIgnoreCase("6")){
				p.setNumloc(5);
			}
			else if(placepiece.group(4).equalsIgnoreCase("7")){
				p.setNumloc(6);
			}
			else if(placepiece.group(4).equalsIgnoreCase("8")){
				p.setNumloc(7);
			}
			else 
				return false;

			p.setTeam("d");
			p.setFullteam("Dark ");
		}
		else 
			return false;

		if(b.board[p.getLetterloc()][p.getNumloc()].isOccupied() ){ 
			if(b.board[p.getLetterloc()][p.getNumloc()].getP().getTeam().equals(p.getTeam())){
				throw new Exception("You can not place your piece onto another one of your pieces");

			}
			else if (!b.board[p.getLetterloc()][p.getNumloc()].getP().getTeam().equals(p.getTeam())){
				System.out.println("Place "+ p.getFullteam() + p.getFullPiece() + "on " + p.getFullletterloc() + p.getNumloc() + 
						" to capture" +b.board[p.getLetterloc()][p.getNumloc()].getP().getFullteam()+ b.board[p.getLetterloc()][p.getNumloc()].getP().getFullPiece());
				return true;
			}
		}
		else if(b.board[p.getLetterloc()][p.getNumloc()].getP() == null) {
			System.out.println("Place "+ p.getFullteam() + p.getFullPiece() + "on " + p.getFullletterloc() +   (p.getNumloc()+1));
			b.board[p.getLetterloc()][p.getNumloc()].setP(p);
			return true;
		}

		return true;
	}

	public boolean singleMove(String string, Board b) throws Exception{

		Matcher singmove = Pattern.compile("([a-hA-H])([1-8])([a-hA-H])([1-8])(\\*)?").matcher(string);


		if (!singmove.find()){
			return false;
		}

		Tile tileOrigin = b.board[(int)singmove.group(1).toLowerCase().charAt(0)-97][(int)singmove.group(2).charAt(0)-49];
		Tile tileDestination = b.board[(int)singmove.group(3).toLowerCase().charAt(0)-97][(int)singmove.group(4).charAt(0)-49];



		if (singmove.group(5)!=null){
			if(!tileOrigin.isOccupied()){
				throw new Exception("There is no piece to be found at the position "+singmove.group(1) + singmove.group(2));

			}
			if(tileDestination.isOccupied()){
				if(!tileDestination.getP().getTeam().equals(tileOrigin.getP().getTeam())){

					if(tileOrigin.getP().move(tileOrigin.getP(), tileDestination, b)){
						System.out.println("Move the piece at " + singmove.group(1) + singmove.group(2) +" to capture the piece at "+ singmove.group(3) + singmove.group(4));
						tileDestination.setP(tileOrigin.getP());
						tileOrigin.setP(null);
					} else {
						String cantmovethere = "The "+ tileOrigin.getP().getFullteam()+" "+tileOrigin.getP().getFullPiece() + " cannot move to column " +
								(tileDestination.getXcoord()+1)+ " row " + (tileDestination.getYcoord()+1);
						throw new Exception(cantmovethere);
					}
					//^ This one is complete... I think...
				}
				else{
					throw new Exception("You can not capture another piece of yours");

				}
			}	


			else if(!tileDestination.isOccupied()){
				throw new Exception("There is no piece at the destination to capture");

			}
			return true;
		}
		else if(singmove.group(5) == null){

			if(!tileOrigin.isOccupied()){
				throw new Exception("There is no piece to be found at the position "+singmove.group(1) + singmove.group(2));
			}
			if(tileDestination.isOccupied()){
				if(!tileDestination.getP().getTeam().equals(tileOrigin.getP().getTeam())){
					throw new Exception("You can not move your piece onto an opposing team's piece without a capture flag '*' ");
				}
				else{
					throw new Exception("You can not move your piece onto another one of your pieces");

				}
			}
			else if(!tileDestination.isOccupied()){
				System.out.println("TileDestination XCoord = "+tileDestination.getXcoord());
				System.out.println("TileDestination YCoord = "+tileDestination.getYcoord());
		
				if(tileOrigin.getP().move(tileOrigin.getP(), tileDestination, b)){
					//System.out.println("HelloItSucceded");
					System.out.println("Move the "+tileOrigin.getP().getFullPiece()+"at " + singmove.group(1) + singmove.group(2) +" to "+ singmove.group(3) + singmove.group(4));
					tileDestination.setP(tileOrigin.getP());
					tileOrigin.setP(null);
				}
				//CastleLight
				else if(tileOrigin.getP().getPiece().equalsIgnoreCase("k") && tileOrigin.getP().getTeam().equals("l") && (tileDestination.getXcoord() == 6 && tileDestination.getYcoord() == 7)){
					System.out.println("WE ARE IN 6,7");
					if(b.board[tileOrigin.getXcoord()+1][tileOrigin.getYcoord()].getP() == null){
						System.out.println("First Inner If done");
						if(b.board[tileOrigin.getXcoord()-2][tileOrigin.getYcoord()].getP() == null){
							System.out.println("Second Inner If done");
							System.out.println(b.board[0][7].getP().getPiece());
							if(b.board[7][7].getP().getPiece().equals("r") && b.board[0][7].getP().getTeam().equals("l")){
								System.out.println("In The Moving If!");
								b.board[5][7].setP(b.board[0][7].getP());
								b.board[7][7].setP(null);
								tileDestination.setP(tileOrigin.getP());
								tileOrigin.setP(null);
							}
						}
					}
				}
				else if(tileOrigin.getP().getPiece().equalsIgnoreCase("k") && tileOrigin.getP().getTeam().equals("l") && (tileDestination.getXcoord() == 2 && tileDestination.getYcoord() == 7)){
					System.out.println("WE ARE IN 2,7");
					
					
					//THIS ONE IS COMPLETE . DO IT FOR THE TOP ONE!!! test it first arush you think you might have just finished it ^
					if(b.board[tileOrigin.getXcoord()-1][tileOrigin.getYcoord()].getP() == null){
						System.out.println("First Inner If done");
						if(b.board[tileOrigin.getXcoord()-2][tileOrigin.getYcoord()].getP() == null){
							System.out.println("Second Inner If done");
							System.out.println(b.board[0][7].getP().getPiece());
							if(b.board[0][7].getP().getPiece().equals("r") && b.board[0][7].getP().getTeam().equals("l")){
								System.out.println("In The Moving If!");
								b.board[3][7].setP(b.board[0][7].getP());
								b.board[0][7].setP(null);
								tileDestination.setP(tileOrigin.getP());
								tileOrigin.setP(null);
							}
						}
					}

				}
				//CastleDark
				else {
					//System.out.println("HelloItfailed");
					String cantmovethere = "The "+ tileOrigin.getP().getFullteam()+" "+tileOrigin.getP().getFullPiece() + " cannot move to column " +
							(tileDestination.getXcoord()+1)+ " row " + (tileDestination.getYcoord()+1);
					throw new Exception(cantmovethere);
				}
				return true;
			}

			//Castling below


			return true;
		}

		else
			return false;




	}
	public boolean doubleMove(String string, Board b) throws Exception{
		Matcher dubmove = Pattern.compile("([a-hA-H])([1-8])([a-hA-H])([1-8])([a-hA-H])([1-8])([a-hA-H])([1-8])").matcher(string);



		if (!dubmove.find() && string.length() != 8){
			return false;
		}

		Tile tileOrigin = b.board[(int)dubmove.group(1).toLowerCase().charAt(0)-97][(int)dubmove.group(2).charAt(0)-49];
		Tile tileDestination = b.board[(int)dubmove.group(3).toLowerCase().charAt(0)-97][(int)dubmove.group(4).charAt(0)-49];

		Tile tileDestinationKing = b.board[(int)dubmove.group(3).toLowerCase().charAt(0)-97][(int)dubmove.group(4).charAt(0)-49];
		Tile tileDestinationRook = b.board[(int)dubmove.group(3).toLowerCase().charAt(0)-97][(int)dubmove.group(4).charAt(0)-49];

		if(tileOrigin.getP().getPiece().equalsIgnoreCase("k") && tileDestination.getP().getPiece().equalsIgnoreCase("r")){

			tileDestination.setP(tileOrigin.getP());
			tileOrigin.setP(null);

			System.out.println("Move the piece at " + dubmove.group(1) + dubmove.group(2) +" to "+ dubmove.group(3) + dubmove.group(4) + 
					" and the piece at "+ dubmove.group(5) + dubmove.group(6) + " to "+ dubmove.group(7) + dubmove.group(8));
		}

		else
			throw new Exception("Invalid Move!");


		return false;
	}
	public boolean check(Board b){

		//b.board[b.getdKingx()][b.getdKingy()].getP()
		return false;

	}
}
