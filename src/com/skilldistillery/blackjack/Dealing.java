package com.skilldistillery.blackjack;

import java.util.Scanner;

public class Dealing {
private Deck deck; // a Deck is a List<Card>;
private Card cards;

public static void main(String[] args) {
	Deck deck = new Deck();
	Scanner kb = new Scanner(System.in);
	
	Dealing dealing = new Dealing(deck);
	dealing.run(kb);
	
	
	
	
	kb.close();
	
}


private void run(Scanner kb) {
	deck.shuffleCards();
	System.out.println("How many cards would you like?");
	int pnumCards = kb.nextInt();
	try {
		if (pnumCards < 52) {
		for (int i = 0; i < pnumCards; i++) {
			deck.dealCard();
			System.out.println(deck.dealCard());
		}
		} else {
			System.err.println("That's too many cards, silly!");
		}
	} catch (Exception e) {
		System.err.println("Invalid number of cards. Try again.");
	}
	
	
}


public Dealing(Deck deck) {
	this.deck = deck;
}



/*Write a program to ask a user how many cards they want.

Handle the case where users enter a non-integer or a number greater than 
52: print an error message.
Deal the cards and display them on the screen. Also display the total value 
of all cards.
 * 
 */
	


}
