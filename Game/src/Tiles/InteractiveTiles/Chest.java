package Tiles.InteractiveTiles;

import Items.CoinItem;
import Tiles.InteractiveTile;

import javax.imageio.ImageIO;
import java.util.Objects;

import main.GamePanel;

public class Chest extends InteractiveTile {

    boolean opened = false;


    public Chest(int wX,int wY,GamePanel gp){
        super(wX,wY,gp);
        collision=true;
        try{
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/InteractiveTiles/chest_closed.png")));
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

        if(!opened && checkKey()){
            gp.inventory.retrieveItem();
            try{
                img = ImageIO.read(getClass().getResourceAsStream("/InteractiveTiles/chest_open.png"));
            }catch (Exception e){
                e.printStackTrace();
            }
            opened = true;
            gp.chatBox.setMessageByKey("chest");
            //weiß Gott was
        }
    }

    public boolean checkKey(){
        return gp.inventory.peekItem() instanceof CoinItem;
    }
}
