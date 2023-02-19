package Objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Chest extends Object{

    public OBJ_Chest(){
        id=2002;
        name = "Chest";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/Objects/chest.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
