package com.oosd.piece.abstractfactory;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import com.oosd.util.Constants;

public class PieceFactoryProducer {
	
	//Singleton Pattern
	public static PieceFactoryProducer factoryProducer = new PieceFactoryProducer();
	private PieceFactoryProducer() {
		
	}
	public static PieceFactoryProducer getInstance() {
		return factoryProducer;
	}
	
	/**
	 * Factory method to produce/return a required factory. 
	 */
	@Requires("type != null && !type.isEmpty()")
	@Ensures("factory != null")
	public IPieceFactory getPieceFactory(String type){
		IPieceFactory factory = null;
		if(type.equalsIgnoreCase(Constants.XMEN)){
			 factory = new XMenPieceFactory();
			
		}else{
			factory = new AvengerPieceFactory();
		}
		return factory;
	}
	
}
