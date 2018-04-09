package csci305.javalab;

import static csci305.javalab.Main.moves;

//child class of Player; represents a stupid bot that just plays the same move
public class StupidBot extends Player {

    public StupidBot(String inName) {				//constructor just calls the parent's
        super(inName);
    }

	//overrides + implements method play - simply plays Rock every time
    @Override
    public Element play() {
        return moves.get("Rock");
    }
}
