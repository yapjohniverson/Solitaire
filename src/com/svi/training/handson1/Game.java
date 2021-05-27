package com.svi.training.handson1;

import java.util.List;
import java.util.Stack;

public class Game {

	private Foundation foundation; // you can initialize but empty
	private Tableau tableau;
	private WastePile wastePile;
	private Talon talon;
	private boolean faceUp;

	public Game() {
		this.tableau = new Tableau();
		this.talon = new Talon();
		this.wastePile = new WastePile();
		this.foundation = new Foundation();
		this.faceUp = true;

	}

	public void startGame(Deck deck) {
		createTableau(deck);
		createTalon(deck);
		// System.out.println(!tableau.getTableauRow(0).get(0).toString().equals("Covered"));
		// //always my condition

	}

	public void createTableau(Deck deck) {
		List<List<Card>> tab = tableau.getRowColumn();

		for (int i = tableau.getSize() - 1; i >= 0; i--) {
			for (int j = 0; j < tableau.getSize() - i; j++) {
				tab.get(i).add(deck.getCards().pop()); // ????????????

			}
		}
		faceUpLastCard();

		/*
		 * for (List<Card> row : tableau.getRowColumn()) { if (!row.isEmpty()) { Card
		 * last = row.get(row.size() - 1); // get last element of each row if
		 * (!last.isFaceUp()) { // check if ace down, if falsef last.flipToOpen(); //
		 * becomes face up } } }
		 */

	}

	public void createTalon(Deck deck) {
		Stack<Card> tal = talon.getTalonCards();
		for (Card c : deck.getCards()) {
			c.flipToOpen();
		}
		while (deck.getCards().size() != 0) {
			tal.add(deck.getCards().pop()); // noice
		}

		// for (Card c : tal) {
		// c.flipToOpen();
		// }
	}

	public void displayTalon() { // display talon size, talon talon values, wastepile?
		Stack<Card> showTalon = talon.getTalonCards();
		Stack<Card> wasteP = wastePile.getWastePile();
		System.out.println("Talon size: " + showTalon.size());
		System.out.println("Talon values: " + showTalon);
		System.out.println("Waste Pile  : " + wasteP);

	}

	public void talonClicked() {
		System.out.println("TALON CLICKED --------");
		Stack<Card> talonPile = talon.getTalonCards();
		Stack<Card> wasteP = wastePile.getWastePile();
		int counter = 0;
		if (talonPile.iterator().hasNext() && counter < 1) { // change draw 1 or draw 3
			wasteP.add(talonPile.pop());
			counter++;

		} else if (talonPile.isEmpty()) {
			talonPile.addAll(wasteP);
			wasteP.clear();
		}

	}

	public boolean autoWtoT() {
		Stack<Card> talonC = talon.getTalonCards();
		Stack<Card> wasteP = wastePile.getWastePile();
		int row = 6;
		while (row >= 0 && !wasteP.isEmpty()) {
			if (wastePile.showCard().getRankValue() == 13 && tableau.getTableauRow(row).isEmpty()) {
				System.out.println("CARD TO MOVE FROM WASTEPILE ---->" + wastePile.showCard());
				moveWtoT(row);
				return true;
			} else if (!wastePile.getWastePile().isEmpty() && !tableau.getTableauRow(row).isEmpty()) {
				Card wastePileTop = wastePile.showCard();
				Card tableauLastCard = tableau.showLastCard(row);
				if (MoverUtils.isMoveValid(tableauLastCard, wastePileTop)) {
					System.out.println("CARD TO MOVE FROM WASTEPILE ---->" + wastePileTop);
					moveWtoT(row);
					return true;
				}
			}
			row--;
		}

		System.out.println("NO POSSIBLE W2T MOVES");
		return false;

	}

	public boolean autoTtoF() {
		int row = 6;
		while (row >= 0) {
			if (!tableau.getTableauRow(row).isEmpty()) {
				Card c = tableau.showLastCard(row);
				System.out.println(c);
				if (c.isFaceUp()) {
					if (MoverUtils.isMoveValid(c, foundation)) {
						System.out.println("CARD TO MOVE FROM TABLEAU --->" + c);
						moveTtoF(row);
						faceUpLastCard();
						return true;
					}
				}
			}
			row--;
		}
		System.out.println("NO POSSIBLE T2F MOVES");
		return false;

		// sloop tableau rows
		// check only last elemnt per row, isMoveValid?
	}

	public boolean autoWtoF() {
		if (!wastePile.getWastePile().isEmpty()) { // works for value 1
			Card c = wastePile.showCard();
			if (c != null && MoverUtils.isMoveValid(c, foundation)) {
				System.out.println("CARD TO MOVE FROM WASTEPILE IS ---->" + c);
				moveWtoF();
				return true;
			}
		}
		System.out.println("NO VALID W2F MOVES");

		return false;
	}

	/**
	 * This method does a move on cards within a tableau
	 *
	 */
	public boolean autoTtoT() {
		int tabRows = 6;

		while (tabRows >= 0) {
			Card c = tableau.getMaxSolitaireCardInTheRow(tabRows);
			System.out.println(c);
			if (c != null && MoverUtils.isMoveValid(tableau, c)) {
				System.out.println("CARD TO MOVE IS ----> " + c);
				Location fromLocation = tableau.findCardInTableau(c);
				int row = tableau.getRowToAppend(c);
				moveTtoT(fromLocation.getRow(), fromLocation.getColumn(), row);
				faceUpLastCard();
				return true;
			}
			tabRows--;
		}
		

		System.out.println("NO VALID T2T MOVES");
		return false;

	}

	// implementation to add last element of specified row to specified foundation
	public void moveTtoF(int fromTableauRow) {
		Card c = tableau.showLastCard(fromTableauRow);
		tableau.removeLastCard(fromTableauRow);
		foundation.addFoundation(c);
	}

	public void moveWtoF() {
		Card c = wastePile.showCard();
		wastePile.removeCard();
		foundation.addFoundation(c);
	}

	public void moveWtoT(int toTableauRow) {
		Card c = wastePile.showCard();
		wastePile.removeCard();
		tableau.addCard(c, toTableauRow);
	}

	public void moveTtoT(int fromTableauRow, int fromTableauColumn, int toTableauRow) {
		tableau.transferBetweenPiles(fromTableauRow, fromTableauColumn, toTableauRow);
	}

	// from wastepile to foundation, remove wastepile

	// method loop tableau, add to foundation last element,if not empty
	// given a tab, add last element to foundation
	public boolean hasEnded() {

		boolean f = foundation.winningCondition();

		if (f == true) {
			return true;
		}

		return false;
	}

	public void faceUpLastCard() {
		for (List<Card> row : tableau.getRowColumn()) {
			if (!row.isEmpty()) {
				Card last = row.get(row.size() - 1); // get last element of each row
				if (!last.isFaceUp()) { // check if ace down, if falsef
					last.flipToOpen(); // becomes face up
				}
			}
		}
	}

	@Override
	public String toString() {
		return "" + tableau + "talon: " + talon + '\n' + "Waste Pile: " + wastePile + '\n' + "Foundation: "
				+ foundation;
	}

}
