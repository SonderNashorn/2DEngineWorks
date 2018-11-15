package Engine;
import processing.core.PApplet;

public class Platform extends Sprite {
	public int strokeColour;
	public int fillColour;
	
	public Platform (PApplet p, float x ,float y, float w, float h)
	{
		super(p, x, y);
		this.size.x = w;
		this.size.y = h;
		
		this.strokeColour = parent.color(255,255,255);//rgb white
		this.fillColour = parent.color(0,0,0);//rgb black
	}		
	public void start(){
		super.start();		
		this.transform.localboundingBox.fromSize(size);
	}
	@Override
	public void update() {
		super.update();
	}
	

	public void render() {
	
		parent.pushMatrix();//resets the matrix grid? for what i understand calling this nullifies the values stored in the matrix
		parent.translate(this.transform.position.x, this.transform.position.y);
		parent.stroke(this.strokeColour);
		parent.fill(this.fillColour);		
		parent.line(0,0,this.size.x,this.size.y);
		/*parent.rectMode(PApplet.CENTER);
		parent.rect(0, 0, this.size.x, this.size.y);*/
		parent.popMatrix();		
	}
}
