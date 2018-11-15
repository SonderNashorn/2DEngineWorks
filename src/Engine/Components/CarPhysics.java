package Engine.Components;

import processing.core.PVector;
import Engine.GameManager;
import Engine.GameObject;
import processing.core.PApplet;
import Engine.DirectionInfo;

public class CarPhysics extends GameComponent {
	int frameDelay = 2;
	private PVector velocity = new PVector(0, 0);
	public BoxCollider2D boxCollider2D;
	public float rotation = 0f;
	public float speed = 3f;
	public float maxSpeed = 6f;
	
	public CarPhysics(GameObject g) {
		super(g);	
	}
	public void start() {
		this.boxCollider2D = new BoxCollider2D(this.gameObject);
	}
	
	public void render() {
	}
public void update() {		
		if (GameManager.frameCount % frameDelay == 0) {
			}
		this.transform.prev_position.x = this.transform.position.x;
		this.transform.prev_position.y = this.transform.position.y;
		//need to add a proper direction control 
		//idea: push W increase speed towards direction we are facing.
		//what I need then is a direction check and then apply velocity towards that Y or X
		//perhaps an Enumerator.
		if (PApplet.abs(velocity.x) >= maxSpeed) {
			if(velocity.x > 0)
				velocity.x = maxSpeed;
			else
				velocity.x = -maxSpeed;
		}
		
		//add patches where you get slowed down (max speed reduces)
		checkCollisions();
	}
	private void checkCollisions(){	
	if (PApplet.abs( this.transform.prev_position.x - this.transform.position.x) < 0.1f) {
		if (PApplet.abs( this.transform.prev_position.y - this.transform.position.y) < 0.1f) {
			return;
			}
		}
	
	//using Rod Martin's Hitinfo reworked to be used in my game 
	
	for (int i = 0; i < GameManager.gameBoundingBoxes.size(); i++) {
		//NTS check this thoroughly to make sure I understand the concept so I can use it properly afterwards
		HitInfo hitInfo = new HitInfo();
		hitInfo.boundingBox = GameManager.gameBoundingBoxes.get(i);
		hitInfo = this.boxCollider2D.checkCollision(hitInfo);
		if (hitInfo.didHit) {			
			switch (hitInfo.hitSide) {
			case TOP:
				this.velocity.y = 0f;
				this.transform.position.y = hitInfo.boundingBox.bottom + this.transform.localboundingBox.bottom;

				break;
				
			case BOTTOM:
				this.velocity.y = 0f;
				this.transform.position.y = hitInfo.boundingBox.top + this.transform.localboundingBox.top;
								
				break;
			case LEFT:
				this.velocity.x = 0f;
				this.transform.position.x = hitInfo.boundingBox.left + this.transform.localboundingBox.left;

				break;
			case RIGHT:
				this.velocity.x = 0f;
				this.transform.position.x = hitInfo.boundingBox.right + this.transform.localboundingBox.right;

				break;
			case NONE:
				break;
			}
		}

	}
	}
	
	public void move(float force) {		
			//velocity.x += force;
		/* first attempt, trying to work with directions*/
		DirectionInfo direction = new DirectionInfo();
		  switch (direction.facingDirection){
		  case NORTH:
		  		this.velocity.y +=force;
		  		break;
		  case SOUTH:
		  		this.velocity.y -=force;
		  		break;
		  case EAST:
		  		this.velocity.x +=force;
		  		break;
		  case WEST:
		  		this.velocity.x -=force;
		  		break;
		  }
	}
	//personal directions:
	//determine where the player or anyone for that matter is facing and increase their speed towards that direction.
 public double rotate(double degree)
 {
	 degree = rotate(PApplet.PI/4.0);
	 return degree;
 }
	
	public void keyUp(float slow) {		
			velocity.x -= slow;
	}
}

