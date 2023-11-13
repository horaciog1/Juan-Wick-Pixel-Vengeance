package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Door extends Entity{
	
	// constructor
	public OBJ_Door(GamePanel gp) {
		
		super(gp);
		name = "Door";
		down0 = setup("/objects/door");
		collision = true;
		
		
		
		
	}// end OBJ_Door()
}// end class
