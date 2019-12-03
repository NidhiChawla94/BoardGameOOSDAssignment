package com.oosd.undo.momento;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.oosd.model.Piece;

@Invariant("piece != null")
public class Memento {
	
	private final Piece piece;
	
	public Memento(Piece pieceToSave){
		this.piece = pieceToSave;
	}
	
	/**
	 * Getting most recent saved Piece
	 * 
	 */
	@Ensures("piece != null && !piece.getId().isEmpty()")
	public Piece getSavedPiece(){
		return piece;
	}

}
