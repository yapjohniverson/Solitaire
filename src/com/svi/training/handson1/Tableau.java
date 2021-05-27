package com.svi.training.handson1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tableau {
	private List<List<Card>> rowColumn;
	private int size;

	public List<List<Card>> getRowColumn() {
		return rowColumn;
	}

	public Tableau() {
		// initialize with 7 rows
		rowColumn = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			rowColumn.add(new ArrayList<>());
		}
	}

	public Card showLastCard(int row) {
		List<Card> rowCards = rowColumn.get(row);
		return rowCards.get(rowCards.size() - 1);
	}

	public void addCard(Card c, int row) {
		List<Card> rowCards = rowColumn.get(row);
		rowCards.add(c);
	}

	public void removeLastCard(int row) {
		List<Card> rowCards = rowColumn.get(row);
		rowCards.remove(rowCards.size() - 1);
	}

	public void transferBetweenPiles(int fromRow, int fromColumn, int toRow) {
		List<Card> rowCardsFrom = rowColumn.get(fromRow);

		// Create a copy of cards to transfer
		// Need to create a copy based from stack overflow, else it will throw
		// ConcurrentModificationException
		List<Card> cardsToTransfer = new ArrayList<>();
		for (Card c : rowCardsFrom.subList(fromColumn, rowCardsFrom.size())) {
			cardsToTransfer.add(c);
		}

		// clear/remove the copied cards from the tableau
		rowCardsFrom.subList(fromColumn, rowCardsFrom.size()).clear();

		// add cards
		List<Card> rowCardsTo = rowColumn.get(toRow);
		rowCardsTo.addAll(cardsToTransfer);
	}

	public List<Card> getTableauRow(int row) {
		return rowColumn.get(row);
	}

	public int getSize() {
		return rowColumn.size();
	}

	public boolean isEmpty() {
		return false;
	}

	@Override
	public String toString() { // use for each to display
		StringBuilder str = new StringBuilder();
		for (List<Card> row : rowColumn) {
			str.append(row + "\n");
		}
		return str.toString();

	}

	public Card getMaxSolitaireCardInTheRow(int row) {
		List<Card> rowCards = rowColumn.get(row);

		if (rowCards.isEmpty()) {
			return null;
		} else if (rowCards.size() == 1) {
			return rowCards.get(0);	
		} else {
			int column = rowCards.size() - 1;
			
			Card currentCard = rowCards.get(column);
			Card topCard = rowCards.get(column - 1);
			if(topCard.isFaceUp() && currentCard.isFaceUp()) {
				while (MoverUtils.isMoveValid(topCard, currentCard) && column > 1) {
					column--;
					currentCard = rowCards.get(column);
					topCard = rowCards.get(column - 1);
					//hq is max in 2nd king in iteration 20
					if(column == 1 && MoverUtils.isMoveValid(topCard, currentCard) && topCard.isFaceUp()) {
						return topCard;
					}
			}
			
			
			}
			return currentCard;
		}
	}

	public Location findCardInTableau(Card c) {
		for (int i = 0; i <= rowColumn.size() - 1; i++) {
			List<Card> rowCards = rowColumn.get(i);
			for (int j = 0; j <= rowCards.size() - 1; j++) {
				Card currentCard = rowCards.get(j);
				if (currentCard.getSuit().equals(c.getSuit()) && currentCard.getRankValue() == c.getRankValue()) {
					return new Location(i, j);
				}
			}
		}

		return null;
	}

	

	public Integer getRowToAppend(Card append) {
		for (int i = rowColumn.size() - 1; i >= 0; i--) {
			List<Card> rowCards = rowColumn.get(i);
			if (!rowCards.isEmpty()) {
				Card original = rowCards.get(rowCards.size() - 1);
				if (MoverUtils.isMoveValid(original, append)) {
					return i;
				}
			
			}else if (rowCards.isEmpty() && append.getRankValue() == 13) {
				return i;
			}
		}
		return null;
	}
}
