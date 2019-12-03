package com.oosd.commands;

import com.google.java.contract.Invariant;

/**
 * 
 * @author  Nidhi Chawla
 * @version 1.0
 * @classDescription CommandInvoker defines the command 
 * 
 */

@Invariant("command!=null")
public class CommandInvoker {
	
	private Command command; //command reference object of command class
	
	public void setCommand(Command command){
		this.command = command;
	}
	
	public void performAction(){
		command.execute();
	}
	
}
