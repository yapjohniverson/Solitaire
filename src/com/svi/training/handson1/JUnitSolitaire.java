package com.svi.training.handson1;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class JUnitSolitaire {
	
	
	@Test
	void test() throws IOException  {
		ReadFile file = new ReadFile();
		String fileFromText = file.readFile("input.txt");
		
		Card card;
		Stack<Card> gameCard = new Stack<>();
		Deck deck = new Deck(gameCard);

		for (String data : fileFromText.split(",")) {
			String suit = data.split("-")[0];
			String rank = data.split("-")[1];
			card = new Card(suit, rank);
			gameCard.add(card);
		}
		
		int dk = deck.getCards().get(0).getRankValue(); // DK
		int dq = deck.getCards().get(1).getRankValue(); // DQ
		
		assertTrue (dk > dq);
		
		
	}

}
