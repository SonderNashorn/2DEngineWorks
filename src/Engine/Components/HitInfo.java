package Engine.Components;

import Engine.Sides;

public class HitInfo {
	public Sides hitSide = Sides.NONE;
	public BoundingBox boundingBox;
	public boolean didHit = false;
}
