package object;


import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity {
	
	
	// constructor
	public OBJ_Heart(GamePanel gp) {
		super(gp);
		
		name = "Heart";
		image = setup("/objects/full_heart");
		image2 = setup("/objects/half_heart");
		image3 = setup("/objects/empty_heart");
		
	}// end OBJ_Heart()
}// end class
