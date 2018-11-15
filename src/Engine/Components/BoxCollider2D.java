package Engine.Components;

import Engine.GameObject;
import Engine.ProcessingCore;
import Engine.Sides;
import Engine.Transform;

public class BoxCollider2D extends ProcessingCore {

	public Transform transform = new Transform();
	public BoxCollider2D(GameObject g) {
		super(g.parent);
		this.transform = g.transform;
	}
	public HitInfo checkCollision(HitInfo hitInfo) {
		// collision with static _boundingBox
		BoundingBox new_bb;
		new_bb = this.transform.NewWorldBoundingBox();
		BoundingBox prev_bb;
		prev_bb = this.transform.PreviousWorldBoundingBox();
		BoundingBox tile_bb = hitInfo.boundingBox;
		if (this.transform.position.y > tile_bb.top && this.transform.position.y < tile_bb.bottom) {
			
			if (new_bb.left < tile_bb.right && new_bb.right > tile_bb.right ) {
				//collision right
				hitInfo.hitSide = Sides.RIGHT;
				hitInfo.didHit = true;
			} 
			if (new_bb.left < tile_bb.left && new_bb.right > tile_bb.left ) {
				//collision left
				hitInfo.hitSide = Sides.LEFT;
				hitInfo.didHit = true;
			}
		}
		if (new_bb.right > tile_bb.left && new_bb.left < tile_bb.right) {
			// game sprite is OVER tile_bb
			if (new_bb.bottom > tile_bb.top && prev_bb.top < tile_bb.top) {
				 //collision down
				hitInfo.hitSide = Sides.BOTTOM;
				hitInfo.didHit = true;
			}
			if (new_bb.top < tile_bb.bottom && prev_bb.bottom > tile_bb.bottom) {
				hitInfo.hitSide = Sides.TOP;
				hitInfo.didHit = true;
			}
		}else {
			
		}
		return hitInfo;
	}	
}

