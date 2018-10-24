package Engine;
import processing.core.*;
//importing arrays from java utilities
import java.util.ArrayList;

public class GameManager {
	//this is the same as in CoreLauncher so we can render everything into a window. Not sure why it is needed but it is...
	public PApplet parent;
	//Sets background to 0 that is black. (this comes from processing)
	public int background = 0;
	private ArrayList<GameObject> gameObjects;
	private ArrayList<GameObject> playerGameObjects;
	private ArrayList<BoundingBox> gameBoundingBoxes;
	
	//a publicly available GameManager Function (called from CoreLauncher) 
	public GameManager(PApplet p){
        parent = p;
        //creates a list of GameObjects as a new array of GameObjects
        gameObjects 	  = new ArrayList<GameObject>();
        playerGameObjects = new ArrayList<GameObject>();
        gameBoundingBoxes = new ArrayList<BoundingBox>();
    }
	//Creates an ArrayList of GameObjects that is gameObjects (wutnow?)
    //private ArrayList<GameObject> gameObjects; ///moved before the game manager
    
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
    
    public void checkCollisions() {
    	for(int i = 0; i< gameBoundingBoxes.size(); i++) {
    		BoundingBox bb = gameBoundingBoxes.get(i);
    		for(int j = 0; j< playerGameObjects.size(); j++) {
    			GameObject p = playerGameObjects.get(j);
    			p.checkCollisions(bb);
    		}
    	}
    		
    }
    //public function to:
    public void UpdateAll() {
    	checkCollisions();
    	//set the background of the PApplet background to the one established above.
    	parent.background(background);
    	//update/render every object in our list.
        for(int i = 0; i < gameObjects.size(); i++){
        	
            GameObject g = gameObjects.get(i);
            g.update();
            g.render();
        }
    }
	public void keyPressed(char key, int keyCode) {
		for(int i = 0; i<gameObjects.size(); i++) {
			GameObject g = gameObjects.get(i);
			g.keyPressed(key,keyCode);
		}
	}
}
