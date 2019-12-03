package com.oosd.observables;

import com.oosd.observers.IObserver;

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDescription  IObservable class is the interface class
* 					 that has different abstract observable methods
* 					  				  
* 
*/
public interface IObservable {

	// Declaration of different Observable method 
	void register(IObserver observer);
	void unregister(IObserver observer);
	void notifyObservers();
	
}
