package com.oosd.builder;

import com.oosd.model.Location;
import com.oosd.model.Piece;
import com.oosd.model.power.PowerComponent;
/**
* @author  Siddharth Sachdeva
* @version 1.0
* @classDesciption IPieceBuilder interface class defines the attributes
* 				   of piece
*             
*/
public interface IPieceBuilder {

	PieceBuilder createPiece(Piece piece); // Define piece reference object of class piece. 
	PieceBuilder buildPieceId(String id); // Define Piece id
	PieceBuilder buildPieceName(String name); // Define Piece name
	PieceBuilder buildPieceLocation(Location location); // Define location reference object of class Board. 
	PieceBuilder buildPiecePowerComponent(PowerComponent powerComponent);// Define powerComponent reference object of PowerComponent class. 
	PieceBuilder buildIsAlive(boolean isAlive); //Define isAlive to check piece status 
	PieceBuilder buildTeamName(String teamName); //Define team name
	PieceBuilder buildLifeVolume(Double lifeVolume); // Define Life volume
	PieceBuilder buildImagePath(String imagePath); // Define piece image path
	Piece getPiece();// Get the piece id 
	
}
