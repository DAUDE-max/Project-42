package Entities;

import Tiles.InteractiveTile;
import main.AppSettings;
import main.GamePanel;
import main.KeyManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{
    //Interface
    GamePanel gp;
    KeyManager kM;
    //Position
    public final int sX;
    public final int sY;
    int accspeed = speed;

    public boolean controlsLocked = false;

    /**Constructor, setting Interfaces, position and hitbox
     * And applying default Values and player images */
    public Player(GamePanel gp){
        this.gp = gp;
        this.kM = gp.keyManager;
        sX = (AppSettings.desktopWidth)/2 - GamePanel.tileSize /2;
        sY = (AppSettings.desktopHight)/2 - GamePanel.tileSize /2;
        hitBox = new Rectangle(6,42,50,16);
        hitBoxX = hitBox.x;
        hitBoxY = hitBox.y;



        setDefaultValues();
        getPlayerImages();
    }
    //Default values
    public void setDefaultValues(){
        wX = 50* GamePanel.tileSize;
        wY = 50* GamePanel.tileSize;
        speed = 4;
        direction = "down";
    }
    //Images
    public void getPlayerImages(){

        try{
            up1 =       ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/up1.png")));
            up2 =       ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/up2.png")));
            down1 =     ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/down1.png")));
            down2 =     ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/down2.png")));
            right1 =    ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/right1.png")));
            right2 =    ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/right2.png")));
            left1 =     ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/left1.png")));
            left2 =     ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/left2.png")));

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void update(){
        if(!controlsLocked) {
            if (kM.downPressed || kM.upPressed || kM.rightPressed || kM.leftPressed) {

                if (kM.upPressed) {
                    direction = "up";
                } else if (kM.downPressed) {
                    direction = "down";
                }
                if (kM.leftPressed) {
                    direction = "left";
                } else if (kM.rightPressed) {
                    direction = "right";
                }

                //Object Collision

                accspeed = speed;
                int[] b = gp.collision.checkTile(this);
                int objID = gp.collision.checkItems(this, true);
                collectItem(objID);
                interact(gp.collision.checkIT(this, true));

                if (kM.upPressed && contains(b, 1)) {
                    wY -= accspeed;
                } else if (kM.downPressed && contains(b, 2)) {
                    wY += accspeed;
                }

                if (kM.leftPressed && contains(b, 3)) {
                    wX -= accspeed;
                } else if (kM.rightPressed && contains(b, 4)) {
                    wX += accspeed;
                }


                //Switches direction images
                eC++;
                if (eC > 10) {
                    if (eN == 1) {
                        eN = 2;
                    } else if (eN == 2) {
                        eN = 1;
                    }
                    eC = 0;
                }
            } else {
                eN = 1;
            }
        }


    }
    //Blocking system from InteractiveTiles
    void interact(InteractiveTile t){
        if(t==null)return;
        if(!t.collision)return;
        accspeed = 0;

    }


    //Item collecting
    public void collectItem(int i){
        if(i != 404){
            boolean vanish = gp.itemManager.obj[i].interact(gp);
            if(vanish){
                gp.itemManager.obj[i]=null;
            }
        }
    }
    //Draw
    public void draw(Graphics2D g2){
        BufferedImage image = null;

        //Animation image switch
        switch (direction) {
            case "up" -> {
                if (eN == 1) image = up1;
                if (eN == 2) image = up2;

            }
            case "down" -> {
                if (eN == 1) image = down1;
                if (eN == 2) image = down2;

            }
            case "left" -> {
                if (eN == 1) image = left1;
                if (eN == 2) image = left2;

            }
            case "right" -> {
                if (eN == 1) image = right1;
                if (eN == 2) image = right2;

            }
        }
        g2.drawImage(image, sX,sY, GamePanel.tileSize, GamePanel.tileSize, null);
    }

    public void disableControls(){
        controlsLocked = true;
    }

    public void enableControls(){
        controlsLocked = false;
    }
}
