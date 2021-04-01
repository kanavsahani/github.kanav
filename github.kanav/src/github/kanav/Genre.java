package github.kanav;

public class Genre extends Rating{
	private String genre, originalGenre;
	
	public Genre(String genre, String r, int y, String c) {
		super(r, y, c);
		this.genre = genre;
		originalGenre = r;
	}
	public void changeRating(int age) {
		if (age > 12) {
			setRating("mature");
		}
		else {
			setRating(originalGenre);
		}
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGenre() {
		return genre;
	}
	public double worth() {
		return 60.0-(getYear()/1000.0);
	}
}
