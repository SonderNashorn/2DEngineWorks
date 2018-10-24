package Engine;
import processing.core.PApplet;

public class Platform extends Sprite {
	//local variables
	public int width;
	public int height;
	int strokeColour;
	int fillColour;
	
	//taking Sprite's original processing variable coordinates and size
	public Platform (PApplet p, int x ,int y, int w, int h)
	{
		super(p,x,y);
		this.width = w;
		this.height = h;
		this.strokeColour = parent.color(255,255,255);//rgb white
		this.fillColour = parent.color(0,0,0);//rgb black
	}		
	public void start(){
		super.start();		
	}
	@Override
	public void update() {
	}

	public void render() {
		super.render();
		parent.pushMatrix();//resets the matrix grid? for what i understand calling this nullifies the values stored in the matrix
		parent.translate(this.transform.position.x, this.transform.position.y);
		parent.stroke(this.strokeColour);
		parent.fill(this.fillColour);
		parent.rect(0, 0, this.width, this.height);
		parent.popMatrix();		
	}
}
