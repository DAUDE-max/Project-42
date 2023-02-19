package Objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Coin extends Object {

    public OBJ_Coin(){
        id = 1001;
        name = "Coin";

        try {
            img = ImageIO.read(getClass().getResourceAsStream("/Objects/coin.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
