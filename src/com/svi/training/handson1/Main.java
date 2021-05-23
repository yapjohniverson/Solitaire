package com.svi.training.handson1;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;



public class Main {

	public static void main(String[] args) throws IOException {
		/*
		 * for(String data: file.getCardFromFile()) { String color = data.split("-")[0];
		 * String suit = data.split("-")[1]; String rank = data.split("-")[2]; card =
		 * new Card(color,suit,rank); gameCard.add(card);
		 * 
		 * }
		 * 
		 * System.out.println(gameCard);
		 */
		
		Card card;
		Stack<Card> gameCard = new Stack<Card>();
		Deck deck = new Deck(gameCard);

		ReadFile file = new ReadFile();
		String fileFromText = file.readFile("input.txt");// "D-A,D-K,D-Q,D-J,D-10,D-9,D-8,D-7,D-6,D-5,D-4,D-3,D-2,H-A,H-K,H-Q,H-J,H-10,H-9,H-8,H-7,H-6,H-5,H-4,H-3,H-2,S-A,S-K,S-Q,S-J,S-10,S-9,S-8,S-7,S-6,S-5,S-4,S-3,S-2,C-A,C-K,C-Q,C-J,C-10,C-9,C-8,C-7,C-6,C-5,C-4,C-3,C-2";
		

		for (String data : fileFromText.split(",")) {
			String suit = data.split("-")[0];
			String rank = data.split("-")[1];

			card = new Card(suit, rank);
			gameCard.add(card);
		}
		//System.out.println(deck.getCards() & deck & gameCard); //gameCard and deck the same, concept diff tho?
		//System.out.println(deck.getCards().subList(0, 7));
		//deck.shuffleCards();
		//System.out.println(deck.getCards().get(1).getSuitColor());
		//?
		
		
		

		
		Game game = new Game(deck);
		System.out.println(game);
		game.displayTalon();
		for(int i = 0;  i < 8; i++) {
			game.talonClicked();
			game.displayTalon();
		}
	
	
		
	
		//display all lists
		//when talon is clicked, display talon size, talon values, and wastepile 
		while(game.hasNotEnded()) {
			
			//first method, maneuvre to maneuvre row to row and row to column
			//wastepile to maneuvre
			//wastepile to foundation
			//maneuvre to foundation
			//talon draw
			
			//for each class, same methods, create generic 
			//ismovevalid, remove and add to new row, add card, tostring
		}
	}

}
