package pieces;

public abstract class Piece {

	private String piece;
	private String FullPiece;
	private int letterloc;
	private int numloc;
	private String fullletterloc;
	private String team;
	private String fullteam;
	

	
	public Piece(String s, String fp){
		this.piece = s;
		this.FullPiece = fp;
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

	@Override
	public String toString() {
		if (getTeam().equals("l")){
			return getFullletterloc().toLowerCase();
		}
		else
			return getFullletterloc();
			
	
	}
	
	
}
