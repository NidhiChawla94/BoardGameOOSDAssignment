package com.oosd.healers;

import java.util.Random;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.oosd.model.Board;
import com.oosd.model.Game;
import com.oosd.model.Location;
import com.oosd.util.Constants;

/**
* @author  Siddharth Sachdeva
* @version 1.0
* @classDesciption HealerGenerator class generate the random healing elements
*                  for the piece to increase the life volume
*/
@Invariant("game != null")
public class HealerGenerator {

	Healer healer = null; // set the healer element to null
	Game game= Game.getInstance(); // Create the instance of game class.
	
	/**
	 * this method generates the random healing element on the 
	 * board and generate the image.
	 * @return healer
	 */
	@Ensures("healer != null")
	public Healer generateHealer(){
		Board board = game.getBoard();
		Random rand = new Random();

		Location emptyLocation = board.getEmptyLocation();
		int  randomNo = rand.nextInt(2) + 1;
		if(randomNo == 1){
			healer = new ElixirHealer();
			healer.setImagePath(Constants.ELIXIR_HEALER_IMAGE);
			healer.setHealerId(Constants.ELIXIR_HEALER_ID);
		}else{
			healer = new AntidoteHealer();
			healer.setImagePath(Constants.ANTIDOTE_HEALER_IMAGE);
			healer.setHealerId(Constants.ANTIDOTE_HEALER_ID);
		}
		healer.setLocation(emptyLocation);
		board.getHealers().add(healer);
		return healer;
	}
}
