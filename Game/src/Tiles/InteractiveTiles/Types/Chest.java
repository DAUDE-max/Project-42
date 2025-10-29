package Tiles.InteractiveTiles.Types;

import Items.Types.CoinItem;

import Tiles.InteractiveTiles.InteractiveTile;
import main.GamePanel;

public class Chest extends InteractiveTile {

    boolean opened = false;


    public Chest(int wX,int wY,GamePanel gp){
        super(wX,wY,gp);
        collision=true;
        getImg("/InteractiveTiles/chest_closed.png");

        hitBox.x = 1;
        hitBox.y = 14;
        hitBox.width = 63;
        hitBox.height = 46;
    }
    @Override
    public void action() {

        if(!opened && checkKey()){
            gp.inventory.retrieveItem();
            getImg("/InteractiveTiles/chest_open.png");

            opened = true;
            gp.chatBox.setMessageByKey("chest");
            //weiß Gott was
        }
    }

    public boolean checkKey(){
        return gp.inventory.peekItem() instanceof CoinItem;
    }
}
