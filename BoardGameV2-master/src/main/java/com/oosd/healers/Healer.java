package com.oosd.healers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.oosd.model.Location;
import com.oosd.model.Piece;


/**
* @author  Siddharth Sachdeva
* @version 1.0
* @classDesciption Healer is the abstract class that contains the information of healing piece
*             
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({ @JsonSubTypes.Type(value = ElixirHealer.class, name = "ElixirHealer"),
		@JsonSubTypes.Type(value = AntidoteHealer.class, name = "AntidoteHealer") })
public abstract class Healer implements IPieceHealer {

	private String imagePath; // Declare the piece image path
	private String healerId; // declare the piece of healer id
	private Location location; // location reference object of Location class 
	private Piece piece;	// piece reference object of Piece class  

	//Abstract method that perform heal operation on piece
	public abstract void heal(Piece piece);
	
	/**
	 * get the healer piece location
	 * @return location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * set the healer piece location
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	
	/**
	 * get the piece
	 * @return piece
	 */
	public Piece getPiece() {
		return piece;
	}

	/**
	 * set the piece
	 * @param piece
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	/**
	 * get the image path of piece
	 * @return imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * set the image path of piece
	 * @param imagePath
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * get the healer id of piece
	 * @return healerId
	 */
	public String getHealerId() {
		return healerId;
	}

	/**
	 * set the healer id of piece
	 * @param healerId
	 */
	public void setHealerId(String healerId) {
		this.healerId = healerId;
	}
	
}
