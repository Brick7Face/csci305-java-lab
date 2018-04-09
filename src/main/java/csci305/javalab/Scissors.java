package csci305.javalab;

/*  CSCI 305 Lab 3 - Java Lab
 *  Rock, Paper, Scissors, Lizard, Spock
 *  Nate Tranel - njtranel@gmail.com
 */

//Scissors is a specialized form of Element, represents Scissors movement
public class Scissors extends Element {

	public Scissors(String inName) {
		super(inName);
	}	//calls parent constructor to set name

	@Override
	public Outcome compareTo(Element e) {				//concrete method here: generates correct outcome based on the element in question
		Outcome o = null;
		switch (e.getName()) {
			case "Rock":
				o = new Outcome("Rock crushes Scissors", "Lose");
				break;
			case "Paper":
				o = new Outcome("Scissors cut paper", "Win");
				break;
			case "Scissors":
				o = new Outcome("Scissors equal scissors", "Tie");
				break;
			case "Lizard":
				o = new Outcome("Scissors decapitate lizard", "Win");
				break;
			case "Spock":
				o = new Outcome("Spock smashes scissors", "Lose");
				break;
		}
		return o;
	}
}
