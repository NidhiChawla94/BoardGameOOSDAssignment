package com.oosd.piece.abstractfactory;

import java.util.List;

import com.oosd.model.Piece;

public interface IPieceFactory {
	
	public Piece createLeader();
	public List<Piece> createMidLevelWarriors();
	public List<Piece> createLowLevelWarriors();
	

}
