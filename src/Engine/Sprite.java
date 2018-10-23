package Engine;
import processing.core.PApplet;

public abstract class Sprite extends GameObject {
	public Sprite(PApplet p) {
		super(p);
	}
	//to be quite honest I have no clue why we need to establish PApplet p twice.
	public Sprite(PApplet p, int x, int y)
	{
		super(p);	
		this.transform.position.x = x;
		this.transform.position.y = y;
		
	}
	

	//update(); instead of update(){} because reasons
	public abstract void update();

	//this will override the parents Render if we use it.
	@Override
	public void render() {
		//We'll render our components here.

	}
	public void start() {
		//and start them too.
	}
}
