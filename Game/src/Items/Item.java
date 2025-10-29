package Items;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Item {
    //Position
    public int wX, wY;
    public Rectangle hitBox = new Rectangle(0,0,64,64);
    public int hitBoxX = 0;
    public int hitBoxY = 0;
    //Img and collision
    public BufferedImage img;
    public boolean collision;
    public int id;



    protected void getImg(String path){
        try {
            img = ImageIO.read(getClass().getResourceAsStream(path));
        }catch (IOException e){
            e.printStackTrace();

        }
    }

    //Super method for all following item actions
    public boolean interact(GamePanel p) {
        return false;
    }
    //Makes an item disappear when collected


    public int speed = 0;
    public int hearts = 0;

    //Draw
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
