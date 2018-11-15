package Platformer;

import processing.core.PApplet;
//imports every class from Engine
import Engine.*;

public class Launcher extends CoreLauncher {
	//establishing launcher coming from PApplet
	public Launcher(PApplet p) {
			super(p);
	}
	
	public void StartGame(){
		super.StartGame();
        Player player = new Player(parent, parent.width/2,parent.height/2,60, 60);
        player.start();
        this.gameManager.addObject(player);
        this.gameManager.addPlayerGameObjects(player);
        
        /*Camera2D camera = new Camera2D(parent,player, 99);
        camera.cameraOffset.y = 90;
        this.gameManager.addObject(camera);*/
        
        //NTS Rename the whole scheme as track
        //Horizontal lines
        /*int platforms = 150;
        Platform platform;
        for(int i = 0; i < platforms; i++){
        	float x = parent.random(0, parent.width);
        	float y = parent.random(-parent.height * 2f, parent.height*0.9f);
        	
        	platform = new Platform(parent, x,y,10, 0);
            platform.start();
            this.gameManager.addObject(platform);
            this.gameManager.addGameBoundingBoxes(platform);
		       }
        //Horizontal Long lines
        platforms = 5;
        for(int i = 0; i < platforms; i++){
            platform = new Platform(parent, parent.random(parent.width),parent.random(parent.height),50, 0);
            platform.start();
            this.gameManager.addObject(platform);
            this.gameManager.addGameBoundingBoxes(platform);
        }     
        //Vertical lines
        platforms = 120;
        for(int i = 0; i < platforms; i++){
        	float x = parent.random(0, parent.width);
        	float y = parent.random(-parent.height * 2f, parent.height*0.9f);
        	
        	platform = new Platform(parent, x,y,0, 10);
            platform.start();
            this.gameManager.addObject(platform);
            this.gameManager.addGameBoundingBoxes(platform);
		       }
        */
        /*
        platform = new Platform(parent, parent.width/2, parent.height-100,50, 50);
        platform.start();
        this.gameManager.addObject(platform);
        this.gameManager.addGameBoundingBoxes(platform);
        
        platform = new Platform(parent, (parent.width*0.75f),(parent.height*0.65f),60, 20);
        platform.start();
        this.gameManager.addObject(platform);
        this.gameManager.addGameBoundingBoxes(platform);
        
        platform = new Platform(parent, (parent.width*0.65f),(parent.height*0.45f),60, 20);
        platform.start();
        this.gameManager.addObject(platform);
        this.gameManager.addGameBoundingBoxes(platform);
        
        //GROUND
        platform = new Platform(parent, parent.width/2, parent.height-10,parent.width, 20);
        platform.start();
        platform.strokeColour = parent.color(0,200,20);
        platform.fillColour = parent.color(0,200,20);
        this.gameManager.addObject(platform);
        this.gameManager.addGameBoundingBoxes(platform);
        //left
        platform = new Platform(parent, 0, parent.height/2, 20, parent.height);
        platform.start();
        platform.strokeColour = parent.color(0,200,20);
        platform.fillColour = parent.color(0,200,20);
        this.gameManager.addObject(platform);
        this.gameManager.addGameBoundingBoxes(platform);
        //right
        platform = new Platform(parent, parent.width, parent.height/2, 20, parent.height);
        platform.start();
        platform.strokeColour = parent.color(0,200,20);
        platform.fillColour = parent.color(0,200,20);
        this.gameManager.addObject(platform);
        this.gameManager.addGameBoundingBoxes(platform);*/
		    }
	public void UpdateAll(){
		super.UpdateAll();		
	}
}

