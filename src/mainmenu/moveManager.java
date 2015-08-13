package mainmenu;

import java.util.regex.Matcher;

import pieces.*;

import java.util.regex.Pattern;

import board.Board;
import board.Tile;

public class moveManager {

	public moveManager(){

	}

	public void moveReader(String string, Board board) throws Exception{

		Piece p;
		Piece p2;
		if(string.length() == 4 || string.length() == 5){
			if(placeMove(string,board)){

			}
			else if(singleMove(string,board)){

			}

			else
				System.out.println("Invalid Command!");
		}
		else
			if(doubleMove(string,board)){

			}
			else 
				System.out.println("Invalid Command");

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

					if(tileOrigin.getP().move(tileOrigin.getP(), tileDestination)){
						System.out.println("Move the piece at " + singmove.group(1) + singmove.group(2) +" to capture the piece at "+ singmove.group(3) + singmove.group(4));
						tileDestination.setP(tileOrigin.getP());
						tileOrigin.setP(null);
					} else {
						String cantmovethere = "The "+ tileOrigin.getP().getFullteam() + tileOrigin.getP().getFullPiece() + " cannot move to "+ 
								tileDestination.getP().getFullletterloc()+ tileDestination.getP().getNumloc();
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
				System.out.println("Move the piece at " + singmove.group(1) + singmove.group(2) +" to "+ singmove.group(3) + singmove.group(4));
				tileDestination.setP(tileOrigin.getP());
				tileOrigin.setP(null);
				return true;
			}
			return true;
		}

		else
			return false;




	}
	public boolean doubleMove(String string, Board board){
		Matcher dubmove = Pattern.compile("([a-hA-H])([1-8])([a-hA-H])([1-8])([a-hA-H])([1-8])([a-hA-H])([1-8])").matcher(string);

		if (!dubmove.find() && string.length() != 8){
			return false;
		}

		if(dubmove.groupCount() == 8)
			System.out.println("Move the piece at " + dubmove.group(1) + dubmove.group(2) +" to "+ dubmove.group(3) + dubmove.group(4) + 
					" and the piece at "+ dubmove.group(5) + dubmove.group(6) + " to "+ dubmove.group(7) + dubmove.group(8));

		else
			return false;


		return true;
	}
}
