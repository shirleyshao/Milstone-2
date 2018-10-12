/**
 * Project: Tournament Bracket Project
 * Authors: Rehan Madhugiri, Nick Merfeld, Xianjia Shao, Andy Waldron
 * E-mails: madhugiri@wisc.edu, nmerfeld@wisc.edu, xshao36@wisc.edu, awaldron2@wisc.edu
 * Due: 5/3/2018
 * Files: Main.java, Bracket.java, Challenger.java, Matchup.java, teamList.txt.
 * Other Sources Used: None.
 * Known Bugs: None.
 */

package application;

import java.util.Random;

import javafx.scene.control.Button;

/**
 * @authors Rehan Madhugiri, Nick Merfeld, Xianjia Shao, Andy Waldron
 *
 * This class represents a matchup, and contains all pertinent information: the first challenger,
 * the second challenger, and the submit button assigned to the matchup that is used to set the
 * scores when an event is handled.
 */
public class Matchup {
	
	private Challenger c1; // First challenger.
	private Challenger c2; // Second challenger.
	private Button button; // Submit button.
	
	/**
	 * The constructor method sets the c1 field to the first challenger and the c2 field to the
	 * second challenger. It also sets a button to the button field for the matchup.
	 * 
	 * @param c1 First challenger.
	 * @param c2 Second challenger.
	 * @return Nothing returned.
	 */
	public Matchup(Challenger c1, Challenger c2, Button button){
		this.c1 = c1;
		this.c2 = c2;
		this.button = button;
	}
	
	/**
	 * This method returns the challenger with the greater score. If the scores are equal, the
	 * winner is chosen randomly.
	 * 
	 * @param c1 First challenger.
	 * @param c2 Second challenger.
	 * @return The challenger with the greater score.
	 */
	public Challenger getWinner(Challenger c1, Challenger c2) {
		// Tie 
		if(c1.getScore() == c2.getScore()){
			Random random = new Random(2);
			int result = random.nextInt();
			if(result == 0) return c1;
			else return c2;
		}
		
		// c1's score is greater
		if(c1.getScore() > c2.getScore()){
			return c1;
		}
		
		// c2's score is greater
		return c2;
	}
	
	/**
	 * This method returns the submit button of this particular matchup object.
	 * 
	 * @param No parameters.
	 * @return Nothing returned.
	 */
	public Button getButton(){
		return button;
	}
	
	/**
	 * This method returns the first challenger of the matchup.
	 * 
	 * @param No parameters.
	 * @return The first challenger of the matchup.
	 */
	public Challenger getC1() {
		return c1;
	}
	
	/**
	 * This method returns the second challenger of the matchup.
	 * 
	 * @param No parameters.
	 * @return The second challenger of the matchup.
	 */
	public Challenger getC2() {
		return c2;
	}
	
	/**
	 * This method "adds" a challenger to the matchup. It doesn't actually add a challenger object,
	 * it just renames the already existing challenger's name from "TBD" to whatever string is
	 * passed in as an argument.
	 * 
	 * @param team
	 */
	public void addChallenger(String team) {
		if(c1.getName().equals("TBD")) c1.setName(team);
		else if(c2.getName().equals("TBD")) c2.setName(team);
	}
	
}
