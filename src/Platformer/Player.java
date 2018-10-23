package Platformer;

import Engine.Sprite;
import processing.core.PApplet;
//this is to draw vectors
import processing.core.PVector;

public class Player extends Sprite {
	//setting up variables 
	float speed = 3f;
	float gravity = 0.1f;
	//player size
	private PVector size = new PVector(12,12);
	//setting a sprite colour from PApplet first the outline then the inside.
	public int stroke = parent.color(120,120,255);
	public int fill = parent.color(255);
	
	public Player (PApplet p){
		super(p);//for some reason super p doesn't work here? needs further investigation
		}
	//again setting two separate PApplet super(p)s for some reason though this time with some variables for width height and coordinates.
	 public Player(PApplet p, float x, float y, float w, float h) {
	        super(p);
	        speed = 3.0f;
	 }
	//in a start method we create ourselves (this.) in the middle. but if I recall correctly that is the exact same position we give ourselves somewhere else.
	        //Launcher.java -> Player player = new Player(parent, parent.width/2,parent.height/2,60, 60); so it creates a player Object and now we create the sprite for it. 
	        //that way it actually becomes visible? hmm, interesting.
	public void start() {
	   		 this.transform.position.x = parent.width / 2;
	   		 this.transform.position.y = parent.height / 2;
	   	 }
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	public void render(){
		//using our fill values we will set the parents fill and stroke
		parent.fill(this.fill);
		parent.stroke(this.stroke);
		//from the parent (Processing) we create a cube that takes our position and size. (PVector12,12);
		parent.rect(this.transform.position.x, this.transform.position.y, this.size.x, this.size.y);

	}
}
