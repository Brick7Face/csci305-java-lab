package csci305.javalab;

//Rock is a specialized form of Element
public class Rock extends Element {

	public Rock(String inName) {
		super(inName);
	}		//calls parent constructor to set name

	@Override
	public Outcome compareTo(Element e) {				//concrete method here: generates correct outcome based on the element in question
		Outcome o = null;
		switch (e.getName()) {
			case "Rock":
				o = new Outcome("Rock equals rock", "Tie");
				break;
			case "Paper":
				o = new Outcome("Paper covers rock", "Lose");
				break;
			case "Scissors":
				o = new Outcome("Rock crushes scissors", "Win");
				break;
			case "Lizard":
				o = new Outcome("Rock crushes lizard", "Win");
				break;
			case "Spock":
				o = new Outcome("Spock vaporizes rock", "Lose");
				break;
		}
		return o;
	}
}
