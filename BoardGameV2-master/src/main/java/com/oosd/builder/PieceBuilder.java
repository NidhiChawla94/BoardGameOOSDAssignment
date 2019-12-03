package com.oosd.builder;

import com.oosd.model.Location;
import com.oosd.model.Piece;
import com.oosd.model.power.PowerComponent;

/**
* @author  Siddharth Sachdeva
* @version 1.0
* @classDesciption PieceBuilder class implements the IPieceBuilder
* 				   class
*             
*/
public class PieceBuilder implements IPieceBuilder {

	private Piece piece; // Define piece reference object of class piece.

	/**
	 *
	 * CONSTRUCTOR
	 * @param Piece
	 *        piece: reference of piece
	 * 
	 */
	@Override
	public PieceBuilder createPiece(Piece piece) {
		this.piece = piece;
		return this;
	}

	/**
	 * Set the Piece id
	 * @param id
	 */
	@Override
	public PieceBuilder buildPieceId(String id) {
		piece.setId(id);
		return this;
	}
	
	/**
	 * set the piece name
	 * @return name
	 */
	@Override
	public PieceBuilder buildPieceName(String name) {
		piece.setName(name);
		return this;
	}
	
	/**
	 * get the piece location
	 * @return location
	 */
	@Override
	public PieceBuilder buildPieceLocation(Location location) {
		piece.setLocation(location);
		return this;
	}

	/**
	 * set the piece power component
	 * @return powerComponent
	 */
	@Override
	public PieceBuilder buildPiecePowerComponent(PowerComponent powerComponent) {
		piece.setPowerComponent(powerComponent);
		return this;
	}

	/**
	 * set the piece status
	 * @return isAlive
	 */
	@Override
	public PieceBuilder buildIsAlive(boolean isAlive) {
		piece.setAlive(isAlive);
		return this;
	}
	
	/**
	 * set the piece team name
	 * @return teamName
	 */

	@Override
	public PieceBuilder buildTeamName(String teamName) {
		piece.setTeamName(teamName);
		return this;
	}
	
	/**
	 * set the piece image path
	 * @return imagePath
	 */
	
	@Override
	public PieceBuilder buildImagePath(String imagePath) {
		piece.setImagePath(imagePath);
		return this;
	}
	
	/**
	 * set the piece life volume
	 * @return lifeVolume
	 */
	@Override
	public PieceBuilder buildLifeVolume(Double lifeVolume) {
		piece.setLifeVolume(lifeVolume);
		return this;
	}
	
	/**
	 * get the piece reference object 
	 * @return piece
	 * 
	 */
	@Override
	public Piece getPiece (){
		return piece;
	}

}
