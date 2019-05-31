package com.skilldistillery.blackjack;


public class Card {

	private Suit suit;
	private Rank rank;

	/*
	 * A card has a Suit and Rank. Set these in the constructor. Generate the
	 * methods hashCode and equals Add a toString which says rank + " of " + suit.
	 * Add a method getValue to return the card's numeric value.
	 */
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public Card() {
	}

	public String toString() {
		String rankAndSuitString = (rank + " of " + suit);
		return rankAndSuitString;
	}

	public int getValue() {
		return rank.getValue();
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

}
