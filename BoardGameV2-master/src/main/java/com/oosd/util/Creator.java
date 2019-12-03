package com.oosd.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.oosd.model.Board;
import com.oosd.model.Game;
import com.oosd.model.Piece;
import com.oosd.model.Player;
import com.oosd.model.power.Power;
import com.oosd.model.power.PowerComponent;
import com.oosd.model.power.PowerGroup;
import com.oosd.piece.abstractfactory.IPieceFactory;
import com.oosd.piece.abstractfactory.PieceFactoryProducer;

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDescription  This class creates the main objects requires .   				  
* 					 to setup and run the game.
*/

public class Creator {

	private static Creator creator = new Creator();// Declaration of creator reference object of Creator Class.

	private PowerGroup mindPowerComponentGroup,thunderStormPowerComponentGroup;

	private PowerGroup magneticPowerGroup, angerPowerGroup,smellPowerGroup,hearingPowerGroup, electricityPowerGroup, snowPowerGroup;
	
	
	/**
	 * get the creator instance 
	 * @return creator
	 */
	public static Creator getInstance() {
		return creator;
	}
	
	private Creator() {

	}

	

	public void createPowers() {
		mindPowerComponentGroup = new PowerGroup(Constants.MIND_POWER, Constants.POWER_GROUP);
		PowerComponent askToSuicidePower = new Power(Constants.ASK_TO_SUICIDE, Constants.POWER,
				Constants.ASK_TO_SUICIDE_POWER_STRENGTH, Constants.ASK_TO_SUICIDE_POWER_IMG);
		PowerComponent burnPower = new Power(Constants.BURN, Constants.POWER,
				Constants.BURN_STRENGTH, Constants.BURN_POWER_IMG);
		
		mindPowerComponentGroup.addPower(askToSuicidePower);
		mindPowerComponentGroup.addPower(burnPower);
		
		thunderStormPowerComponentGroup = new PowerGroup(Constants.THUNDERSTORM_POWER, Constants.POWER_GROUP);
		PowerComponent stormPower = new Power(Constants.STORM, Constants.POWER,
				Constants.STORM_STRENGTH, Constants.STORM_POWER_IMG);
		PowerComponent thunderPower = new Power(Constants.THUNDER, Constants.POWER,
				Constants.THUNDER_STRENGTH, Constants.THUNDER_POWER_IMG);		
		thunderStormPowerComponentGroup.addPower(stormPower);
		thunderStormPowerComponentGroup.addPower(thunderPower);
		
		magneticPowerGroup = new PowerGroup(Constants.MAGNETIC_POWER_GROUP, Constants.POWER_GROUP);
		PowerComponent magneticPower = new Power(Constants.MAGNETIC_POWER, Constants.POWER,
				Constants.MAGNETIC_POWER_STRENGTH, Constants.MAGNETIC_POWER_IMG);
		magneticPowerGroup.addPower(magneticPower);
		
		angerPowerGroup = new PowerGroup(Constants.ANGER_POWER_GROUP, Constants.POWER_GROUP);
		PowerComponent angerPower = new Power(Constants.ANGER_POWER, Constants.POWER,
				Constants.ANGER_POWER_STRENGTH, Constants.ANGER_POWER_IMG);
		angerPowerGroup.addPower(angerPower);
		
		smellPowerGroup = new PowerGroup(Constants.SMELL_POWER_GROUP, Constants.POWER_GROUP);
		PowerComponent smellPower = new Power(Constants.SMELL_POWER, Constants.POWER,
				Constants.SMELL_POWER_STRENGTH, Constants.SMELL_POWER_IMG);
		smellPowerGroup.addPower(smellPower);
		
		hearingPowerGroup = new PowerGroup(Constants.HEARING_POWER_GROUP, Constants.POWER_GROUP);
		PowerComponent hearingPower = new Power(Constants.HEARING_POWER, Constants.POWER,
				Constants.HEARING_POWER_STRENGTH, Constants.HEARING_POWER_IMG);
		hearingPowerGroup.addPower(hearingPower);
		
		electricityPowerGroup = new PowerGroup(Constants.ELECTRICITY_POWER_GROUP, Constants.POWER_GROUP);
		PowerComponent electricityPower = new Power(Constants.ELECTRICITY_POWER, Constants.POWER,
				Constants.ELECTRICITY_POWER_STRENGTH, Constants.ELECTRICITY_POWER_IMG);
		electricityPowerGroup.addPower(electricityPower);
		
		snowPowerGroup = new PowerGroup(Constants.SNOW_POWER_GROUP, Constants.POWER_GROUP);
		PowerComponent snowPower = new Power(Constants.SNOW_POWER, Constants.POWER,
				Constants.SNOW_POWER_STRENGTH, Constants.SNOW_POWER_IMG);
		snowPowerGroup.addPower(snowPower);
	}

	public Board createBoard(boolean startNewGame) {
		Game.getInstance().createBoard();
		Board board = null;
		
		createPowers();
		
		if (startNewGame) {
			IPieceFactory xMenPieceFactory = PieceFactoryProducer.getInstance().getPieceFactory(Constants.XMEN);
			List<Piece> pieces = new ArrayList<Piece>();

			pieces.add(xMenPieceFactory.createLeader());
			pieces.addAll(xMenPieceFactory.createMidLevelWarriors());
			pieces.addAll(xMenPieceFactory.createLowLevelWarriors());

			IPieceFactory avengerPieceFactory = PieceFactoryProducer.getInstance().getPieceFactory(Constants.AVENGER);
			pieces.add(avengerPieceFactory.createLeader());
			pieces.addAll(avengerPieceFactory.createMidLevelWarriors());
			pieces.addAll(avengerPieceFactory.createLowLevelWarriors());

			board = Game.getInstance().getBoard();
			board.setPieces(pieces);

			
			Player player1 = new Player(1, 0.0, Constants.AVENGER);
			Player player2 = new Player(2, 0.0, Constants.XMEN);
			List<Player> players = new ArrayList<>();
			players.add(player1);
			players.add(player2);
			Game game = Game.getInstance();
			game.setBoard(board);
			game.setPlayers(players);
			game.setCurrentPlayer(game.getPlayers().get(0));
		} else {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

			try {
				Game.getInstance().setGame(mapper.readValue(new File(Constants.BOARD_JSON_PATH), Game.class));
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return board;
	}

	public PowerComponent getPowerComponentByName(String componentName) {
		switch (componentName) {
		case Constants.MIND_POWER:
			return mindPowerComponentGroup;
		case Constants.THUNDERSTORM_POWER:	
			return thunderStormPowerComponentGroup;
		case Constants.MAGNETIC_POWER_GROUP:
			return magneticPowerGroup;	
		case Constants.ANGER_POWER_GROUP:
			return angerPowerGroup;
		case Constants.SMELL_POWER_GROUP:
			return smellPowerGroup;
		case Constants.HEARING_POWER_GROUP:
			return hearingPowerGroup;
		case Constants.ELECTRICITY_POWER_GROUP:
			return electricityPowerGroup;
		case Constants.SNOW_POWER_GROUP:	
			return snowPowerGroup;
		}
		return null;
	}

}