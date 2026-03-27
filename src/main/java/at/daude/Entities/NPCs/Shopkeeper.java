package at.daude.Entities.NPCs;

import at.daude.Items.Types.CoinItem;
import at.daude.core.GamePanel;

public class Shopkeeper extends NPC {

    int demand = 5;

    public Shopkeeper(int wX, int wY, GamePanel gp, String[] args) {
        super(wX,wY,gp, args);
    }

    @Override
    public void act1(){
        if(demand == 0)gp.currentScreen.switchScreen();

        if(gp.inventory.peekItem() instanceof CoinItem){
            gp.inventory.retrieveItem();
            demand--;
        }
    }

    @Override
    public void act2() {
    }
}
