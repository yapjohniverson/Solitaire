package com.svi.training.handson1;

import java.util.ArrayList;

public class Tableau {
	private ArrayList<ArrayList<Card>> tableau;
	private int size;
	
	
	
	public ArrayList<ArrayList<Card>> getTableau() {
		return tableau;
	}



	public Tableau(Deck deck) {
		tableau = new ArrayList<>();

		for (int i = 0; i < 7; i++) {
			tableau.add(new ArrayList<>());
		}

	}

	

	public void faceUpLastCard() {
		for (ArrayList<Card> row : tableau) {
			if (!row.isEmpty()) {
				Card last = row.get(row.size() - 1); // get last element of each row
				if (!last.isFaceUp()) { // check if ace down, if falsef
					last.flipToOpen(); // becomes face up
				}

			}
		}
	}
	public ArrayList<Card> getTableauRow(int row) {
		return tableau.get(row);
	}
	
	public int getSize() {
		return tableau.size();
	}

	public boolean isEmpty() {
		return false;
	}



	@Override
	public String toString() { //use for each to display
		StringBuilder str = new StringBuilder();
		for(ArrayList<Card> row : tableau) {
			str.append(row + "\n");
		}
		return str.toString();

	}
}
