package csci305.javalab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static csci305.javalab.Main.*;

//represents a player in rock, paper, scissors, lizard, spock
//contains a name, a field for the opponent's last play, and 
//whether or not the last hand was a win for the player
public abstract class Player {
    private String name;
    protected Element oppLastPlay;
    protected boolean won;

    public Player(String inName) {					//super constructor called by child classes
        this.name = inName;
    }

    public String getName() {						//getter for name field
        return this.name;
    }

    public void updateWon(boolean value) {			//updates value of won (for encapsulation)
        this.won = value;
    }

    public void setLast(Element last) {				//updates opponent's last play (for encapsulation)
        this.oppLastPlay = last;
    }

    public abstract Element play();					//implemented in child classes
}

//child class of Player; represents a stupid bot that just plays the same move
class StupidBot extends Player {
	
    public StupidBot(String inName) {				//constructor just calls the parent's
        super(inName);
    }

	//overrides + implements method play - simply plays Rock every time
    @Override
    public Element play() {
        return moves.get("Rock");
    }
}

//represents a bot that picks a random move every play
class RandomBot extends Player {

    public RandomBot(String inName) {
        super(inName);
    }

	//implemented play method
    @Override
    public Element play() {
        Random r = new Random();													//create a new instance of class Random
        ArrayList<String> options = new ArrayList<String>(moves.keySet());			//convert the moves Map to a List of keys
        return moves.get(options.get(r.nextInt(options.size())));					//generate a random number in the range of # of keys and pick a key based on that number
    }
}

//represents a bot that starts at one move and iterates through the list of moves
class IterativeBot extends Player {
    private Element lastMove;								//contains the value of it's last move (this may differ from the opponent's last move, naturally)

    public IterativeBot(String inName) {					//calls the super constructor for name and initializes the first move to Rock
        super(inName);
        lastMove = moves.get("Rock");
    }

	//play method implementation - compares to it's last move and moves to the next move in the list; restarts at Rock
    @Override
    public Element play() {
        if (lastMove == moves.get("Rock")) {
            Element newLast = moves.get("Paper");
            lastMove = newLast;
            return newLast;
        }
        else if (lastMove == moves.get("Paper")) {
            Element newLast = moves.get("Scissors");
            lastMove = newLast;
            return newLast;
        }
        else if (lastMove == moves.get("Scissors")) {
            Element newLast = moves.get("Lizard");
            lastMove = newLast;
            return newLast;
        }
        else if (lastMove == moves.get("Lizard")) {
            Element newLast = moves.get("Spock");
            lastMove = newLast;
            return newLast;
        }
        else {
            Element newLast = moves.get("Rock");
            lastMove = newLast;
            return newLast;
        }
    }
}

//represents a bot that repeats whatever its opponent played last hand
class LastPlayBot extends Player {
	
    public LastPlayBot(String inName) {				//call super constructor for name and initialize the first move to Rock
        super(inName);
        oppLastPlay = moves.get("Rock");
    }

	//implementation of play - simply return the last play variable, which is set from main and is updated in the parent class
    @Override
    public Element play() {
        return oppLastPlay;
    }
}

//represents a human player and prints a menu for the player to enter a choice through stdin
class Human extends Player {

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
                if (choice > 0 && choice < 6) {															//if the input is within the valid range, flag it as acceptable
                    goodInput = true;
                }
                else {
					System.out.print("Invalid move. Please try again.\nEnter your move: ");				//otherwise print error message and prompt for retry
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

//employ rock-paper-scissors winning strategy for rock, paper, scissors, lizard, spock
class MyBot extends Player {
    private Element lastPlay;							//tracks local last play

    public MyBot(String inName) {						//calls super, initializes last game to a win, and first play to Rock
        super(inName);
        lastPlay = moves.get("Rock");
        won = true;
    }

	//implementaiton of play - using well known winning strategy for Rock, Paper, Scissors (explained below)
    @Override
    public Element play() {
        if (won) {              //if MyBot won the last hand, switch to an element that would beat it's last play
            lastPlay = findOpposite(lastPlay);
        }
        else {                  //if MyBot lost/tied the hand, switch to an element that would beat the opponent's last play
            lastPlay = findOpposite(oppLastPlay);
        }
        return lastPlay;		//return the final verdict
    }

	//helper method to determine the opposite play of the one passed in
    private Element findOpposite(Element e) {
        Random r = new Random();										//initialize a Random instance
        int choice = r.nextInt(1);										//let the pick of opposite be a random number between 0 and 1 (since there are two options for opposites)
        Element opposite = null;										//move to return at end
        switch (e.getName()) {											//pick between the moves that would be e based on randomly generated number
            case "Rock":
                if (choice == 0) opposite = moves.get("Paper");
                else opposite = moves.get("Spock");
                break;
            case "Paper":
                if (choice == 0) opposite = moves.get("Scissors");
                else opposite = moves.get("Lizard");
                break;
            case "Scissors":
                if (choice == 0) opposite = moves.get("Rock");
                else opposite = moves.get("Spock");
                break;
            case "Lizard":
                if (choice == 0) opposite = moves.get("Scissors");
                else opposite = moves.get("Rock");
                break;
            case "Spock":
                if (choice == 0) opposite = moves.get("Paper");
                else opposite = moves.get("Lizard");
                break;
        }
        return opposite;												//return resulting move
    }
}

