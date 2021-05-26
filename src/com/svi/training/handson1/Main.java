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

        ReadFile file = new ReadFile();
		String fileFromText = "D-A,D-K,D-Q,D-J,D-10,D-9,D-8,D-7,D-6,D-5,D-4,D-3,D-2,H-A,H-K,H-Q,H-J,H-10,H-9,H-8,H-7,H-6,H-5,H-4,H-3,H-2,S-A,S-K,S-Q,S-J,S-10,S-9,S-8,S-7,S-6,S-5,S-4,S-3,S-2,C-A,C-K,C-Q,C-J,C-10,C-9,C-8,C-7,C-6,C-5,C-4,C-3,C-2";

		Card card;
		Stack<Card> gameCard = new Stack<>();
		Deck deck = new Deck(gameCard);

		for (String data : fileFromText.split(",")) {
            String suit = data.split("-")[0];
            String rank = data.split("-")[1];
            card = new Card(suit, rank);
            gameCard.add(card);
        }

		// TODO: Uncomment later after debug
        //deck.shuffleCards();
		
		
        Game game = new Game();
        game.startGame(deck);
        
        int counter = 0;
        while(counter < 100) {
        	game.autoTtoT();
        	game.autoWtoT();
        	game.autoWtoF();
        	game.autoTtoF();
        	game.talonClicked();
        	System.out.println(game);
        	counter++;
        	}
       
    
        
        
        
     
        
   /*
		 * while(!game.hasNotEnded()) { game.autoTtoT(); System.out.println(game);
		 * game.autoWtoT(); System.out.println(game); game.autoWtoF();
		 * System.out.println(game); game.autoTtoF(); System.out.println(game);
		 * game.talonClicked(); System.out.println(game); }
		 */
		/*
		 * game.autoTtoT(); System.out.println(game); game.autoWtoT();
		 * System.out.println(game); game.autoWtoF(); System.out.println(game);
		 * game.autoTtoF(); System.out.println(game);
		 * 
		 * game.talonClicked(); System.out.println(game);
		 * 
		 * game.autoTtoT(); System.out.println(game); game.autoWtoT();
		 * System.out.println(game); game.autoWtoF(); System.out.println(game);
		 * game.autoTtoF(); System.out.println(game);
		 * 
		 * game.talonClicked(); System.out.println(game);
		 * 
		 * game.autoTtoT(); System.out.println(game); game.autoWtoT();
		 * System.out.println(game); game.autoWtoF(); System.out.println(game);
		 * game.autoTtoF(); System.out.println(game);
		 * 
		 * 
		 * game.talonClicked(); System.out.println(game);
		 * 
		 * game.autoTtoT(); System.out.println(game); game.autoWtoT();
		 * System.out.println(game); game.autoWtoF(); System.out.println(game);
		 * game.autoTtoF(); System.out.println(game);
		 */
		
		/*
		 * while (!game.hasNotEnded()) {
		 * 
		 * game.autoTtoT(); System.out.println(game); }
		 * 
		 * for(int i = 0; i < 5; i++) { game.autoWtoT(); System.out.println(game); }
		 * 
		 * for(int i = 0; i < 5; i++) { game.autoWtoF(); System.out.println(game); }
		 * 
		 * for(int i = 0; i < 5; i++) { game.autoTtoF(); System.out.println(game); }
		 * 
		 * game.talonClicked();
		 */
        
       
        }
    }

