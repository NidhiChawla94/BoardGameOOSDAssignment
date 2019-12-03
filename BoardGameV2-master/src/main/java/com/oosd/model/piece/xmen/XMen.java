package com.oosd.model.piece.xmen;

import java.util.Collection;

import com.oosd.model.Piece;

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDescription  XMen class invokes the attributes of piece class  				  
* 
*/

public class XMen extends Piece{


	/** 
	   * Constructor calls the Parent Class Piece.  
	   */
	public XMen() {
		super();
	}	
	
	
	Collection<Piece> pieces; // Define the collection of pieces.

	/**
	 * get the Pieces
	 * @return pieces
	 */
	public Collection<Piece> getPieces() {
		return pieces;
	}
	
	/**
	 * Set the Pieces
	 * @param pieces
	 */

	public void setPieces(Collection<Piece> pieces) {
		this.pieces = pieces;
	}
}
