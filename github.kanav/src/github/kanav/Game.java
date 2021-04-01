package github.kanav;

public class Game extends Genre {
	private String GameName;
	
	public Game (String GameName, String genre, String r, int y, String c){
		super(genre, r, y, c);
		this.GameName = GameName;
	}
	public void GenreChange() {
		if (GameName.contains("gun")) {
			setGenre("FPS");	
		}
	}
	public String display () {
		return super.display() + GameName + ", " + getGenre();
	}
	public static void main(String[] args) {
		Game COD = new Game("CallOfDutygun", "TPS", "Teen", 2015, "black");
		COD.GenreChange();
		System.out.println(COD.getGenre());
		COD.changeRating(13);
		System.out.println(COD.getRating());
		COD.changeRating(12);
		System.out.println(COD.getRating());
		System.out.println(COD.worth());
		System.out.println(COD.display());
	}
}
