package csci305.javalab;

/*  CSCI 305 Lab 3 - Java Lab
 *  Rock, Paper, Scissors, Lizard, Spock
 *  Nate Tranel - njtranel@gmail.com
 */

 //This class was part of the assignment
 //self-checks and was not generated by me.
 //It was to test the Player class and subclasses.
public class TestPlayers {

	//create instances of StupidBot and RandomBot and test their play functions
    public static void main(String args[]) {
        Player p1 = new StupidBot("StupidBot");
        Player p2 = new RandomBot("RandomBot");
        Element p1move = p1.play();
        Element p2move = p2.play();
        System.out.println(p1move.compareTo(p2move));
    }
}