package PsychologyProject; // package declaration
// Psychology Project By: Kanav Sahani
import java.awt.Color;// all the imports or used in this program
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class GuideUI { // My psychology project
 int WIDTH = 1000, HEIGHT = 500; //variables for window size
 String name; // variable that takes in user input as the name and is used for the boarder
 int i = 1; //used to determine what question the test is on
 String[] Q1 ={"\n\n\n                 Welcome to the Psychology Test! Type your name in the text box below","\n\n\n                 Would you open an envelope that has the date of your death inside?",
			"\n\n\n                 Would you be friends with yourself?","\n\n\n                 If you commit a crime to feed your hungry child, \n                 are you a bad person or did you commit the crime out of necessity?"
			,"\n\n\n                 If you could see a measuring scale above people’s heads, \n                 what would you want this scale to measure?", "\n\n\n                 What are your Biggest Strengths and Weaknesses?", "\n\n\n                 " + name+ " is"};
 // this Q1 array is an array of all the questions that are asked
 JTextArea inputAreaOne = new JTextArea(); // this is the input area for the user
 String path = "Images/noisestorm-crab-rave-monstercat-release_0pj1ld4l.wav"; //sound file for the song that plays (Crab rave)
 
 JPanel panel = new JPanel(); // panel that holds everything
 JPanel paintPanel = new JPanel() { // paint panel that draws the crab dancing gifs
	 public void paint(Graphics g) { // paint method
		g.setColor(Color.gray); // sets the color of background
		g.fillRect(0, 0, getWidth(), getHeight()); //draws a background rectangle
		Image icon; // variable for the image
		try { // try catch method for catching errors
			icon = new ImageIcon(new File("Images/output-onlinegiftools (1).gif").toURI().toURL()).getImage(); //define the icon with the gif by taking the file, converting to uri then url and then getting the image
			g.drawImage(icon, 0, 0, GuideUI.this.WIDTH-900, GuideUI.this.HEIGHT-400, this); // draw the 1st gif
			g.drawImage(icon, GuideUI.this.WIDTH-125, 0, GuideUI.this.WIDTH-900, GuideUI.this.HEIGHT-400, this); // draw the second gif 			
		} catch (MalformedURLException e) {
			e.printStackTrace(); // the catch for any errors
		} // closing bracket
	 } // closing bracket
 }; // closing bracket
 JPanel buttonPanel = new JPanel(), buttonPanel1 = new JPanel(), buttonPanel2 = new JPanel(), buttonPanel3 = new JPanel(), buttonPanel4 = new JPanel(); // panels that hold all the buttons that get pressed by the user
 JTextArea displayarea = new JTextArea(); // display text area for the questions
 JButton[] A1 = {new JButton("Hell yea"),new JButton("Hell no")}; JButton[] A2 = {new JButton("Definitely"),new JButton("Nah I'm a Weirdo")}; JButton[] A3 = {new JButton("I'm a Bad Person"),new JButton("You Gotta Do What You Gotta Do")};JButton[] A4 = {new JButton("How Much Emotional Stress They Will Cause Me"),new JButton("How Much Joy They Will Bring Me")}; JButton[] A5 = {new JButton("Stength: Communication Weakness: Confidence"), new JButton("Stengths: Confidence Weaknesses: Communication")}; // array of buttons with all the answers to the questions
 JFrame frame = new JFrame(); // this frame holds the panels which hold everything
 JButton EnterButton = new JButton("Next Question"); // button for moving to the next question after typing in name
 int mentallyInsane = -1, manageable = 0, somewhatStable = 1; // variables used later on for determining where the user ranks on the scale
 int scoreTracker = 0; //scoretracker. Adds or subtracts depending on the answers and is compared at the end to the variables right above this to determine where the user falls
 
 public GuideUI() { // constructor that holds almost everything
		frame.setSize(WIDTH, HEIGHT); //setting frame size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make it closeable
		BoxLayout buttonlayout = new BoxLayout(buttonPanel, BoxLayout.X_AXIS); // set up layout for buttons of 1st question
		BoxLayout buttonlayout1 = new BoxLayout(buttonPanel1, BoxLayout.X_AXIS); // set up layout for buttons of 2nd question
		BoxLayout buttonlayout2 = new BoxLayout(buttonPanel2, BoxLayout.X_AXIS); // set up layout for buttons of 3rd question
		BoxLayout buttonlayout3 = new BoxLayout(buttonPanel3, BoxLayout.X_AXIS); // set up layout for buttons of 4th question
		BoxLayout buttonlayout4 = new BoxLayout(buttonPanel4, BoxLayout.X_AXIS); // set up layout for buttons of 5th question
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS); // layout for the whole panel (in the y direction)
		buttonPanel.setLayout(buttonlayout); // sets layout for first button panel
		buttonPanel1.setLayout(buttonlayout1); //  sets layout for 2nd button panel
		buttonPanel2.setLayout(buttonlayout2); // sets layout for 3rd button panel
		buttonPanel3.setLayout(buttonlayout3); // sets layout for 4th button panel
		buttonPanel4.setLayout(buttonlayout4); // sets layout for 5th button panel
		panel.setLayout(boxlayout); // sets layout for full frame
		panel.setBorder(BorderFactory.createTitledBorder("Psychology Test")); //creates a boarder
		displayarea.setFont(new Font("Comic Sans", Font.BOLD, 23)); // sets fonts
		displayarea.setForeground(Color.blue); //sets text display to blue
		displayarea.setBackground(Color.gray); // sets background to gray
		displayarea.setText(Q1[0]); // sets the text with the 1st item from array
		displayarea.setEditable(false); // does not allow user to edit this panel
		inputAreaOne.getInputMap().put(KeyStroke.getKeyStroke('\n'), "ENTER"); // allow user to press enter for next question
		inputAreaOne.getActionMap().put("ENTER", new EnterAction()); // allows user to click the key enter or next question
        inputAreaOne.setEditable(true); // allow user to enter
        try { // try catch to catch any errors
        	AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path)); // use the audio file instance variable "path"
        	Clip clip = AudioSystem.getClip(); // use clip to get the audio
        	clip.open(inputStream); // open the audio file
        	clip.loop(Clip.LOOP_CONTINUOUSLY); // just keep looping it
        	clip.start(); // start playing
        }catch(Exception ex) { // catch to catch any errors
        	ex.printStackTrace(); // type of error
        } // closing bracket
        EnterButton.addActionListener(new ActionListener() { // action listener for enter button so that it can detect when it is clicked
			public void actionPerformed(ActionEvent e) { // when button clicked do this
				Action(); // do this method. method explained deeper into code. It basically goes to next question
			} // closing bracket
        }); // closing bracket
        A1[0].addActionListener(new ActionListener(){ // action listener for first answer to first question
        	public void actionPerformed(ActionEvent e) { // method for holding what should be done once this button is clicked
        		scoreTracker++; // add one to the score
        		buttonPanel.setVisible(false); // remove this button panel
        		i++; // add one to the question tracker variable
        		displayarea.setText(Q1[i]); // set the text to the next question
        		try { // try catch method for running the action1 method (defined later in the code)
					Action1(); // run the action1 method
				} catch (IOException e1) { // catch any errors
					e1.printStackTrace(); // specifically IOException errors 
				} // closing bracket
        	} // closing bracket
        }); // closing bracket
        A1[1].addActionListener(new ActionListener(){ // action listener for second answer to first question
        	public void actionPerformed(ActionEvent e) { // method for holding what should be done once this button is clicked
        		scoreTracker--; // subtract one from the score
        		buttonPanel.setVisible(false); // remove this button panel
        		i++;  // add one to the question tracker variable
        		displayarea.setText(Q1[i]); // set the text to the next question
        		try { // try catch method for running the action1 method (defined later in the code)
					Action1(); // run the action1 method
				} catch (IOException e1) { // catch any errors
					e1.printStackTrace(); // specifically IOException errors 
				} // closing bracket
        	} // closing bracket
        }); // closing bracket
        A2[0].addActionListener(new ActionListener() { // action listener for first answer to second question
			public void actionPerformed(ActionEvent e) { // method for holding what should be done once this button is clicked
				scoreTracker+=2; // add two to the score
				buttonPanel1.setVisible(false); // remove this button panel
				i++;  // add one to the question tracker variable
				displayarea.setText(Q1[i]); // set the text to the next question
				try { // try catch method for running the action1 method (defined later in the code)
					Action1(); // run the action1 method
				} catch (IOException e1) { // catch any errors
					e1.printStackTrace(); // specifically IOException errors 
				} // closing bracket
			} // closing bracket
        }); // closing bracket
        A2[1].addActionListener(new ActionListener() { // action listener for second answer to second question
			public void actionPerformed(ActionEvent e) { // method for holding what should be done once this button is clicked
				scoreTracker-=2; // subtract two from the score
				buttonPanel1.setVisible(false); // remove this button panel
				i++;  // add one to the question tracker variable
				displayarea.setText(Q1[i]); // set the text to the next question
				try { // try catch method for running the action1 method (defined later in the code)
					Action1(); // run the action1 method
				} catch (IOException e1) { // catch any errors
					e1.printStackTrace(); // specifically IOException errors 
				} // closing bracket
			} // closing bracket
        }); // closing bracket
        A3[0].addActionListener(new ActionListener() { // action listener for first answer to third question
			public void actionPerformed(ActionEvent e) { // method for holding what should be done once this button is clicked
				scoreTracker--; // subtract one from the score
				buttonPanel2.setVisible(false); // remove this button panel
				i++;  // add one to the question tracker variable
				displayarea.setText(Q1[i]); // set the text to the next question
				try { // try catch method for running the action1 method (defined later in the code)
					Action1(); // run the action1 method
				} catch (IOException e1) { // catch any errors
					e1.printStackTrace(); // specifically IOException errors 
				} // closing bracket
			} // closing bracket
        }); // closing bracket
        A3[1].addActionListener(new ActionListener() { // action listener for second answer to third question
			public void actionPerformed(ActionEvent e) { // method for holding what should be done once this button is clicked
				scoreTracker++; // add one from the score
				buttonPanel2.setVisible(false); // remove this button panel
				i++; // add one to the question tracker variable
				displayarea.setText(Q1[i]); // set the text to the next question
				try { // try catch method for running the action1 method (defined later in the code)
					Action1(); // run the action1 method
				} catch (IOException e1) { // catch any errors
					e1.printStackTrace(); // specifically IOException errors 
				} // closing bracket
			} // closing bracket
        }); // closing bracket
        A4[0].addActionListener(new ActionListener() { // action listener for first answer to fourth question
			public void actionPerformed(ActionEvent e) { // method for holding what should be done once this button is clicked
				scoreTracker-=3; // subtract three from the score
				buttonPanel3.setVisible(false); // remove this button panel
				i++;  // add one to the question tracker variable
				displayarea.setText(Q1[i]); // set the text to the next question
				try { // try catch method for running the action1 method (defined later in the code)
					Action1(); // run the action1 method
				} catch (IOException e1) { // catch any errors
					e1.printStackTrace(); // specifically IOException errors 
				} // closing bracket
			} // closing bracket
        }); // closing bracket
        A4[1].addActionListener(new ActionListener() {// action listener for second answer to fourth question
			public void actionPerformed(ActionEvent e) { // method for holding what should be done once this button is clicked
				scoreTracker+=3; // add three to the score
				buttonPanel3.setVisible(false); // remove this button panel
				i++; // add one to the question tracker variable
				displayarea.setText(Q1[i]); // set the text to the next question
				try { // try catch method for running the action1 method (defined later in the code)
					Action1(); // run the action1 method
				} catch (IOException e1) { // catch any errors
					e1.printStackTrace(); // specifically IOException errors 
				} // closing bracket
			} // closing bracket
        }); // closing bracket
        A5[0].addActionListener(new ActionListener() {// action listener for first answer to fifth question
			public void actionPerformed(ActionEvent e) { // method for holding what should be done once this button is clicked
				scoreTracker+=2; // add two to the score
				buttonPanel3.setVisible(false); // remove this button panel
				i++; // add one to the question tracker variable
				displayarea.setText(Q1[i]); // set the text to the next question
				try { // try catch method for running the action1 method (defined later in the code)
					Action1(); // run the action1 method
				} catch (IOException e1) { // catch any errors
					e1.printStackTrace(); // specifically IOException errors 
				} // closing bracket
			} // closing bracket
			}); // closing bracket
        A5[1].addActionListener(new ActionListener() { // action listener for second answer to fifth question
        	public void actionPerformed(ActionEvent e) { // method for holding what should be done once this button is clicked
				scoreTracker-=2; // subtract two from the score
				buttonPanel3.setVisible(false); // remove this button panel
				i++;  // add one to the question tracker variable
				displayarea.setText(Q1[i]); // set the text to the next question
				try { // try catch method for running the action1 method (defined later in the code)
					Action1(); // run the action1 method
				} catch (IOException e1) { // catch any errors
					e1.printStackTrace(); // specifically IOException errors 
				} // closing bracket
			} // closing bracket
			}); // closing bracket
        buttonPanel.setPreferredSize(new Dimension(1000,180)); // set 1st button panel size
        buttonPanel.add(A1[0]); // add answer button #1 for 1st question
        buttonPanel.add(A1[1]); // add answer button #2 for 1st question
        buttonPanel1.setPreferredSize(new Dimension(1000,180)); // set 2nd button panel size
        buttonPanel1.add(A2[0]); // add answer button #1 for 2nd question
        buttonPanel1.add(A2[1]); // add answer button #2 for 2nd question
        buttonPanel2.setPreferredSize(new Dimension(1000,180)); // set 3rd button panel size
        buttonPanel2.add(A3[0]); // add answer button #1 for 3rd question
        buttonPanel2.add(A3[1]); // add answer button #2 for 3rd question
        buttonPanel3.setPreferredSize(new Dimension(1000,180)); // set 4th button panel size
        buttonPanel3.add(A4[0]); // add answer button #1 for 4th question
        buttonPanel3.add(A4[1]); // add answer button #2 for 4th question
        buttonPanel4.setPreferredSize(new Dimension(1000,180)); // set 5th button panel size
        buttonPanel4.add(A5[0]); // add answer button #1 for 5th question
        buttonPanel4.add(A5[1]); // add answer button #2 for 5th question
        paintPanel.setPreferredSize(new Dimension(WIDTH,100)); // set paintpanel (panel with the gifs) size
        panel.add(paintPanel); // add gif panel to the main panel
        panel.add(displayarea); // add the display area for the questions into main panel
        panel.add(inputAreaOne); // add the user input area to the main panel
        panel.add(EnterButton); // add the enter button for the "what is your name" question to the main panel
        frame.add(panel); // add the main panel to the main frame
        frame.setLocationRelativeTo(null); // set the location to the center
		frame.setResizable(false); // do not allow the user to resize the window
		frame.setVisible(true); // make the window visible to the user
	} // closing bracket
	private class EnterAction extends AbstractAction{ // action for when the enter button is clicked (the first question)
		public void actionPerformed(ActionEvent e) { // action performed method
			Action(); // run the action method (shown below)
		} // closing bracket
	} // closing bracket
	public void Action () { // action method used when the enter button is clicked after the first question
		name = inputAreaOne.getText(); // get the user input for the name in first question
		Q1[Q1.length-1] = "\n\n\n                 " + name.trim()+" is"; // used for the final screen when displaying the user's result
		inputAreaOne.setText(null); // empty the text box to get ready for next few questions
		panel.setBorder(BorderFactory.createTitledBorder(name + "'s Psychology Test")); // use the user's inputted name to set the border
		displayarea.setText(Q1[i]); //set the text to the next question
		if (i == 1) { // if the question tracker variable 'i' is at 1,
			inputAreaOne.setVisible(false); // remove the input area as it is not needed
			EnterButton.setVisible(false); // remove the enterbutton as it is not needed
			panel.add(buttonPanel); // add the buttonpanel for the next question
		} // closing bracket
	} // closing bracket
	public void Action1() throws IOException { // Action1 method used after every question
		if (i == 2) { // if the question tracker variable 'i' is at 2,
			buttonPanel.setVisible(false); // remove the buttonpanel for first question
			panel.add(buttonPanel1); // add the button panel for the next question
		} // closing bracket
		if (i == 3) { // if the question tracker variable 'i' is at 3,
			buttonPanel1.setVisible(false); // remove the buttonpanel for second question
			panel.add(buttonPanel2); // add the button panel for the next question
		} // closing bracket
		if (i == 4) { // if the question tracker variable 'i' is at 4,
			buttonPanel2.setVisible(false); // remove the buttonpanel for third question
			panel.add(buttonPanel3); // add the button panel for the next question
		} // closing bracket
		if (i == 5) { // if the question tracker variable 'i' is at 5,
			buttonPanel3.setVisible(false); // remove the buttonpanel for fourth question
			panel.add(buttonPanel4); // add the button panel for the next question
		} // closing bracket
		if (i == 6) { // if the question tracker variable 'i' is at 6,
			String result = "unknown"; // create a variable which will hold the user's result
			buttonPanel4.setVisible(false); // remove the button panel for the fifth question
			if (scoreTracker < mentallyInsane) { // if the scoreTracker variable is under the number set for mentally insane,
				displayarea.setPreferredSize(new Dimension(WIDTH,HEIGHT-380)); // resize display area
				Image myPicture = ImageIO.read(new File("Images/Mentally_Insane-removebg-preview.png")); // variable for the picture that shows the user's result
				JPanel finalScore = new JPanel() { // create a panel that draws the user's final score
					public void paint(Graphics g) { // paint the final score with an image
						g.setColor(Color.gray); // set background color to gray to make it consistent with the rest of the frame
						g.fillRect(0, 0, GuideUI.this.WIDTH-25, GuideUI.this.HEIGHT-200); // draw a rectangle
						g.drawImage(myPicture, 0, 0, GuideUI.this.WIDTH-25, GuideUI.this.HEIGHT-250, null);	// display the user's result					
					} // closing bracket
				}; // closing bracket
				finalScore.setPreferredSize(new Dimension(WIDTH-25, HEIGHT-200)); // set the size for this panel
				panel.add(finalScore); // add this panel to the main panel
				result = "Mentally Insane"; // change the variable to hold the user's result
			} // closing bracket
			else if (scoreTracker > manageable && scoreTracker < manageable+2) { // if the scoreTracker variable is above manageable and below manageable+2 (integer variable+2)
				BufferedImage myPicture = ImageIO.read(new File("Images/Manageable_But_Needs_Work-removebg-preview.png")); // create a variable for the image of the graph that shows user's result
				displayarea.setPreferredSize(new Dimension(WIDTH,HEIGHT-380)); // resize displayarea
				JPanel finalScore = new JPanel() { // create a panel that draw's the user's final score
					public void paint(Graphics g) { // paint the final score with an image
						g.setColor(Color.gray); // set background color to gray to make it consistent with the rest of the frame
						g.fillRect(0, 0, GuideUI.this.WIDTH-25, GuideUI.this.HEIGHT-200); // draw a rectangle
						g.drawImage(myPicture, 0, 0, GuideUI.this.WIDTH-25, GuideUI.this.HEIGHT-250, null); // display the user's result
					} // closing bracket
				}; // closing bracket
				finalScore.setPreferredSize(new Dimension(WIDTH-25, HEIGHT-200)); // set the size for this panel
				panel.add(finalScore); // add this panel to the main panel
				result = "Manageable, but needs work"; // change the variable to hold the user's result
			} // closing bracket
			else if (scoreTracker > somewhatStable && scoreTracker < somewhatStable+3) { // if the scoreTracker variable is above somewhatStable and below somewhatStable (integer variable+3)
				BufferedImage myPicture = ImageIO.read(new File("Images/Stable_But_Not_Fully-removebg-preview.png")); // create a variable for the image of the graph that shows user's result
				displayarea.setPreferredSize(new Dimension(WIDTH,HEIGHT-380)); // resize displayarea
				JPanel finalScore = new JPanel() { // create a panel that draw's the user's final score
					public void paint(Graphics g) { // paint the final score with an image
						g.setColor(Color.gray); // set background color to gray to make it consistent with the rest of the frame
						g.fillRect(0, 0, GuideUI.this.WIDTH-25, GuideUI.this.HEIGHT-200); // draw a rectangle
						g.drawImage(myPicture, 0, 0, GuideUI.this.WIDTH-25, GuideUI.this.HEIGHT-250, null); // display the user's result
					} // closing bracket
				}; // closing bracket
				finalScore.setPreferredSize(new Dimension(WIDTH-25, HEIGHT-200)); // set the size for this panel
				panel.add(finalScore); // add this panel to the main panel
				result = "Somewhat stable"; // change the variable to hold the user's result
			} // closing bracket
			else { // if the scoreTracker variable does not fit any of the other if/else-if statements, the user is emotionally stable
				BufferedImage myPicture = ImageIO.read(new File("Images/Emotionally_Stable-removebg-preview.png")); // create a variable for the image of the graph that shows user's result
				displayarea.setPreferredSize(new Dimension(WIDTH,HEIGHT-380)); // resize displayarea
				JPanel finalScore = new JPanel() { // create a panel that draw's the user's final score
					public void paint(Graphics g) { // paint the final score with an image
						g.setColor(Color.gray); // set background color to gray to make it consistent with the rest of the frame
						g.fillRect(0, 0, GuideUI.this.WIDTH-25, GuideUI.this.HEIGHT-200); // draw a rectangle
						g.drawImage(myPicture, 0, 0, GuideUI.this.WIDTH-25, GuideUI.this.HEIGHT-250, null); // display the user's result
					} // closing bracket
				}; // closing bracket
				finalScore.setPreferredSize(new Dimension(WIDTH-25, HEIGHT-200)); // set the size for this panel
				panel.add(finalScore); // add this panel to the main panel
				result = "Emotionally Stable"; // change the variable to hold the user's result
			} // closing bracket
			panel.repaint(); // repaint the panel with the new info
			panel.setVisible(true); // make sure the panel is visible
			
			String appendResult = name.trim() + " was " + result; // variable used for data analytics
			try { // try catch method for catching errors
				Writer fileWriter = new FileWriter("results.txt", true); // create a new file for holding the data
				BufferedWriter writer = new BufferedWriter(fileWriter); // new writer to write in the data
				writer.write(appendResult + "\n"); // write the String with the result
				writer.close(); // close it once it's done
			}catch(Exception ex) { // catch errors
				ex.printStackTrace(); //specifically Exception errors
			} // closing bracket
		} // closing bracket
	} // closing bracket
	
	public static void main(String[] args) { // main method for running the code
		new GuideUI(); // run the constructor
	} // closing bracket
} // closing bracket
