package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackjackHand extends Hand {
// fields


// constructors

	public BlackjackHand() {
	}

//methods
	public void addCard(Card c) {
		this.getCards().add(c);
	}

	public int getHandValue() {
		int handValue = 0;
		for (int i = 0; i < this.getCards().size(); i++) {
			handValue += this.getCards().get(i).getValue();
		}
		return handValue;
	}



//	public void clearHand() {
//		this.getCards() = null;
//		System.out.println("Hand cleared.");
//	}

	}
