package Tile;

import Entitys.Player;
import Objects.OBJ_Chest;
import Objects.OBJ_Coin;
import Tile.InteractiveTiles.Chest;
import Tile.InteractiveTiles.Door;
import main.GamePanel;

public class ITM {
    GamePanel gp;
    public InteractiveTile[] its;
    public ITM(GamePanel gp, Player p) {
        this.gp = gp;
        its = new InteractiveTile[10];

    }

    public void setUP(){

        its[0] = new Chest();
        its[0].wX = 3200;
        its[0].wY = 2900;


        its[1] = new Door();
        its[1].wX = 3300;
        its[1].wY = 3000;
    }
}
