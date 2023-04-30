package Items;

import Entities.Player;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ChestItem extends Item {

    public ChestItem(){
        id=2002;
        name = "Chest";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/Items/chest.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean interact(GamePanel gp) {
        if(gp.player.coinCount > 0){
            gp.player.coinCount--;
                return open();
        }
        return false;
    }

    public boolean open() {
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/Items/chest_open.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;

    }
}
