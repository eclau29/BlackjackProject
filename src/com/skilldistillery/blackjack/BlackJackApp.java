package com.skilldistillery.blackjack;

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
		
		blackjack.run(kb);
		
		kb.close();
	}

	private void run(Scanner kb) {
		System.out.println("Welcome to BlackJack Sim! Hope you're feeling lucky!");
		int hitOrStay = 0;
		do {
			hitOrStay = 1;
			dealer.dealToPlayer(kb);
			playerHand.getHandValue();
			System.out.println("Would you like to hit or stay? \n1. HIT\n2. Stay ");
			 hitOrStay = kb.nextInt();
			 switch (hitOrStay) {
			 case 1:
				 dealer.dealToPlayer(kb);
				 playerHand.getHandValue();
				 break;
			 case 2:
				 System.out.println("You've decided to stay.");
				 break;
			 default:
				 System.out.println("Invalid Entry");
				 dealer.dealToPlayer(kb);
				 playerHand.getHandValue();
			 }
		} while( hitOrStay == 1);
			
		
		
		dealer.dealToPlayer(kb);
		playerHand.getHandValue();
		dealer.dealerHand(2);
		dealerHand.getHandValue();
		if (playerHand.getHandValue() > 21) {
			System.out.println("Player loses! *womp womp*");
			System.out.println("Play again? (Y/N)");
		} else if (dealerHand.getHandValue() > 21) {
			System.out.println("Dealer loses! Player wins...");
		} else if (dealerHand.getHandValue()< 17) {
			while (dealerHand.getHandValue() < 17) {
			dealer.dealerHand(1);
		}
	}
	}
}
