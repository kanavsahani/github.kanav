package Chat;

public class SarcasticBot extends ChatBot {

	@Override
	public void sayHi() {
		System.out.println("Hi *sarcastically*");
		
	}

	@Override
	public void sayBye() {
		System.out.println("Bye *sarcastically*");
		
	}

	@Override
	public void startConversation() {
		System.out.println("I hope you are doing well *sarcastically*");
		
	}

	@Override
	public void askFirstQuestion() {
		System.out.println("How are you? *sarcastically*");
		
	}

	@Override
	public void askSecondQuestion() {
		System.out.println("How are classes? *sarcastically*");
		
	}

	@Override
	public void askThirdQuestion() {
		System.out.println("What are your grades? *sarcastically*");
		
	}
	
}
