package Tiles.InteractiveTiles.NPC;

import main.GamePanel;
import main.Shop;


//Npc als Erklärbär für die Stroyline (potentiell funktionierender Händler)
public class Jeff extends NPC {
    public Jeff(int wX,int wY,GamePanel gp, String[] args) {
        super(wX,wY,gp, args);
    }

    @Override
   public void act1(){
        //gp.shop = new Shop(new String[]{"2", "keyItem", "speedCarpetItem"});
        gp.player.controlsLocked = true;
    }

    @Override
    public void act2() {
        //gp.shop = null;
        gp.player.controlsLocked = false;
    }
}

