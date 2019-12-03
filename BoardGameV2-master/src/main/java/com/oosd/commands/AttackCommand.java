package com.oosd.commands;

import com.google.java.contract.Invariant;
import com.oosd.model.Piece;
import com.oosd.model.power.Power;


/**
* 
* @author  Nidhi Chawla
* @version 1.0
* @classDescription Concrete command class for Attack Command.
* 
*/
@Invariant("power!=null,attackingPiece!=null,attackedPiece!=null")
public class AttackCommand implements Command{

    private Piece attackingPiece, attackedPiece ; // declare piece reference variables 
    Power power; // power reference object of class power
    
    /**
     * CONSTRUCTOR
     * 
     * @param attackingPiece the piece in the attacking mode
     * @param attackedPiece  the piece in the attacked mode
     * @param powerType      define the mode of attack(attack/defense)
     * 					     method defines the piece that is under attack 
     * 						 and attacking piece.
     *          
     */
    
    public AttackCommand(Piece attackingPiece, Piece attackedPiece, Power power) {
        super();
        this.attackingPiece = attackingPiece;
        this.attackedPiece = attackedPiece;
        this.power = power;
    }

    /**
     * method that fetch the power component for 
     * the attacking piece. 
     */
    @Override
    public void execute() {
        attackingPiece.getPowerComponent().attack(power,attackedPiece);
    }

}
