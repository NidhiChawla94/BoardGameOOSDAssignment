package com.oosd.model;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import com.oosd.builder.PieceBuilder;
import com.oosd.healers.IPieceHealer;
import com.oosd.model.piece.avenger.Avenger;
import com.oosd.model.piece.avenger.BlackWidow;
import com.oosd.model.piece.avenger.Hulk;
import com.oosd.model.piece.avenger.IronMan;
import com.oosd.model.piece.avenger.Thor;
import com.oosd.model.piece.xmen.CharlesXavier;
import com.oosd.model.piece.xmen.Jean;
import com.oosd.model.piece.xmen.Magneto;
import com.oosd.model.piece.xmen.Wolverine;
import com.oosd.model.piece.xmen.XMen;
import com.oosd.model.power.PowerComponent;
import com.oosd.util.Constants;

/**
 * 
 * @author Siddharth Sachdeva
 * @version 1.0
 * @param <T>
 * @classDescription This class assigns the player attributes of the game
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({ @JsonSubTypes.Type(value = Avenger.class, name = "Avenger"),
		@JsonSubTypes.Type(value = XMen.class, name = "XMen"),
		@JsonSubTypes.Type(value = BlackWidow.class, name = "BlackWidow"),
		@JsonSubTypes.Type(value = Hulk.class, name = "Hulk"),
		@JsonSubTypes.Type(value = IronMan.class, name = "IronMan"),
		@JsonSubTypes.Type(value = Thor.class, name = "Thor"),
		@JsonSubTypes.Type(value = CharlesXavier.class, name = "CharlesXavier"),
		@JsonSubTypes.Type(value = Jean.class, name = "Jean"),
		@JsonSubTypes.Type(value = Magneto.class, name = "Magneto"),
		@JsonSubTypes.Type(value = Wolverine.class, name = "Wolverine") })

public abstract class Piece implements Cloneable, IPieceHealer {
	// Instance Variables
	private String id; // Declaration of Piece id.
	private String name; // Declaration of Piece name
	private Location location;  // Declaration of location reference object of location class.
	private PowerComponent powerComponent; // Declaration of powerComponent reference object of PowerComponent class.
	private boolean isAlive; // check the player status (alive/killed)
	private String teamName; // Declaration of team name
	private String imagePath; // Declaration of piece image path
	private boolean defenceMode; // check the defense mode (active/inactive)
	private double lifeVolume; // Declare the life volume

	/**
	 * CONSTRUCTOR
	 */
	public Piece() {
		super();
	}

	// public abstract Piece capture(Piece capturedPiece, Creator helper);

	/**
	 * Clone the piece and return it.
	 */
	@Override
	protected Piece clone() {
		try {
			return (Piece) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Get the Piece Image Path
	 * 
	 * @return imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * Set the piece Image Path
	 * 
	 * @param imagePath
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * Get the piece id
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the Piece id
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * get the piece name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the piece name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the piece location
	 * 
	 * @return location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * set the piece Location
	 * 
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * get the power component of piece
	 * 
	 * @return powers
	 */
	public PowerComponent getPowerComponent() {
		return powerComponent;
	}

	/**
	 * Set the Power component of Piece
	 * 
	 * @param powers
	 */

	public void setPowerComponent(PowerComponent powerComponent) {
		this.powerComponent = powerComponent;
	}

	/**
	 * check if the plyer is alive
	 * @return isAlive
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * 
	 * @param isAlive
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	/**
	 * get the piece team name 
	 * @return teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * set the piece team name
	 * @param teamName
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * Activate the defense mode
	 */
	public void activateDefenceMode() {
		this.defenceMode = true;
	}

	/**
	 * Disable the defense mode
	 */
	public void disableDefenceMode() {
		this.defenceMode = false;
	}

	/**
	 * check if the defense mode is enabled 
	 * for piece
	 * @return defenceMode
	 */
	public boolean isDefenceModeEnabled() {
		return defenceMode;
	}

	/**
	 * get the life volume
	 * return lifeVolume
	 */
	@Override
	public double getLifeVolume() {
		return lifeVolume;
	}

	/**
	 * set the life volume
	 * @param lifeVolume
	 */
	public void setLifeVolume(double lifeVolume) {
		this.lifeVolume = lifeVolume;
	}

	/**
	 * 
	 * @param pieces Defines the collection of pieces
	 * @return possibleLocations This method get all the possible moves of the
	 *         pieces by validating the move from current piece location.
	 */

	@Requires("pieces != null && pieces.size() > 0")
	@Ensures("possibleLocations != null")
	public Collection<Location> getAvailableMoves(Collection<Piece> pieces) {
		Collection<Location> possibleLocations = new ArrayList<>();
		possibleLocations
				.add(new Location(this.getLocation().getxCoordinate() + 1, this.getLocation().getyCoordinate()));
		possibleLocations
				.add(new Location(this.getLocation().getxCoordinate() - 1, this.getLocation().getyCoordinate()));
		possibleLocations
				.add(new Location(this.getLocation().getxCoordinate(), this.getLocation().getyCoordinate() + 1));
		possibleLocations
				.add(new Location(this.getLocation().getxCoordinate(), this.getLocation().getyCoordinate() - 1));
		possibleLocations
				.add(new Location(this.getLocation().getxCoordinate() + 1, this.getLocation().getyCoordinate() + 1));
		possibleLocations
				.add(new Location(this.getLocation().getxCoordinate() - 1, this.getLocation().getyCoordinate() - 1));
		possibleLocations
				.add(new Location(this.getLocation().getxCoordinate() + 1, this.getLocation().getyCoordinate() - 1));

		possibleLocations
				.add(new Location(this.getLocation().getxCoordinate() - 1, this.getLocation().getyCoordinate() + 1));
		Collection<Piece> validateOnPieces = new ArrayList<Piece>(pieces);
		validateOnPieces.remove(this);
		Collection<Location> temporaryPossibleLocations = new ArrayList<>(possibleLocations);
		for (Location location : temporaryPossibleLocations) {
			for (Piece currentPiece : validateOnPieces) {

				boolean isOtherPieceOnCurrentLocation = currentPiece.getLocation().getxCoordinate() == location.getxCoordinate()
						&& currentPiece.getLocation().getyCoordinate() == location.getyCoordinate();
				if (isOtherPieceOnCurrentLocation) {
					possibleLocations.remove(location);
				}

				// is first or last row
				// is first or last column
				if (location.getyCoordinate() < Constants.MIN_COLUMN
						|| location.getyCoordinate() > Constants.MAX_COLUMN) {
					possibleLocations.remove(location);
				} else if (location.getxCoordinate() < Constants.MIN_ROW
						|| location.getxCoordinate() > Constants.MAX_ROW) {
					possibleLocations.remove(location);
				}
			}
		}
		return possibleLocations;

	}

	/**
	 * Prototype pattern is implemented  and the cloning of piece
	 *  operation is performed
	 * @return piece
	 */
	// Prototype pattern
	public Piece clonePiece() {
		Piece piece = null;
		try {
			Class<? extends Piece> pieceClass = this.getClass();
			piece = (Piece) pieceClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return new PieceBuilder().createPiece(piece).buildPieceId(this.getId()).buildPieceName(this.getName())
				.buildPieceLocation(this.getLocation()).buildPiecePowerComponent(this.getPowerComponent())
				.buildIsAlive(this.isAlive()).buildTeamName(this.getTeamName()).buildImagePath(this.getImagePath())
				.getPiece();
	}

}
