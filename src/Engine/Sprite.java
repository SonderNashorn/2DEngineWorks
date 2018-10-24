package Engine;

import processing.core.*;


public abstract class Sprite extends GameObject {
	public PVector size = new PVector(12,12);
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
	public void render() { // update and render every component 
		for (int i = this.components.size() - 1; i >= 0; i--) {
			GameComponent comp = this.components.get(i);
			comp.update();
			comp.render();
		}
	}
	public void start() {
		for(int i = this.components.size() -1; i>=0; i--) {
			GameComponent comp = this.components.get(i);
			comp.start();
		}
		//and start them too.
	}
	public void keyPressed(char key, int keyCode)
	{
		
		
	}
}
