package com.oosd.model.power;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.java.contract.Requires;
import com.oosd.model.Piece;

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDescription  PowerComponent is the abstract class
* 					 which defines the attack method
* 					  				  
* 
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({ @JsonSubTypes.Type(value = Power.class, name = "Power"),
		@JsonSubTypes.Type(value = PowerGroup.class, name = "PowerGroup") })
public abstract class PowerComponent {
	
	private String name; // Declare the power name
	private String type; // Declare the power type

	public PowerComponent() {
		
	}
	
	/**
	 * CONSTRUCTOR
	 * @param name declare the power name
	 * @param type declare the power type
	 */
	public PowerComponent(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public abstract void attack(Power power, Piece attackedOnPiece);
	
	/**
	 * get the power name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the power name
	 * @param name
	 */
	@Requires("name != null && !name.isEmpty()")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the power type
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * set the power type
	 * @param type
	 */
	@Requires("type != null && !type.isEmpty()")
	public void setType(String type) {
		this.type = type;
	}
}
