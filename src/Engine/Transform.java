package Engine;
import processing.core.PVector;

public class Transform {
	
	public Transform() {}
	//here we establish a Vector for position at 0,0 a rotation 0,0 and a scale of 0.0
	public PVector position = new PVector(0,0);
	public PVector rotation = new PVector(0,0);
	public PVector scale = new PVector(0,0);
	
	public BoundingBox boundingBox = new BoundingBox(-1,1,-1,1);
	public BoundingBox WorldBoundingBox() {
		BoundingBox bb = new BoundingBox();
		bb.left = position.x + boundingBox.left;
		bb.right = position.x + boundingBox.right;
		bb.top = position.y + boundingBox.top;
		bb.bottom = position.y + boundingBox.bottom;
		return bb;	
	}
}
