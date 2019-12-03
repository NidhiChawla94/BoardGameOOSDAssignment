package com.oosd.observers;

import com.oosd.controller.BoardController;
import com.oosd.observables.MoveReceiverObservable;
import com.oosd.util.Constants;

public class MoveObserver implements IObserver {

	private MoveReceiverObservable moveHandler;
	
	public MoveObserver(MoveReceiverObservable moveHandler) {
		this.moveHandler = moveHandler;
	}

	@Override
	public void update() {
		BoardController.getInstance().setEnergyNotified(true);
		if(moveHandler.getMoveCount()== Constants.MAX_MOVES){
			BoardController.getInstance().setFinishGameNotified(true);
		}
		
	}

}
