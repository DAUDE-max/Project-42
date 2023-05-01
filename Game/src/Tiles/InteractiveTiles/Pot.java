package Tiles.InteractiveTiles;

import Tiles.InteractiveTile;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;


public class Pot extends InteractiveTile {

    /**
     * Pot should break on interaction and can summon a coin on death
     * */

    boolean coinInside;
    public Pot(GamePanel gp,boolean coinInside) {
        super(gp);
        collision = true;
        try{
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/pot.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
        hitBox.x = 12;
        hitBox.y = 9;
        hitBox.width = 40;
        hitBox.height = 52;
        this.coinInside = coinInside;
    }

    @Override
    public void action() {
        if(coinInside)gp.itemManager.summon(wX/64,wY/64, "coin");
        gp.interactiveTileManager.kill(this);

    }
}
