package Objects;

import Entitys.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Chest extends Object{

    public OBJ_Chest(){
        id=2002;
        name = "Chest";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/Objects/chest_closed.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean interact(Player p) {
        if(p.coinCount > 0){
            p.coinCount--;
                return open();
        }
        return false;
    }

    public boolean open() {
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/Objects/chest_open.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;

    }
}
