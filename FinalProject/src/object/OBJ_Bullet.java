package object;


import entity.Projectile;
import main.GamePanel;

public class OBJ_Bullet extends Projectile {

	GamePanel gp;
	
	public OBJ_Bullet(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		
		name = "Bullet";
		speed = 9;
		maxLife = 80;
		life = maxLife;
		attack = 1;
		//useCost = 1;
		alive = false;
		getImage();
		
		solidArea.x = 16;
		solidArea.y = 14;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 30;
		solidArea.height = 30;

	}
	
	public void getImage() {
		up0 = setup("/projectile/bullet_up_0", gp.tileSize, gp.tileSize);
		up1 = setup("/projectile/bullet_up_1", gp.tileSize, gp.tileSize);
		down0 = setup("/projectile/bullet_down_0", gp.tileSize, gp.tileSize);
		down1 = setup("/projectile/bullet_down_1", gp.tileSize, gp.tileSize);
		right0 = setup("/projectile/bullet_right_0", gp.tileSize, gp.tileSize);
		right1 = setup("/projectile/bullet_right_1", gp.tileSize, gp.tileSize);
		left0 = setup("/projectile/bullet_left_0", gp.tileSize, gp.tileSize);
		left1 = setup("/projectile/bullet_left_1", gp.tileSize, gp.tileSize);

	
	
	
	
	} // end getImage

} // end class
