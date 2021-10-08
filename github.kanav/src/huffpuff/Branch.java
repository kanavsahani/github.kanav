package huffpuff;

public class Branch<E> {
	
	public boolean maybeLeaf;
	public E info;
	public Branch branch1, branch2;
	
	public Branch(Branch branch1, Branch branch2) {
		this.branch1 = branch1;
		this.branch2 = branch2;
	}
	public Branch(E information, boolean maybeLeaf) {
		info = information;
		this.maybeLeaf = maybeLeaf;
		maybeLeaf = true;
	}
}
