package Engine;
import Engine.Components.BoundingBox;
import processing.core.PVector;
public class Transform {
	
	public Transform() {}
	public PVector prev_position   = new PVector(0,0);
	public PVector position 	   = new PVector(0,0);
	public PVector rotation 	   = new PVector(0,0);
	public PVector scale 		   = new PVector(0,0);
	public BoundingBox localboundingBox = new BoundingBox(-1,1,-1,1);
	public BoundingBox worldboundingBox = new BoundingBox(-1,1,-1,1); 
	
	public BoundingBox PreviousWorldBoundingBox() {
		BoundingBox bb  = new BoundingBox();
		bb.center_x 	= prev_position.x;
		bb.center_y 	= prev_position.y;
		bb.left 		= prev_position.x + localboundingBox.left;
		bb.right 		= prev_position.x + localboundingBox.right;
		bb.top 			= prev_position.y + localboundingBox.top;
		bb.bottom 		= prev_position.y + localboundingBox.bottom;
		return bb;
	}
	
	public BoundingBox NewWorldBoundingBox() {
		BoundingBox bb  = new BoundingBox();
		bb.center_x 	= position.x;
		bb.center_y 	= position.y;
		bb.left 		= position.x + localboundingBox.left;
		bb.right 		= position.x + localboundingBox.right;
		bb.top 			= position.y + localboundingBox.top;
		bb.bottom 		= position.y + localboundingBox.bottom;
		return this.worldboundingBox;
	}
}
