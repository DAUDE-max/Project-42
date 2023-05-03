package Items;

import Entities.Player;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class CoinItem extends Item {

    public int id = 1;
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
        gp.inventory.addItem(this, id);
        return true;


    }
}
