package com.svi.training.handson1;

import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class Deck {
	private Stack<Card> cards = new Stack<Card>();
	private int size;
	private boolean isFaceUp;

	public Stack<Card> getCards() {
		return cards;
	}

	public Deck(Stack<Card> gameCard) {
		this.cards = gameCard;
		this.isFaceUp = false;
	}
	
	public void shuffleCards() {
		Collections.shuffle(cards);
	}

	public int getSize() {
		return cards.size();
	}

	@Override
	public String toString() {
		return "Deck: " + cards ;
	}
	
	
}
