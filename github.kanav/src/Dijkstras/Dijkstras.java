package Dijkstras;

public class Dijkstras {
	public Dijkstras() {
		Distancegraph graph = new Distancegraph();
		String a = "A", b = "B", c = "C", d = "D", e = "E";
        graph.connect(a, b, 2);
        graph.connect(b, c, 5);
        graph.connect(a, e, 1);
        graph.connect(e, d, 2);
        graph.connect(d, c, 1);
	}
	
	public static void main(String[] args) {
		new Dijkstras();
	}
}
