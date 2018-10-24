package Engine;
import processing.core.PVector;

public class Physics2D extends GameComponent {
	private PVector velocity = new PVector(0,0);
	float gravity = 0.1f;
	boolean canJump = true;
	
	public Physics2D(GameObject g) {
		super(g);	
	}
	
	@Override
	public void start() {
	}

	@Override
	public void render() {
	}

	@Override
	public void update() {
		
		gravityEffect();
		//applies a vector to on the Y axis 
		this.transform.position.y += velocity.y;
		
	}
//a "jump" ability that if canjump is true applies a negative force (that pushes up)
	public void jump (int force)
	{
		if(canJump)
		{
			velocity.y = -force;
			canJump = false;			
		}		
	}
	public void isGrounded() {
	canJump = true;
	}
	private void gravityEffect()
	{
		velocity.y += gravity;
		if(velocity.y >= 4f)
		{
			velocity.y = 4f;			
		}
		
	}
}
