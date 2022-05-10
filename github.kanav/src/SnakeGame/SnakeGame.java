package SnakeGame;

	import java.awt.EventQueue;
	import javax.swing.JFrame;

	public class SnakeGame extends JFrame {

	    public SnakeGame() {
	        
	        initUI();
	    }
	    
	    private void initUI() {
	        
	        add(new Snake());
	        
	        setResizable(false);
	        pack();
	        
	        setTitle("Snake");
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	}
