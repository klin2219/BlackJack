/*
 * Kevin Lin
 * 9/23/2020
 * Blackjack Project
 *
 */

import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args){

        // objects
        Scanner scan = new Scanner(System.in);
        P1Random rng = new P1Random();
        
        int choice = 1, gameNum = 0, numPlayerWins = 0, numDealerWins = 0
                      , numTies = 0, numGames = 0, playerHand = 0,
                        dealerHand, card;

        boolean condition = true;
        double  percentagePlayerWin;

        while(choice != 4){

            // keeps track of number of games and the current game
            if(playerHand == 0) {
                gameNum++;
                numGames++;
                condition = true;
                choice = 1;
                System.out.println("START GAME #" + gameNum);
                System.out.println(" ");
            }

                if (choice == 1) { // if user decides to get a card

                    card = rng.nextInt(13) + 1;

                    // values corresponding to cards
                    if (card == 1) {
                        System.out.println("Your card is a ACE!");
                    } else if (card == 11) {
                        System.out.println("Your card is a JACK!");
                        card = 10;
                    } else if (card == 12) {
                        System.out.println("Your card is a QUEEN!");
                        card = 10;
                    } else if (card == 13) {
                        System.out.println("Your card is a KING!");
                        card = 10;
                    } else {
                        System.out.println("Your card is a " + card + "!");
                    }

                    playerHand = playerHand + card;
                    System.out.println("Your hand is: " + playerHand); // player's hand changes
                    System.out.println(" ");

                    if (playerHand == 21) {
                        System.out.println("BLACKJACK! You win!");
                        numPlayerWins++;
                        dealerHand = 0;
                        playerHand = 0;
                        card = 0;
                        condition = false;
                        System.out.println(" ");
                    } else if (playerHand > 21) {
                        System.out.println("You exceeded 21! You lose.");
                        dealerHand = 0;
                        numDealerWins++;
                        playerHand = 0;
                        card = 0;
                        condition = false;
                        System.out.println(" ");
                    }
                }

                // menu choices for the player
                if(condition) {
                    System.out.println("1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit");
                    System.out.println(" ");

                    // player's option
                    System.out.print("Choose an option: ");
                    choice = scan.nextInt();
                    System.out.println(" ");
                }

                // checks for invalid input
                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.");
                    System.out.println(" ");
                }


                if (choice == 2) { // if user decides to hold hand

                    dealerHand = rng.nextInt(11) + 16;  // 16 and 26 inclusive

                    System.out.println("Dealer's hand: " + dealerHand);
                    System.out.println("Your hand is: " + playerHand);
                    System.out.println(" ");

                    // win loss tie conditions
                    if (dealerHand > 21 || playerHand > dealerHand) {
                        System.out.println("You win!");
                        numPlayerWins++;

                    } else if (dealerHand == playerHand) {
                        System.out.println("It's a tie! No one wins!");
                        numTies++;
                    } else if (dealerHand > playerHand) {
                        System.out.println("Dealer wins!");
                        numDealerWins++;
                    }
                    System.out.println(" ");

                    // helps start a new round
                    dealerHand = 0;
                    playerHand = 0;
                    card = 0;
                }


                if (choice == 3) { // to print statistics
                    System.out.println("Number of Player wins: " + numPlayerWins);
                    System.out.println("Number of Dealer wins: " + numDealerWins);
                    System.out.println("Number of tie games: " + numTies);
                    int tempVal = numGames - 1;
                    System.out.println("Total # of games played is: " + tempVal);
                    percentagePlayerWin = ((double) numPlayerWins / tempVal) * 100;
                    System.out.printf("%s%.1f%s%n", "Percentage of Player wins: ",  percentagePlayerWin, "%");
                    System.out.println(" ");

                }

        }

    }

}



