package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Dealer {
	
	// fields
	private Deck deck = new Deck(); // a Deck is a List<Card>;
	private Card cards;
	private Hand hand;
	
	// constructor
	public Dealer(Deck deck) {
		this.deck = deck;
	}
	
	// methods
public void dealerHand (int qty) {
	hand.addCard(qty);
	
}
public void dealToPlayer (Scanner kb) {
		deck.shuffleCards();
		boolean cont = true;
		int pnumCards;
		int playerCardValue = 0;
		
		System.out.print("How many cards would you like? ");
		while (cont) {
			try {
				pnumCards = kb.nextInt();
				List<Card> playerHand = new ArrayList<>(pnumCards);
				if (pnumCards <= 52) {
					for (int i = 0; i < pnumCards; i++) {
						Card playerCard = deck.dealCard();
						System.out.println(playerCard);
						playerCardValue += playerCard.getValue();
						playerHand.add(playerCard);
						
					}
					System.out.println(playerCardValue);
					break;
					
				} else if (pnumCards > 52) {
					System.err.println("That's too many cards, silly! Let's try again.");
				}

			} catch (InputMismatchException e) {
				System.out.println("Invalid number of cards. Try again!");
				break;
			}

		} cont = false;
	}
}
