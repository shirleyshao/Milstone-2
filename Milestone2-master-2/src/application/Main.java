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
	
import java.io.File;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @authors Rehan Madhugiri, Nick Merfeld, Xianjia Shao, Andy Waldron
 *
 * This class contains all the JavaFX setup, processes, user interaction, etc.
 */
public class Main extends Application {
	
	public static Bracket bracket; // The tournament bracket object.
	private static ArrayList<ArrayList<TextField>> teamScores; // ArrayList of an ArrayList of team score text fields. The first dimension of the ArrayList is the number of rounds, while the ArrayList inside contains the text fields themselves.
	private static ArrayList<ArrayList<Button>> submitButtons; // ArrayList of an ArrayList of submit buttons. The first dimension of the ArrayList is the number of rounds, while the ArrayList inside contains the buttons themselves.
	private static ArrayList<ArrayList<Challenger>> teams; // ArrayList of an ArrayList of challenger objects. The first dimension of the ArrayList is the number of rounds, while the ArrayList inside contains the challenger objects themselves.
	
	private static int numRounds; // Number of rounds in the tournament.
	
	/**
	 * This method creates the controls, sets properties and the stage, and shows the stage.
	 * 
	 * @param primaryStage The stage that all the controls and functionality will be placed in.
	 * @return Nothing returned.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane gridPane = new GridPane();
			ScrollPane scroll = new ScrollPane(gridPane);
			BorderPane root = new BorderPane(scroll);
			root.setPadding(new Insets(10, 20, 10, 20));
			
			if(bracket.getAllChallengers().length == 0){ // If number of challengers equals 0.
				gridPane.add(new Label("There are no challengers in the bracket"), 0, 0);
			}
			
			else if(bracket.getAllChallengers().length == 1){ // If number of challengers equals 1.
				gridPane.add(new Label("Winner: " + bracket.getAllChallengers()[0]), 0, 0);
			}
			
			else {
			root.setTop(new Label("Enter a score in the text fields and press submit when both scores are added."));
				
			int submitYCoord;
			int submitXCoord;
			
			for(int i = 0; i < numRounds; i++){ // Adds buttons from matchups class to gridPane.
				submitXCoord = i;
				if(i == 0){
					submitYCoord = 3;
					for(int j = 0; j < bracket.getMatchups().get(i).size(); j++){
						gridPane.add(bracket.getMatchups().get(i).get(j).getButton(), submitXCoord, submitYCoord);
						submitYCoord += 5;						
					}
				}
				submitXCoord = 2 * i;
				if(i == 1){
					submitYCoord = 5;
					for(int j = 0; j < bracket.getMatchups().get(i).size(); j++){
						gridPane.add(bracket.getMatchups().get(i).get(j).getButton(), submitXCoord, submitYCoord);
						submitButtons.get(i).get(j).setDisable(true);
						submitYCoord += 10;
					}
				}
				if(i == 2){
					submitYCoord = 10;
					for(int j = 0; j < bracket.getMatchups().get(i).size(); j++){
						gridPane.add(bracket.getMatchups().get(i).get(j).getButton(), submitXCoord, submitYCoord);
						submitButtons.get(i).get(j).setDisable(true);
						submitYCoord += 20;
					}
				}
				if( i == 3){
					submitYCoord = 20;
					for(int j = 0; j < bracket.getMatchups().get(i).size(); j++){
						gridPane.add(bracket.getMatchups().get(i).get(j).getButton(), submitXCoord, submitYCoord);
						submitButtons.get(i).get(j).setDisable(true);
						submitYCoord += 20;
					}
				}
			}
			
			int scoreXCoord = 1;
			int scoreYCoord = 2;
			for(int i=0; i<numRounds; i++) { // Adds textfields to the gridPane.
				if(i==0) {
					for(int j=0; j<teamScores.get(i).size(); j+=2) {
						TextField teamScores1 = teamScores.get(i).get(j);
						TextField teamScores2 = teamScores.get(i).get(j+1);
						gridPane.add(teamScores1, scoreXCoord, scoreYCoord);
						gridPane.add(teamScores2, scoreXCoord, scoreYCoord + 2);
						scoreYCoord += 5;
					}
					scoreYCoord = 3;
				} else if(i==1) {
					for(int j=0; j<teamScores.get(i).size(); j+=2) {
						TextField teamScores1 = teamScores.get(i).get(j);
						TextField teamScores2 = teamScores.get(i).get(j+1);
						teamScores1.setDisable(true);
						teamScores2.setDisable(true);
						gridPane.add(teamScores1, scoreXCoord, scoreYCoord);
						gridPane.add(teamScores2, scoreXCoord, scoreYCoord + 5);
						scoreYCoord += 10;
					}
					scoreYCoord = 5;
				} else if(i==2) {
					for(int j=0; j<teamScores.get(i).size(); j+=2) {
						TextField teamScores1 = teamScores.get(i).get(j);
						TextField teamScores2 = teamScores.get(i).get(j+1);
						teamScores1.setDisable(true);
						teamScores2.setDisable(true);
						gridPane.add(teamScores1, scoreXCoord, scoreYCoord);
						gridPane.add(teamScores2, scoreXCoord, scoreYCoord + 10);
						scoreYCoord += 20;
					}
					scoreYCoord = 10;
				} else {
					for(int j=0; j<teamScores.get(i).size(); j+=2) {
						TextField teamScores1 = teamScores.get(i).get(j);
						TextField teamScores2 = teamScores.get(i).get(j+1);
						teamScores1.setDisable(true);
						teamScores2.setDisable(true);
						gridPane.add(teamScores1, scoreXCoord, scoreYCoord);
						gridPane.add(teamScores2, scoreXCoord, scoreYCoord + 20);
						scoreYCoord*=2;
					}
				}
				scoreXCoord+=2;
			}
			
			int TBDLabelXCoord = 0;
			int TBDLabelYCoord = 2;
			for(int i=0; i<numRounds; i++) { // Adds the TBD and team labels to the gridPane.
				if(i==0) {
					for(int j=0; j<teams.get(i).size(); j+=2) {
						gridPane.add(teams.get(i).get(j).getLabel(), TBDLabelXCoord, TBDLabelYCoord);
						gridPane.add(teams.get(i).get(j + 1).getLabel(), TBDLabelXCoord, TBDLabelYCoord + 2);
						TBDLabelYCoord +=5;
					}
					TBDLabelYCoord = 3;
				} else if(i==1) {
					for(int j=0; j<teams.get(i).size(); j+=2) {
						gridPane.add(teams.get(i).get(j).getLabel(), TBDLabelXCoord, TBDLabelYCoord);
						gridPane.add(teams.get(i).get(j + 1).getLabel(), TBDLabelXCoord, TBDLabelYCoord + 5);
						TBDLabelYCoord+=10;
					}
					TBDLabelYCoord = 5;
				} else if(i==2) {
					for(int j=0; j<teams.get(i).size(); j+=2) {
						gridPane.add(teams.get(i).get(j).getLabel(), TBDLabelXCoord, TBDLabelYCoord);
						gridPane.add(teams.get(i).get(j + 1).getLabel(), TBDLabelXCoord, TBDLabelYCoord + 10);
						TBDLabelYCoord+=20;
					}
					TBDLabelYCoord = 10;
				} else {
					for(int j=0; j<teams.get(i).size(); j+=2) {
						gridPane.add(teams.get(i).get(j).getLabel(), TBDLabelXCoord, TBDLabelYCoord);
						gridPane.add(teams.get(i).get(j + 1).getLabel(), TBDLabelXCoord, TBDLabelYCoord + 20);

						TBDLabelYCoord+=40;
					}
				}
				TBDLabelXCoord += 2;
			}
			
			ArrayList<Challenger> semifinalists = new ArrayList<Challenger>();
			for(int i = 0; i < bracket.getMatchups().size(); i++) { // This loop is for setting event handling.
				for(int j = 0; j < bracket.getMatchups().get(i).size(); j++) {
					int roundIndex = i; // Used in the ActionEvent
					int matchupIndex = j; // Used in the ActionEvent
					Matchup matchup = bracket.getMatchups().get(i).get(j);
					Button button = matchup.getButton();
					ArrayList<TextField> roundScores = teamScores.get(i);
					TextField score1 = roundScores.get(j*2);
					TextField score2 = roundScores.get(j*2 + 1);		
					ArrayList<Challenger> roundChallengers = teams.get(i);
					Challenger team1 = roundChallengers.get(j*2);
					Challenger team2 = roundChallengers.get(j*2+1);
					
					
					button.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent event) {
							try {
								if(Integer.parseInt(score1.getText()) < 0  || Integer.parseInt(score2.getText()) < 0) {
									Alert negativeNumAlert = new Alert(Alert.AlertType.ERROR, "ERROR: Negative numbers are not valid scores. Re-enter a positive integer.", ButtonType.OK);
									negativeNumAlert.showAndWait();
								} else {
									team1.setScore(Integer.parseInt(score1.getText()));
									team2.setScore(Integer.parseInt(score2.getText()));
									Challenger winner = matchup.getWinner(team1, team2);
									button.setDisable(true);
									Challenger loser;
									if(team1 == winner) loser = team2;
									else loser = team1;
									if(roundIndex == numRounds-2) {
										semifinalists.add(loser);
									}
									try {
										Label resultLabel = teams.get(roundIndex+1).get(matchupIndex).getLabel();
										resultLabel.setText(winner.getName());
										teams.get(roundIndex+1).get(matchupIndex).setName(winner.getName());
										teamScores.get(roundIndex+1).get(matchupIndex).setDisable(false);
										Matchup resultMatchup = bracket.getMatchups().get(roundIndex+1).get(matchupIndex/2);
										resultMatchup.addChallenger(winner.getName());
										
										if( !(resultMatchup.getC1().getName().equals("TBD") || 
												resultMatchup.getC2().getName().equals("TBD")) ) {
											resultMatchup.getButton().setDisable(false);
										}
									} catch (IndexOutOfBoundsException e) {
										gridPane.add(new Label("Winner: " + winner.getName()), numRounds*10, 10);
										gridPane.add(new Label("Second Place: " + loser.getName()), numRounds*10, 11);
										if(teams.get(0).size() == 2) return;
										Matchup thirdPlace = new Matchup(semifinalists.get(0), semifinalists.get(1), new Button(""));
										gridPane.add(new Label("Third Place: " + thirdPlace.getWinner(semifinalists.get(0), semifinalists.get(1))), numRounds*10, 12);
									}
								}
							} catch (NumberFormatException e) {
								Alert nonIntAlert = new Alert(Alert.AlertType.ERROR, "ERROR: Words are not valid scores. Re-enter a positive integer.", ButtonType.OK);
								nonIntAlert.showAndWait();
							}
						}
					});
				}
			}
			}
			root.setLeft(gridPane);

			Scene scene = new Scene(root,1000,500);			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method does pre-computation, reads in the team file to make an ArrayList of
	 * challengers, and launches the tournament.
	 * 
	 * @param args String array of command line arguments.
	 * @return Nothing returned.
	 */
	public static void main(String[] args) {
		File teamsFile = new File(args[0]);
		ArrayList<Challenger> challengers = new ArrayList<Challenger>();
		try {
			Scanner scnr = new Scanner(teamsFile);
			int seed = 1;
			while(scnr.hasNextLine()) {
				Challenger challenger = new Challenger(seed + " " + scnr.nextLine()); // Creates new challenger with seed number next to name.
				challengers.add(challenger);
				seed++;
			}
			scnr.close();
			
			bracket = new Bracket(challengers);
			
			numRounds = (int) (Math.log(challengers.size()) / Math.log(2));
		
			
			teamScores = new ArrayList<ArrayList<TextField>>();
			for(int i=numRounds; i>0; i--) {
				teamScores.add(new ArrayList<TextField>());
				for(int j=0; j<Math.pow(2, i); j++) {
					teamScores.get(teamScores.size()-1).add(new TextField("scores..."));
				}
			}
			
			submitButtons = new ArrayList<ArrayList<Button>>();
			for(int i=numRounds; i>0; i--) {
				submitButtons.add(new ArrayList<Button>());
				for(int j=0; j<(Math.pow(2, i)/2); j++) {
					submitButtons.get(submitButtons.size()-1).add(new Button("Submit"));
				}
			}
			
			// Adding initial team names to teamLabels
			teams = new ArrayList<ArrayList<Challenger>>();
			for(int i = numRounds; i > 0; i--) {
				teams.add(new ArrayList<Challenger>());
			}
			
			for(int i = numRounds; i > 0; i--) {

				for(int j = 0; j < Math.pow(2, i); j ++){
					if( i == numRounds){
						teams.get(0).add(new Challenger(bracket.getActiveChallengers().get(j).getName()));
					}
					else{
						teams.get(numRounds - i).add(new Challenger("TBD"));	
					}
				}
			}
			
			// adding matchups to matchup 
			for(int i = 0; i < teams.size(); i++) { // number of rounds
				bracket.getMatchups().add(new ArrayList<Matchup>());
				if(i == 0) {
					for(int j = 0; j < teams.get(i).size()/2; j ++){ // number of matchups in each round
						bracket.getMatchups().get(i).add(
								new Matchup(bracket.getAllChallengers()[j], bracket.getAllChallengers()[j+1], submitButtons.get(0).get(j)));
					}
				}
				
				else {
					for(int j = 0; j < teams.get(i).size() / 2; j ++){ // number of matchups in each round
						bracket.getMatchups().get(i).add(
								new Matchup(new Challenger("TBD"), new Challenger("TBD"), submitButtons.get(i).get(j)));
					}
				}
				
			}
		
			
		} catch(FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
		}
		launch(args);
	}
}
