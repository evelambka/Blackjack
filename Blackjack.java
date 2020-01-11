import java.util.Scanner;
public class Blackjack {
    public static void main(String[] args) {
        // this block of code establishes the variables that will keep track of wins and tie games needed if
        // the user chooses to see their statistics.
        int gameNumber = 1;
        P1Random rng = new P1Random();
        Scanner keyboard = new Scanner(System.in);
        int playerWins = 0;
        int dealerWins = 0;
        int tieGames = 0;
        int personResponse = 0;


        //this while loop will continue to run the whole program until the person chooses to exit with option 4.
        //it is also used to increment and establish the game number.
        while (gameNumber >= 1) {
            System.out.println("START GAME #" + gameNumber);
            System.out.println(" ");
            int personTotal = (rng.nextInt(13) + 1);

            //this block if else statement tells the system to output the names of the face cards rather than their values.
            if (personTotal == 1) {
                System.out.println("Your card is a ACE!");
            } else if (personTotal == 11) {
                personTotal = 10;
                System.out.println("Your card is a JACK!");
            } else if (personTotal == 12) {
                personTotal = 10;
                System.out.println("Your card is a QUEEN!");
            } else if (personTotal == 13) {
                personTotal = 10;
                System.out.println("Your card is a KING!");
            } else {
                System.out.println("Your card is a " + personTotal + "!");
            }
            System.out.println("Your hand is: " + personTotal);

            //this while loop is for just one game of blackjack. it will continue to loop until there is either a
            //win for the dealer/player or a tie.
            while (personTotal <= 21) {
                int secondNumber = 0;
                int runningTotal = 0;

                System.out.println("1.  Get another card");
                System.out.println("2.  Hold hand");
                System.out.println("3.  Print statistics");
                System.out.println("4.  Exit");

                //this gets the input from the user on which option they choose
                System.out.print("Choose an option: ");
                personResponse = keyboard.nextInt();
                System.out.println(" ");

                //this if statement tells the program that the user is done playing the game.
                if (personResponse == 4) {
                    break;
                }

                //this if else statement tells the user that their input is wrong if they choose a number other than 1-4.
                if (personResponse < 1 || personResponse > 4) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");
                    System.out.println(" ");

                //this if else statement covers everything that happens when the user chooses to draw another card.
                } else if (personResponse == 1) {
                    secondNumber = (rng.nextInt(13) + 1);
                    if (secondNumber == 1) {
                        System.out.println("Your card is a ACE!");
                    } else if (secondNumber == 11) {
                        secondNumber = 10;
                        System.out.println("Your card is a JACK!");
                    } else if (secondNumber == 12) {
                        secondNumber = 10;
                        System.out.println("Your card is a QUEEN!");
                    } else if (secondNumber == 13) {
                        secondNumber = 10;
                        System.out.println("Your card is a KING!");
                    } else {
                        System.out.println("Your card is a " + secondNumber + "!");
                    }
                    //this block of code keeps track of the total value of the user's hand.
                    personTotal = secondNumber + personTotal;
                    runningTotal = personTotal + runningTotal;
                    System.out.println("Your hand is: " + runningTotal);
                    System.out.println(" ");
                    if (runningTotal == 21) {
                        System.out.println("BLACKJACK! You win!");
                        playerWins++;
                        break;
                    }
                }

                runningTotal = personTotal + runningTotal;

                // this if statement covers everything that happens when the user chooses to hold their hand.
                // therefore, this section has to do with the dealer's hand.
                if (personResponse == 2) {
                    int dealerHand;
                    dealerHand = rng.nextInt(11) + 16;
                    System.out.println("Dealer's hand: " + dealerHand);
                    System.out.println("Your hand is: " + runningTotal);
                    //this whole if statement establishes how the program will find out if the player or the dealer won.
                    //it also increments the player wins and dealer wins used for the statistics section later on.
                    if (dealerHand < runningTotal) {
                        if (runningTotal <= 21) {
                            System.out.println("You win!");
                            playerWins++;
                        } else {
                            System.out.println("Dealer wins!");
                            dealerWins++;
                        }
                        break;
                    } else if (dealerHand > runningTotal) {
                        if (dealerHand <= 21) {
                            System.out.println("Dealer wins!");
                            dealerWins++;
                        } else {
                            System.out.println("You win!");
                            playerWins++;
                        }
                        break;
                    } else {
                        System.out.println("It's a tie! No one wins!");
                        tieGames ++;
                        break;
                    }
                }

                //this if statement covers everything that will happen when the user wants to see their statistics.
                if (personResponse == 3) {
                    System.out.println("Number of Player wins: " + playerWins);
                    System.out.println("Number of Dealer wins: " + dealerWins);
                    System.out.println("Number of tie games : " + tieGames);
                    System.out.println("Total # of games played is: " + (gameNumber - 1));
                    double winPercent;
                    winPercent = Math.round(((double) playerWins / (gameNumber - 1.0)) * 100.0);
                    System.out.println("Percentage of Player wins: " + winPercent + "%");
                }

            // this if statement tells the player that they lose if their hand exceeds 21.
            if (personTotal > 21) {
                System.out.println("You exceeded 21! You lose.");
                dealerWins ++;
            }

            //the remaining if statement just breaks the remaining while loop when the user wants to exit the game.
            }
            if (personResponse == 4) {
                break;
            }
        gameNumber ++;

        }
    }
}