package Tiles;

import Entities.Player;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class InteractiveTile{
    /** A Tile to be interactive:
     * It can be solid
     * It can be activated by pushing 'E' if in range*/
    //Default
    public GamePanel gp;
    public BufferedImage img;
    public int wY,wX;
    public boolean collision;
    //Hitbox
    public Rectangle hitBox = new Rectangle(0,0,64,64);
    public int hitBoxX = 0;
    public int hitBoxY = 0;

    public InteractiveTile( int wX,int wY,GamePanel gp){
        this.gp = gp;
        this.wX = wX;
        this.wY = wY;
    }


    //Draw
    public void draw(Graphics2D g2){

        int sX = wX - gp.player.wX + gp.player.sX;
        int sY = wY - gp.player.wY + gp.player.sY;


        if(wX + GamePanel.tileSize >   gp.player.wX - gp.player.sX &&
                wX - GamePanel.tileSize <   gp.player.wX + gp.player.sX &&
                wY + GamePanel.tileSize >   gp.player.wY - gp.player.sY &&
                wY - GamePanel.tileSize <   gp.player.wY + gp.player.sY) {

            g2.drawImage(img, sX, sY, GamePanel.tileSize, GamePanel.tileSize, null);
        }
    }

    //empty super action method
    public void action(){}


}
