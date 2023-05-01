package Tiles;

import Entities.Player;
import Tiles.InteractiveTiles.Chest;
import Tiles.InteractiveTiles.Door;
import main.GamePanel;

public class InteractiveTileManager {
    GamePanel gp;
    Player p;
    public InteractiveTile[] its;

    public InteractiveTileManager(GamePanel gp) {
        this.gp = gp;
        its = new InteractiveTile[10];
        this.p = gp.player;
        update();

    }

    public void setup() {

        its[0] = new Chest(gp);
        its[0].wX = GamePanel.tileSize * 54;
        its[0].wY = GamePanel.tileSize * 46;


        its[1] = new Door(gp);
        its[1].wX = GamePanel.tileSize * 52;
        its[1].wY = GamePanel.tileSize * 46;

        its[2] = new Door(gp);
        its[2].wX = GamePanel.tileSize * 45;
        its[2].wY = GamePanel.tileSize * 46;

    }

    public void update() {
        gp.keyManager.ePressed = false;
        for (InteractiveTile t : its) {
            if (t == null) break;
            switch (p.direction) {
                case "right" -> {
                    if (t.wX > p.wX + 32 && t.wX < p.wX + 160 && t.wY > p.wY - 32 && t.wY < p.wY + 96) {
                        t.action();
                    }
                }
                case "left" -> {
                    if (t.wX > p.wX - 96 && t.wX < p.wX + 32 && t.wY > p.wY - 32 && t.wY < p.wY + 96) {
                        t.action();
                    }
                }
                case "up" -> {
                    if (t.wX > p.wX - 32 && t.wX < p.wX + 96 && t.wY > p.wY - 96 && t.wY < p.wY) {
                        t.action();
                    }
                }
                case "down" -> {
                    if (t.wX > p.wX - 32 && t.wX < p.wX + 96 && t.wY > p.wY + 32 && t.wY < p.wY + 160) {
                        t.action();
                    }
                }
            }

        }

    }
}
