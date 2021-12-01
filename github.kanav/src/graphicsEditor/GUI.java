package graphicsEditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUI {
	int height = 800, width = 800;
	int tempX, tempY;
	boolean isOnrectangle = false, isOnCircle = false, isOnDelete = false, isOnText = false, isOnLine = false, isOnColor = false;
	Color initialColor = Color.BLACK;
	// instance variables to determine height and with of screen, initial mouse values needed
	// for drawing shapes, initialcolor when changing colors, and boolean statements to determine which button was clicked
	public GUI() {
		JFrame window = new JFrame();
		JPanel container = new JPanel();
		// basic statements to create the frame and everything on the frame
		ArrayList<Shape> shapeContainer = new ArrayList<Shape>();
		container.setPreferredSize(new Dimension(width, height));
		// container to hold all shapes and determining the size of screen
		JPanel canvas = new JPanel() {
			public void paint(Graphics g) {
				super.paint(g);
				g.setColor(new Color (10,186,181));
				g.fillRect(0, 0, width, height-50);
				for (Shape s: shapeContainer) {
					s.draw(g);
				}
			}
			// painting whole canvas with color and using for each loop to draw each shape from  the user
		};
		canvas.setPreferredSize(new Dimension(width, height - 50));
		JPanel buttonContainer = new JPanel();
		// setting canvas size and also creating a container for all the buttons
		buttonContainer.setPreferredSize(new Dimension(width, 50));
		// setting size for the button container
		JButton circlebutton = new JButton ("Circle");
		JButton rectanglebutton = new JButton("Rectangle");
		JButton deletebutton = new JButton("Delete");
		JButton textbutton = new JButton("Text");
		JButton linebutton = new JButton("Line");
		JTextArea textbox = new JTextArea();
		JButton colorbutton = new JButton("Color Chooser");
		// defining all the buttons and choices for the user
		rectanglebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isOnrectangle = true;
				isOnCircle = false;
				isOnDelete = false;
				isOnText = false;
				isOnColor = false;
				isOnLine = false;
			}
		});
		// action listener to determine that rectangle was clicked and the others should be deactivated
		circlebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isOnCircle = true;
				isOnrectangle = false;
				isOnDelete = false;
				isOnText = false;
				isOnColor = false;
				isOnLine = false;
			}
		});
		// action listener to determine that circle was clicked and the others should be deactivated
		deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isOnDelete = true;
				isOnrectangle = false;
				isOnCircle = false;
				isOnText = false;
				isOnColor = false;
				isOnLine = false;
			}
		});
		// action listener to determine that delete was clicked and the others should be deactivated
		linebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isOnLine = true;
				isOnrectangle = false;
				isOnCircle = false;
				isOnText = false;
				isOnColor = false;
				isOnDelete = false;
			}
			
		});
		// action listener to determine that line was clicked and the others should be deactivated
		
		textbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isOnText = true;
				isOnrectangle = false;
				isOnCircle = false;
				isOnDelete = false;
				isOnColor = false;
				isOnLine = false;
			}
		});
		// action listener to determine that text was clicked and the others should be deactivated
		colorbutton.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				isOnColor = true;
				isOnrectangle = false;
				isOnCircle = false;
				isOnDelete = false;
				isOnText = false;
				isOnLine = false;
				initialColor = JColorChooser.showDialog(null, "Select a color", initialColor);
				// sets the color to the user input from the table of colors
			}
			// action listener to determine that colorchooser was clicked and the others should be deactivated
			
		});
		
		textbutton.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				textbox.setText(textbox.getText());
				
			}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
		});
		// key listener to determine what the text box should say
		
		canvas.addMouseListener(new MouseListener () {
			// mouse listener used to draw shapes
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
			// mousePressed because we are dragging the mouse to determine dimensions
				tempX = e.getX();
				tempY = e.getY();
				//these two statements are there to store the starting point of the shape
				if (isOnrectangle == true) {
				// if statement to determine which shape is being drawn(rectangle in this case)
					shapeContainer.add(new Rectangle(e.getX(), e.getY(), 0, 0, initialColor));
					//draws the shape
				}
				if (isOnCircle == true) {
				// if statement to determine which shape is being drawn (circle in this case)
					shapeContainer.add(new Circle(e.getX(), e.getY(), 0, 0, initialColor));
					//draws the shape
				}
				if (isOnLine == true) {
				// if statement to determine which shape is being drawn (line in this case)
					shapeContainer.add(new Line(e.getX(), e.getY(), e.getX(), e.getY(), initialColor));
				}
				if (isOnDelete == true) {
				// if statement to determine which shape is being drawn (delete in this case)
					for (Shape s: shapeContainer) {
					// for each loop to go through every shape
						if (s.isOn(e.getX(), e.getY()) == true) {
						// if the mouse is on a shape,
							shapeContainer.remove(s);
							//remove it
							break;
							// and break the loop so that it doesn't keep going and deleting everything
						}
					}
				}
				if (isOnText == true) {
				// if statement to determine which shape is being drawn (text in this case)	
					shapeContainer.add(new Text(e.getX(),e.getY(),textbox.getText().length()*11,20,initialColor, textbox.getText()));
					// draw the text as a shape
				}
				// no need for if statement on IsOnColor because the color changing happened in the ActionListener
				window.getContentPane().repaint();
				//repaint to draw the newly determined shapes
			}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		canvas.addMouseMotionListener(new MouseMotionListener() {
		//mouse motion because shapes are being drawn with respect to the mouse cursor
			public void mouseDragged(MouseEvent e) {
				if (isOnrectangle || isOnCircle || isOnLine)
				// if a circle or rectangle or line is being drawn,
					shapeContainer.get(shapeContainer.size()-1).resize(tempX, tempY, e.getX(), e.getY());
					// resize it so that when the mouse drags to a new spot the shape forms itself into the spot
					window.getContentPane().repaint();
					// repaint to show the newly drawn shape
				}
			public void mouseMoved(MouseEvent e) {}
		});
		textbox.setPreferredSize(new Dimension(100, 30));
		// set size of text box
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		// set the container so that it stacks on the Y-axis, not X-axis
		window.setSize(height, width);
		// set size of the window
		container.setBorder(BorderFactory.createTitledBorder("Graphics Editor"));
		// give the whole thing a fancy border
		buttonContainer.add(circlebutton);
		buttonContainer.add(rectanglebutton);
		buttonContainer.add(deletebutton);
		buttonContainer.add(linebutton);
		buttonContainer.add(textbutton);
		buttonContainer.add(textbox);
		buttonContainer.add(colorbutton);
		// add all the buttons to the button container
		container.add(buttonContainer);
		// add the button container to the container
		container.add(canvas);
		// add the canvas to the container
		window.add(container);
		// add the container to the window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// make it so that the x button works when closing the file
		window.setLocationRelativeTo(null);
		// set the window in the dead center of the screen
		window.setResizable(false);
		// don't let the user resize the screen
		window.setVisible(true);
		// make sure the user can actually see the program
		window.getContentPane().repaint();
		// repaint so that the user can actually see what's happening
	}
	public static void main (String args[]) {
		new GUI();
		// main method so that the program can actually run
	}
}
