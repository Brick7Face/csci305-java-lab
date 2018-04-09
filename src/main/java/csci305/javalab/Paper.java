package csci305.javalab;

/*  CSCI 305 Lab 3 - Java Lab
 *  Rock, Paper, Scissors, Lizard, Spock
 *  Nate Tranel - njtranel@gmail.com
 */

//Paper is a specialized form of Element, represents Paper move
public class Paper extends Element {

	public Paper(String inName) {
		super(inName);
	}		//calls parent constructor to set name

	@Override
	public Outcome compareTo(Element e) {				//concrete method here: generates correct outcome based on the element in question
		Outcome o = null;
		switch (e.getName()) {
			case "Rock":
				o = new Outcome("Paper covers rock", "Win");
				break;
			case "Paper":
				o = new Outcome("Paper equals paper", "Tie");
				break;
			case "Scissors":
				o = new Outcome("Scissors cut paper", "Lose");
				break;
			case "Lizard":
				o = new Outcome("Lizard eats paper", "Lose");
				break;
			case "Spock":
				o = new Outcome("Paper disproves Spock", "Win");
				break;
		}
		return o;
	}
}
