package Entitys;

import main.GamePanel;
import main.KeyManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{

    GamePanel gp;
    KeyManager kM;

    public final int sX;
    public final int sY;
    int accspeed = speed;

    public int coinCount = 0;

    public Player(GamePanel gp, KeyManager kM){
        this.gp = gp;
        this.kM = kM;
        sX = (gp.mcol*gp.tileSize)/2 - gp.tileSize/2;
        sY = (gp.mrow*gp.tileSize)/2 - gp.tileSize/2;
        hitBox = new Rectangle(6,42,50,16);
        hitBoxX = hitBox.x;
        hitBoxY = hitBox.y;


        sDV();
        getPI();
    }

    public void sDV(){
        wX = 50* gp.tileSize;
        wY = 50* gp.tileSize;
        speed = 4;
        direction = "down";
    }

    public void getPI(){

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

        if(kM.downPressed || kM.upPressed || kM.rightPressed || kM.leftPressed) {

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
            int[] b = gp.collison.checkTile(this);
            int objID = gp.collison.checkObject(this,true);
            collectItem(objID);

                if (kM.upPressed && contains(b, 1)) {
                    wY -= accspeed;
                } else if (kM.downPressed && contains(b, 2))  {
                    wY += accspeed;
                }

                if (kM.leftPressed && contains(b, 3)) {
                    wX -= accspeed;
                } else if (kM.rightPressed && contains(b, 4)) {
                    wX += accspeed;
                }





            eC++;
            if (eC > 10) {
                if (eN == 1) {
                    eN = 2;
                } else if (eN == 2) {
                    eN = 1;
                }
                eC = 0;
            }
        }else{
            eN = 1;
        }


    }

    public void collectItem(int i){
        if(i != 404){
            boolean vanish = gp.obj[i].interact(this);
            if(vanish){
                gp.obj[i]=null;
            }
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;

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
        g2.drawImage(image, sX,sY,gp.tileSize, gp.tileSize, null);
    }
}
