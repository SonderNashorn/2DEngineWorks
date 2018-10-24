package Engine;
import processing.core.PApplet;

public class CoreLauncher {
	//We will render the main window on the parent that is processing (also known as:PApplet).
	public PApplet parent;
	
	//Establishing a reference for other classes to use. where CoreLauncher.parent or Corelauncher.p = PApplet)
	public CoreLauncher(PApplet p){
        parent = p;
    }
	
	//Stand alone class managing GameObjects appearing on our screen.
	public GameManager gameManager;
	
	//Creates a method that starts the whole process by making a new GameManager(sending "p" over as PApplet).
    public void StartGame(){
        gameManager = new GameManager(parent);
    }
    //An update method that simply just calls GameManagers update method. 
    public void UpdateAll(){
        gameManager.UpdateAll();
    }
	
	
}
