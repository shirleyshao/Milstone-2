/**
 * Project: Tournament Bracket Project
 * Authors: Rehan Madhugiri, Nick Merfeld, Xianjia Shao, Andy Waldron
 * E-mail: madhugiri@wisc.edu, nmerfeld@wisc.edu, xshao36@wisc.edu, awaldron2@wisc.edu
 * Due: 5/3/2018
 * Files: Main.java, Bracket.java, Challenger.java, Matchup.java, teamList.txt.
 * Other Sources Used: None.
 * Known Bugs: None.
 */

package application;

import javafx.scene.control.Label;

/**
 * @authors Rehan Madhugiri, Nick Merfeld, Xianjia Shao, Andy Waldron
 * 
 * This class represents a single challenger who is assigned a name as a string and score which
 * can be compared when one challenger object plays another challenger obejct.
 */
public class Challenger {
	
	private String name; // Name of challenger.
	private int score; // Score of challenger at a certain time.
	private Label label; // Label in the JavaFX stage of the team.
	
	/**
	 * Challenger constructor which sets the challenger's name to whatever is passed in the
	 * constructor.
	 * 
	 * @param name The name of the team.
	 * @return Nothing returned.
	 */
	public Challenger(String name) {
		this.name = name;
		label = new Label(name);
	}
	
	/**
	 * This method returns the score of the challenger.
	 * 
	 * @param No parameters.
	 * @return The score of the team as an int.
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * This method returns the label in the JavaFX of the challenger.
	 * 
	 * @param No parameters.
	 * @return The label of the challenger.
	 */
	public Label getLabel() {
		return label;
	}
	
	/**
	 * This method sets the score of the challenger to whatever int is passed in as an argument.
	 * 
	 * @param newScore The score of the challenger.
	 * @return Nothing returned.
	 */
	public void setScore(int newScore) {
		score = newScore;
	}
	
	/**
	 * This method returns the name of the challenger as a string.
	 * 
	 * @param No parameters.
	 * @return The name of the challenger as a string.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method sets the name of the challenger to whatever is passed in as an argument.
	 * 
	 * @param newName The name of the challenger.
	 * @return Nothing returned.
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * This method returns the name of the challenger as a string.
	 * 
	 * @param No parameters.
	 * @return The name of the challenger as a string.
	 */
	public String toString() {
		return name;
	}
}
