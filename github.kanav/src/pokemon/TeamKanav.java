package pokemon;

import java.util.ArrayList;

public class TeamKanav extends PokeTeam{
	public TeamKanav() {
		super("TeamKanav");
	}
	public ArrayList<Pokemon> createTeam() {
		ArrayList<Pokemon> Team = new ArrayList<Pokemon>();
		
			Team.add(new Venusaur());
			Team.add(new Squirtle());
			Team.add(new Reshiram());
		return Team;
	}
}
