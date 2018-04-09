package csci305.javalab;

/*  CSCI 305 Lab 3 - Java Lab
 *  Rock, Paper, Scissors, Lizard, Spock
 *  Nate Tranel - njtranel@gmail.com
 */

//Spock is a specialized form of Element, represents Spock move
public class Spock extends Element {

	public Spock(String inName) {
		super(inName);
	}		//calls parent constructor to set name

	@Override
	public Outcome compareTo(Element e) {				//concrete method here: generates correct outcome based on the element in question
		Outcome o = null;
		switch (e.getName()) {
			case "Rock":
				o = new Outcome("Spock Vaporizes rock", "Win");
				break;
			case "Paper":
				o = new Outcome("Paper disproves Spock", "Lose");
				break;
			case "Scissors":
				o = new Outcome("Spock smashes scissors", "Win");
				break;
			case "Lizard":
				o = new Outcome("Lizard poisons Spock", "Lose");
				break;
			case "Spock":
				o = new Outcome("Spock equals Spock", "Tie");
				break;
		}
		return o;
	}
}
