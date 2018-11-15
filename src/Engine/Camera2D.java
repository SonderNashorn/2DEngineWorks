package Engine;
import processing.core.PApplet;
import processing.core.PVector;
public class Camera2D extends GameObject {
	public GameObject followMe;
	public float offsetLimit = 100;
	public PVector cameraOffset = new PVector(0,0);
	
	public Camera2D(PApplet p, GameObject f, float limit) {
		super(p);
		this.followMe = f;
		offsetLimit = limit;
	}

	
	@Override
	public void start() {
	}

	@Override
	public void update() {
	}

	@Override
	public void render() {
		late_update_xy();
	}
	private void late_update_xy() {
		//this shit moves the camera, for what reason do we need virtual and non virtual garbage is beyond me
		//but I am expecting no explanation.
		PVector virtualScreenCentre = GameManager.screenOffset.copy();		
		virtualScreenCentre.add(GameManager.offset);		
		PVector virtualPlayer = GameManager.offset.copy();
		virtualPlayer.add(this.followMe.transform.position);
		
		float d = virtualScreenCentre.dist(virtualPlayer);
		
		if (d > offsetLimit) {
			virtualScreenCentre.sub(virtualPlayer);
			virtualScreenCentre.add(this.cameraOffset);
			GameManager.offset.lerp(virtualScreenCentre, 0.02f);
		}
	}
}
