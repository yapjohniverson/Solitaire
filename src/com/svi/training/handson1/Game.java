package com.svi.training.handson1;

import java.util.ArrayList;
import java.util.Stack;

public class Game {

	private Foundation foundation; // you can initialize but empty
	private Tableau tableau;
	private WastePile wastePile;
	private Talon talon;

	public Game(Deck deck) {
		this.tableau = new Tableau(new Deck(deck.getCards()));
		this.talon = new Talon(new Deck(deck.getCards()));
		this.wastePile = new WastePile();
		this.foundation = new Foundation();

		createTableau(deck);
		createTalon(deck);
	}

	public void createTableau(Deck deck) {
		ArrayList<ArrayList<Card>> tab = tableau.getTableau();

		for (int i = 0; i <= tableau.getSize() - 1; i++) {
			for (int j = 0; j <= tableau.getSize() - 1; j++) {
				if (j < (tableau.getSize() - i)) {
					tab.get(j).add(deck.getCards().pop()); // ????????????
				}
			}
		}
	}

	public void createTalon(Deck deck) {

		Stack<Card> tal = talon.getTalonCards();
		while (deck.getCards().size() != 0) {
			tal.add(deck.getCards().pop()); // noice

		}

	}

	public void displayTalon() { // display talon size, talon talon values, wastepile?
		Stack<Card> showTalon = talon.getTalonCards();
		Stack<Card> wasteP = wastePile.getWastePile();
		System.out.println("Talon size: " + showTalon.size());
		System.out.println("Talon values: " + showTalon);
		System.out.println("Waste Pile  : " + wasteP);

	}

	public void talonClicked() {
		Stack<Card> talonPile = talon.getTalonCards();
		Stack<Card> wasteP = wastePile.getWastePile();
		int counter = 0;
		while (talonPile.iterator().hasNext() && counter < 3) {
			wasteP.add(talonPile.pop());
			counter++;
			if (talonPile.isEmpty()) {
				talonPile.addAll(wasteP);
				wasteP.clear();
			}
			// if empty , add wastepile to talon, clear wastepile
		}
	}
	//

	public void tableauToFoundation() {
		ArrayList<ArrayList<Card>> tab = tableau.getTableau();
		Stack<Card> clubFoundation = foundation.getClubFoundation();
		Stack<Card> spadeFoundation = foundation.getSpadeFoundation();
		Stack<Card> heartFoundation = foundation.getHeartFoundation();
		Stack<Card> diamondFoundation = foundation.getDiamondFoundation();

		for (int i = tab.size() - 1; i >= 0; i--) { // ouch unreadable
			if (!tab.get(i).isEmpty()) {
				Card maxClub = foundation.peekTopClubsFoundation();
				if (maxClub == null) {
					// ace
				} else {
					foundation.peekTopClubsFoundation().getRankValue();
				}

				if (tab.get(i).get(tab.get(i).size() - 1)
						.getRankValue() == foundation.peekTopClubsFoundation().getRankValue() + 1 // if not null,
						&& (tab.get(i).get(tab.get(i).size() - 1).getSuit().equals(Suits.C))) {
					tab.get(i).remove(tab.get(i).size() - 1);
					clubFoundation.add(tab.get(i).get(tab.get(i).size() - 1));// clubs

				} else if (tab.get(i).get(tab.get(i).size() - 1).getRankValue() == spadeFoundation.peek().getRankValue()
						+ 1 && (tab.get(i).get(tab.get(i).size() - 1).getSuit().equals(Suits.S))) {
					tab.get(i).remove(tab.get(i).size() - 1);
					spadeFoundation.add(tab.get(i).get(tab.get(i).size() - 1));// spades

				} else if (tab.get(i).get(tab.get(i).size() - 1).getRankValue() == heartFoundation.peek().getRankValue()
						+ 1 && (tab.get(i).get(tab.get(i).size() - 1).getSuit().equals(Suits.H))) {
					tab.get(i).remove(tab.get(i).size() - 1);
					heartFoundation.add(tab.get(i).get(tab.get(i).size() - 1));// hearts

				} else if (tab.get(i).get(tab.get(i).size() - 1).getRankValue() == clubFoundation.peek().getRankValue()
						+ 1 && (tab.get(i).get(tab.get(i).size() - 1).getSuit().equals(Suits.D))) {
					tab.get(i).remove(tab.get(i).size() - 1);
					diamondFoundation.add(tab.get(i).get(tab.get(i).size() - 1));// diamonds
				}
			}
		}

	}

	public void wastePileToFoundation() {
		Stack<Card> wasteP = wastePile.getWastePile(); // if wastepile is ace and foundation is null
		Stack<Card> clubFoundation = foundation.getClubFoundation();
		Stack<Card> spadeFoundation = foundation.getSpadeFoundation();
		Stack<Card> heartFoundation = foundation.getHeartFoundation();
		Stack<Card> diamondFoundation = foundation.getDiamondFoundation();

		Card maxClub = foundation.peekTopClubsFoundation();
		Card maxSpade = foundation.peekTopSpadesFoundation();
		Card maxHeart = foundation.peekTopHeartsFoundation();
		Card maxDiamond = foundation.peekTopDiamondsFoundation();

		if (maxClub == null && wasteP.pop().getRankValue() == 1) { // foundation is null and wastepile last element is
			if (wasteP.pop().getSuit().equals(Suits.C)) { // no comparison for suits..
				clubFoundation.add(wasteP.pop());
			}
		}else
		//ate marsh sorry ganito lang naiisip ko :c
		// spades
		if (maxSpade == null && wasteP.pop().getRankValue() == 1) {
			if (wasteP.pop().getSuit().equals(Suits.S)) {
				spadeFoundation.add(wasteP.pop());
			}
		}else if(maxClub != null && maxClub.getRankValue() == wasteP.pop().getRankValue() + 1) {
			if(wasteP.pop().getSuit().equals(Suits.S)) {
				spadeFoundation.add(wasteP.pop());
			}
		}
		// hearts
		if(maxHeart == null && wasteP.pop().getRankValue() == 1)
			if (wasteP.pop().getSuit().equals(Suits.H)) {
				heartFoundation.add(wasteP.pop());
				if (maxDiamond == null && wasteP.pop().getRankValue() == 1) {
					if (wasteP.pop().getSuit().equals(Suits.D)) {
						diamondFoundation.add(wasteP.pop());
					}
				}

	}
	// from wastepile to foundation, remove wastepile

	// method loop tableau, add to foundation last element,if not empty
	// given a tab, add last element to foundation
	public boolean hasNotEnded() {
		// move class, isMoveValid()

		return false;
	}

	@Override
	public String toString() {
		return "" + tableau + "talon: " + talon + '\n' + "Waste Pile: " + wastePile + '\n' + "Foundation: "
				+ foundation;
	}

}
