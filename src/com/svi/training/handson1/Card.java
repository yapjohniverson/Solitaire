package com.svi.training.handson1;

public class Card {

	private Suits suit;
	private Ranks rank;
	private String color;

	private boolean faceUp;

	

	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}

	public Card(String suit, String rank) {
		this.suit = Suits.valueOf(suit);
		for (Ranks r : Ranks.values()) {
			if (rank.equals(r.getRankString())) {
				this.rank = r;
			}
		}
		this.faceUp = false;
	}

	public Suits getSuit() {
		return suit;
	}

	public Ranks getRank() {
		return rank;
	}

	public int getRankValue() {
		return rank.getRank();
	}

	public int getSuitValue() {
		return suit.getValueOfSuit();
	}

	public String setColor(String color) {
		return this.color = color;
	}

	public String getSuitColor() {
		if (this.suit.equals(Suits.C) || this.suit.equals(Suits.S)) {
			return setColor("Black");
		} else {
			return setColor("Red");
		}
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public void flipToOpen() {
		this.faceUp = !this.faceUp;

	}

	@Override
	public String toString() {

		if (isFaceUp()) {
			return suit + "-" + rank.getRankString();
		} else {
			return "Covered";
		}

	}

	// TODO Auto-generated method stub

}
