package Tiles.InteractiveTiles.Types;

import Tiles.InteractiveTiles.InteractiveTile;
import main.GamePanel;

public class Door extends InteractiveTile {

    public Door(int wX,int wY, GamePanel gp){
        super(wX,wY,gp);
        collision = true;
        getImg("/InteractiveTiles/door_closed.png");
    }
    @Override
    public void action() {
        if(collision){
            collision = false;
            getImg("/InteractiveTiles/door_open.png");

        }else {
            collision = true;
            getImg("/InteractiveTiles/door_closed.png");

        }
    }
}
