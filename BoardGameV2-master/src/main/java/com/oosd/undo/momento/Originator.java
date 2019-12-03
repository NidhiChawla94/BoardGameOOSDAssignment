package com.oosd.undo.momento;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import com.oosd.model.Piece;

public class Originator {
	
	private Piece piece;

	/**
	 * Setting the Piece object.
	 * @param piece
	 */
	@Requires("piece != null")
	public void set(Piece piece){
		this.piece = piece;
	}
	
	/**
	 * Creating a new Memento and passing a cloned Piece
	 * 
	 */
	public Memento createMemento(){
		return new Memento(this.piece.clonePiece());
	}
	
	/**
	 * Getting the most recent stored Memento 
	 * and returning it to the client
	 * @param memento
	 */
	@Ensures("this.piece != null")
	@Requires("memento != null")
	public Piece restoreFromMemento(Memento memento){
		this.piece = memento.getSavedPiece();
		return this.piece;
	}

}
