package PsychologyProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.server.UID;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import graphicsEditor.Text;

public class GuideUI {
 int WIDTH = 1000, HEIGHT = 500;
 String name;
 int i = 1;
 String[] Q1 ={"\n\n\n                 Welcome to the Psychology Test! Type your name in the text box below","\n\n\n                 Would you open an envelope that has the date of your death inside?",
			"\n\n\n                 Would you be friends with yourself?","\n\n\n                 If you commit a crime to feed your hungry child, \n                 are you a bad person or did you commit the crime out of necessity?"
			,"\n\n\n                 If you could see a measuring scale above people’s heads, \n                 what would you want this scale to measure?"};
 JTextArea inputAreaOne = new JTextArea();	
 JPanel panel = new JPanel(), buttonPanel = new JPanel(), buttonPanel1 = new JPanel(), buttonPanel2 = new JPanel(), buttonPanel3 = new JPanel();
 JTextArea displayarea = new JTextArea();
 JButton[] A1 = {new JButton("Hell yea"),new JButton("Hell no")}; JButton[] A2 = {new JButton("Hell yea"),new JButton("Hell no")}; JButton[] A3 = {new JButton("Hell yea"),new JButton("Hell no")};JButton[] A4 = {new JButton("Hell yea"),new JButton("Hell no")};
 JFrame frame = new JFrame();
 JButton EnterButton = new JButton("Next Question");
 int scoreTracker = 0;
 public GuideUI() {
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BoxLayout buttonlayout = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
		BoxLayout buttonlayout1 = new BoxLayout(buttonPanel1, BoxLayout.X_AXIS);
		BoxLayout buttonlayout2 = new BoxLayout(buttonPanel2, BoxLayout.X_AXIS);
		BoxLayout buttonlayout3 = new BoxLayout(buttonPanel3, BoxLayout.X_AXIS);
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		buttonPanel.setLayout(buttonlayout);
		buttonPanel1.setLayout(buttonlayout1);
		buttonPanel2.setLayout(buttonlayout2);
		buttonPanel3.setLayout(buttonlayout3);
		panel.setLayout(boxlayout);
		panel.setBorder(BorderFactory.createTitledBorder("Psychology Test"));
		displayarea.setForeground(Color.gray);
		displayarea.setFont(new Font("Comic Sans", Font.BOLD, 23));
		displayarea.setForeground(Color.blue);
		displayarea.setBackground(Color.gray);
		displayarea.setText(Q1[0]);
		displayarea.setEditable(false);
		inputAreaOne.getInputMap().put(KeyStroke.getKeyStroke('\n'), "ENTER");
		inputAreaOne.getActionMap().put("ENTER", new EnterAction());
        inputAreaOne.setEditable(true);
        EnterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Action();
			}
        });
        A1[0].addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		scoreTracker++;
        		buttonPanel.setVisible(false);
        		i++;
        		displayarea.setText(Q1[i]);
        		Action1();
        	}
        });
        A1[1].addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		scoreTracker--;
        		buttonPanel.setVisible(false);
        		i++;
        		displayarea.setText(Q1[i]);
        		Action1();
        	}
        });
        A2[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scoreTracker++;
				buttonPanel1.setVisible(false);
				i++;
				displayarea.setText(Q1[i]);
				Action1();
			}
        });
        A2[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scoreTracker--;
				buttonPanel1.setVisible(false);
				i++;
				displayarea.setText(Q1[i]);
				Action1();
			}
        });
        A3[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scoreTracker++;
				buttonPanel2.setVisible(false);
				i++;
				displayarea.setText(Q1[i]);
				Action1();
			}
        });
        A3[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scoreTracker--;
				buttonPanel2.setVisible(false);
				i++;
				displayarea.setText(Q1[i]);
				Action1();
			}
        });
        A4[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scoreTracker++;
				buttonPanel3.setVisible(false);
				i++;
				displayarea.setText(Q1[i]);
				Action1();
			}
        });
        A4[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scoreTracker--;
				buttonPanel3.setVisible(false);
				i++;
				displayarea.setText(Q1[i]);
				Action1();
			}
        });
        buttonPanel.setPreferredSize(new Dimension(1000,180));
        buttonPanel.add(A1[0]);
        buttonPanel.add(A1[1]);
        buttonPanel1.setPreferredSize(new Dimension(1000,180));
        buttonPanel1.add(A2[0]);
        buttonPanel1.add(A2[1]);
        buttonPanel2.setPreferredSize(new Dimension(1000,180));
        buttonPanel2.add(A3[0]);
        buttonPanel2.add(A3[1]);
        buttonPanel3.setPreferredSize(new Dimension(1000,180));
        buttonPanel3.add(A4[0]);
        buttonPanel3.add(A4[1]);
        panel.add(displayarea);
        panel.add(inputAreaOne);
        panel.add(EnterButton);
        frame.add(panel);
        
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	private class EnterAction extends AbstractAction{
		public void actionPerformed(ActionEvent e) {
			Action();
		}
	}
	public void Action () {
		name = inputAreaOne.getText();
		inputAreaOne.setText(null);
		panel.setBorder(BorderFactory.createTitledBorder(name + "'s Psychology Test"));
		displayarea.setText(Q1[i]);
		if (i == 1) {
			inputAreaOne.setVisible(false);
			EnterButton.setVisible(false);
			panel.add(buttonPanel);
			
		}
		
	}
	public void Action1() {
		if (i == 2) {
			buttonPanel.setVisible(false);
			panel.add(buttonPanel1);
		}
		if (i == 3) {
			buttonPanel1.setVisible(false);
			panel.add(buttonPanel2);
		}
		if (i == 4) {
			buttonPanel2.setVisible(false);
			panel.add(buttonPanel3);
		}
	}
	
	public static void main(String[] args) {
		new GuideUI();
	}
}
