package github.kanav;

public class SumIt {
	
  // instance variables
  private double one1;
  private double two2;
  private double sum;
 
  
  // use the two parameters to set the values of your two instance variables
  public void setNums(double num1, double num2) {
	  one1 = num1;
	  two2 = num2;
	  
  }
  

  
  public void sum() {
	  
	  sum = (one1+two2);
	  
  }
  
  // print the sum here
  public void print() {
	  
	  System.out.println(sum);
	  
  }
  
  
  public static void main(String[] args) {
	  SumIt runner = new SumIt();
	  
	  // should print out 12
	  runner.setNums(5,  7);
	  runner.sum();
	  runner.print();
	  
	  // should print out 40
	  runner.setNums(13, 27);
	  runner.sum();
	  runner.print();
  }
  
}