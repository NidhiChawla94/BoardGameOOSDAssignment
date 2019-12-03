package com.oosd.model;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import com.oosd.healers.AntidoteHealer;
import com.oosd.healers.ElixirHealer;
import com.oosd.healers.Healer;
import com.oosd.util.Constants;

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDesciption The Healing factory Class program generates the
* 					Antitode and Elixir healing element 
* 				   
* 
*/
public class HealerFactory {
	
	public static HealerFactory factory = new HealerFactory(); // Create the factory object for healer factory class.
	
	private HealerFactory(){
		
	}
	
	/**
	 * get the instance for HealerFactory
	 * @return factory
	 */
	public static HealerFactory getInstance(){
		return factory;
	}

	/**
	 * this method create the new type of healing element
	 * @param healerId
	 * @return healer
	 */
	@Requires("healerId != null && !headerId.isEmpty()")
	@Ensures("healer != null")
	public Healer createHealer(String healerId) {
		Healer healer;
		if(healerId.equalsIgnoreCase(Constants.ANTIDOTE_HEALER_ID)){
			healer = new AntidoteHealer();
		}else{
			healer = new ElixirHealer();
		}
		return healer;
	}
	
}
