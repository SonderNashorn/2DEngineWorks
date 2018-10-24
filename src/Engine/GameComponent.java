package Engine;


public abstract class GameComponent extends ProcessingCore {
	public GameComponent(GameObject g) {
		super(g.parent); //what's the difference between PApplet p and g.parent?
						//unless it's the fact that we don't import PApplet here
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
