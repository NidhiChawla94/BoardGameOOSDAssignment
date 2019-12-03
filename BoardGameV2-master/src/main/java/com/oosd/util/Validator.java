package com.oosd.util;

import java.util.ArrayList;
import java.util.Collection;

import com.oosd.model.Game;
import com.oosd.model.Location;
import com.oosd.model.Piece;

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDescription  This class creates the main objects requires .   				  
* 					 to setup and run the game.
*/

public class Validator {

	private static Validator validator = new Validator(); // Create validator object 
	private Validator() {

	}

	/**
	 * get the instance of validator
	 * @return validator
	 */
	public static Validator getInstance() {
		return validator;
	}

	/**
	 * 
	 * @param destination Defines the destination location of piece.
	 * @param piece      Defines the piece to be moved
	 * @return true
	 *                This method first validates the move of each piece by
	 *                checking whether the piece is moved  within same location or 
	 *                Whether the piece is trying to move from more than one location or
	 *                checks whether the same team piece is moved twice.  
	 *               
	 */

	public boolean validateMove (Location destination, Piece pieceToBeValidated, Collection<Piece> pieces){
		if (!Game.getInstance().getCurrentPlayer().getName().equals(pieceToBeValidated.getTeamName())) {
			return false;
		}

		boolean isSameLocation = pieceToBeValidated.getLocation().getxCoordinate() == destination.getxCoordinate()
				&& pieceToBeValidated.getLocation().getyCoordinate() == destination.getyCoordinate();

		boolean isWrongMoveAtXCordinate = destination.getxCoordinate() > pieceToBeValidated.getLocation().getxCoordinate() + 1
				|| destination.getxCoordinate() < pieceToBeValidated.getLocation().getxCoordinate() - 1;
		boolean isWrongMoveAtYCordinate = destination.getyCoordinate() > pieceToBeValidated.getLocation().getyCoordinate() + 1
				|| destination.getyCoordinate() < pieceToBeValidated.getLocation().getyCoordinate() - 1;

		if (isSameLocation) {
			return false;
		} else if (isWrongMoveAtXCordinate || isWrongMoveAtYCordinate) {
			return false;
		}else{
			Collection<Piece> validateOnPieces = new ArrayList<Piece>(pieces);
			validateOnPieces.remove(this);
			for (Piece currentPiece : validateOnPieces) {

				boolean movingOnAnotherPlayer = currentPiece.getLocation().getxCoordinate() == destination
						.getxCoordinate()
						&& currentPiece.getLocation().getyCoordinate() == destination.getyCoordinate();
				if (movingOnAnotherPlayer) {
					return false;
				}

			}
		}
		return true;
	}
	
	/**
	 * This method validates if the piece is attacking on the
	 * same team member and also checks if the piece in defense mode is 
	 * being attacked.
	 * mode is being attacked
	 * @param attackingPiece
	 * @param attackedPiece
	 * @return error message
	 */
	public String validateAttack(Piece attackingPiece, Piece attackedPiece) {
		String errorMessage = null;
		if(attackedPiece.getTeamName().equalsIgnoreCase(attackingPiece.getTeamName())){
			errorMessage = Constants.ATTACK_ON_SAME_TEAM_MEMBER;
		}
		if(attackedPiece.isDefenceModeEnabled()){
			errorMessage = Constants.PLAYER_IN_DEFENCE_MODE;
		}
		return errorMessage;
		
	}
}
