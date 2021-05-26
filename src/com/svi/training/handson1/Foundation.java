package com.svi.training.handson1;

import java.util.Stack;
import static com.svi.training.handson1.Suits.*;

public class Foundation {
	private Stack<Card> clubs;
	private Stack<Card> spades;
	private Stack<Card> hearts;
	private Stack<Card> diamonds;

	public Foundation() {
		this.clubs = new Stack<>();
		this.spades = new Stack<>();
		this.hearts = new Stack<>();
		this.diamonds = new Stack<>();

	}

	@Override
	public String toString() {
		return "Club Foundation: " + clubs + "\n" + "Spades Foundation: " + spades + "\n" + "Hearts foundation: "
				+ hearts + "\n" + "Diamonds Foundation: " + diamonds + "\n";
	}

	public boolean isEmpty() {
		return true; // true ba?

	}

	public void addFoundation(Card c){
		Suits suit = c.getSuit();
		switch(suit) {
			case C:
				clubs.push(c);
				break;
			case S:
				spades.push(c);
				break;
			case H:
				hearts.push(c);
				break;
			case D:
				diamonds.push(c);
				break;
			default:
				System.out.println("ERROR: Invalid Suit!");
		}
	}

	public Card peekTopClubsFoundation() {
		if (clubs.isEmpty()) {
			return null;
		} else {
			return this.clubs.peek();
		}
	}

	public Card peekTopSpadesFoundation() {
		if (spades.isEmpty()) {
			return null;
		} else {
			return this.spades.peek();
		}
	}

	public Card peekTopHeartsFoundation() {
		if (hearts.isEmpty()) {
			return null;
		} else {
			return this.hearts.peek();
		}
	}

	public Card peekTopDiamondsFoundation() {
		if (diamonds.isEmpty()) {
			return null;
		} else {
			return this.diamonds.peek();
		}
	}

	public boolean winningCondition() {
		boolean full = true;
		if (clubs.size() != 13 || spades.size() != 13 || hearts.size() != 13 || diamonds.size() != 13) {
			full = false;
		}
		return full;
	}

	

	public Stack<Card> getClubFoundation() {
		// TODO Auto-generated method stub
		return clubs;
	}

	public Stack<Card> getSpadeFoundation() {
		// TODO Auto-generated method stub
		return spades;
	}

	public Stack<Card> getHeartFoundation() {
		// TODO Auto-generated method stub
		return hearts;
	}

	public Stack<Card> getDiamondFoundation() {
		// TODO Auto-generated method stub
		return diamonds;
	}

}
