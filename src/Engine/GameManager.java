package Engine;
import processing.core.*;
import java.util.ArrayList;

import Engine.Components.BoundingBox;


public class GameManager extends ProcessingCore {
	public int background = 0;
	private ArrayList<GameObject> gameObjects;
	private ArrayList<GameObject> playerGameObjects;
	public static int frameCount = 0;
	public static ArrayList<BoundingBox> gameBoundingBoxes;
	public static PVector offset = new PVector(0,0);
	public static PVector screenOffset = new PVector(0,0);
	
	public GameManager(PApplet p){
		super(p);
		this.name = "GameManager";		

        gameObjects 	  = new ArrayList<GameObject>();
        playerGameObjects = new ArrayList<GameObject>();
        gameBoundingBoxes = new ArrayList<BoundingBox>();
        
    	screenOffset.x = parent.width / 2;
		screenOffset.y = parent.height / 2;
    }
      
	
	 public void addGameBoundingBoxes(GameObject b){
	    	gameBoundingBoxes.add(b.transform.NewWorldBoundingBox());
	    }
	public void addPlayerGameObjects(GameObject b){
    	playerGameObjects.add(b);
    }	
    //public function to add a new object to the screen.
    public void addObject(GameObject g){
        gameObjects.add(g);
    }
    //public function to remove the last added object from the above list.
    public void removeObject(GameObject g){
        gameObjects.remove(gameObjects.lastIndexOf(g));
    }
    
    //public function to start every object held in our list.
    public void StartAll() {
    	
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject g = gameObjects.get(i);
            g.start();
        }
    }
    

    //public function to:
    public void UpdateAll() {
    	parent.pushMatrix();
		parent.translate(offset.x, offset.y);
    	parent.background(background);
    	
        for(int i = 0; i < gameObjects.size(); i++){
        	
            GameObject g = gameObjects.get(i);
            g.update();
            g.render();
        }
        frameCount ++; 
		parent.popMatrix();
    }
	public void keyPressed(char key, int keyCode) {
		for(int i = 0; i<gameObjects.size(); i++) {
			GameObject g = gameObjects.get(i);
			g.keyPressed(key,keyCode);
		}
	}
	public void keyReleased(char key, int keyCode) {
		for (int i = 0; i < playerGameObjects.size(); i++) {
			// send key press to player
			GameObject g = playerGameObjects.get(i);
			g.keyReleased(key, keyCode);
		}
	}
}
