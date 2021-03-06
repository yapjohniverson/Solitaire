package com.svi.training.handson1;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

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

		// TODO: Uncomment later after debug
		// deck.shuffleCards();

		Scanner input = new Scanner(System.in);
		// System.out.println("How many times do you want to play?");
		// int numberOfGames = input.nextInt();
		Game game = new Game();
		game.startGame(deck);

		int winCounter = 0;
		int loseCounter = 0;
		int counter = 0;
		int counterIteration = 0;
		while(counterIteration < 61) {
			game.autoTtoT();
			System.out.println(game);
			game.autoWtoT();
			System.out.println(game);
			game.autoWtoF();
			System.out.println(game);
			game.autoTtoF();
			System.out.println(game);
			game.talonClicked();
			System.out.println(game);

			counter++;
			if (game.hasEnded()) {
				System.out.println("Congratulations! You won!");
				winCounter++;
			} else if (counter == 150) {
				System.out.println("no possible moves, you lose");
				loseCounter++;
				break;
			}
			counterIteration++;
		}

		System.out.println("number of wins" + winCounter);
		System.out.println("number of loss" + loseCounter);

	}

}
