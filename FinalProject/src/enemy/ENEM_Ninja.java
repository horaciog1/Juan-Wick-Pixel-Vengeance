package enemy;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class ENEM_Ninja extends Entity{

	public ENEM_Ninja(GamePanel gp) {
		super(gp);
		
		type = 2;
		name = "Ninja";
		speed = 4;			// or maybe 6, we'll see
		maxLife = 4;
		life = maxLife;
		
		solidArea.x = 11;
		solidArea.y = 10;
		solidArea.width = 32;
		solidArea.height = 50;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	} // end constructor

	
	public void getImage() {
		
		// setupPlayer = setup using the player size, to keep proportions of the ninjas
		
		up0 = setup("/enemy/ninja_up_0");
		up1 = setup("/enemy/ninja_up_1");
		down0 = setup("/enemy/ninja_down_0");
		down1 = setup("/enemy/ninja_down_1");
		right0 = setup("/enemy/ninja_right_0");
		right1 = setup("/enemy/ninja_right_1");
		left0 = setup("/enemy/ninja_left_0");
		left1 = setup("/enemy/ninja_left_1");
		
	} // end getImage
	
	public void setAction() {
		
		// Very simple AI
		actionLockCounter++;
		
		if (actionLockCounter == 120) {
			
			Random random = new Random();
			int i = random.nextInt(100)+1;	// pick a number from 1 to 100
			
			if( i <= 25) {
				direction = "up";
			}
			if( i > 25 && i <= 50) {
				direction = "down";
			}
			if( i > 50 && i <= 75) {
				direction = "left";
			}
			if( i > 75 && i <= 100) {
				direction = "right";
			}
			
			actionLockCounter = 0;
			
		} // end if
		
		
		
	} // end setAction
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // end class
