package csci305.javalab;

//Outcome is small helper class which contains an outcome based on an evaluation,
//and a value (win/lose/tie)
public class Outcome {
    private String outcome, value;

    //when creating an outcome, set outcome and value
    public Outcome(String inOutcome, String inValue) {
        this.outcome = inOutcome;
        this.value = inValue;
    }

    //print message based on the outcome's value
    public String toString() {
            return outcome + " -- " + value;
        }

    //getter for outcome
    public String getOutcome() {
        return this.outcome;
    }

    //getter for value
    public String getValue() {
        return this.value;
    }
}
