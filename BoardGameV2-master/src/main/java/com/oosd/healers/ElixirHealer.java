package com.oosd.healers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import com.oosd.model.Piece;

/**
* @author  Siddharth Sachdeva
* @version 1.0
* @classDesciption ElixirHealer extends the healer class and perform healing action
*             
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElixirHealer extends Healer {
	
	
	private static final Double HEALING_VOLUME = 200.00; // Declare the life volume of piece
	
	/**
	 * This method heals and set the life volume of piece
	 */
	@Requires("piece != null")
	@Ensures("piece.getLifeVolume() > old.piece.getLifeVolume()")
	@Override
	public void heal(Piece piece) {
		setPiece(piece);
		piece.setLifeVolume(this.getLifeVolume());
	}
	
	/**
	 * get the life volume of piece.
	 */

	@Override
	public double getLifeVolume() {
		return this.getPiece().getLifeVolume() + HEALING_VOLUME;
	}

	
	
}
