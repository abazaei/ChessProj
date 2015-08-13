package pieces;


public class Pawn extends Piece {
	
	public static String Piece = "p";
	private static String  FullPiece = "Pawn ";
	
	public Pawn(String team){
		super(Piece, FullPiece, team);
	}
	

}
