package Tile;

import Entitys.Player;
import Tile.InteractiveTiles.Chest;
import Tile.InteractiveTiles.Door;
import main.GamePanel;

public class ITM {
    GamePanel gp;
    Player p;
    public InteractiveTile[] its;

    public ITM(GamePanel gp, Player p) {
        this.gp = gp;
        its = new InteractiveTile[10];
        this.p = p;
        update();

    }

    public void setUP() {

        its[0] = new Chest();
        its[0].wX = gp.tileSize * 54;
        its[0].wY = gp.tileSize * 46;


        its[1] = new Door();
        its[1].wX = gp.tileSize * 52;
        its[1].wY = gp.tileSize * 46;

    }

    public void update() {
        if (gp.kM.ePressed) {
            gp.kM.ePressed = false;
            for (InteractiveTile t : its) {
                switch (p.direction) {
                    case "right" -> {
                        if (t.wX > p.wX-32 && t.wX < p.wX+96 && t.wY > p.wY+64 && t.wY < p.wY+160) {
                            t.action();
                        }
                    }
                    case "left" -> {
                        if (t.wX > p.wX-96 && t.wX < p.wX && t.wY > p.wY-32 && t.wY < p.wY+96) {
                            t.action();
                        }
                    }
                    case "up" -> {
                        if (t.wX > p.wX-32 && t.wX < p.wX+96 && t.wY > p.wY-96 && t.wY < p.wY) {
                            t.action();
                        }
                    }
                    case "down" -> {
                        if (t.wX > p.wX-32 && t.wX < p.wX+96 && t.wY > p.wY+64 && t.wY < p.wY-160) {
                            t.action();
                        }
                    }
                }

            }
        }
    }
}
