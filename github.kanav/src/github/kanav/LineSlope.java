package github.kanav;

public class LineSlope {
	
	// you'll probably want some instance variables... (4 coordinates and a slope)

	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private double slope;

	// use the parameters to assign your instance variables
	public void set_coordinates (int X1, int Y1, int X2, int Y2) {
		
		x1 = X1;
		x2 = X2;
		y1 = Y1;
		y2 = Y2;
		
	}

	
	// calculate the slope using your instance variables
	public void calculate_slope () {
		
		slope = ((double)(y2-y1)/(x2-x1));
		
	}

	
	// print the slope you calculated in calculate_slope
	public void display_slope () {
		
		System.out.println((double)slope);
	}
	
	public static void main(String[] args) {
		
		LineSlope runner = new LineSlope();
		
		// this line should have a slope of 2
		runner.set_coordinates(3, 3, 7, 11);
		runner.calculate_slope();
		runner.display_slope();
		
		// this line should have a slope of -.75
		runner.set_coordinates(0, -2, -4, 1);
		runner.calculate_slope();
		runner.display_slope();

	}
}