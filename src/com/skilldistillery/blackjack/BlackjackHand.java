package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackjackHand extends Hand {
// fields
	private int handQty;
	private List<Card> cards = new ArrayList<Card>(handQty);
	private Deck deck = new Deck();

// constructors

	public BlackjackHand() {
	}

//methods
	public void addCard(int qty) {
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

	public List<Card> getCards() {

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
