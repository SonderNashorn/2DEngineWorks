package Engine;
import processing.core.PApplet;

public abstract class ProcessingCore {
	//this is an abstract class to reach the Processing PApplet easier for other classes (ease of use).
	//publicly available name and ID.
	public String name;
	public int ID;
	//The core PApplet we are rendering ourselves onto.
	public PApplet parent;
	//public method for extending classes to use.
	public ProcessingCore(PApplet p){
        parent = p;
    }
}
