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

