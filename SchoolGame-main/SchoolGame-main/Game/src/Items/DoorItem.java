package Items;

import javax.imageio.ImageIO;
import java.io.IOException;

public class DoorItem extends Item {

    public DoorItem(){
        id = 2001;
        name = "Door";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/Tiles/door_closed.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
