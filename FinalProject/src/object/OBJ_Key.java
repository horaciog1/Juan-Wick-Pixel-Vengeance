package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Key extends Entity {
	
	
	// constructor
	public OBJ_Key(GamePanel gp) {
		super(gp);
		
		name = "Key";
		down0 = setup("/objects/key");
		
		
		
	} // end OBJ_Key()
} // end class
