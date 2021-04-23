package Chat;

public class EnthusiasticBot extends ChatBot {

	@Override
	public void sayHi() {
		System.out.println("Hi *Enthusiastically*");
		
	}

	@Override
	public void sayBye() {
		System.out.println("Bye *Enthusiastically*");
		
	}

	@Override
	public void startConversation() {
		System.out.println("I hope you are doing well. *Enthusiastically*");
		
	}

	@Override
	public void askFirstQuestion() {
		System.out.println("How are you? *Enthusiastically*");
		
	}

	@Override
	public void askSecondQuestion() {
		System.out.println("How are classes? *Enthusiastically");
		
	}

	@Override
	public void askThirdQuestion() {
		System.out.println("What are your grades? *Enthusiastically*");
		
	}
	
}
