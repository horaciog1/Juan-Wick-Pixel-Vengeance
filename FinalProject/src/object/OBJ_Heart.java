package object;


import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity {
	
	
	// constructor
	public OBJ_Heart(GamePanel gp) {
		super(gp);
		
		name = "Heart";
		image = setup("/objects/full_heart", gp.tileSize, gp.tileSize);
		image2 = setup("/objects/half_heart", gp.tileSize, gp.tileSize);
		image3 = setup("/objects/empty_heart", gp.tileSize, gp.tileSize);
		
	}// end OBJ_Heart()
}// end class
