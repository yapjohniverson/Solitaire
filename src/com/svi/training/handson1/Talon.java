package com.svi.training.handson1;

import java.util.Stack;

public class Talon {

	private Stack<Card> talonCards;
	private int size;
	//call wastepile

	// best practice - How do I name methosd?
	// (a) Verbs - behaviours of the object
	// (b) Private characterstics - getters/setters
	// (c) if method returns boolean ( true, false) - method name is always a
	// question
	// (d) ano ung method name dapat un lang ung ginagawa, walang magic

	public Talon(Deck deck) {
		this.talonCards = new Stack<>();
	}

	public int getSize() {
		return talonCards.size();
	}

	public Stack<Card> getTalonCards() {
		return talonCards;
	}
	
	public Card drawTalon() {
		if (talonCards.iterator().hasNext()) { //
			return talonCards.pop();
		}
	
		return null;
	}

	public boolean isEmpty() {
		return false;
	}
	
	public String toString() {
		return " " + talonCards;
	}
	// add card

}
