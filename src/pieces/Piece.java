package pieces;

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
	
	
	public boolean move(Piece p, Tile t){
		if(p.getPiece().equals("n"))
			knjump();
		else if(p.getPiece().equals("r"))
			rookmove();
		else if(p.getPiece().equals("q"))
			queenmove();
		else if(p.getPiece().equals("p"))
			pawnmove();
		else if(p.getPiece().equals("b"))
			bishopmove();
		else if(p.getPiece().equals("k"))
			kingmove();
		return false;
		
	}
	private boolean kingmove() {
		return false;
		// TODO Auto-generated method stub
		
	}

	private boolean bishopmove() {
		return false;
		// TODO Auto-generated method stub
		
	}

	private boolean pawnmove() {
		return false;
		// TODO Auto-generated method stub
		
	}

	private boolean queenmove() {
		return false;
		// TODO Auto-generated method stub
		
	}

	public boolean knjump(){
		return false;
		
	}
	public boolean rookmove(){
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
