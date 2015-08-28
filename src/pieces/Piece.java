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
			return queenMove(p,t, b);
		else if(p.getPiece().equals("p"))
			return pawnMove(p,t, b);
		else if(p.getPiece().equals("b"))
			return bishopMove(p,t,b);
		else if(p.getPiece().equals("k"))
			return kingMove(p,t, b);
		return false;

	}
	private boolean kingMove(Piece p, Tile destination, Board b) {

		if(queenMove(p,destination,b) && (Math.abs(p.getLetterloc()-destination.getXcoord()) == 1 || Math.abs(p.getNumloc()-destination.getYcoord())==1)){
			return true;
		}


		return false;
	}

	private boolean bishopMove(Piece p, Tile destination, Board b) {
		//FIX THE MOVE, IT IS GOING THROUGH OBJECTS IN A DIAGNOL BUT HITTING OBJECTS ADJACENT
		if (destination.getXcoord() > (p.getLetterloc()) && destination.getYcoord() < (p.getNumloc())){
			if((Math.abs((p.getLetterloc()-destination.getXcoord())) == Math.abs(p.getNumloc()-destination.getYcoord()))){
				//NorthEast [i + 1][j - 1]
				//System.out.println("This is NorthEast");
				for(int i = p.getLetterloc() + 1, j = p.getNumloc() - 1; i != destination.getXcoord() && j != destination.getYcoord();i++,j--){
					if(b.board[i][j].isOccupied()){

						//System.out.println(i+","+j + " This is NorthEast");
						
						return false;
					}

				}
			}
			else return false;
			return true;
		}
		else if (destination.getXcoord() < (p.getLetterloc()) && destination.getYcoord() < (p.getNumloc())){
			if((Math.abs((p.getLetterloc()-destination.getXcoord())) == Math.abs(p.getNumloc()-destination.getYcoord()))){
				//NorthWest [x-1][y-1]
				//System.out.println("This is NorthWest");
				for(int i = p.getLetterloc() - 1, j = p.getNumloc() - 1; i != destination.getXcoord() && j != destination.getYcoord();i--,j--){
					if(b.board[i][j].isOccupied()){
						//throw new Exception("There is a "+b.board[i][j].getP()+" in the way");
						return false;

					}

				}
			}
			else return false;
			return true;
		}
		else if (destination.getXcoord() < (p.getLetterloc()) && destination.getYcoord() > (p.getNumloc())){
			if((Math.abs((p.getLetterloc()-destination.getXcoord())) == Math.abs(p.getNumloc()-destination.getYcoord()))){
				//SouthWest [x-1][y+1]
				//System.out.println("This is SouthWest");
				//			System.out.println(b.board[p.getLetterloc() - 1][p.getNumloc() + 1].getP());
				for(int i = p.getLetterloc() - 1, j = p.getNumloc() + 1; i != destination.getXcoord() && j != destination.getYcoord();i--,j++){

					//2 - 1 , 0 + 1 
					//i = 1 , j = 1
					if(b.board[i][j].isOccupied()){
						//System.out.println(i+","+j + " This is SouthWest");
						return false;

					}

				}
			}
			else 
				return false;
			return true;
		}
		else if (destination.getXcoord() > (p.getLetterloc()) && destination.getYcoord() > (p.getNumloc())){
			if((Math.abs((p.getLetterloc()-destination.getXcoord())) == Math.abs(p.getNumloc()-destination.getYcoord()))){
				//SouthEast [x+1][y+1]
				//System.out.println("This is SouthEast");
				for(int i = p.getLetterloc() + 1, j = p.getNumloc() + 1; i != destination.getXcoord() && j != destination.getYcoord();i++,j++){
					System.out.println("Trying BIshop Move x: " + i + " y: "+ j);
					
					System.out.println(b.board[i][j].getP().getFullPiece());
					if(b.board[i][j].isOccupied()){
						System.out.println("something in way of bishop move");
						//System.out.println(i+","+j + " This is SouthEast");
						return false;

					}

				}
			}
			else return false;
			return true;
		}
		//System.out.println(destination.getXcoord() +"," + (p.getLetterloc())+ "X:Y" +destination.getYcoord()+ "," + (p.getNumloc()));
		return false;
	}

	private boolean pawnMove(Piece p, Tile destination, Board b) {


		

		if(p.getTeam().equals("d")){
			if(!(p.getLetterloc()!=destination.getXcoord()) && !b.board[destination.getXcoord()][destination.getYcoord()].isOccupied()){
				if(p.getNumloc() < destination.getYcoord()){
					if(destination.getYcoord() - p.getNumloc() == 1){
						return true;
					}
					else if((destination.getYcoord()- p.getNumloc()  == 2 ) && (p.getNumloc() == 1)){
						return true;
					}
				}
			}
			else if((p.getLetterloc()!=destination.getXcoord()) && b.board[destination.getXcoord()][destination.getYcoord()].isOccupied()){
				//d captures
				if(Math.abs(p.getLetterloc()-destination.getXcoord())== 1 && Math.abs(p.getNumloc() - destination.getYcoord())==1){
					if(p.getNumloc() < destination.getYcoord()){
						return true;
					}

				}
			}

		}
		else if(p.getTeam().equals("l")){
			if(!(p.getLetterloc()!=destination.getXcoord()) && !b.board[destination.getXcoord()][destination.getYcoord()].isOccupied()){
				if(p.getNumloc() > destination.getYcoord()){
					if(p.getNumloc() - destination.getYcoord() == 1){
						return true;
					}
					else if((p.getNumloc() - destination.getYcoord() == 2) && (p.getNumloc() == 6)){
						return true;
					}
				}
			}
			else if((p.getLetterloc()!=destination.getXcoord()) && b.board[destination.getXcoord()][destination.getYcoord()].isOccupied()){
				//l captures
				if(Math.abs(p.getLetterloc()-destination.getXcoord())== 1 && Math.abs(p.getNumloc() - destination.getYcoord())==1){
					if(p.getNumloc() > destination.getYcoord()){
						return true;
					}
				}
			}
		}
		return false;
		// TODO Auto-generated method stub

	}

	private boolean queenMove(Piece p, Tile destination, Board b) {
		if(bishopMove(p,destination, b) || rookMove(p,destination, b)){
			return true;
		}
		return false;

	}

	public boolean knJump(Piece p, Tile destination){

		//		System.out.println("letter loc " + p.getLetterloc() + " number loc "+   p.getNumloc());
		//		System.out.println("destination column " + destination.getXcoord() + " destination row " +destination.getYcoord());
		if (destination.getXcoord() == (p.getLetterloc()+2) && destination.getYcoord() == (p.getNumloc()+1)){
			return true;
		}
		else if (destination.getXcoord() == (p.getLetterloc()+2) && destination.getYcoord() == (p.getNumloc()-1)){
			return true;
		}
		else if (destination.getXcoord() == (p.getLetterloc()-2) && destination.getYcoord() == (p.getNumloc()+1)){
			return true;
		}
		else if (destination.getXcoord() == (p.getLetterloc()-2) && destination.getYcoord() == (p.getNumloc()-1)){
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
					//System.out.println("Moving Horizontally-Right");

					if(b.board[i][destination.getYcoord()].isOccupied()&& !b.board[i][destination.getYcoord()].getP().equals(p)){
						return false;

					}
					//NEXT STEP: MAKE int i = the row or column of the piece . IN THE FOR LOOP

				}
				return true;
			}
			else{
				for(int i = p.getLetterloc(); i != destination.getXcoord();i--){
					//System.out.println("Moving Horizontally-LEFT");

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
					//System.out.println("Moving Vertically-Down");

					if(b.board[destination.getXcoord()][i].isOccupied() &&
							!b.board[destination.getXcoord()][i].getP().equals(p)){

						//System.out.println(b.board[destination.getXcoord()][i]);
						return false;

					}
				}
			}
			else{
				for(int i = p.getNumloc(); i != destination.getYcoord();i--){
					//System.out.println("Moving Vertically-Up");

					if(b.board[destination.getXcoord()][i].isOccupied() &&
							!b.board[destination.getXcoord()][i].getP().equals(p)){

						//System.out.println(b.board[destination.getXcoord()][i]);
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
