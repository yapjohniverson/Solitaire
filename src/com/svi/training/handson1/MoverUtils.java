package com.svi.training.handson1;

public class MoverUtils {

	public boolean isMoveValid(Tableau t, Card c) {
		boolean wasteAddToTableau = false;
		for (int i = t.getSize() - 1; i >= 0; i--) {
			if ((t.getTableauRow(i).isEmpty() && c.getRank().equals(c.getRank().KING)) || (!t.getTableauRow(i).isEmpty() && 
					(t.getTableauRow(i).get(t.getTableauRow(i).size() - 1).getRankValue() == c.getRankValue() + 1
					&& t.getTableauRow(i).get(t.getTableauRow(i).size() - 1).getSuitColor() != c.getSuitColor()))) {
				wasteAddToTableau = true;
				//return the row
				//if(t.getTableauRow(i).get(t.getTableauRow(i).size()-1).iterator().hasPrevious() == ); how to reverse
			}
		}
		

		return wasteAddToTableau;

		// if empty and card value is king, if not empty and last index of row is
		// sequence of card
	}

	public boolean isMoveValid(Card c, Foundation f) { // tableau to foundation
		boolean addToFoundation = false;
		if (c.getRank().equals(1) && c.getSuit().equals(c.getSuit().C)
				|| (!f.isEmpty() && (f.peekTopClubsFoundation().getRankValue() == c.getRankValue() - 1
						&& c.getSuit().equals(c.getSuit().C)))) {
			addToFoundation = true;
		} else if (c.getRank().equals(1) && c.getSuit().equals(c.getSuit().S)
				|| (!f.isEmpty() && (f.peekTopSpadesFoundation().getRankValue() == c.getRankValue() - 1
						&& c.getSuit().equals(c.getSuit().S)))) {
			addToFoundation = true;
		} else if (c.getRank().equals(1) && c.getSuit().equals(c.getSuit().H)
				|| (!f.isEmpty() && (f.peekTopHeartsFoundation().getRankValue() == c.getRankValue() - 1
						&& c.getSuit().equals(c.getSuit().H)))) {
			addToFoundation = true;
		} else if (c.getRank().equals(1) && c.getSuit().equals(c.getSuit().D)
				|| (!f.isEmpty() && (f.peekTopDiamondsFoundation().getRankValue() == c.getRankValue() - 1
						&& c.getSuit().equals(c.getSuit().D)))) {
			addToFoundation = true;
		}

		return addToFoundation;
	}

	public boolean isMoveValid(Card original, Card append) {
		boolean cardToCard = false;
		if (append.getRankValue() == original.getRankValue() + 1 && append.getSuitColor() != original.getSuitColor()) {
			cardToCard = true;
		}
		return cardToCard;
	}

}
