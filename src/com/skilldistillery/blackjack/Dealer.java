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
	
	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Card getCards() {
		return cards;
	}

	public void setCards(Card cards) {
		this.cards = cards;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	// constructor
	public Dealer(Deck deck) {
		this.deck = deck;
	}
	
	// methods
//public void dealerHand (int qty) {
//	hand.addCard();
	
//}

public List<Card> dealToPlayer (Scanner kb) {
//		deck.shuffleCards();
		boolean cont = true;
		int pnumCards;
		int playerCardValue = 0;
		List<Card> playerHand = null;
		
		System.out.print("How many cards would you like? ");
		while (cont) {
			try {
				pnumCards = kb.nextInt();
				playerHand = new ArrayList<Card>();
				if (pnumCards <= 52) {
					for (int i = 0; i < pnumCards; i++) {
						Card playerCard = deck.dealCard();
						System.out.println(playerCard);
						playerCardValue += playerCard.getValue();
						playerHand.add(playerCard);
						
					}
					System.out.println(playerCardValue);
					return playerHand;
					
				} else if (pnumCards > 52) {
					System.err.println("That's too many cards, silly! Let's try again.");
				}

			} catch (InputMismatchException e) {
				System.out.println("Invalid number of cards. Try again!");
				break;
			}

		} cont = false;
		return playerHand;
	} 
}
