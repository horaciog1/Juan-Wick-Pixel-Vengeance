package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_Heart extends SuperObject {
	
	GamePanel gp;
	
	// constructor
	public OBJ_Heart(GamePanel gp) {
		
		this.gp = gp;
		
		name = "Heart";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/full_heart.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/objects/half_heart.png"));
			image3 = ImageIO.read(getClass().getResourceAsStream("/objects/empty_heart.png"));
			image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
			image2 = uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
			image3 = uTool.scaleImage(image3, gp.tileSize, gp.tileSize);
		} // end try
		catch(IOException e) {
			e.printStackTrace();
		} // end catch
	}// end OBJ_Heart()
}// end class