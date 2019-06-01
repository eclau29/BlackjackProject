package com.skilldistillery.blackjack;

import java.util.List;
import java.util.Scanner;

public class BlackJackApp {

	Deck deck = new Deck();
	Dealer dealer = new Dealer(deck);
	Hand playerHand = new BlackjackHand();
	Hand dealerHand = new BlackjackHand();

	public static void main(String[] args) {
		BlackJackApp blackjack = new BlackJackApp();
		Scanner kb = new Scanner(System.in);
		Deck deck = new Deck();
		Dealer dealer = new Dealer(deck);
		Hand playerHand = new BlackjackHand();
		Hand dealerHand = new BlackjackHand();

		blackjack.run(kb);

		kb.close();
	}

	private void run(Scanner kb) {
		System.out.println("Welcome to BlackJack Sim! Hope you're feeling lucky!");
		deck.shuffleCards();
		int hitOrStay = 1;
		int playerHandValue = 0;
		for (int i = 0; i < 2; i++) {
			playerHand.addCard(dealer.getDeck().dealCard());

			dealerHand.addCard(dealer.getDeck().dealCard());
		}

		System.out.println("Player: " + playerHand + "(" + playerHand.getHandValue() + ")");
		System.out.println("Dealer: " + dealerHand.getCards().get(0));
		do {
			System.out.println("Would you like to hit or stay? \n1. HIT\n2. Stay ");
			hitOrStay = kb.nextInt();
			if (hitOrStay == 1) {
				playerHand.addCard(dealer.getDeck().dealCard());
				System.out.println("Player: " + playerHand + "(" + playerHand.getHandValue() + ")");
				if (playerHand.getHandValue() > 21) {
					System.out.println("HA ha YOU LOSE :P");
					System.exit(0);
				} if (playerHand.getHandValue() == 21) {
					System.out.println("Congratulations, you're a winner!");
				}
			}

		} while (hitOrStay == 1);

		while (dealerHand.getHandValue() < 17) {
			dealerHand.addCard(dealer.getDeck().dealCard());
		}
//		do {
		if (playerHand.getHandValue() > 21) {
			System.out.println("Player loses! *womp womp*");
			System.out.println("Play again? (Y/N)");
		} else if (dealerHand.getHandValue() > 21) {
			System.out.println("Dealer: " + dealerHand + "(" + dealerHand.getHandValue() + ")");
			System.out.println("Dealer loses...player wins");
		} else if (dealerHand.getHandValue() < 17) {
			while (dealerHand.getHandValue() < 17) {
				dealerHand.addCard(dealer.getDeck().dealCard());
			}
		}else if (dealerHand.getHandValue() > playerHand.getHandValue()) {
			System.out.println("Dealer: " + dealerHand);
			System.out.println("Dealer wins! Would you like to play again? (Y/N)");
			
		} else if (dealerHand.getHandValue() < playerHand.getHandValue()) {
			System.out.println("Dealer: " + dealerHand);
			System.out.println("Player wins! Congratulations, it's your lucky day!");
		}

//		if (dealerHand.getHandValue() > playerHand.getHandValue()) {
//			System.out.println("Dealer wins! Would you like to play again? (Y/N)");
//		} else if (dealerHand.getHandValue() < playerHand.getHandValue()) {
//			System.out.println("Player wins! Would you like to play again? (Y/N)");
//		} else {
//			System.out.println("It's a draw :O");
//		}

	}
}
