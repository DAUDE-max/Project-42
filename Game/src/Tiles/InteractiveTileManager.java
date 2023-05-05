package Tiles;

import Entities.Player;
import Tiles.InteractiveTiles.Chest;
import Tiles.InteractiveTiles.Door;
import Tiles.InteractiveTiles.NPC;
import Tiles.InteractiveTiles.Pot;
import main.GamePanel;

public class InteractiveTileManager {
    //Referenzen
    GamePanel gp;
    Player p;
    //Array
    public InteractiveTile[] its;
    int index = 0;

    public InteractiveTileManager(GamePanel gp) {
        this.gp = gp;
        its = new InteractiveTile[10];
        this.p = gp.player;
        update();

    }

    public void summon(int wX, int wY, String id, String[] special) {

        switch (id){
            case "chest" -> {
                its[index] = new Chest(gp);
                its[index].wX = GamePanel.tileSize * wX;
                its[index].wY = GamePanel.tileSize * wY;
                index++;
            }
            case "door" -> {
                its[index] = new Door(gp);
                its[index].wX = GamePanel.tileSize * wX;
                its[index].wY = GamePanel.tileSize * wY;
                index++;
            }
            case "pot" -> {
                its[index] = new Pot(gp, special[0]);
                its[index].wX = GamePanel.tileSize * wX;
                its[index].wY = GamePanel.tileSize * wY;
                index++;
            }
            case "npc" -> {
                its[index] = new NPC(gp, special);
                its[index].wX = GamePanel.tileSize * wX;
                its[index].wY = GamePanel.tileSize * wY;
                index++;
            }
        }

    }

    public void kill(InteractiveTile interactiveTile){
        for (int i = 0; i< its.length;i++) {
            if(its[i] == interactiveTile){
                its[i]=null;
            }
        }
    }

    public void update() {
        gp.keyManager.ePressed = false;
        for (InteractiveTile t : its) {
            if (t == null) break;
            switch (p.direction) {
                case "right" -> {
                    if (t.wX > p.wX + 32 && t.wX < p.wX + 96 && t.wY > p.wY - 32 && t.wY < p.wY + 96) {
                        t.action();
                    }
                }
                case "left" -> {
                    if (t.wX > p.wX - 96 && t.wX < p.wX + 32 && t.wY > p.wY - 32 && t.wY < p.wY + 96) {
                        t.action();
                    }
                }
                case "up" -> {
                    if (t.wX > p.wX - 32 && t.wX < p.wX + 96 && t.wY > p.wY - 64 && t.wY < p.wY) {
                        t.action();
                    }
                }
                case "down" -> {
                    if (t.wX > p.wX - 32 && t.wX < p.wX + 96 && t.wY > p.wY + 32 && t.wY < p.wY + 96) {
                        t.action();
                    }
                }
            }

        }

    }
}
