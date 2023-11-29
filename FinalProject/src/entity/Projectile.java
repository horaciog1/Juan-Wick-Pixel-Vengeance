package entity;

import main.GamePanel;

public class Projectile extends Entity {

	Entity user;
	
	public Projectile(GamePanel gp) {
		super(gp);
		// TODO Auto-generated constructor stub
	}
	
	public void set(int worldX, int worldY, String direction, boolean alive, Entity user) {
		
		this.worldX = worldX;
		this.worldY = worldY;
		this.direction = direction;
		this.alive = alive;
		this.user = user;
		this.life = this.maxLife;
		
		
	} // end set
	
	
	
	public void update() {
		
		if(user == gp.player) {
			int enemyIndex = gp.cChecker.checkEntity(this, gp.enemy);
			
			if(enemyIndex != 999) {
				gp.player.damageEnemy(enemyIndex);
				alive = false;
			}
		}
		
		if(user != gp.player) {
			boolean contactPlayer = gp.cChecker.checkPlayer(this);
			if(gp.player.invincible == false && contactPlayer == true) {
				damagePlayer(attack);
				alive = false;
			}
		}
		
		switch(direction) {
		case "up": worldY -= speed; 	break;
		case "down": worldY += speed; 	break;
		case "left": worldX -= speed; 	break;
		case "right": worldX += speed;	 break;
		}// end switch
		
		life--;
		if(life <= 0) {
			alive = false;
		}
		
		spriteCounter++;
		if (spriteCounter > 12 ) {
			if (spriteNum == 1) {
				spriteNum = 2;
			}
			else if (spriteNum ==2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		} // end if spriteCounter > 12
		
		
	} // end update
	
	
} // end class
