package Tiles.InteractiveTiles.NPC;

import Items.CoinItem;
import main.GamePanel;

public class Trader extends NPC{

    public Trader(int wX, int wY, GamePanel gp, String[] args) {
        super(wX,wY,gp, args);
    }
    int coinCount = 10;
    public void action(){
        gp.chatBox.setMessageByKey("traderFalse");
        if(!(gp.inventory.peekItem() instanceof CoinItem)){
            return;
        }
        coinCount--;
        gp.inventory.retrieveItem();

        if(coinCount == 0)gp.win();
    }
}
