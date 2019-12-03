package com.oosd.commands;

import com.google.java.contract.Invariant;
import com.oosd.model.Game;

/**
 * 
 * @author  Nidhi Chawla
 * @version 1.0
 * @classDescription SaveCommand class implements the command class.
 * 
 */
@Invariant("game!=null")
public class SaveCommand implements Command {

	Game game; // game reference object of game class


	/**
	 * CONSTRUCTOR
	 * @param game game reference object
	 * 
	 */
	public SaveCommand(Game game) {
		this.game = game;
	}

	/**
	 * Save the game status
	 */
	@Override
	public void execute() {
		game.saveGame();

	}

}
