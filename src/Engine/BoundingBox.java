package Engine;
import processing.core.PVector;
public class BoundingBox {
	public BoundingBox()
	{
				
	}
	//I need to clearly get this
	public BoundingBox(int l, int r, int t, int b)
	{
		  left = l;//so left right top bottom is straight
		 right = r;
		   top = t;
		bottom = b;		
	}
	public void fromSize(PVector size)
	{
		this.left =  -size.x/2f;//it creates the box by taking the half the negative size of x
		this.right =  size.x/2f;//then the right side is the positive of the same half.
		this.top =   -size.y/2f;//same with top and bottom
		this.bottom = size.y/2f;		
	}
	
	public float left;
	public float right;
	public float top;
	public float bottom;
}

