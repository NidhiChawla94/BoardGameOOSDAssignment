package com.oosd.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.oosd.util.CommonUtility;
import com.oosd.util.Creator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * 
 *  
 * @author  Nidhi Chawla
 * @version 1.0
 * @classDescription MenuView class displays the score
 *                   of individual team and displays the game result.
 * 					 
 * 
 */

public class MenuView implements Initializable{

	//Define text for resume game.
	@FXML
	private Text resumeGameAnchorPane;

	//Define pane for new game.
	@FXML
	private AnchorPane newGameAnchorPane;

	//Define label to check game status
	@FXML
	private Label gameStatus;


	@FXML
	void onNewGameClicked(MouseEvent event) {
		Creator.getInstance().createBoard(true);
		try {
			CommonUtility.openNewScene("Board");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method starts the new instance
	 * to start the new game.
	 * 
	 */

	/*
	 * This method recommences the game from the
	 *  pause state. 
	 * 
	 */
	@FXML
	void onResumeGameClicked(MouseEvent event) {

		gameStatus.setText("Please wait game is being loaded!!");
		Creator.getInstance().createBoard(false);
		try {
			CommonUtility.openNewScene("Board");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	



	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
