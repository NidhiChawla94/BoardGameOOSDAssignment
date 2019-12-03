package com.oosd.piece.abstractfactory;

import java.util.ArrayList;
import java.util.List;

import com.google.java.contract.Ensures;
import com.oosd.builder.PieceBuilder;
import com.oosd.model.Location;
import com.oosd.model.Piece;
import com.oosd.model.piece.avenger.BlackWidow;
import com.oosd.model.piece.avenger.Hulk;
import com.oosd.model.piece.avenger.IronMan;
import com.oosd.model.piece.avenger.Thor;
import com.oosd.util.Constants;
import com.oosd.util.Creator;

public class AvengerPieceFactory implements IPieceFactory {

	/**
	 * This method builds leader and returns it 
	 */
	@Ensures("leader != null && leader.isAlive() && !leader.getId().isEmpty()")
	@Override
	public Piece createLeader() {
		return new PieceBuilder().createPiece(new IronMan()).buildPieceId(Constants.ID_IRONMAN)
				.buildPieceName(Constants.IRONMAN).buildPieceLocation(new Location(8, 5))
				.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.MIND_POWER))
				.buildIsAlive(true).buildTeamName(Constants.AVENGER)
				.buildLifeVolume(ILeader.LIFE_VOLUME)
				.buildImagePath(Constants.IRONMAN_IMAGE).getPiece();
	}

	/**
	 * This method builds mid level warriors and returns them 
	 */
	@Ensures("midLevelWarriors != null && midLevelWarriors.size() > 0")
	@Override
	public List<Piece> createMidLevelWarriors() {
		List<Piece> midLevelWarriors = new ArrayList<Piece>();
		
		midLevelWarriors.add(new PieceBuilder().createPiece(new Hulk()).buildPieceId(Constants.ID_HULK1)
					.buildPieceName(Constants.HULK).buildPieceLocation(new Location(8, 1))
					.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.ANGER_POWER_GROUP))
					.buildIsAlive(true).buildTeamName(Constants.AVENGER)
					.buildLifeVolume(IMidLevelWarrior.LIFE_VOLUME)
					.buildImagePath(Constants.HULK_IMAGE).getPiece());
		
		
		midLevelWarriors.add(new PieceBuilder().createPiece(new Hulk()).buildPieceId(Constants.ID_HULK2)
					.buildPieceName(Constants.HULK).buildPieceLocation(new Location(8, 6))
					.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.ANGER_POWER_GROUP))
					.buildIsAlive(true).buildTeamName(Constants.AVENGER)
					.buildLifeVolume(IMidLevelWarrior.LIFE_VOLUME)
					.buildImagePath(Constants.HULK_IMAGE).getPiece());
		
		midLevelWarriors.add(new PieceBuilder().createPiece(new Hulk()).buildPieceId(Constants.ID_HULK3)
					.buildPieceName(Constants.HULK).buildPieceLocation(new Location(8, 9))
					.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.ANGER_POWER_GROUP))
					.buildIsAlive(true).buildTeamName(Constants.AVENGER)
					.buildLifeVolume(IMidLevelWarrior.LIFE_VOLUME)
					.buildImagePath(Constants.HULK_IMAGE).getPiece());
		
		midLevelWarriors.add(new PieceBuilder().createPiece(new Thor()).buildPieceId(Constants.ID_THOR1)
					.buildPieceName(Constants.THOR).buildPieceLocation(new Location(8, 2))
					.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.SNOW_POWER_GROUP))
					.buildIsAlive(true).buildTeamName(Constants.AVENGER)
					.buildLifeVolume(IMidLevelWarrior.LIFE_VOLUME)
					.buildImagePath(Constants.THOR_IMAGE).getPiece());
		
		
		midLevelWarriors.add(new PieceBuilder().createPiece(new Thor()).buildPieceId(Constants.ID_THOR2)
					.buildPieceName(Constants.THOR).buildPieceLocation(new Location(8, 4))
					.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.SNOW_POWER_GROUP))
					.buildIsAlive(true).buildTeamName(Constants.AVENGER)
					.buildLifeVolume(IMidLevelWarrior.LIFE_VOLUME)
					.buildImagePath(Constants.THOR_IMAGE).getPiece());
		
		midLevelWarriors.add(new PieceBuilder().createPiece(new Thor()).buildPieceId(Constants.ID_THOR3)
					.buildPieceName(Constants.THOR).buildPieceLocation(new Location(8, 7))
					.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.SNOW_POWER_GROUP))
					.buildIsAlive(true).buildTeamName(Constants.AVENGER)
					.buildLifeVolume(IMidLevelWarrior.LIFE_VOLUME)
					.buildImagePath(Constants.THOR_IMAGE).getPiece());
	
		return midLevelWarriors;
	}
	
	/**
	 * This method builds low level warriors and returns them 
	 */
	@Ensures("lowLevelWarriors != null && lowLevelWarriors.size() > 0")
	@Override
	public List<Piece> createLowLevelWarriors() {
		List<Piece> lowLevelWarriors = new ArrayList<Piece>();
		
		lowLevelWarriors.add(new PieceBuilder().createPiece(new BlackWidow()).buildPieceId(Constants.ID_BLACKWIDOW1)
					.buildPieceName(Constants.BLACKWIDOW).buildPieceLocation(new Location(8, 10))
					.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.HEARING_POWER_GROUP))
					.buildIsAlive(true).buildTeamName(Constants.AVENGER)
					.buildLifeVolume(ILowLevelWarrior.LIFE_VOLUME)
					.buildImagePath(Constants.BLACK_WIDOW_IMAGE).getPiece());
		
		lowLevelWarriors.add(new PieceBuilder().createPiece(new BlackWidow()).buildPieceId(Constants.ID_BLACKWIDOW2)
					.buildPieceName(Constants.BLACKWIDOW).buildPieceLocation(new Location(8, 3))
					.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.HEARING_POWER_GROUP))
					.buildIsAlive(true).buildTeamName(Constants.AVENGER)
					.buildLifeVolume(ILowLevelWarrior.LIFE_VOLUME)
					.buildImagePath(Constants.BLACK_WIDOW_IMAGE).getPiece());
		
		lowLevelWarriors.add(new PieceBuilder().createPiece(new BlackWidow()).buildPieceId(Constants.ID_BLACKWIDOW3)
					.buildPieceName(Constants.BLACKWIDOW).buildPieceLocation(new Location(8, 8))
					.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.HEARING_POWER_GROUP))
					.buildIsAlive(true).buildTeamName(Constants.AVENGER)
					.buildLifeVolume(ILowLevelWarrior.LIFE_VOLUME)
					.buildImagePath(Constants.BLACK_WIDOW_IMAGE).getPiece());
		
		return lowLevelWarriors;
	}

}
