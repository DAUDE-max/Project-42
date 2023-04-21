package Tile;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class InteractiveTile{

    public BufferedImage img;
    int id;
    int wX;
    int wY;
    public boolean collision;
    public Rectangle hitBox = new Rectangle(0,0,64,64);
    public int hitBoxX = 0;
    public int hitBoxY = 0;


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
    /* ToDo:
    *   -   If e pressed 1 block range and faced -> activate
    *   -   If more then one block is interactive take closest
    *   -   only blocks the player is not standing on are interactive
    *       (means Door anly when not on them closable, standad interactive blocks are collision true)
    *   -   Uses = Chest + Door  */

    public void action(){}


}
