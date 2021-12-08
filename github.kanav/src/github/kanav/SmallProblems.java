package github.kanav;

public class SmallProblems {
	public static int dX, dY;
	public static void SmallProblem(String[] Directions) {
		for (String s: Directions) {
			if (s == "North" || s == "north") {
				dY++;
			}
			if (s == "South" || s == "south") {
				dY--;
			}
			if (s == "East" || s == "east") {
				dX++;
			}
			if (s == "West" || s == "west") {
				dX--;
			}
		}
		if (dY > 0 && dX > 0) {
			System.out.println(Math.abs(dY) + " miles "+ "north, " + Math.abs(dX) + " miles"+ " east");
		}
		if (dY < 0 && dX > 0) {
			System.out.println(Math.abs(dY) + " miles " + "South, " + Math.abs(dX) + " miles" + " east");
		}
		if (dY > 0 && dX < 0) {
			System.out.println(Math.abs(dY) + " miles " + "north, " + Math.abs(dX) + " miles" + " west");
		}
		if (dY < 0 && dX < 0) {
			System.out.println(Math.abs(dY) + " miles " + "South, " + Math.abs(dX) + " miles" + " west");
		}
		if (dY == 0 && dX > 0) {
			System.out.println(Math.abs(dX) + " miles" + " East");
		}
		if (dY == 0 && dX < 0) {
			System.out.println(Math.abs(dX) + " miles" + " West");
		}
		if (dY < 0 && dX == 0) {
			System.out.println(Math.abs(dY) + " miles" + " South");
		}
		if (dY > 0 && dX == 0) {
			System.out.println(Math.abs(dY) + " miles" + " North");
		}
		if (dY == 0 && dX == 0) {
			System.out.println("No Direction");
		}
	}
	
	public static void main(String[] args) {
		String[] directions = new String[] { "North", "East", "West", "South", "West", "East", "North", "west", "South", "east", "east", "west", "south"};
		SmallProblem(directions);
	}
}
