package Objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Door extends Object{

    public OBJ_Door(){
        id = 2001;
        name = "Door";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/Objects/door.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
