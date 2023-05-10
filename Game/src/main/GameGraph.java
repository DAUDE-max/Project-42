package main;

import Items.Item;
import Tiles.InteractiveTile;

import java.awt.*;

public class GameGraph {

    public void draw(GamePanel gp, Graphics2D graphics2d){
        // Tiles
        gp.tileManager.draw(graphics2d);

        // Interactive tiles
        for (InteractiveTile i : gp.interactiveTileManager.its) {
            if (i != null) {
                i.draw(graphics2d);
            }
        }

        // Objects
        for (Item o : gp.itemManager.obj) {
            if (o != null) {
                o.draw(graphics2d, gp);
            }
        }

        // Player
        gp.player.draw(graphics2d);
        gp.inventory.draw(graphics2d);
        gp.chatBox.draw(graphics2d);

        if(gp.shop != null)gp.shop.draw(graphics2d);
    }
}
