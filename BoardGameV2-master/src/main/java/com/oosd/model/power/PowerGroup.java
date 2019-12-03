package com.oosd.model.power;

import java.util.HashSet;
import java.util.Set;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;
import com.oosd.model.Piece;

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDescription  PowerGroup extends the PowerComponent
* 					 that implements the attack method
* 					  				  
* 
*/
@Invariant("powerComponents.size() >= 0")
public class PowerGroup extends PowerComponent {

	private Set<PowerComponent> powerComponents = new HashSet<PowerComponent>(); // Declare the list of power components
	
	/**
	 * CONSTRUCTOR
	 */
	public PowerGroup() {
		super();
	}
	/**
	 * CONSTRUCTOR
	 * @param name define power name
	 * @param type define power type
	 */
	public PowerGroup(String name, String type) {
		super(name, type);
	}

	/**
	 * this method perform the attack operation 
	 * and validate that the attacked piece has sufficient 
	 * life volume
	 */
	@Requires("power != null && attackedOnPiece != null")
	@Ensures("attackedOnPiece.getLifeVolume() < old.attackedOnPiece.getLifeVolume());")
	@Override
	public void attack(Power power, Piece attackedOnPiece) {
		power.attack(power, attackedOnPiece);
	}
	
	/**
	 * This method add the power component 
	 * to power list
	 * @param power
	 */
	@Requires("power != null")
	@Ensures("old.powerComponents.size() + 1 == powerComponents.size()")
	public void addPower(PowerComponent power){
		powerComponents.add(power);
	}
	
	/**
	 * removes the power component
	 * @param power
	 */
	@Requires("power != null")
	@Ensures("old.powerComponents.size() - 1 == powerComponents.size()")
	public void removePower(PowerComponent power){
		powerComponents.remove(power);
	}
	
	/**
	 * get the power component 
	 * @param type
	 * @return powerComponent
	 */
	public PowerComponent getPowerComponent(String type){
		for(PowerComponent powerComponent : powerComponents){
			if(powerComponent.getType().equalsIgnoreCase(type)){
				return powerComponent;

			}
		}
		return null;
	}
	
	/**
	 * set the power components
	 * @return powerComponents
	 */
	public Set<PowerComponent> getPowers(){
		return powerComponents;
	}
}
