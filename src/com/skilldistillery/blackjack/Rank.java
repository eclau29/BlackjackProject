package com.skilldistillery.blackjack;

public enum Rank {
	
	/*Add a private value field to Rank.
Add a one-arg constructor to Rank and set the value field to 2-10 for numbers, 
10 for JACK, QUEEN, and KING, and 11 for ACE.
Add a getValue() method to return the value.
*/
	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), 
	JACK(10), QUEEN(10), KING(10), 
	ACE(11);
	
	private final int value;

	private Rank(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}
