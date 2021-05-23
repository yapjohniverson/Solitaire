package com.svi.training.handson1;

import java.util.Iterator;
import java.util.Stack;

public class WastePile {
	private Stack<Card> wastePile;

	public Stack<Card> getWastePile() {
		return wastePile;
	}

	public WastePile() {
		wastePile = new Stack<>();
	}

	public Card removeTopWastePile() {
		return wastePile.pop();
	}

	public Card getTopOfWastePile() {
		return wastePile.peek();
	}

	public void draw(Stack<Card> card) {
		Iterator<Card> value = card.iterator();
		while (value.hasNext()) {
				wastePile.add(value.next());
		}
		 // clear current values, add three

	}

	@Override
	public String toString() {
		return "" + wastePile;
	}

}
