package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

//import com.skilldistillery.enums.drills.cards.Card;

public abstract class Hand {
	
	// FIELDS
private int handQty;
private List<Card> cards = new ArrayList<Card>(handQty);
private Deck deck = new Deck();

	//CONSTRUCTORS
public Hand() {}

public Hand(int handQty) {
	this.handQty = handQty;
}
public Hand(List<Card> cards, int handQty) {
	this.cards = cards;
	this.handQty = handQty;
}

// METHODS

//List<Card> hand = new ArrayList<>(pnumCards);
//if (pnumCards <= 52) {
//	for (int i = 0; i < pnumCards; i++) {
//		Card playerCard = deck.dealCard();
//		System.out.println(playerCard);
//		playerCardValue += playerCard.getValue();
//		hand.add(playerCard);

public void addCard (int qty) {
	Card c = deck.dealCard();
	cards.add(c);
	
}

public int getHandValue() {
	int handValue = 0;
	for (int i = 0; i < handQty; i++) {
		Card c = deck.dealCard();
		handValue += c.getValue();
		cards.add(c);
	} 
	return handValue;
}

public List<Card> getCards () {
	
	return cards;
}

public void clearHand() {
	cards = null;
	System.out.println("Hand cleared.");
}


@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	for (Card card : cards) {
		System.out.println(card);
	}
	return null;


}
}
