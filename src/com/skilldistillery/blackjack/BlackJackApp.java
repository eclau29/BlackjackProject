package com.skilldistillery.blackjack;

import java.util.List;
import java.util.Scanner;

public class BlackJackApp {

	Dealer dealer = new Dealer();
	Hand playerHand;
	Hand dealerHand;

	public static void main(String[] args) {
		BlackJackApp blackjack = new BlackJackApp();
		Scanner kb = new Scanner(System.in);

		blackjack.run(kb);

		kb.close();
	}

	private void run(Scanner kb) {
		System.out.println("Welcome to BlackJack Sim! Hope you're feeling lucky!\n");
		boolean cont = true;
		String userCont;

		while (cont) {
			dealer.getDeck().shuffleCards();
			playerHand = new BlackjackHand();
			dealerHand = new BlackjackHand();
			boolean hitOrStay = true;
			int playerHandValue = 0;

			for (int i = 0; i < 2; i++) {
				playerHand.addCard(dealer.getDeck().dealCard());

				dealerHand.addCard(dealer.getDeck().dealCard());
			}

			System.out.println("Player: " + playerHand + "(" + playerHand.getHandValue() + ")");
			System.out.println("Dealer: " + dealerHand.getCards().get(0) + "\n");
			do {
				if (playerHand.getHandValue() == 21) {
					System.out.print("Congratulations, you're a winner!\nWould you like to play again? (Y/N) ");
					cont = cont(kb);
					if (cont) {
						break;
					} else {
						System.out.println("Thanks for playing!");
						System.exit(0);
					}
				}
				if (dealerHand.getHandValue() == 21) {
					System.out.print("Sorry, dealer wins :P Try again? (Y/N) ");
					cont = cont(kb);
					if (cont) {
						break;
					} else {
						System.out.println("Thanks for playing!");
						System.exit(0);
					}
				}

				hitOrStay = hitOrStay(kb);
				if (hitOrStay) {
					playerHand.addCard(dealer.getDeck().dealCard());
					System.out.println("Player: " + playerHand + "(" + playerHand.getHandValue() + ")");
					if (playerHand.getHandValue() > 21) {
						System.out.print("Aww, you lost :( \nPlay again? (Y/N) ");
						cont = cont(kb);
						if (cont) {
							break;
						} else {
							System.out.println("Thanks for playing!");
							System.exit(0);
						}

					}

				}

			} while (hitOrStay);

			while (dealerHand.getHandValue() < 17) {
				dealerHand.addCard(dealer.getDeck().dealCard());
			}

			if (playerHand.getHandValue() > 21) {
				System.out.println("Player loses! *womp womp* \nWould you like to try your luck again? (Y/N) ");
				cont = cont(kb);
				if (!cont) {
					System.out.println("Thanks for playing!");
					System.exit(0);
				} 

			} else if (dealerHand.getHandValue() > 21) {
				System.out.println("Dealer: " + dealerHand + "(" + dealerHand.getHandValue() + ")");
				System.out.println("Dealer loses, player wins! Congrats! :D Play again? (Y/N) ");
				cont = cont(kb);
				if (!cont) {
					System.out.println("Thanks for playing!");
					System.exit(0);
				} 

			} else if (dealerHand.getHandValue() < 17) {
				while (dealerHand.getHandValue() < 17) {
					dealerHand.addCard(dealer.getDeck().dealCard());
				}
			} else if (dealerHand.getHandValue() > playerHand.getHandValue()) {
				System.out.println("Dealer: " + dealerHand);
				System.out.println("Dealer wins! Better luck next time!\n . . . ");
				System.out.print("...is it \"next time\" now? (\"Y\" to continue, \"N\" to end game) ");
				cont = cont(kb);
				if (!cont) {
					System.out.println("Thanks for playing!");
					System.exit(0);
				} 

			} else if (dealerHand.getHandValue() < playerHand.getHandValue()) {
				System.out.println("Dealer: " + dealerHand + "(" + dealerHand.getHandValue() + ")");
				System.out.print("Player wins! Congratulations, it's your lucky day! Play again? (Y/N) ");
				cont = cont(kb);
				if (!cont) {
					System.out.println("Thanks for playing!");
					System.exit(0);
				} 

			} else if (dealerHand.getHandValue() == playerHand.getHandValue()) {
				System.out.print("It's a tie! Want a rematch?? >:D (Y/N) ");
				cont = cont(kb);
				if (!cont) {
					System.out.println("Thanks for playing!");
					System.exit(0);
				} 
			}

		}
	}

	public boolean hitOrStay(Scanner kb) {
		System.out.println("Would you like to hit or stay? \nType \"1\" for HIT\nType \"2\" to Stay ");
		int userResp = kb.nextInt();
		boolean hitOrStay = true;
		if (userResp == 1) {
			hitOrStay = true;
		} else if (userResp == 2) {
			hitOrStay = false;
		}
		return hitOrStay;
	}

	public boolean cont(Scanner kb) {
		String userCont = kb.next();
		boolean cont = true;
		if (userCont.equalsIgnoreCase("n")) {
			cont = false;
		} 
		return cont;
	}
}
