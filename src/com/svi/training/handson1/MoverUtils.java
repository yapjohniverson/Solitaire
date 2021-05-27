package com.svi.training.handson1;

public class MoverUtils {

	public static boolean isMoveValid(Tableau t, Card c) { // c is highest t is the row to append
		boolean wasteAddToTableau = false;
		Location fromLocation = t.findCardInTableau(c);

		for (int i = t.getSize() - 1; i >= 0; i--) {
			/*if (!t.getTableauRow(i).isEmpty() && (t.getTableauRow(i).get(0).getRankValue() == 13
					&& (c.getRankValue() == 12 && fromLocation.getColumn() == 1))) {
				wasteAddToTableau = false;
			}*/
			if(c.getRankValue() == 13 && fromLocation.getColumn() == 0) {
				wasteAddToTableau = false;
			}
			// if highest is king and there is an empty row
			else if (t.getTableauRow(i).isEmpty() && c.getRankValue() == 13 || (!t.getTableauRow(i).isEmpty()
					&& (t.getTableauRow(i).get(t.getTableauRow(i).size() - 1).getRankValue() == c.getRankValue() + 1)
					&& (t.getTableauRow(i).get(t.getTableauRow(i).size() - 1).getSuitColor() != c.getSuitColor()))) {
				wasteAddToTableau = true;
			}

		}
		return wasteAddToTableau;
	}

	public static boolean isMoveValid(Card c, Foundation f) { // tableau to foundation
		boolean addToFoundation = false;
		if (c.getRankValue() == 1 || (!f.getClubFoundation().isEmpty()
				&& ((c.getRankValue() == f.getClubFoundation().peek().getRankValue() + 1)
						&& c.getSuit().equals(Suits.C)))) {
			addToFoundation = true;
		} else if (c.getRankValue() == 1 || (!f.getSpadeFoundation().isEmpty()
				&& ((c.getRankValue() == f.getSpadeFoundation().peek().getRankValue() + 1)
						&& c.getSuit().equals(Suits.S)))) {
			addToFoundation = true;
		} else if (c.getRankValue() == 1 || (!f.getHeartFoundation().isEmpty()
				&& ((c.getRankValue() == f.getHeartFoundation().peek().getRankValue() + 1)
						&& c.getSuit().equals(Suits.H)))) {
			addToFoundation = true;
		} else if (c.getRankValue() == 1 || (!f.getDiamondFoundation().isEmpty()
				&& ((c.getRankValue() == f.getDiamondFoundation().peek().getRankValue() + 1)
						&& c.getSuit().equals(Suits.D)))) {
			addToFoundation = true;
		}
		return addToFoundation;

	}

	public static boolean isMoveValid(Card original, Card append) {
		boolean cardToCard = false;
		if ((append.getRankValue() + 1) == original.getRankValue()
				&& append.getSuitColor() != original.getSuitColor()) {
			cardToCard = true;
		}
		return cardToCard;
	}

}
