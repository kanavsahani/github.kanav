package Chat;

public class DepressedBot extends ChatBot {

	@Override
	public void sayHi() {
		System.out.println("Hey *Depressed*");
		
	}

	@Override
	public void sayBye() {
		System.out.println("Bye *Depressed*");
		
	}

	@Override
	public void startConversation() {
		System.out.println("I hope you are doing well. *Depressed");
		
	}

	@Override
	public void askFirstQuestion() {
		System.out.println("How are you? *Depressed*");
		
	}

	@Override
	public void askSecondQuestion() {
		System.out.println("How are classes? *Depressed*");
		
	}

	@Override
	public void askThirdQuestion() {
		System.out.println("What are your grades? *Depressed*");
		
	}
	
}
