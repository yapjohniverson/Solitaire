package com.svi.training.handson1;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class WastePile {
	private Stack<Card> wastePile;

	public Stack<Card> getWastePile() {
		return wastePile;
	}

	public WastePile() {
		wastePile = new Stack<>();
	}

	
	public Card showCard(){
		return wastePile.peek();
	}

	public void removeCard(){
		wastePile.pop();
	}

	@Override
	public String toString() {
		return "" + wastePile;
	}

}
