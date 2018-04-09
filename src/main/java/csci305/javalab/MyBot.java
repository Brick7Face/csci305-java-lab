package csci305.javalab;

import java.util.Random;

import static csci305.javalab.Main.moves;

//employ rock-paper-scissors winning strategy for rock, paper, scissors, lizard, spock
public class MyBot extends Player {
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
