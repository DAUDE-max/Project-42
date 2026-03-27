package at.daude.Entities.NPCs;

import at.daude.Items.Types.CoinItem;
import at.daude.core.GamePanel;

public class Wanderer extends NPC{
    int demand = 2;

    public Wanderer(int wX, int wY, GamePanel gp, String[] args) {
        super(wX,wY,gp, args);
    }

    @Override
    public void act1(){
        if(gp.inventory.peekItem() instanceof CoinItem){
            gp.chatBox.setMessageByKey(name+"a");
            gp.inventory.retrieveItem();
            demand--;
        }
        if(demand == 0)gp.currentScreen.switchScreen();
    }

}
