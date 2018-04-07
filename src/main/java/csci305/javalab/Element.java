package csci305.javalab;


//Element class represents the parent of each of five possible moves:
//rock, paper, scissors, lizard, or spock, each with similar attributes
public abstract class Element {
	private String name;									//contains a name
	
	public Element(String inName) {
		name = inName;
	}	//name set in constructor
	
	public String getName() {							//getter for name of element
		return this.name;
	}
	
	public abstract Outcome compareTo(Element e);		//concrete methods in child classes
}

//Rock is a specialized form of Element
class Rock extends Element {

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

//Paper is a specialized form of Element
class Paper extends Element {
	
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

//Scissors is a specialized form of Element
class Scissors extends Element {
	
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

//Lizard is a specialized form of Element
class Lizard extends Element {
	
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

//Spock is a specialized form of Element
class Spock extends Element {
	
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
