import java.awt.*;
import javax.swing.*;

/** 
 * This class makes an Arena Panel that extends Jpanel to be used to fight.
 * It requires Fighter and ArenaPanel class.
 * @author Alec Fenichel
 * @version Awesome
 * Collaboration Statement:
 * I worked on this alone.
 * I showed my code to the TA Stefano Fenu and he said it was "good" or "decent".
 * I was very hurt by his statements.
 */

public class ArenaDriver {

	/**
	 * Main method that runs.
	 * @param args which are unused.
	 */
	
	public static void main(String[] args){
		
		JFrame frame = new JFrame("Alec's Fighting Machine");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ArenaPanel panel = new ArenaPanel();
		frame.add(panel);
		
		frame.pack();
		frame.setSize(new Dimension(300,750));
		frame.setResizable(false);
		
		frame.setVisible(true);
	}

}
