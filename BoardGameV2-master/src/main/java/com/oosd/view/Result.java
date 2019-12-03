package com.oosd.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.oosd.model.Game;
import com.oosd.util.Constants;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * 
 *  
 * @author  Nidhi Chawla
 * @version 1.0
 * @classDescription Result class displays the score
 *                   of individual team and displays the game result.
 * 					 
 * 
 */


public class Result implements Initializable{

	//Define text field to display Winner team
	@FXML
    private Text winnerTeamNameText;

	//Define text field for first PlayerName
    @FXML
    private Text player1Name;

    //Define text field for second PlayerName
    @FXML
    private Text player2Name;
    
    //Define text field to display player 1 score
    @FXML
    private Text player1Score;
    
    //Define text field to display player 2 score
    @FXML
    private Text player2Score;
    
    //Define Exit button
    @FXML
    private Button exitButton;



    /*
     *@param location  identify relative path for the root object 
	 *@param resources localize the root object 
	 *				   Displays the player name, player score and game results
     * 
     * 
     */

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Game gameInstance = Game.getInstance();
		
		if(gameInstance.getWinner() ==  null){
			winnerTeamNameText.setText(Constants.TIE_MESSAGE);
		}else{
			winnerTeamNameText.setText(gameInstance.getWinner().getName());	
		}
		player1Name.setText(gameInstance.getPlayers().get(0).getName());
		player2Name.setText(gameInstance.getPlayers().get(1).getName());
		player1Score.setText(String.valueOf(gameInstance.getPlayers().get(0).getScore()));
		player2Score.setText(String.valueOf(gameInstance.getPlayers().get(1).getScore()));
	}
	
	/*
	 * 
	 * Method exit the application by terminating the 
	 * running JVM
	 * 
	 */

	
	public void onExitClicked() {
		System.exit(0);
	}

}
