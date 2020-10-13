package github.kanav;
// Kanav Sahani's Adventure Project
// I got help from No One

import java.util.Scanner;

public class Adventure_Better {
	
	// we need our scanner in multiple methods, so make it an instance variable
	private Scanner input = new Scanner(System.in);
	
	// introduces the game and gets the user's name
	public void introduction() {
		
		System.out.println("Welcome to my kingdom. What's your name?");
		//type name
		String answer = input.next();
		
		System.out.println("Of course, you're " + answer + " the infamous bounty hunter. \n"
				+ "You must be here in search of the king.");
		//next comes the first decision
		first_decision();
	}
	
	// asks the first question and gets an answer
	public void first_decision() {
		System.out.println("You are in the kingdom and the door shuts behind you. \nIn front of you"
				+ " is a group of soldiers. What do you do?");
		//3 choices
		System.out.println("a. Demand to meet the king \nb. Fight the soldiers and kill the king on the throne.");
		
		String answer = input.next();
		
		// if input is 'a', move on to the meeting step
		if (answer.equals("a")) 
			Demand_Meeting();
			
		// if input is 'b', move on to the attacking step
		else if (answer.equals("b"))
			attacking_decision();
		
		// if they're dumb, give an error
		else 
			input_error();
	}
	
	// the attacker step
	public void Demand_Meeting() {
		System.out.println("You demand to see the king. The person on the throne says 'you are looking at him.'"
				+ "\nWhat do you do?" );
		System.out.println("a. Demand a 1 v 1 fight with no weapons. \nb. Leap forth and kill him"
				+ "\nc. Ask to leave and come another day.");
		//3 decisions, one works
		String answer = input.next();
		
		// input 'a' leads to the fight
		if (answer.equals("a")) 
			onevone_fight();
		
		// input 'b' leads to death
		else if (answer.equals("b")) 
	
			for_the_kill();
		
		// input 'c' leads to the chickening out
		else if (answer.equals("c")) 
			chicken_out();
		
		// dumb error
		else
			input_error();
	}
	
	// the warrior step
	public void chicken_out() {

		System.out.println("The guards escort you and you have a great day. Awesome!"
				+ "\nYou lose but at least you live.");
		//loss but you live
		
	}
	
	public void onevone_fight() {
		System.out.println("He leads you down a path. After a bit, you take a turn onto a new path. "
				+ "\nAt the end of the path is a large Colosseum for fighting. "
				+ "\nYou are at the entrance. What do you do?");
		System.out.println("a. Attempt to assassinate the warriors. \nb. Walk in with them. "
				+ "\nc. Ask to fight with weapons.");
		//b  is the right choice
		
		String answer = input.next();
		
		// input 'a' leads to the running away step
		if (answer.equals("a")) 
			Assassination();
		
		// input 'b' leads to success
		else if (answer.equals("b")) 
			success();
		
		// input 'c' leads to death
		else if (answer.equals("c")) 
			guns_out();
				
		// dumb error
		else 
			input_error();
	}
	
	// possible end of game step
	public void Assassination() {
		System.out.println("You try to asssassinate the guards. You kill 3 of them, but the 4th one sticks a knife in you. RIP.");

	}
	
	// possible end of game step
	public void success() {
		System.out.println("You fight the King without weapons"
			+ "\n You throw an uppercut to him but he dodges. Then he throws a jab at you with his left hand. "
			+ "\n He hit you. But you retaliate with a cross-hook combo. You knock him out"
			+ "\n You proceed to kill him. You steal his throne and all his riches. YOU WIN!");
	}
	
	// possible end of game step
	public void guns_out() {
		System.out.println("You ask to fight with weapons. The guards agree."
				+ "\nYou pick out a shotgun."
				+ "\nYou walk in with the shotgun but he has a sniper. BOOM! \nYou fall to the ground. RIP.");
	}
	

	
	
	
	// Attempt to kill gone wrong
	public void for_the_kill() {
		System.out.println("Well, you tried to kill him, but the guards stop you."
			+ "They hang you and throw your body into the ocean. RIP.");
	}
	
	// Attempt to assassinate gone wrong
	public void attacking_decision() {
		System.out.println("Maybe not the smartest choice. They pin you down and decapitate you. RIP");	
	}
	
	// idiot control
	public void input_error() {
		System.out.println("Not a valid input");
	}

	// main method to get the game started.
	public static void main(String[] args) {
				
		// only need to call introduction() because this leads to the other 
		// methods.
		Adventure_Better my_adventure = new Adventure_Better();
		my_adventure.introduction();
	}
}
