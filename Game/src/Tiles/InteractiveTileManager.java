package Tiles;

import Entities.Player;
import Tiles.InteractiveTiles.Chest;
import Tiles.InteractiveTiles.Door;
import Tiles.InteractiveTiles.NPC.Bib;
import Tiles.InteractiveTiles.NPC.Selector;
import Tiles.InteractiveTiles.Pot;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import main.GamePanel;

public class InteractiveTileManager {
    //Referenzen
    GamePanel gp;
    Player p;
    //Array
    public List<InteractiveTile> its = new CopyOnWriteArrayList<>();

    public InteractiveTileManager(GamePanel gp) {
        this.gp = gp;
        this.p = gp.player;
        update();
    }

    public void summon(int wX, int wY, String id, String[] special) {
        switch (id){
            case "chest" -> {
                wX *= GamePanel.tileSize;
                wY *= GamePanel.tileSize;
                its.add(new Chest(wX,wY,gp));
            }
            case "door" -> {
                wX *= GamePanel.tileSize;
                wY *= GamePanel.tileSize;
                its.add(new Door(wX,wY,gp));
            }
            case "pot" -> {
                wX *= GamePanel.tileSize;
                wY *= GamePanel.tileSize;
                its.add(new Pot(wX,wY,gp, special[0]));
            }
            case "npc" -> {
                switch (special[0]){
                    case "jeff" -> {
                        wX *= GamePanel.tileSize;
                        wY *= GamePanel.tileSize;
                        its.add( new Bib(wX,wY,gp, special));
                    }
                    case "trader" -> {
                        wX *= GamePanel.tileSize;
                        wY *= GamePanel.tileSize;
                        its.add( new Selector(wX,wY,gp, special));
                    }
                }
            }
        }

    }

    public void kill(InteractiveTile interactiveTile){
       its.remove(interactiveTile);
    }

    public void update() {
        gp.keyManager.ePressed = false;
        synchronized (its){
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
}
