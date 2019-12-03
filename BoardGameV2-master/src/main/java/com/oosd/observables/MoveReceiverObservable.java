package com.oosd.observables;

import java.util.ArrayList;
import java.util.List;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import com.oosd.model.Location;
import com.oosd.model.Piece;
import com.oosd.observers.IObserver;
import com.oosd.util.Constants;

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDescription  MoveReceiverObservable class extends IObservable
* 					 class and implements register, unregister and notify methods.	  
* 
*/
public class MoveReceiverObservable implements IObservable {

	private int moveCount;
	private static MoveReceiverObservable moveHandler = new MoveReceiverObservable();
	private List<IObserver> observers = new ArrayList<>();

	private MoveReceiverObservable() {

	}

	public static MoveReceiverObservable getInstance() {
		return moveHandler;
	}
	public int getMoveCount() {
		return moveCount;
	}
	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}



	/**
	 * 
	 * @param destination      Defines the destination location of piece.
	 * @param pieceToBeMoved   Defines the piece which has to be moved
	 * @return void
	 *          			   This method moves the piece from source to destination and 
	 *          			   observes the movement and keep track of the count . 	
	 */

	@Requires("destination.xCoordinate = piece.getLocation().getxCoordinate+1 || destination.yCoordinate = piece.getLocation().getyCoordinate+1")
	public void  move(Piece pieceToBeMoved, Location destination) {
		
		pieceToBeMoved.setLocation(destination);
		this.setMoveCount(++this.moveCount);
		
		if(this.getMoveCount() !=0 && this.getMoveCount() % Constants.HEALER_MOVES_REQUIRED == 0){
			this.notifyObservers();	
		}
		
	}

	/**
	 * this method register the observer
	 */
	@Ensures("old.observers.size() + 1 == observers.size()")
	@Override
	public void register(IObserver observer) {
		this.observers.add(observer);
	}

	/**
	 * This method unregister the observer
	 * 
	 */
	@Ensures("old.observers.size() - 1 == observers.size()")
	@Override
	public void unregister(IObserver observer) {
		this.observers.remove(observer);

	}
	
	/**
	 * This method notify the observer
	 * when any update is performed.
	 */
	@Override
	public void notifyObservers() {
		for (IObserver observer : this.observers) {
			observer.update();
		}

	}

}
