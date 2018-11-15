package Engine;
import processing.core.*;
import java.util.ArrayList;

import Engine.Components.GameComponent;
public abstract class GameObject extends ProcessingCore {
	//this is establishing that its a PApplet and its p variable is its parent. 
	public GameObject(PApplet p) {
		super(p);
		this.components = new ArrayList<GameComponent>();
	}
		
	public String name;
	public String tag;
	
	public ArrayList<GameComponent> components;
	public Transform transform = new Transform();
	public abstract void start();
	public abstract void update();
	public abstract void render();
	
	public void keyReleased(char key, int keyCode) {}
	public void keyPressed(char key, int keyCode) {}	

	public String ToString() {
		return this.name;
	}
	
}
