package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject{
	
	public OBJ_Door() {
		
		name = "Door";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Objects/Door.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
