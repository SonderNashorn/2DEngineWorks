package Platformer;

import Engine.*;
import Engine.Components.CarPhysics;
import processing.core.PApplet;
import processing.core.PVector;

public class Player extends Sprite {	
	float acceleration = 3f;
	float deceleration = 1f;
	float rotation = 0f;
	double turnRotation = 20;
	private PVector size = new PVector(12,24);	
	private CarPhysics physics;
	public int stroke = parent.color(120,120,255);
    public int fill = parent.color(255);
	
	public Player (PApplet p){
		super(p);
		}
	
	 public Player(PApplet p, float x, float y, float w, float h) {
	        super(p);
	 }
	
	public void start() {		
	   		 this.transform.position.x = parent.width / 2;
	   		 this.transform.position.y = parent.height / 2;		 
	   		 this.transform.localboundingBox.fromSize(size);
	   		 this.physics = new CarPhysics(this);
	   		 this.physics.start();
	   		 this.physics.speed = acceleration;
	   	 }
		
	@Override
	public void update() {
		super.update();
	}

	public void render(){		
		parent.fill(this.fill);
		parent.stroke(this.stroke);		
		parent.rect(this.transform.position.x, this.transform.position.y, this.size.x, this.size.y);
	}
	
	public void keyPressed(char key, int keyCode) {
		//Need to add the directional feature here too.
		/*
		 * Directions:
		 * UP   = speed +
		 * DOWN = speed -
		 * LEFT = rotate-
		 * RIGHT= rotate+
		 * 
		 * 
		 * */
		   if (keyCode == PApplet.UP) {
			this.physics.move(-acceleration);
		}
		   if (keyCode == PApplet.DOWN) {
			this.physics.move(acceleration);
		}		   
		   if (keyCode == PApplet.LEFT) {
				this.physics.rotate(-turnRotation);
		}	
		   if (keyCode == PApplet.RIGHT) {
			   this.physics.rotate(turnRotation);
		}
}
	public void keyReleased(char key, int keyCode) {
		this.physics.keyUp(deceleration);
	}
	
}

