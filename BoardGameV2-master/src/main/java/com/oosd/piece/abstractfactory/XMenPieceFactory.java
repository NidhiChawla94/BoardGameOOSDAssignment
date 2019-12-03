package com.oosd.piece.abstractfactory;

import java.util.ArrayList;
import java.util.List;

import com.google.java.contract.Ensures;
import com.oosd.builder.PieceBuilder;
import com.oosd.model.Location;
import com.oosd.model.Piece;
import com.oosd.model.piece.xmen.CharlesXavier;
import com.oosd.model.piece.xmen.Jean;
import com.oosd.model.piece.xmen.Magneto;
import com.oosd.model.piece.xmen.Wolverine;
import com.oosd.util.Constants;
import com.oosd.util.Creator;

public class XMenPieceFactory implements IPieceFactory {

	/**
	 * This method builds leader and returns it 
	 */
	@Ensures("leader != null && leader.isAlive() && !leader.getId().isEmpty()")
	@Override
	public Piece createLeader() {
		Piece leader = new PieceBuilder().createPiece(new CharlesXavier()).buildPieceId(Constants.ID_CHARLES)
				.buildPieceName(Constants.CHARLES).buildPieceLocation(new Location(1, 5))
				.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.THUNDERSTORM_POWER))
				.buildIsAlive(true).buildTeamName(Constants.XMEN)
				.buildLifeVolume(ILeader.LIFE_VOLUME)
				.buildImagePath(Constants.CHARLES_XAVIER_IMAGE).getPiece(); 

		return leader;
	}

	/**
	 * This method builds mid level warriors and returns them 
	 */
	@Ensures("midLevelWarriors != null && midLevelWarriors.size() > 0")
	@Override
	public List<Piece> createMidLevelWarriors() {
		List<Piece> midLevelWarriors = new ArrayList<Piece>();

		midLevelWarriors.add(new PieceBuilder().createPiece(new Wolverine()).buildPieceId(Constants.ID_WOLVERINE1)
				.buildPieceName(Constants.WOLVERINE).buildPieceLocation(new Location(1, 1))
				.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.ELECTRICITY_POWER_GROUP)).buildIsAlive(true).buildTeamName(Constants.XMEN)
				.buildLifeVolume(IMidLevelWarrior.LIFE_VOLUME)
				.buildImagePath(Constants.WOLVERINE_IMAGE).getPiece());
		midLevelWarriors.add(new PieceBuilder().createPiece(new Wolverine()).buildPieceId(Constants.ID_WOLVERINE2)
				.buildPieceName(Constants.WOLVERINE).buildPieceLocation(new Location(1, 6))
				.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.ELECTRICITY_POWER_GROUP)).buildIsAlive(true).buildTeamName(Constants.XMEN)
				.buildLifeVolume(IMidLevelWarrior.LIFE_VOLUME)
				.buildImagePath(Constants.WOLVERINE_IMAGE).getPiece());
		midLevelWarriors.add(new PieceBuilder().createPiece(new Wolverine()).buildPieceId(Constants.ID_WOLVERINE3)
				.buildPieceName(Constants.WOLVERINE).buildPieceLocation(new Location(1, 7))
				.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.ELECTRICITY_POWER_GROUP)).buildIsAlive(true).buildTeamName(Constants.XMEN)
				.buildLifeVolume(IMidLevelWarrior.LIFE_VOLUME)
				.buildImagePath(Constants.WOLVERINE_IMAGE).getPiece());

		midLevelWarriors.add(new PieceBuilder().createPiece(new Magneto()).buildPieceId(Constants.ID_MAGNETO1)
				.buildPieceName(Constants.MAGNETO).buildPieceLocation(new Location(1, 2))
				.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.MAGNETIC_POWER_GROUP)).buildIsAlive(true).buildTeamName(Constants.XMEN)
				.buildLifeVolume(IMidLevelWarrior.LIFE_VOLUME)
				.buildImagePath(Constants.MAGNETO_IMAGE).getPiece());
		midLevelWarriors.add(new PieceBuilder().createPiece(new Magneto()).buildPieceId(Constants.ID_MAGNETO2)
				.buildPieceName(Constants.MAGNETO).buildPieceLocation(new Location(1, 3))
				.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.MAGNETIC_POWER_GROUP)).buildIsAlive(true).buildTeamName(Constants.XMEN)
				.buildLifeVolume(IMidLevelWarrior.LIFE_VOLUME)
				.buildImagePath(Constants.MAGNETO_IMAGE).getPiece());
		midLevelWarriors.add(new PieceBuilder().createPiece(new Magneto()).buildPieceId(Constants.ID_MAGNETO3)
				.buildPieceName(Constants.MAGNETO).buildPieceLocation(new Location(1, 9))
				.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.MAGNETIC_POWER_GROUP)).buildIsAlive(true).buildTeamName(Constants.XMEN)
				.buildLifeVolume(IMidLevelWarrior.LIFE_VOLUME)
				.buildImagePath(Constants.MAGNETO_IMAGE).getPiece());

		return midLevelWarriors;
	}

	/**
	 * This method builds low level warriors and returns them 
	 */
	@Ensures("lowLevelWarriors != null && lowLevelWarriors.size() > 0")
	@Override
	public List<Piece> createLowLevelWarriors() {
		List<Piece> lowLevelWarriors = new ArrayList<Piece>();

		lowLevelWarriors.add(new PieceBuilder().createPiece(new Jean()).buildPieceId(Constants.ID_JEAN1)
				.buildPieceName(Constants.JEAN).buildPieceLocation(new Location(1, 10))
				.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.SMELL_POWER_GROUP)).buildIsAlive(true).buildTeamName(Constants.XMEN)
				.buildLifeVolume(ILowLevelWarrior.LIFE_VOLUME)
				.buildImagePath(Constants.JEAN_IMAGE).getPiece());
		lowLevelWarriors.add(new PieceBuilder().createPiece(new Jean()).buildPieceId(Constants.ID_JEAN2)
				.buildPieceName(Constants.JEAN).buildPieceLocation(new Location(1, 4))
				.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.SMELL_POWER_GROUP)).buildIsAlive(true).buildTeamName(Constants.XMEN)
				.buildLifeVolume(ILowLevelWarrior.LIFE_VOLUME)
				.buildImagePath(Constants.JEAN_IMAGE).getPiece());
		lowLevelWarriors.add(new PieceBuilder().createPiece(new Jean()).buildPieceId(Constants.ID_JEAN3)
				.buildPieceName(Constants.JEAN).buildPieceLocation(new Location(1, 8))
				.buildPiecePowerComponent(Creator.getInstance().getPowerComponentByName(Constants.SMELL_POWER_GROUP)).buildIsAlive(true).buildTeamName(Constants.XMEN)
				.buildLifeVolume(ILowLevelWarrior.LIFE_VOLUME)
				.buildImagePath(Constants.JEAN_IMAGE).getPiece());

		return lowLevelWarriors;
	}
}
