package Items;

import Entities.Player;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item {

    public BufferedImage img;
    public String name;
    public int id;
    public boolean collision;
    public int wX, wY;
    public Rectangle hitBox = new Rectangle(0,0,64,64);
    public int hitBoxX = 0;
    public int hitBoxY = 0;

    public boolean interact(GamePanel p) {
        return false;
    }
    public void vanish(){
        System.gc();
    }

    public void draw(Graphics2D g2, GamePanel gp){

        int sX = wX - gp.player.wX + gp.player.sX;
        int sY = wY - gp.player.wY + gp.player.sY;


        if(wX + GamePanel.tileSize >   gp.player.wX - gp.player.sX &&
           wX - GamePanel.tileSize <   gp.player.wX + gp.player.sX &&
           wY + GamePanel.tileSize >   gp.player.wY - gp.player.sY &&
           wY - GamePanel.tileSize <   gp.player.wY + gp.player.sY) {

            g2.drawImage(img, sX, sY, GamePanel.tileSize, GamePanel.tileSize, null);
        }
    }
}
