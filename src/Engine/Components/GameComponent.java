package Engine.Components;

import Engine.GameObject;
import Engine.ProcessingCore;
import Engine.Transform;

public abstract class GameComponent extends ProcessingCore {
	public GameComponent(GameObject g) {
		super(g.parent); 
		//Generic components
		this.gameObject = g;
		this.transform = this.gameObject.transform;
		this.gameObject.components.add(this);
	}
	public GameObject gameObject;
	public Transform transform;
	public abstract void start();
	public abstract void render();
	public abstract void update();	
}
