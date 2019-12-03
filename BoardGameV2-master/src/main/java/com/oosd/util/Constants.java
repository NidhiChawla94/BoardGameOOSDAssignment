package com.oosd.util;

/**
* 
* @author  Siddharth Sachdeva
* @version 4.0
* @classDescription  Class defines all the constants used in the game   				  
* 					 like piece name, image location, strength of the
* 					 piece.
*/

public interface Constants {

	String EMPTY = "";
	
	String XMEN = "XMen";
	String CHARLES = "Charles";
	String WOLVERINE = "Wolverine";
	String JEAN = "Jean";
	String MAGNETO="Magneto";

	String AVENGER = "Avenger";
	String IRONMAN = "IronMan";
	String BLACKWIDOW = "Blackwidow";
	String THOR = "Thor";
	String HULK = "Hulk";

	String ID_WOLVERINE1 = "pieceWolverine1";
	String ID_WOLVERINE2 = "pieceWolverine2";
	String ID_WOLVERINE3 = "pieceWolverine3";

	String ID_JEAN1 = "pieceJean1";
	String ID_JEAN2 = "pieceJean2";
	String ID_JEAN3 = "pieceJean3";

	String ID_MAGNETO1="pieceMagneto1";
	String ID_MAGNETO2="pieceMagneto2";
	String ID_MAGNETO3="pieceMagneto3";
	String APPLICATION_TITLE = "Warrior Combat";
	String SPLASH_SCREEN = "view/SplashScreen.fxml";


	String ID_BLACKWIDOW1 = "pieceBlackWidow1";
	String ID_BLACKWIDOW2 = "pieceBlackWidow2";
	String ID_BLACKWIDOW3 = "pieceBlackWidow3";

	String ID_THOR1 = "pieceThor1";
	String ID_THOR2 = "pieceThor2";
	String ID_THOR3 = "pieceThor3";

	String ID_HULK1 = "pieceHulk1";
	String ID_HULK2 = "pieceHulk2";
	String ID_HULK3 = "pieceHulk3";


	String ID_IRONMAN = "pieceIronMan";

	String ID_CHARLES = "pieceCharlesXavier";
	String SUPERMAN = "Superman";
	String ID_SUPERMAN = "pieceSuperMan";
	String BATMAN = "Batman";
	String ID_BATMAN = "pieceBatMan";
	String BATMAN_IMAGE = "/images/Batman.png";
	String BLACK_WIDOW_IMAGE =  "/images/blackwidow.png";
	String CHARLES_XAVIER_IMAGE = "/images/CharlesXavier.png";
	String HULK_IMAGE = "/images/hulk.png";
	String IRONMAN_IMAGE = "/images/ironMan.png";
	String JEAN_IMAGE = "/images/jean.png";
	String MAGNETO_IMAGE = "/images/magneto.png";
	String WOLVERINE_IMAGE = "/images/pieceWolverine1.png";
	String SUPERMAN_IMAGE = "/images/superman.png";
	String THOR_IMAGE = "/images/Thor_featured.png";
	String ELIXIR_HEALER_IMAGE = "/images/apple.png";
	Integer MIN_COLUMN = 1;
	Integer MAX_COLUMN = 10;
	Integer MIN_ROW = 1;
	Integer MAX_ROW = 8;
	String BOARD_JSON_PATH = "src/main/resources/game_state/board.json";
	String MIND_POWER = "MIND_POWER";
	String POWER = "POWER";
	Double ASK_TO_SUICIDE_POWER_STRENGTH = 100.00;
	String POWER_GROUP = "POWER_GROUP";
	String ASK_TO_SUICIDE = "ASK_TO_SUICIDE";
	String ASK_TO_SUICIDE_POWER_IMG = ".....";
	String XMEN_LEADER = "CHARLES";
	String ELIXIR_HEALER_ID = "HEALER_ELIXIR";
	String ANTIDOTE_HEALER_ID = "HEALER_ANTIDOTE";
	String ANTIDOTE_HEALER_IMAGE = "/images/banana.png";
	int MAX_MOVES = 15;
	String TIE_MESSAGE = "It's a TIE!";
	String BURN = "BURN";
	Double BURN_STRENGTH = 200.00;
	String BURN_POWER_IMG = "images/fire.gif";
	String THUNDERSTORM_POWER = "THUNDERSTORM_POWER";
	String STORM = "STORM";
	Double STORM_STRENGTH = 150.00;
	String STORM_POWER_IMG = "images/fire.gif";
	String THUNDER = "THUNDER";
	Double THUNDER_STRENGTH = 220.00;
	String THUNDER_POWER_IMG = "images/fire.gif";
	String MAGNETIC_POWER = "MAGNETIC_POWER";
	Double MAGNETIC_POWER_STRENGTH = 300.00;
	String MAGNETIC_POWER_IMG = "images/fire.gif";
	String ANGER_POWER = "ANGER_POWER";
	Double ANGER_POWER_STRENGTH = 270.00;
	String ANGER_POWER_IMG = "images/fire.gif";
	String SMELL_POWER = "SMELL_POWER";
	Double SMELL_POWER_STRENGTH = 240.00;
	String SMELL_POWER_IMG = "images/fire.gif";
	String HEARING_POWER = "HEARING_POWER";
	Double HEARING_POWER_STRENGTH = 150.00;
	String HEARING_POWER_IMG = "images/fire.gif";
	String ELECTRICITY_POWER = "ELECTRICITY_POWER";
	Double ELECTRICITY_POWER_STRENGTH = 120.00;
	String ELECTRICITY_POWER_IMG = "images/fire.gif";
	String SNOW_POWER = "SNOW_POWER";
	Double SNOW_POWER_STRENGTH = 180.00;
	String SNOW_POWER_IMG = "images/fire.gif";
	String MAGNETIC_POWER_GROUP = "MAGNETIC_POWER_GROUP";
	String ANGER_POWER_GROUP = "ANGER_POWER_GROUP";
	String SMELL_POWER_GROUP = "SMELL_POWER_GROUP";
	String HEARING_POWER_GROUP = "HEARING_POWER_GROUP";
	String ELECTRICITY_POWER_GROUP = "ELECTRICITY_POWER_GROUP";
	String SNOW_POWER_GROUP = "SNOW_POWER_GROUP";
	int HEALER_MOVES_REQUIRED = 5;

	String ATTACK_ON_SAME_TEAM_MEMBER = "You cannot attack on member of your team!";

	String PLAYER_IN_DEFENCE_MODE = "Player you are attacking is in defence mode. Attack on another player";
	
}
