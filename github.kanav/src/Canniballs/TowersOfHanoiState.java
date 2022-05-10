package Canniballs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TowersOfHanoiState
{
	private int step = 1;
	private List<LinkedList<Integer>> pegs= new ArrayList<>(3);
    private int totalDisks;
    public TowersOfHanoiState(int disks)
    {
    	for (int i = 0; i < 3; i++) {
    	    pegs.add(new LinkedList<>());
    	}
    	LinkedList<Integer> peg0 = pegs.get(0);
    	peg0.add(3);
    	peg0.add(2);
    	peg0.add(1);
        totalDisks = disks;
    }
    public void solve()
    {
       
        System.out.println("Initially :");
        printState();
        moveTower(totalDisks, 0, 2, 1);
    }

    private void moveTower(int numDisks, int start, int end, int temp)
    {
        if (numDisks == 1)
        {
            moveOneDisk(start, end);
        }
        else
        {
            moveTower(numDisks-1, start, temp, end);
            moveOneDisk(start, end);
            moveTower(numDisks-1, temp, end, start);
        }
    }
    private void printState() {
        int i = 0;
        for (LinkedList<Integer> peg : pegs) {
            System.out.print("peg" + i++ + ": ");
            for (int j = 0; j < 3; j++) {
                try { 
                    System.out.print(peg.get(j) + " ");
                }
                catch (Exception e) {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
    private void moveOneDisk(int start, int end)
    {
    	System.out.println("Step " + step++ + ": Move one disk from " + start + " to " + end);
    	pegs.get(end).add(pegs.get(start).removeLast());
    	printState();
    }
        // Creates a TowersOfHanoi puzzle and solves it.
        public static void main(String[] args)
        {
            TowersOfHanoiState towers = new TowersOfHanoiState(3);
            towers.solve();
        }
}