package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_Door extends SuperObject{
	
	GamePanel gp;
	
	// constructor
	public OBJ_Door(GamePanel gp) {
		
		this.gp = gp;
		
		name = "Door";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
			uTool.scaleImage(image, gp.tileSize,  gp.tileSize);
		} // end try
		catch(IOException e) {
			e.printStackTrace();
		}// end catch
		collision = true;
	}// end OBJ_Door()
}// end class
