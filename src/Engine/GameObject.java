package Engine;
import processing.core.*;
import java.util.ArrayList;
public abstract class GameObject extends ProcessingCore {
	//this is establishing that its a PApplet and its p variable is its parent. 
	public GameObject(PApplet p) {
		super(p);
		this.components = new ArrayList<GameComponent>();
	}
	
	//public variables
	public String name;
	public String tag;
	
	//Create an array for GameComponents
	public ArrayList<GameComponent> components;
	//a new transform class called through GameObject (a way to modify its position)
	public Transform transform = new Transform();
	//class specific start/render/update functions.
	public abstract void start();
	public abstract void update();
	public abstract void render();
	//a function for others to call the original GameObject name.
	public String ToString() {
		return this.name;
	}
	
}
