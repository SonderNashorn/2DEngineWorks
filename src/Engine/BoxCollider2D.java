package Engine;

public class BoxCollider2D extends ProcessingCore {
	public BoundingBox boundingBox;
	public Transform transform = new Transform();
	public BoxCollider2D(GameObject g) {
		super(g.parent);
		this.transform = g.transform;
	}
	public boolean checkCollision(BoundingBox platform_bb){
		//here the bounding box is our worldbounding box.??? so it creates a box for the entire window.
		this.boundingBox = this.transform.WorldBoundingBox();
		//if the platforms left is smaller than the bb's right and the platforms right is bigger than bb's left
		if(platform_bb.left < this.boundingBox.right && platform_bb.right > this.boundingBox.left) {
			//transform this position by top - bottom?
			this.transform.position.y = platform_bb.top - this.transform.boundingBox.bottom;
			return true;			
		}
		if (platform_bb.bottom <this.boundingBox.top) {
			
		}
		return false;
	}
}
