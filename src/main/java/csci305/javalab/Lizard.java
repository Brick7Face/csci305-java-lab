package csci305.javalab;

//Lizard is a specialized form of Element
public class Lizard extends Element {

	public Lizard(String inName) {
		super(inName);
	}		//calls parent constructor to set name

	@Override
	public Outcome compareTo(Element e) {				//concrete method here: generates correct outcome based on the element in question
		Outcome o = null;
		switch (e.getName()) {
			case "Rock":
				o = new Outcome("Rock crushes lizard", "Lose");
				break;
			case "Paper":
				o = new Outcome("Lizard eats paper", "Win");
				break;
			case "Scissors":
				o = new Outcome("Scissors decapitate lizard", "Lose");
				break;
			case "Lizard":
				o = new Outcome("Lizard equals lizard", "Tie");
				break;
			case "Spock":
				o = new Outcome("Lizard poisons Spock", "Win");
				break;
		}
		return o;
	}
}
