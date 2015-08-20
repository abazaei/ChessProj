package pieces;

import board.Board;
import board.Tile;

public abstract class Piece {

	private String piece;
	private String FullPiece;
	private int letterloc;
	private int numloc;
	private String fullletterloc;
	private String team;
	private String fullteam;



	public Piece(String s, String fp, String pieceteam){
		this.piece = s;
		this.FullPiece = fp;
		this.team = pieceteam;
		if(pieceteam.equals("l")){
			this.fullteam = "Light";
		}
		else if (pieceteam.equals("d")){
			this.fullteam = "Dark";
		}
	}

	public String getPiece() {
		return piece;
	}
	public String getFullPiece(){
		return FullPiece;
	}

	public int getLetterloc() {
		return letterloc;
	}

	public void setLetterloc(int letterloc) {
		this.letterloc = letterloc;
	}

	public int getNumloc() {
		return numloc;
	}

	public void setNumloc(int numloc) {
		this.numloc = numloc;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getFullletterloc() {
		return fullletterloc;
	}

	public void setFullletterloc(String fullletterloc) {
		this.fullletterloc = fullletterloc;
	}

	public String getFullteam() {
		return fullteam;
	}

	public void setFullteam(String fullteam) {
		this.fullteam = fullteam;
	}


	public boolean move(Piece p, Tile t, Board b){
		if(p.getPiece().equals("n"))
			return knJump(p,t);
		else if(p.getPiece().equals("r"))
			return rookMove(p,t,b);
		else if(p.getPiece().equals("q"))
			return queenMove(p,t);
		else if(p.getPiece().equals("p"))
			return pawnMove(p,t);
		else if(p.getPiece().equals("b"))
			return bishopMove(p,t,b);
		else if(p.getPiece().equals("k"))
			return kingMove(p,t);
		return false;

	}
	private boolean kingMove(Piece p, Tile destination) {
		return false;
		// TODO Auto-generated method stub

	}

	private boolean bishopMove(Piece p, Tile destination, Board b) {
		if (destination.getXcoord() > (p.getLetterloc()) && destination.getYcoord() > (p.getNumloc())){
			//NorthEast
			
		}
		else if (destination.getXcoord() == (p.getLetterloc()) && destination.getYcoord() != (p.getNumloc())){
			//
		}
		return false;

	}

	private boolean pawnMove(Piece p, Tile destination) {
		return false;
		// TODO Auto-generated method stub

	}

	private boolean queenMove(Piece p, Tile destination) {
		return false;
		// TODO Auto-generated method stub

	}

	public boolean knJump(Piece p, Tile destination){

		System.out.println("letter loc " + p.getLetterloc() + " number loc "+   p.getNumloc());
		System.out.println("destination column " + destination.getXcoord() + " destination row " +destination.getYcoord());
		if (destination.getXcoord() == (p.getLetterloc()+2) && destination.getYcoord() == (p.getNumloc()+1)){
			return true;
		}
		else if (destination.getXcoord() == (p.getLetterloc()+2) && destination.getYcoord() == (p.getNumloc()-1)){
			return true;
		}
		else if (destination.getXcoord() == (p.getLetterloc()-2) && destination.getYcoord() == (p.getNumloc()+1)){
			return true;
		}
		else if (destination.getXcoord() == (p.getLetterloc()-1) && destination.getYcoord() == (p.getNumloc()+2)){
			return true;
		}
		else if (destination.getXcoord() == (p.getLetterloc()+1) && destination.getYcoord() == (p.getNumloc()+2)){
			return true;
		}
		else if (destination.getXcoord() == (p.getLetterloc()-1) && destination.getYcoord() == (p.getNumloc()-2)){
			return true;
		}
		else if (destination.getXcoord() == (p.getLetterloc()+1) && destination.getYcoord() == (p.getNumloc()-2)){
			return true;
		}
		else
			return false;

	}
	public boolean rookMove(Piece p, Tile destination, Board b){
		if (destination.getXcoord() != (p.getLetterloc()) && destination.getYcoord() == (p.getNumloc())){
			if(destination.getXcoord()>p.getLetterloc()){
				for(int i = p.getLetterloc(); i != destination.getXcoord();i++){
					System.out.println("Moving Horizontally-Right");

					if(b.board[i][destination.getYcoord()].isOccupied()&& !b.board[i][destination.getYcoord()].getP().equals(p)){
						return false;

					}
					//NEXT STEP: MAKE int i = the row or column of the piece . IN THE FOR LOOP

				}
				return true;
			}
			else{
				for(int i = p.getLetterloc(); i != destination.getXcoord();i--){
					System.out.println("Moving Horizontally-LEFT");

					if(b.board[i][destination.getYcoord()].isOccupied()&& !b.board[i][destination.getYcoord()].getP().equals(p)){
						return false;
					}
				}
				return true;
			}
		}
		else if (destination.getXcoord() == (p.getLetterloc()) && destination.getYcoord() != (p.getNumloc())){
			if(destination.getYcoord() > p.getNumloc()){
				for(int i = p.getNumloc(); i != destination.getYcoord();i++){
					System.out.println("Moving Vertically-Down");

					if(b.board[destination.getXcoord()][i].isOccupied() &&
							!b.board[destination.getXcoord()][i].getP().equals(p)){

						System.out.println(b.board[destination.getXcoord()][i]);
						return false;

					}
				}
			}
			else{
				for(int i = p.getNumloc(); i != destination.getYcoord();i--){
					System.out.println("Moving Vertically-Up");

					if(b.board[destination.getXcoord()][i].isOccupied() &&
							!b.board[destination.getXcoord()][i].getP().equals(p)){

						System.out.println(b.board[destination.getXcoord()][i]);
						return false;

					}
				}
			}
			return true;
			//NEED MULTIPLE FOR LOOPS FOR MOVING UP ROOK AND MOVING DOWN ROOK, TEAM DOESNT MATTER!
		}
		else 
			return false;



	}


	@Override
	public String toString() {
		if (getTeam().equals("l")){
			return piece.toUpperCase();
		}
		else
			return piece;


	}


}
