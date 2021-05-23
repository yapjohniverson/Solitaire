package com.svi.training.handson1;

public enum Suits {
	C("CLUBS", 0), S("SPADES", 1), H("HEARTS", 2), D("DIAMONDS", 3);

	private final String suitText;
	private final int suitInt;



	private Suits(String suitText,int suitInt) {
			this.suitText = suitText;
			this.suitInt = suitInt;
		}
	


	public String printSuit() {
		return suitText;
	}
	
	public int getValueOfSuit() {
		return suitInt;
	}

}
