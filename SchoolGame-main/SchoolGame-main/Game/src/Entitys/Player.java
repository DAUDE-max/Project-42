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

    public Player(GamePanel gp, KeyManager kM){
        this.gp = gp;
        this.kM = kM;
        sDV();
        getPI();
    }

    public void sDV(){
        x = 100;
        y = 100;
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
                y -= speed;

            } else if (kM.downPressed) {
                direction = "down";
                y += speed;
            }

            if (kM.leftPressed) {
                direction = "left";
                x -= speed;
            } else if (kM.rightPressed) {
                direction = "right";
                x += speed;
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
        g2.drawImage(image, x,y,gp.tileSize, gp.tileSize, null);
    }
}
