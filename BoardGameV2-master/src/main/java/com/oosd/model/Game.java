package com.oosd.model;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.java.contract.Ensures;

/**
 * 
 * @author Siddharth Sachdeva
 * @version 1.0
 * @classDesciption Game Class program attributes are defined and defines the
 *                  Format of the game.
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {
	// Instance Variables.
	private int id;// Declaration of Game id.
	private String gameName;// Declaration of Game Name.
	private Board board; // Declaration of board reference object of Board Class
	private List<Player> players;// Declaration of Players list.
	private Player currentPlayer; // Declaration of CurrentPlayer reference object of Player Class.

	/**
	 * Get the current player information
	 * 
	 * @return currentPlayer
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * Sets the CurrentPlayer
	 * 
	 * @param currentPlayer
	 */
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	private static Game game = new Game(); // Create single instance of game object (Singleton).

	private Game() {

	}

	public void createBoard() {
		board = new Board();
	}

	/**
	 * get the instance of game
	 * 
	 * @return game
	 */
	public static Game getInstance() {
		return game;
	}

	/**
	 * get the game id
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the game id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * set the game name
	 * 
	 * @return gameName
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * Set the game name
	 * 
	 * @param gameName
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * get the board instance
	 * 
	 * @return board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Set the board instance
	 * 
	 * @param board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * get the players list.
	 * 
	 * @return players
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * Set the players list
	 * 
	 * @param players
	 */
	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	/**
	 * get the game instance
	 * 
	 * @return game
	 */
	public static Game getGame() {
		return game;
	}

	/**
	 * set the game instance
	 * 
	 * @param game
	 */

	public void setGame(Game game) {
		Game.game = game;
	}

	/**
	 * Switch the turns between the players
	 */
	// Toggle the players turn.
	@Ensures("!old.currentPlayer.equals(currentPlayer)")
	public void toggleTurn() {
		List<Player> players = this.getPlayers();
		Player currentPlayer = this.getCurrentPlayer();
		Player player = null;

		if (currentPlayer == null) {
			player = players.get(0);
		} else {
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).getId() == currentPlayer.getId()) {
					if (i == (players.size() - 1)) {
						player = players.get(0);
						break;
					} else {
						player = players.get(i + 1);
						break;
					}
				}
			}
		}
		this.setCurrentPlayer(player);
	}

	/**
	 * Method saves the current state of the game
	 */
	public void saveGame() {
		// Convert object to JSON string and save into a file directly
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			mapper.writeValue(new File("src/main/resources/game_state/board.json"), game);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * get the winner of game
	 * @return determineGameWinner
	 */
	public Player getWinner() {
		return determineGameWinner();
	}

	/**
	 * this method determines the winner of the game 
	 * based on the player 1 and player 2 pieces life volume
	 * @return null
	 */
	private Player determineGameWinner() {
		Double player1Score = 0.00, player2Score = 0.00;
		Player player1 = players.get(0);
		Player player2 = players.get(1);

		for (Piece piece : getBoard().getPiecesByTeam(player1.getName())) {
			player1Score += piece.getLifeVolume();

		}
		player1.setScore(player1Score);

		for (Piece piece : getBoard().getPiecesByTeam(player2.getName())) {
			try {
			player2Score += piece.getLifeVolume();
			}
			catch(NullPointerException e)
			{
				player1Score += 0;
			}
		}
		player2.setScore(player2Score);
		if (player1.getScore() > player2.getScore()) {
			return player1;
		}else if (player2.getScore() > player1.getScore()){
			return player2;
		}
		return null;
	}
}
