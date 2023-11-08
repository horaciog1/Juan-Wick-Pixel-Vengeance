package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_Key extends SuperObject {
	
	GamePanel gp;
	
	// constructor
	public OBJ_Key(GamePanel gp) {
		
		this.gp = gp;
		
		name = "Key";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
			uTool.scaleImage(image,  gp.tileSize, gp.tileSize);
		}// end try
		catch(IOException e) {
			e.printStackTrace();
		} // end catch
	} // end OBJ_Key()
} // end class
