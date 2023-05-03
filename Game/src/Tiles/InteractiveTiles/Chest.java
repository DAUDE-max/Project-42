package Tiles.InteractiveTiles;

import Items.CoinItem;
import Tiles.InteractiveTile;

import javax.imageio.ImageIO;
import java.util.Objects;
import Entities.Player;
import main.GamePanel;

public class Chest extends InteractiveTile {

    boolean opened = false;


    public Chest(GamePanel gp){
        super(gp);
        collision=true;
        try{
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/chest_closed.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
        hitBox.x = 1;
        hitBox.y = 14;
        hitBox.width = 63;
        hitBox.height = 46;
    }
    @Override
    public void action() {

        if(!opened && checkCoin()){
            gp.inventory.retrieveItem();
            try{
                img = ImageIO.read(getClass().getResourceAsStream("/Tiles/chest_open.png"));
            }catch (Exception e){
                e.printStackTrace();
            }
            opened = true;
            //weiß Gott was
        }
    }

    public boolean checkCoin(){
        return gp.inventory.peekItem() instanceof CoinItem;
    }
}
