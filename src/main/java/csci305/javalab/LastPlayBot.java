package csci305.javalab;

import static csci305.javalab.Main.moves;

/*  CSCI 305 Lab 3 - Java Lab
 *  Rock, Paper, Scissors, Lizard, Spock
 *  Nate Tranel - njtranel@gmail.com
 */

//represents a bot that repeats whatever its opponent played last hand
public class LastPlayBot extends Player {

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
