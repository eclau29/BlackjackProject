package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	/*Create a class Deck. It will hold a List of Cards.
In the constructor, initialize the List with all 52 cards.
Add a method checkDeckSize which returns the number of cards still in the deck.
Add a method dealCard that removes a Card from the deck.
Add a method shuffle to shuffle the deck.
	 */
	
private List<Card> cards;

public Deck() {
	cards = createDeck();
}

private List<Card> createDeck() {
List<Card> deck = new ArrayList<>(52); 
for (Suit suit : Suit.values()) {
	for (Rank rank : Rank.values()) {
		Card card = new Card(suit, rank);
		deck.add(card);
	}
}
	return deck;
}

public int checkDeckSize() {
	return cards.size();
	
}

public Card dealCard () {
	return cards.remove(0);
}

public void shuffleCards () {
	Collections.shuffle(cards);
	System.out.println("*shuffle* *shuffle*");
}
public void printShuffledCards () {
	Collections.shuffle(cards);
	System.out.println("*shuffle* *shuffle*");
	for (Card card : cards) {
		System.out.println(card);
	}
}


}
