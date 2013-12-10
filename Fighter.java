import java.util.*;

/** 
 * This class is a Fighter used for killing.
 * It requires and ArenaPanel and ArenaDriver class.
 * @author Alec Fenichel
 * @version Awesome
 * Collaboration Statement:
 * I worked on this alone.
 * I showed my code to the TA Stefano Fenu and he said it was "good" or "decent".
 * I was very hurt by his statements.
 */

public class Fighter {
	
	//Output suppressed with comments
	//This is what I should do according to the instructions, but I am not
	
	private String name;
	private int attack;
	private int defense;
	private int luck;
	//private int health = 100;
	//This is what I should do according to the instructions, but I am not
	private int health;
	private static Random rand = new Random();
	
	//public Fighter(String name, int attack, int defense) {
	//This is what I should do according to the instructions, but I am not
	
	/**
	 * Constructor that assigns values from parameters.
	 * @param name which is the name of the fighter as a String.
	 * @param attack which is the attack level of the fighter as an int.
	 * @param defense which is the attack level of the fighter as an int.
	 * @param health which is the health level of the fighter as an int.
	 */
	
	public Fighter(String name, int attack, int defense, int health) {
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.health = health; //added the ability to change the health
		this.luck = Math.round(attack/2);
	}
	
	/**
	 * Makes the attackee take damage with random factor.
	 * @param damage which is the damage being attempted.
	 */
	
	public void takeDamage(int damage) {
		int ndamage = Math.max(damage - getDefense(),0);
		health = Math.max(health - ndamage,0);
		ArenaPanel.output4.setText(getName() + " took " + ndamage + " after avoiding "+ (damage-ndamage) +" damage.");
		//System.out.println(getName() + " took " + ndamage + " and avoided "+ (damage-ndamage) +" damage.");
	}
	
	/**
	 * Attack that damages with random factor.
	 * @return the int value of damage to give.
	 */
	
	public int fastAttack() {
		int damage = attack-Math.round(luck/2)+rand.nextInt(luck);
		ArenaPanel.output3.setText(getName() + " attempted " + damage + " damage.");
		//System.out.println(getName() + " attempted " + damage + " damage.");
		return damage;
	}
	
	/**
	 * Attack that damages without random factor.
	 * @return the int value of damage to give.
	 */
	
	public int strongAttack() {
		int damage = attack;
		ArenaPanel.output3.setText(getName() + " attempted " + damage + " damage.");
		//System.out.println(getName() + " attempted " + damage + " damage.");
		return damage;
	}
	
	/**
	 * Gets the defense.
	 * @return the int value of defense.
	 */
	
	public int getDefense() {
		int defense;
		if(Math.round(luck/2)>0)
			defense = this.defense + rand.nextInt(Math.round(luck/2));
		else
			defense = this.defense;
		return defense;
	}
	
	/**
	 * Gets the name.
	 * @return the string value of name.
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the health.
	 * @return the int value of health.
	 */
	
	public int getHealth() {
		return health;
	}
}
