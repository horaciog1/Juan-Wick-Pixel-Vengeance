package enemy;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_BlueHeart;
import object.OBJ_Bullet;
import object.OBJ_Heart;
import object.OBJ_NinjaStar;

public class ENEM_Ninja extends Entity{

	GamePanel gp;
	
	public ENEM_Ninja(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = 2;
		name = "Ninja";
		speed = 4;			// or maybe 6, we'll see
		maxLife = 2;
		life = maxLife;
		attack = 2;
		defense = 0;
		projectile = new OBJ_NinjaStar(gp);

		
		solidArea.x = 11;
		solidArea.y = 5;
		solidArea.width = 32;
		solidArea.height = 55;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	} // end constructor

	
	public void getImage() {
		
		// setupPlayer = setup using the player size, to keep proportions of the ninjas
		
		up0 = setup("/enemy/ninja_up_0", gp.tileSize, gp.tileSize);
		up1 = setup("/enemy/ninja_up_1", gp.tileSize, gp.tileSize);
		down0 = setup("/enemy/ninja_down_0", gp.tileSize, gp.tileSize);
		down1 = setup("/enemy/ninja_down_1", gp.tileSize, gp.tileSize);
		right0 = setup("/enemy/ninja_right_0", gp.tileSize, gp.tileSize);
		right1 = setup("/enemy/ninja_right_1", gp.tileSize, gp.tileSize);
		left0 = setup("/enemy/ninja_left_0", gp.tileSize, gp.tileSize);
		left1 = setup("/enemy/ninja_left_1", gp.tileSize, gp.tileSize);
		
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
		
		int i = new Random().nextInt(100)+1;
		if(i > 99 && projectile.alive == false && shotAvailableCounter == 50) {
			projectile.set(worldX, worldY, direction, true, this);
			gp.projectileList.add(projectile);
			shotAvailableCounter = 0;
		}
		
		
		
	} // end setAction
	
	public void damageReaction() {
		
		actionLockCounter = 0;
		
		Random random = new Random();
		int i = random.nextInt(4)+1;	// pick a number from 1 to 4
		
		if(i == 1) {
			direction = "down";
		}
		else if(i == 2) {
			direction = "up";
		}
		else if(i == 3) {
			direction = "right";
		}
		else if (i == 4) {
			direction = "left";
		}
//		else if ( i == 5) {
//			direction = gp.player.direction;		// enemy will run away from player
//		}
		
	} // end damageReaction
	
	public void checkDrop() {
		
		
		// CAST A DIE
		int i = new Random().nextInt(100)+1;
		
		// SET THE ENEMY DROP
		if(i <= 85 ) {
			dropItem(new OBJ_Heart(gp));
		}
		
		
	} // end checkDrop
	
	
	
	
	
} // end class
