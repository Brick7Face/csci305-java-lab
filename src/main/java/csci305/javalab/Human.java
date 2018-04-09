package csci305.javalab;

import java.util.Scanner;

import static csci305.javalab.Main.moves;

/*  CSCI 305 Lab 3 - Java Lab
 *  Rock, Paper, Scissors, Lizard, Spock
 *  Nate Tranel - njtranel@gmail.com
 */

//represents a human player and prints a menu for the player to enter a choice through stdin
public class Human extends Player {

    public Human(String inName) {					//constructor simply calls super
        super(inName);
    }

	//implementation of play - prints menu, waits for user input (an int corresponding to choice), contains error checking
    @Override
    public Element play() {
        Scanner in = new Scanner(System.in);																			//initialize the scanner
        System.out.print("(1) : Rock\n(2) : Paper\n(3) : Scissors\n(4) : Lizard\n(5) : Spock\nEnter your move: ");		//print menu
        boolean goodInput = false;																						//flag for accepted user input
        int choice = 0;																									//default choice is 0
        while (!goodInput) {																							//continue to loop while input is invalid
            try {
                choice = in.nextInt();																	//grab next int in stdin
                if (choice > 0 && choice < 6) {														//if the input is within the valid range, flag it as acceptable
                    goodInput = true;
                }
                else {
					System.out.print("Invalid move. Please try again.\nEnter your move: ");			//otherwise print error message and prompt for retry
					in.next();																			//clear input buffer
				}
            } catch (Exception e) {																		//if input is not an int, catch the exception, print an error, retry
                System.out.print("Invalid move. Please try again.\nEnter your move: ");
                in.next();
            }
        }
        switch(choice) {												//return the player's picked move
            case 1:
                return moves.get("Rock");
            case 2:
                return moves.get("Paper");
            case 3:
                return moves.get("Scissors");
            case 4:
                return moves.get("Lizard");
            case 5:
                return moves.get("Spock");
            default: return moves.get("Rock");							//default choice is Rock; if input is valid this line shouldn't be reached
        }
    }
}
