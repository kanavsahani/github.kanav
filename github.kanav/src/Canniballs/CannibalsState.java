package Canniballs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CannibalsState {

    private int maxDepth = 1000;
    int numMissionariesLeft, numCannibalsLeft, numMissionariesRight,
            numCannibalsRight;
    boolean boatOnLeft;

    public CannibalsState(int nmL, int ncL, int nmR, int ncR, boolean left) {
        numMissionariesLeft = nmL;
        numCannibalsLeft = ncL;
        numMissionariesRight = nmR;
        numCannibalsRight = ncR;
        this.boatOnLeft = left;
    }

    public boolean isLegal() {
        if (!(this.numCannibalsLeft >= 0 && this.numMissionariesLeft >= 0 &&
                this.numCannibalsRight >= 0 && this.numMissionariesRight >= 0)) return false;
        if (this.numCannibalsLeft > this.numMissionariesLeft &&
                this.numMissionariesLeft > 0) return false;
        if (this.numCannibalsRight > this.numMissionariesRight &&
                this.numMissionariesRight > 0) return false;
        return true;
    }

    public boolean isSolved() {
        return numMissionariesLeft == 0 && numCannibalsLeft == 0;
    }

    public boolean equals(Object o) {
        CannibalsState other = (CannibalsState) o;
        return other.numCannibalsLeft == this.numCannibalsLeft &&
                other.numCannibalsRight == this.numCannibalsRight &&
                other.numMissionariesLeft == this.numMissionariesLeft &&
                other.numMissionariesRight == this.numMissionariesRight &&
                other.boatOnLeft == this.boatOnLeft;
        
    }

    public int hashCode() {
        return 10 * this.numMissionariesLeft + 1000 * this.numCannibalsLeft +
                100000 * this.numMissionariesRight + 10000000 * this.numCannibalsRight + (boatOnLeft ?
                1 : 0);
    }

    public String toString() {
        return numMissionariesLeft + "/" + numCannibalsLeft + " || " +
                numMissionariesRight + "/" + numCannibalsRight + "\n";
    }

    public HashSet<CannibalsState> nextStates() {
        HashSet<CannibalsState> nexts = new HashSet<CannibalsState>();
        for (int nm = 0; nm <= Math.min(2, boatOnLeft ?
                this.numMissionariesLeft : this.numMissionariesRight); nm++) {
            for (int nc = (nm == 0 ? 1 : 0); nc <= Math.min(2 - nm,
                    boatOnLeft ? this.numCannibalsLeft : this.numCannibalsRight); nc++) {

                CannibalsState next;
                if (boatOnLeft)
                    next = new CannibalsState(this.numMissionariesLeft -
                            nm, this.numCannibalsLeft - nc, this.numMissionariesRight + nm,
                            this.numCannibalsRight + nc, false);
                else
                    next = new
                            CannibalsState(this.numMissionariesLeft + nm, this.numCannibalsLeft + nc,
                            this.numMissionariesRight - nm, this.numCannibalsRight - nc, true);
                if (next.isLegal())
                    nexts.add(next);
            }
        }
        return nexts;
    }

    public List<CannibalsState> solve(int depth, Set<CannibalsState> previous, List<CannibalsState> solution) {
        if (this.isSolved()) {
            System.out.println("Solution found!");
            solution.add(this);
            return solution;
        }
        if (depth > maxDepth) {
            System.out.println("Max depth reached!");
            return null;
        }
        System.out.println("Depth: " + depth);
        HashSet<CannibalsState> nexts = this.nextStates();
        for (CannibalsState next : nexts) {
           
            if(previous.contains(next))  continue;
            System.out.println("Next state: " + next);
            previous.add(next);

            List<CannibalsState> x = next.solve(depth + 1, previous, solution);
            if (x != null) {
                solution.add(next);
                return solution;
            }
        }

        return null;
    }


    public static void main(String[] args){
        System.out.println("hi");
        CannibalsState start = new CannibalsState(3,3,0,0,true);
        Set<CannibalsState> prev = new HashSet<>();
        prev.add(start);
        System.out.println(start);
        List<CannibalsState> solution = start.solve(0, prev, new ArrayList<>());
        Collections.reverse(solution);
        System.out.println(solution);
    }
}
