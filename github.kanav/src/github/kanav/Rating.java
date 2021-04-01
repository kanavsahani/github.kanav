package github.kanav;

public class Rating {
	protected String rating;
	private int year;
	private String color;
	
	public Rating(String r, int y, String c) {
		rating = r;
		year = y;
		color = c;
	}
	public String display() {
		return rating + ", " + year + ", " + color + ", ";
	}
	public void setColor(String co) {
		color = co;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getRating() {
		return rating;
	}
	public int getYear() {
		return year;
	}
}
