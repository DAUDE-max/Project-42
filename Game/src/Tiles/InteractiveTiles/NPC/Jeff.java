package Tiles.InteractiveTiles.NPC;

import main.GamePanel;

public class Jeff extends NPC {
    public Jeff(int wX,int wY,GamePanel gp, String[] args) {
        super(wX,wY,gp, args);
    }

    @Override
   public void act1(){
        gp.shop = new Shop(new String[]{"3"});
        gp.player.controlsLocked = true;
    }

    @Override
    public void act2() {
        gp.shop = null;
        gp.player.controlsLocked = false;
    }
}

