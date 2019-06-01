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
		System.out.println("Welcome to BlackJack Sim! Hope you're feeling lucky!\n");
		boolean cont = true;
		
		while (cont) {
		deck.shuffleCards();
		int hitOrStay = 1;
		int playerHandValue = 0;
		
		for (int i = 0; i < 2; i++) {
			playerHand.addCard(dealer.getDeck().dealCard());

			dealerHand.addCard(dealer.getDeck().dealCard());
		}

		System.out.println("Player: " + playerHand + "(" + playerHand.getHandValue() + ")");
		System.out.println("Dealer: " + dealerHand.getCards().get(0) + "\n");
		do {
		if (playerHand.getHandValue() == 21) {
			System.out.print("Congratulations, you're a winner!");
			System.exit(0);
		}
		if (dealerHand.getHandValue() == 21) {
			System.out.print("Sorry, dealer wins :P ");
			System.exit(0);
		}
			System.out.println("Would you like to hit or stay? \nType \"1\" for HIT\nType \"2\" to Stay ");
	
			hitOrStay = kb.nextInt();
			if (hitOrStay == 1) {
				playerHand.addCard(dealer.getDeck().dealCard());
				System.out.println("Player: " + playerHand + "(" + playerHand.getHandValue() + ")");
				if (playerHand.getHandValue() > 21) {
					System.out.println("Aww, you lost :( ");
					System.exit(0);

				} 

			}

		} while (hitOrStay == 1);

		while (dealerHand.getHandValue() < 17) {
			dealerHand.addCard(dealer.getDeck().dealCard());
		}

		if (playerHand.getHandValue() > 21) {
			System.out.println("Player loses! *womp womp* \nBetter luck next time!");
			System.exit(0);

		} else if (dealerHand.getHandValue() > 21) {
			System.out.println("Dealer: " + dealerHand + "(" + dealerHand.getHandValue() + ")");
			System.out.println("Dealer loses, player wins! Congrats! :D");
			System.exit(0);

		} else if (dealerHand.getHandValue() < 17) {
			while (dealerHand.getHandValue() < 17) {
				dealerHand.addCard(dealer.getDeck().dealCard());
			}
		}else if (dealerHand.getHandValue() > playerHand.getHandValue()) {
			System.out.println("Dealer: " + dealerHand);
			System.out.println("Dealer wins!");
				System.out.println("Better luck next time!");
				System.exit(0);
			
		} else if (dealerHand.getHandValue() < playerHand.getHandValue()) {
			System.out.println("Dealer: " + dealerHand + "(" + dealerHand.getHandValue() + ")");
			System.out.println("Player wins! Congratulations, it's your lucky day!");
			System.exit(0);

		} else if (dealerHand.getHandValue() == playerHand.getHandValue()) {
			System.out.println("It's a tie! We will meet again for a rematch soon, I'm sure >:D");
			System.exit(0);
		}

	}
	}
}
