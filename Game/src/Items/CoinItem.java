package Items;

import Entities.Player;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class CoinItem extends Item {
    //Constructor
    public CoinItem(){

        try {
            img = ImageIO.read(getClass().getResourceAsStream("/Items/coin.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //Action
    @Override
    public boolean interact(GamePanel gp) {
        gp.inventory.addItem(this);
        return true;


    }
}
