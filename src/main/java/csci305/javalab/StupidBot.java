package csci305.javalab;

import static csci305.javalab.Main.moves;

/*  CSCI 305 Lab 3 - Java Lab
 *  Rock, Paper, Scissors, Lizard, Spock
 *  Nate Tranel - njtranel@gmail.com
 */

//child class of Player; represents a stupid bot that just plays the same move
public class StupidBot extends Player {

    public StupidBot(String inName) {                //constructor just calls the parent constructor with name attribute
        super(inName);
    }

    //overrides + implements method play - simply plays Rock every time
    @Override
    public Element play() {
        return moves.get("Rock");
    }
}
