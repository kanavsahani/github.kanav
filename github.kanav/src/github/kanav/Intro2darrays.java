package github.kanav;
// solutions: 1a:6 1b:1 1c: out of bounds 1d: 3 1e: 'k' 1f: out of bounds 1g: 105 1h: k 1i: {7,6}

public class Intro2darrays {
	public static void display (int [] [] n) {
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n[i].length; j++) {
				System.out.print(n[i] [j]);
			}
			System.out.println();
		}
	}
	public static void strings(String stringss[] []) {
		System.out.println(stringss.length);
	}
	public static void sixintegers(int pyramid [] []) {
		
		for (int i = 0; i < pyramid.length; i++) {
            for (int j = 0; j < pyramid[i].length; j++)
                System.out.print(pyramid[i][j] + " ");
            System.out.println();
        }
	}
	public static void main(String[] args) {
		int[] [] n = new int[5] [5];
		String[] [] stringss = { {"I love chicken"}, 
								{"I'm a big fan of it"},
								{"no like really"} };
		int[] [] pyramid = { {1}, {2, 3}, {4, 5, 6} };
		
		display(n);
		strings(stringss);
		sixintegers(pyramid);
	}

}
