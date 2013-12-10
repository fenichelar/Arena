import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/** 
 * This class is an Arena Panel that extends Jpanel to be used to fight.
 * It requires Fighter and ArenaDriver class.
 * @author Alec Fenichel
 * @version Awesome
 * Collaboration Statement:
 * I worked on this alone.
 * I showed my code to the TA Stefano Fenu and he said it was "good" or "decent".
 * I was very hurt by his statements.
 */

public class ArenaPanel extends JPanel {

	//Output suppressed with comments
	//This is what I should do according to the instructions, but I am not
	
	//private JTextField f1_name_text = new JTextField("Fighter 1");
	//This is what I should do according to the instructions, but I am not
	private JTextField f1_name_text;
	private JTextField f1_attack_text;
	private JTextField f1_defense_text;
	private JTextField f1_health_text;
	
	//private JTextField f2_name_text = new JTextField("Fighter 2");
	//This is what I should do according to the instructions, but I am not
	private JTextField f2_name_text;
	private JTextField f2_attack_text;
	private JTextField f2_defense_text;
	private JTextField f2_health_text;
	
	private JLabel f1_name_title;
	private JLabel f1_name;
	private JLabel f1_attack;
	private JLabel f1_defense;
	private JLabel f1_health;
	
	private JLabel f2_name_title;
	private JLabel f2_name;
	private JLabel f2_attack;
	private JLabel f2_defense;
	private JLabel f2_health;
	
	private JLabel turn;
	private JLabel info;
	private JLabel tinfo;
	
	private JLabel space;
	private JLabel space1;
	private JLabel space2;
	private JLabel space3;
	private JLabel space4;
	
	private Font bold;
	
	public static JLabel output1 = new JLabel();
	public static JLabel output2 = new JLabel();
	public static JLabel output3 = new JLabel();
	public static JLabel output4 = new JLabel();
	public static JLabel output5 = new JLabel();
	
	private JButton fast;
	private JButton strong;
	
	private JButton again;
	
	private boolean p1_turn;
	
	private Fighter p1 = null;
	private Fighter p2 = null;
	
	private Random rand;
	
	/**
	 * Constructor that assigns and adds components to the panel.
	 */
	
	public ArenaPanel() {
		f1_name_title = new JLabel("Fighter 1's Information Here:");
		f1_name = new JLabel("Fighter 1's Name:");
		f1_attack = new JLabel("Fighter 1's Attack:");
		f1_defense = new JLabel("Fighter 1's Defense:");
		f1_health = new JLabel("Fighter 1's Health:");
		
		f2_name_title = new JLabel("Fighter 2's Information Here:");
		f2_name = new JLabel("Fighter 2's Name:");
		f2_attack = new JLabel("Fighter 2's Attack:");
		f2_defense = new JLabel("Fighter 2's Defense:");
		f2_health = new JLabel("Fighter 2's Health:");
		
		bold = new Font(f1_name.getFont().getName(),Font.BOLD,f1_name.getFont().getSize());
		
		rand = new Random();
		
		tinfo = new JLabel("Turn Information Here:");
		tinfo.setFont(bold);
		info = new JLabel("The Fight's Statistics Here:");
		info.setFont(bold);
		turn = new JLabel("It is currently fighter 1's turn to attack!");
		space = new JLabel("                                    ");
		space.setFont(bold);
		space1 = new JLabel("-----------------------------------");
		space1.setFont(bold);
		space2 = new JLabel("-----------------------------------");
		space2.setFont(bold);
		space3 = new JLabel("-----------------------------------");
		space3.setFont(bold);
		space4 = new JLabel("-----------------------------------");
		space4.setFont(bold);
		
		f1_name_title.setFont(bold);
		f2_name_title.setFont(bold);
		
		fast = new JButton("Fast Attack!");
		strong = new JButton("Strong Attack!");
		again = new JButton("Reset");
		
		f1_name_text = new JTextField(10);
		f1_attack_text = new JTextField(10);
		f1_defense_text = new JTextField(10);
		f1_health_text = new JTextField(10);
		
		f2_name_text = new JTextField(10);
		f2_attack_text = new JTextField(10);
		f2_defense_text = new JTextField(10);
		f2_health_text = new JTextField(10);
		
		f1_name_text.setText("Alex");
		f2_name_text.setText("Taylor");
		
		f1_health_text.setText("100");
		f2_health_text.setText("100");
		
		output1.setText("Fighter 1's health displayed here");
		output2.setText("Fighter 2's health displayed here");
		output3.setText("Attempted damage displayed here");
		output4.setText("Taken damage displayed here");
		output5.setText("Who is winning displayed here");
		
		p1_turn = true;
		
		add(space);
		
		add(f1_name_title);
		add(f1_name);
		add(f1_name_text);
		add(f1_attack);
		add(f1_attack_text);
		add(f1_defense);
		add(f1_defense_text);
		add(f1_health);
		add(f1_health_text);
		
		add(space1);
		
		add(f2_name_title);
		add(f2_name);
		add(f2_name_text);
		add(f2_attack);
		add(f2_attack_text);
		add(f2_defense);
		add(f2_defense_text);
		add(f2_health);
		add(f2_health_text);
		
		add(space2);
		add(tinfo);
		add(turn);
		
		add(fast);
		add(strong);
		
		add(space3);
		add(info);
		
		add(output1);
		add(output2);
		add(output3);
		add(output4);
		add(output5);
		
		add(space4);
		
		add(again);
		again.setEnabled(false);
		
		fast.addActionListener(new fastButtonListener());
		strong.addActionListener(new strongButtonListener());
		again.addActionListener(new againButtonListener());
	}
	
	/**
	 * Checks to see if a fighter is dead and ends the fight if they are and outputs statistics.
	 */
	
	public void checkForWin() {
		output1.setText(p1.getName() + " has " + p1.getHealth() + " health left.");
		//System.out.println(p1.getName() + " has " + p1.getHealth() + " health left.");
		output2.setText(p2.getName() + " has " + p2.getHealth() + " health left.");
		//System.out.println(p2.getName() + " has " + p2.getHealth() + " health left.");
		if(Math.min(p1.getHealth(), p2.getHealth())==0) {
			if(p2.getHealth()==0) {
				output5.setText(p2.getName() + " you suck! Grow a pair.");
				//System.out.println(p2.getName() + " you suck! Grow a pair.");
				turn.setText(p1.getName() + " won with " + p1.getHealth() + " health left.");
				//System.out.println(p1.getName() + " won with " + p1.getHealth() + " health left.");
			}
			else {
				output5.setText(p1.getName() + " you suck! Grow a pair.");
				//System.out.println(p1.getName() + " you suck! Grow a pair.");
				turn.setText(p2.getName() + " won with " + p2.getHealth() + " health left.");
				//System.out.println(p2.getName() + " won with " + p2.getHealth() + " health left.");
			}
			fast.setEnabled(false);
			strong.setEnabled(false);
			again.setText("Play Again");
		}
		else {
			if(p1.getHealth()>p2.getHealth()) {
				output5.setText(p1.getName() + ", good job! You are dominating " + p2.getName() + ".");
				//System.out.println(p1.getName() + ", good job! You are dominating " + p2.getName() + ".");
			}
			else if(p2.getHealth()>p1.getHealth()){
				output5.setText(p2.getName() + ", good job! You are dominating " + p1.getName() + ".");
				//System.out.println(p2.getName() + ", good job! You are dominating " + p1.getName() + ".");
			}
			else {
				output5.setText("It is a close fight!");
				//System.out.println("It is a close fight!");
			}
		}
			
	}
	
	/**
	 * Creates fighters and makes fields uneditable after verifying the fields parsability.
	 */
	
	public void prepareFighters() {
		//p1 = new Fighter(f1_name_text.getText(),Integer.parseInt(f1_attack_text.getText()),Integer.parseInt(f1_defense_text.getText()));
		//p2 = new Fighter(f2_name_text.getText(),Integer.parseInt(f2_attack_text.getText()),Integer.parseInt(f2_defense_text.getText()));
		//This is what I should do according to the instructions, but I am not
		
		if(f1_name_text.getText().isEmpty())
			f1_name_text.setText("Alex");
		if(f2_name_text.getText().isEmpty())
			f2_name_text.setText("Taylor");
		
		if(isNotParsable(f1_health_text.getText()))
			f1_health_text.setText("100");
		if(isNotParsable(f2_health_text.getText()))
			f2_health_text.setText("100");
		
		if(isNotParsable(f1_attack_text.getText()))
			f1_attack_text.setText(Integer.toString(Math.max(rand.nextInt(Math.max(Integer.parseInt(f2_health_text.getText())/5,1)),1)));
		if(isNotParsable(f2_attack_text.getText()))
			f2_attack_text.setText(Integer.toString(Math.max(rand.nextInt(Math.max(Integer.parseInt(f1_health_text.getText())/5,1)),1)));
		
		if(isNotParsable(f1_defense_text.getText()))
			f1_defense_text.setText(Integer.toString(Math.max(rand.nextInt(Math.max(Integer.parseInt(f2_attack_text.getText())/2,1)),1)));
		if(isNotParsable(f2_defense_text.getText()))
			f2_defense_text.setText(Integer.toString(Math.max(rand.nextInt(Math.max(Integer.parseInt(f1_attack_text.getText())/2,1)),1)));
		
		f1_name_text.setEditable(false);
		f1_attack_text.setEditable(false);
		f1_defense_text.setEditable(false);
		f1_health_text.setEditable(false);
		
		f2_name_text.setEditable(false);
		f2_attack_text.setEditable(false);
		f2_defense_text.setEditable(false);
		f2_health_text.setEditable(false);
		
		p1 = new Fighter(f1_name_text.getText(),Integer.parseInt(f1_attack_text.getText()),Integer.parseInt(f1_defense_text.getText()),Integer.parseInt(f1_health_text.getText()));
		p2 = new Fighter(f2_name_text.getText(),Integer.parseInt(f2_attack_text.getText()),Integer.parseInt(f2_defense_text.getText()),Integer.parseInt(f2_health_text.getText()));
		
		again.setEnabled(true);
	}
	
	/**
	 * Calls fastAttack after verifying the fighters creation then changes text for turn and then calls checkForWin.
	 * It implements ActionListener.
	 */
	
	private class fastButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(p1==null||p2==null)
				prepareFighters();
			if(p1_turn) {
				p2.takeDamage(p1.fastAttack());
				p1_turn = false;
				turn.setText("It is currently " + p2.getName() + "'s turn to attack!");
			}
			else {
				p1.takeDamage(p2.fastAttack());
				p1_turn = true;
				turn.setText("It is currently " + p1.getName() + "'s turn to attack!");
			}
			checkForWin();
		}
	}
	
	/**
	 * Calls strongAttack after verifying the fighters creation then changes text for turn and then calls checkForWin.
	 * It implements ActionListener.
	 */
	
	private class strongButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(p1==null||p2==null)
				prepareFighters();
			if(p1_turn) {
				p2.takeDamage(p1.strongAttack());
				p1_turn = false;
				turn.setText("It is currently " + p2.getName() + " 's turn to attack!");
			}
			else {
				p1.takeDamage(p2.strongAttack());
				p1_turn = true;
				turn.setText("It is currently " + p1.getName() + " 's turn to attack!");
			}
			checkForWin();
		}
	}
	
	/**
	 * Resets the game so it can be played again.
	 * It implements ActionListener.
	 */
	
	private class againButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			again.setEnabled(false);
			
			p1 = null;
			p2 = null;
			
			f1_name_text.setText("Alex");
			f1_attack_text.setText("");
			f1_defense_text.setText("");
			f1_health_text.setText("100");
			
			f2_name_text.setText("Taylor");
			f2_attack_text.setText("");
			f2_defense_text.setText("");
			f2_health_text.setText("100");
			
			f1_name_text.setEditable(true);
			f1_attack_text.setEditable(true);
			f1_defense_text.setEditable(true);
			f1_health_text.setEditable(true);
			
			f2_name_text.setEditable(true);
			f2_attack_text.setEditable(true);
			f2_defense_text.setEditable(true);
			f2_health_text.setEditable(true);
			
			turn.setText("It is currently fighter 1's turn to attack!");
			
			output1.setText("Fighter 1's health displayed here");
			output2.setText("Fighter 2's health displayed here");
			output3.setText("Attempted damage displayed here");
			output4.setText("Taken damage displayed here");
			output5.setText("Who is winning displayed here");
			
			fast.setEnabled(true);
			strong.setEnabled(true);
			
			again.setText("Reset");
		}
	}
	
	/**
	 * Checks to see if the string can be parsed into an int.
	 * @param s which is a string to be checked for parsability.
	 * @return a boolean answering the question is not parsable.
	 */
	
	public boolean isNotParsable(String s) {
		try {
			Integer.parseInt(s);
			return false;
		}
		catch(Exception ex) {
			return true;
		}
	}

}
