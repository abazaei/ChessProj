package board;

import pieces.Piece;

public class Tile {

	private Piece p;

	
	public Piece getP() {
		return p;
	}

	public void setP(Piece p) {
		this.p = p;
	}

	public boolean isOccupied(){
		if(this.p == null){
			return false;
		}
		else
			return true;
	}

	@Override
	public String toString(){
		
		if(p != null)
			return p.toString();
		else 
			return "-";
		
	}

}
