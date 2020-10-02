package github.kanav;
	
public class SA4 {
	
	private double distances;
	private double QuadAnswers;
	private double averages;
	private double QuadAnswersNegative;
	
	public void distance(double X1, double Y1, double X2, double Y2) {
		
		distances = Math.sqrt((Y2 - Y1) * (Y2 - Y1) + (X2 - X1) * (X2 - X1)) ;
		System.out.println(distances);
	}
	public void arithmatic() {
		
	}
	public void quadratic(int A, int B, int C) {
		QuadAnswers = (((-B + (Math.sqrt((double)B * B - 4 * A * C))))/(2 * A));
		System.out.println(QuadAnswers);
		QuadAnswersNegative = (((-B - (Math.sqrt((double)B * B - 4 * A * C))))/(2 * A));
		System.out.println(QuadAnswersNegative);
	}

	public void charAverage(char M, char D) {
		averages = ((double)(M + D)/2);
		System.out.println(averages);
	}
	
	public static void main(String[] args) {
		
		SA4 tester = new SA4();
		
		// prints out the distance between two points
		// output should be 6.83
		tester.distance(1, -2.5, 3.1, 4);
		
		// prints out a solution to y = ax^2 + bx + c, where the 
		// three parameters are a, b, and c. Use the quadratic equation
		// output should be 2 or -2 (challenge: give both solutions)
		tester.quadratic(1, 0, -4);
		
		// prints out the 'average' of two characters
		// output should be 'W'
		tester.charAverage('m', 'A');
	}
	
		
	}


