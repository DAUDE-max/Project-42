package Objects;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Object {

    BufferedImage img;
    public String name;
    public int id;
    public boolean collision;
    public int wX, wY;

    public void draw(Graphics2D g2, GamePanel gp){

        int sX = wX - gp.player.wX + gp.player.sX;
        int sY = wY - gp.player.wY + gp.player.sY;


        if(wX + gp.tileSize >   gp.player.wX - gp.player.sX &&
           wX - gp.tileSize <   gp.player.wX + gp.player.sX &&
           wY + gp.tileSize >   gp.player.wY - gp.player.sY &&
           wY - gp.tileSize <   gp.player.wY + gp.player.sY) {

            g2.drawImage(img, sX, sY, gp.tileSize, gp.tileSize, null);
        }
    }
}
