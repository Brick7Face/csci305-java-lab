package csci305.javalab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*  CSCI 305 Lab 3 - Java Lab
 *  Rock, Paper, Scissors, Lizard, Spock
 *  Nate Tranel - njtranel@gmail.com
 */

public class Main {
    //instance variables to create final map containing these elements
    private static Element rock = new Rock("Rock");
    private static Element paper = new Paper("Paper");
    private static Element scissors = new Scissors("Scissors");
    private static Element lizard = new Lizard("Lizard");
    private static Element spock = new Spock("Spock");
    //map containing the 5 possible moves
    public static final Map<String, Element> moves = new HashMap<String, Element>() {{
            put(rock.getName(), rock);
            put(paper.getName(), paper);
            put(scissors.getName(), scissors);
            put(lizard.getName(), lizard);
            put(spock.getName(), spock);
        }};

    //simulate a game of rock, paper, scissors, lizard, spock with five rounds
    public static void main(String args[]) {
        Player player1, player2;                                //player variables
        Scanner in = new Scanner(System.in);                    //initialize scanner to read input and print menu below
        System.out.println("Welcome to Rock, Paper, Scissors, Lizard, Spock, implemented by Nate Tranel.\n");
        System.out.print("Please choose two players:\n\t(1) Human\n\t(2) StupidBot\n\t(3) RandomBot\n\t(4) IterativeBot\n\t(5) LastPlayBot\n\t(6) MyBot\n\nSelect player 1: ");
        boolean goodInput = false;                              //flag to determine if input is valid
        int choice1 = 0;                                        //represents the choice of player 1
        while (!goodInput) {                                    //loop until the input is valid
            try {
                choice1 = in.nextInt();                         //grab an int choice from standard in
                if (choice1 > 0 && choice1 < 7) {               //check if input is within acceptable range
                    goodInput = true;                           //if so, validate it, otherwise, print error and retry
                } else System.out.print("Invalid selection. Please try again.\nSelect player 1: ");
            } catch (Exception e) {                             //if user inserts string or otherwise, catch the exception, print error and retry
                System.out.print("Invalid selection. Please try again.\nSelect player 1: ");
                in.next();                                      //clear input buffer to prevent infinite loop
            }
        }
        System.out.print("Select player 2: ");                  //repeat the above steps for player 2's menu
        goodInput = false;
        int choice2 = 0;
        while (!goodInput) {
            try {
                choice2 = in.nextInt();
                if (choice2 > 0 && choice2 < 7) {
                    goodInput = true;
                } else System.out.print("Invalid selection. Please try again.\nSelect player 2: ");
            } catch (Exception e) {
                System.out.print("Invalid selection. Please try again.\nSelect player 2: ");
                in.next();
            }
        }
        switch(choice1) {                                       //setup player1 based on player 1's choice
            case 1:
                player1 = new Human("Human");
                break;
            case 2:
                player1 = new StupidBot("StupidBot");
                break;
            case 3:
                player1 = new RandomBot("RandomBot");
                break;
            case 4:
                player1 = new IterativeBot("IterativeBot");
                break;
            case 5:
                player1 = new LastPlayBot("LastPlayBot");
                break;
            case 6:
                player1 = new MyBot("MyBot");
                break;
            default:                                            //should not reach this statement (checked for above)
                player1 = null;
                break;
        }
        switch(choice2) {                                       //repeat the same setup for player2 based on player 2's choice
            case 1:
                player2 = new Human("Human");
                break;
            case 2:
                player2 = new StupidBot("StupidBot");
                break;
            case 3:
                player2 = new RandomBot("RandomBot");
                break;
            case 4:
                player2 = new IterativeBot("IterativeBot");
                break;
            case 5:
                player2 = new LastPlayBot("LastPlayBot");
                break;
            case 6:
                player2 = new MyBot("MyBot");
                break;
            default:                                            //again, should never reach this statement
                player2 = null;
                break;
        }
        System.out.printf("\n%s vs %s. Go!\n\n", player1.getName(), player2.getName());
        int scoreOne = 0;                                       //variables to keep score and round information, so more or less rounds could be played
        int scoreTwo = 0;
        int maxRound = 5;
        int roundCount = 1;
        while (roundCount <= maxRound) {                        //continue playing until the round maximum is reached
            System.out.printf("Round %d\n", roundCount);
            Element play1 = player1.play();                     //player 1 moves
            Element play2 = player2.play();                     //player 2 moves
            player1.setLast(play2);
            player2.setLast(play1);
            System.out.printf("Player 1 chose %s\nPlayer 2 chose %s\n", play1.getName(), play2.getName());
            Outcome result = play1.compareTo(play2);            //evaluate the outcome based on the moves
            System.out.println(result.getOutcome());
            if (result.getValue().equals("Win")) {                   //if player1 won, print message and increase their score
                System.out.println("Player 1 won the round\n");
                player1.updateWon(true);
                player2.updateWon(false);
                scoreOne++;
            }
            else if (result.getValue().equals("Tie")) {              //if round was tie, print results
                System.out.println("Round was a tie\n");
                player1.updateWon(false);
                player2.updateWon(false);
            }
            else {                                              //if player1 lost, print victory message for player2 and increase their score
                System.out.println("Player 2 won the round\n");
                player1.updateWon(false);
                player2.updateWon(true);
                scoreTwo++;
            }
            roundCount++;                                       //increment the round counter
        }
        System.out.printf("The score is %d to %d.\n", scoreOne, scoreTwo);
        if (scoreOne > scoreTwo) {                              //evaluate the winner based on the score - player1 wins if scoreOne is higher
            System.out.println("Player 1 wins the game");
        }
        else if (scoreOne == scoreTwo) {                        //if the scores are equal, then it is a tie
            System.out.println("Game was a draw");
        }
        else {
            System.out.println("Player 2 wins the game");       //otherwise player 2 wins
        }
    }
}
