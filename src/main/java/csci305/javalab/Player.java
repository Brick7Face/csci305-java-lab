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

