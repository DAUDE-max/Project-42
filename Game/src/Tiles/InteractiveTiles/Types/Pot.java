package Tiles.InteractiveTiles.Types;

import Tiles.InteractiveTiles.InteractiveTile;
import main.GamePanel;


public class Pot extends InteractiveTile {

    /**
     * Pot should break on interaction and can summon a coin on death
     * */

    boolean coinInside;
    public Pot(int wX,int wY,GamePanel gp,String coinInside) {
        super(wX,wY,gp);
        collision = true;
        getImg("/InteractiveTiles/box.png");
        hitBox.x = 12;
        hitBox.y = 9;
        hitBox.width = 40;
        hitBox.height = 52;
        this.coinInside = (coinInside.equals("true"));
    }

    @Override
    public void action() {
        if(coinInside)gp.itemManager.summon(wX/64,wY/64, "coin");
        gp.interactiveTileManager.kill(this);

    }
}
