package com.oosd.commands;

import com.google.java.contract.Ensures;
import com.oosd.model.Location;
import com.google.java.contract.Invariant;
import com.oosd.model.Piece;
import com.oosd.observables.MoveReceiverObservable;


/**
* 
* @author  Nidhi Chawla
* @version 1.0
* @classDescription Concrete command class for Move Command.
* 
*/

@Invariant("piece!=null,destination!=null")
public class MoveCommand implements Command {
	
	private Piece piece ; //piece reference object of class Piece
	private Location destination; //destination reference object of class location
	
	/**
	 * CONSTRUCTOR
	 * 
	 * @param pieceToBeMoved define the piece that is to be moved
	 * @param destination    define destination location of piece
	 * 
	 */
	public MoveCommand(Piece pieceToBeMoved, Location destination) {
		super();
		this.piece = pieceToBeMoved;
		this.destination = destination;
		
	}

	/**
	 * Observe the movement of piece
	 */
	@Ensures("piece.xcoordinate== destination.xcoordinate && piece.ycoordinate == destination.ycoordinate")
	@Override
	public void execute() {
		
		MoveReceiverObservable.getInstance().move(piece, destination);
		
	}
}
