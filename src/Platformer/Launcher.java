package Platformer;

import processing.core.PApplet;
//imports every class from Engine
import Engine.*;

public class Launcher extends CoreLauncher {
	//establishing launcher coming from PApplet
	public Launcher(PApplet p) {
			super(p);
	}
	
	//public function that calls CoreLaunchers StartGame(that creates a new GameManager)
	public void StartGame(){
			super.StartGame();
			//Creates a player from the Player Class that is rendered in the Render window's middle (Because it is width/2)
		       Player player = new Player(parent, parent.width/2,parent.height/2,60, 60);
		       //starts it immediately
		       player.start();
		       //adds this as a new object called player
		       this.gameManager.addObject(player);
		   
		        //Platforms will be made here.
		    }
	}

