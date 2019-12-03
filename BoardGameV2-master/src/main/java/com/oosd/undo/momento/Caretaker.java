package com.oosd.undo.momento;

import java.util.Stack;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

@Invariant("count >= 0")
public class Caretaker {  
	
	public Stack<Memento> savedPieces = new Stack<Memento>();
	private int count;

	/**
	 * This method adds a new Memento 
	 * on the stack
	 * @param memento
	 */
	@Requires("memento != null")
	@Ensures("old.count + 1 == count")
	public void addMemento(Memento memento){
		savedPieces.push(memento);
		count++;
	}
	
	/**
	 * This method return Memento from the Stack
	 * 
	 */
	@Ensures("old.count - 1 == count")
	public Memento getMemento(){
		count--;
		return savedPieces.pop();
	}

	@Ensures("count >= 0")
	public int getCount() {
		return count;
	}

	@Requires("count >= 0")
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
