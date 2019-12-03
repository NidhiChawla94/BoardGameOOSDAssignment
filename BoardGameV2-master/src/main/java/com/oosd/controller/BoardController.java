package com.oosd.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import com.oosd.commands.AttackCommand;
import com.oosd.commands.Command;
import com.oosd.commands.CommandInvoker;
import com.oosd.commands.MoveCommand;
import com.oosd.commands.SaveCommand;
import com.oosd.healers.Healer;
import com.oosd.healers.HealerGenerator;
import com.oosd.model.Board;
import com.oosd.model.Game;
import com.oosd.model.HealerFactory;
import com.oosd.model.Location;
import com.oosd.model.Piece;
import com.oosd.model.power.Power;
import com.oosd.model.power.PowerComponent;
import com.oosd.model.power.PowerGroup;
import com.oosd.undo.momento.Caretaker;
import com.oosd.undo.momento.Originator;
import com.oosd.util.Validator;
/**
* 
*  
* @author  Nidhi Chawla
* @version 2.0
* @classDescription Provides all the information that view
* 					requires from Model. Is responsible for requesting of commands 
* 					to the Commands Invoker.
* 
* 
*/

public class BoardController {
	
	private Game game = Game.getInstance();// Create single instance of Game class.
	private Board board = game.getBoard();// Get Board from Game.
	private CommandInvoker invoker = new CommandInvoker();
	private Command command;
	private boolean isEnergyNotified = false; 
	private boolean isFinishGameNotified = false;
	private boolean isPieceKilled= false;
	private Validator validator = Validator.getInstance();
	
	private static BoardController boardController = new BoardController();// Create single instance of BoardController Object (Singleton)
	
	public Originator originator = new Originator(); //Create instance of Originator object
	public Caretaker caretaker = new Caretaker(); // Create instance of Caretaker object

	private BoardController() {

	}
	/** 
	 * get the instance of BoardController
	 * @return boardController
	 */
	public static BoardController getInstance() {
		return boardController;
	}
	
	/**
	 * check if the game is finished
	 * @return isFinishGameNotified
	 */
	public boolean isFinishGameNotified() {
		return isFinishGameNotified;
	}
	
	
	/**
	 * check if the energy is notified
	 * @return isEnergyNotified
	 */
	
	public boolean isEnergyNotified() {
		return isEnergyNotified;
	}

	/**
	 * set when the player energy is notified 
	 * @param isNotified
	 */
	public void setEnergyNotified(boolean isNotified) {
		this.isEnergyNotified = isNotified;
	}
	
	
	/**
	 * set when the game 
	 * @param isNotified
	 */
	
	public void setFinishGameNotified(boolean isNotified) {
		this.isFinishGameNotified = isNotified;		
	}
	

	@Ensures("healer != null")
	public Healer generateHealer(){
		HealerGenerator healerGenerator = new HealerGenerator();
		Healer healer = healerGenerator.generateHealer();
		return healer;
		
	}
	/**
	 * 
	 * @param undoButtonClicked   Defines undo click event
	 * @param pieceId             Defines id of the piece
	 * @param destination         Defines Destination of piece.
	 * @return isValidMove        Defines valid move
	 *                            this method perform the valid movement of piece using 
	 *                            piece location and piece id.
	 * 
	 */       

	
	public boolean move(String pieceId,Location destination) {
		boolean isValidMove= false;
		try {
			Piece piece = board.getPieceById(pieceId);
			isValidMove = validator.validateMove(destination, piece, board.getPieces());
			if (isValidMove) {
				originator.set(piece);
				caretaker.addMemento(originator.createMemento());
				command = new MoveCommand(piece, destination);
				invoker.setCommand(command);
				invoker.performAction();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValidMove;
	}
	
	/**
	 * this method keeps the piece in defense state 
	 * @param pieceIdInDefenceState
	 */
	@Requires("pieceIdInDefenceState!= null, board.getPieceById(pieceIdInDefenceState)!= null")
	public void activateDefenceMode(String pieceIdInDefenceState){
		Piece pieceInDefenceState = board.getPieceById(pieceIdInDefenceState);
		board.disableOpponentCombatAbility(pieceInDefenceState.getTeamName());
		pieceInDefenceState.activateDefenceMode();
	}
	
	/**
	 * switch player's turn
	 */
	public void toggleTurn(){
		game.toggleTurn();
	}
	
	/**
	 * this method gives the list of available powers for attacking piece
	 * @param attackingPieceId
	 * @return powerNames
	 */
	@Ensures("powerNames!=null")
	public List<String> getPowerListOfPiece(String attackingPieceId){
		Piece attackingPiece = board.getPieceById(attackingPieceId);
		List<String> powerNames = new ArrayList<>();
		PowerGroup pg = (PowerGroup) attackingPiece.getPowerComponent();
		Set<PowerComponent> powerSet = pg.getPowers();
		
		for(PowerComponent powerComp : powerSet){
			powerNames.add(powerComp.getName());
		}
		return powerNames;
	}
	
	/**
	 * this method allocate powers according to the piece that 
	 * is been attacked and being attacked.
	 * @param attackingPiece
	 * @param attackedPiece
	 * @param powerName
	 */
	@Requires("powerName.length != 0 && attackedOnPiece != null && attackingPiece != null")
	@Ensures("attackedOnPiece.getLifeVolume() < old.attackedOnPiece.getLifeVolume());")
	public void attack(Piece attackingPiece, Piece attackedPiece, String powerName){
		Power power = getPowerAccordingToName(powerName, attackingPiece);
		command = new AttackCommand(attackingPiece,attackedPiece, power );
		invoker.setCommand(command);
		invoker.performAction();
	}
	
	/**
	 * Initialize power to the attacking piece
	 * @param powerName 
	 * @param attackingPiece
	 * @return powerComp
	 */
	@Requires("powerName.length != 0 && attackingPiece != null")
	public Power getPowerAccordingToName(String powerName, Piece attackingPiece){
		PowerGroup pg = (PowerGroup) attackingPiece.getPowerComponent();
		Set<PowerComponent> powerSet = pg.getPowers();
		for(PowerComponent powerComp : powerSet){
			if(powerName == powerComp.getName()){
				return (Power) powerComp;
			}
		}
		return null;
	}
	/**
	 * Get the current player name
	 * @return name
	 */
	public String getCurrentPlayerName() {

		return game.getCurrentPlayer().getName();
	}
	
	/**
	 * Saves the Game State 
	 */
	public void saveGame() {
		command = new SaveCommand(game);
		invoker.setCommand(command);
		invoker.performAction();
	}
	/**
	 * Gets the board Pieces
	 * @return pieces
	 */
	public List<Piece> getPieces() {
		return board.getPieces();
	}
	
	/**
	 * get the list of alive pieces
	 * @return getAlivePieces
	 */
	public List<Piece> getAlivePieces() {
		return board.getAlivePieces();
	}
	/**
	 * 
	 * @param  pieceId get the piece id
	 * @return possibleLocations
	 *         Get all the possible moves and location for the Piece  
	 *         
	 *         
	 */
	@Requires("pieceId.length != 0")
	public Collection<Location> getAvailableMovesForPiece(String pieceId) {
		Piece piece = board.getPieceById(pieceId);
		Collection<Location> possibleLocations = piece.getAvailableMoves(board.getPieces());
		return possibleLocations;

	}
	
	/**
	 * get the saved piece when the undo action is performed. 
	 * @return p (piece status)
	 */
	@Ensures("p != null")
	public Piece undoMove() {
		Piece p = originator.restoreFromMemento(caretaker.getMemento());
		return p; 
	}
	
	/**
	 * get the old piece from the list of pieces
	 * @param piece
	 * @return oldPiece
	 */
	
	public Piece getOldPiece(Piece piece) {
		for(Piece oldPiece : getPieces()){
			if(oldPiece.getId().equals(piece.getId())){
				return oldPiece;
			}
		}
		return null;
	}
	
	/**
	 * this method removes the old price the 
	 * @param oldPiece define the old piece 
	 * @param piece    define the list of piece
	 */
	@Ensures("getPieces().contains(piece) && !getPieces().contains(oldPiece)")
	public void replacePiece(Piece oldPiece, Piece piece) {
		getPieces().remove(oldPiece);
		getPieces().add(piece);
		
	}
	
	/**
	 * get the current player when the undo is performed.
	 * @return getCurrentPlayer
	 */
	public boolean playedAllowedToUndo() {
		return game.getCurrentPlayer().isUndoAllowed(); 
	}
	
	/**
	 * This method performs the healing action and make respective change in life volume of piece	
	 * @param healerId             define the healer id
	 * @param xCoordinateOfHealer  define the node x coordinate of healer 
	 * @param yCoordinateOfHealer  define the node y coordinate of healer 
	 * @param pieceToBeHealed      define the piece to be healed
	 */
	
	@Requires("pieceToBeHealed != null && healerId.length()!=0")
	@Ensures("pieceToBeHealed.getLifeVolume() > old.pieceToBeHealed.getLifeVolume()")
	public void heal(String healerId,int xCoordinateOfHealer, int yCoordinateOfHealer,Piece pieceToBeHealed) {
		Healer healer = null;
		healer = HealerFactory.getInstance().createHealer(healerId);	
		healer.heal(pieceToBeHealed);
		board.removeHealerFromLocation(xCoordinateOfHealer,yCoordinateOfHealer);
		
	}
	
	/**
	 * get the piece id when it is being healed.
	 * @param pieceId
	 * @return pieceToBeHealed
	 */
	public Piece getPieceById(String pieceId) {
		Piece pieceToBeHealed =  board.getPieceById(pieceId);
		return pieceToBeHealed;
	}
	
	/**
	 * set the piece in UI when it is killed
	 * @param notify
	 */
	public void notifyRerenderUI(boolean notify) {
		setPieceKilledNotified(true);
	}
	
	/**
	 * check if the piece is killed
	 * @return isPieceKilled
	 */
	public boolean isPieceKilledNotified() {
		return isPieceKilled;
	}
	
	/**
	 * set the piece killed value
	 * @param isPieceKilled
	 */
	public void setPieceKilledNotified(boolean isPieceKilled) {
		this.isPieceKilled = isPieceKilled;
	}
	
	/**
	 * get the current player when undo 
	 * event is performed
	 */
	
	public void playerPlayedUndo() {
		// TODO Auto-generated method stub
		game.getCurrentPlayer().setUndoAllowed(false);
	}
	
	/**
	 * this method validate if the desired piece is being attacked. 
	 * @param attackingPiece  define the piece that is attacking 
	 * @param attackedPiece   define the piece that is been attacked
	 * @return errorMessage   display the error message if it is the invalid attack.
	 */
	public String validateAttack(Piece attackingPiece, Piece attackedPiece) {
		String errorMessage = validator.validateAttack(attackingPiece, attackedPiece);
		return errorMessage;
	}
	

}