package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

//import com.skilldistillery.enums.drills.cards.Card;

public abstract class Hand {
	
	// FIELDS
private int handQty;
private ArrayList<Card> cards = new ArrayList<Card>(handQty);

	//CONSTRUCTORS
public Hand() {}

public void setCards(ArrayList<Card> cards) {
	this.cards = cards;
}

public Hand(int handQty) {
	this.handQty = handQty;
}
public Hand(ArrayList<Card> cards, int handQty) {
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

public void addCard (Card c) {
	cards.add(c);
}

public int getHandValue() {
	int handValue = 0;
	for (int i = 0; i < handQty; i++) {
		handValue += cards.get(i).getValue();
	} 
	return handValue;
}

public List<Card> getCards () {
	
	return cards;
}

public void clearHand() {
	cards = new ArrayList<>();
	System.out.println("Hand cleared.");
}


@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	for (Card card : cards) {
		builder.append(card + " ");
	}
	return builder.toString();


}

}
