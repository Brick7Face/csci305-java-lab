package csci305.javalab;

import java.util.ArrayList;
import java.util.Random;

import static csci305.javalab.Main.moves;

/*  CSCI 305 Lab 3 - Java Lab
 *  Rock, Paper, Scissors, Lizard, Spock
 *  Nate Tranel - njtranel@gmail.com
 */

//represents a bot that picks a random move every play
public class RandomBot extends Player {

    public RandomBot(String inName) {                            //call super constructor with name attribute
        super(inName);
    }

	//implemented play method
    @Override
    public Element play() {
        Random r = new Random();													//create a new instance of class Random
        ArrayList<String> options = new ArrayList<String>(moves.keySet());			    //convert the moves Map to a List of keys
        return moves.get(options.get(r.nextInt(options.size())));					//generate a random number in the range of # of keys and pick a key based on that number
    }
}
