package Items;

import Entities.Player;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class CoinItem extends Item {

    public CoinItem(){
        id = 1001;
        name = "Coin";

        try {
            img = ImageIO.read(getClass().getResourceAsStream("/Items/coin.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean interact(GamePanel gp) {
        gp.player.coinCount++;
        gp.inventory.addItem(this);
        return true;


    }
}
