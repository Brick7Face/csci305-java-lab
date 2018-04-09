package csci305.javalab;

import static csci305.javalab.Main.moves;

//represents a bot that starts at one move and iterates through the list of moves
public class IterativeBot extends Player {
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
