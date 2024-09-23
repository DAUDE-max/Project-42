package Entities;

import diagnosen.Diagnose;
import diagnosen.DiagnoseManager;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import main.GamePanel;

public class Patient extends Entity {

    int actualspeed = speed;
    Diagnose diagnose;

    public Patient (GamePanel gp, DiagnoseManager diagnoseManager, int wX, int wY, int diagnoseNR){
        super(gp);
        this.wX = wX*GamePanel.tileSize;
        this.wY = wY*GamePanel.tileSize;
        direction = "down";

        hitBox = new Rectangle(6,42,50,16);
        hitBoxX = hitBox.x;
        hitBoxY = hitBox.y;

        diagnose = diagnoseManager.diagnose(diagnoseNR); 
        getPatientImages();
    }

    //Images
    public void getPatientImages(){

        try{
            up1 =       ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Patient/up1.png")));
            up2 =       ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Patient/up2.png")));
            down1 =     ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Patient/down1.png")));
            down2 =     ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Patient/down2.png")));
            right1 =    ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Patient/right1.png")));
            right2 =    ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Patient/right2.png")));
            left1 =     ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Patient/left1.png")));
            left2 =     ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Patient/left2.png")));

        }catch (IOException e){
            e.printStackTrace();
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

        int sX = wX - gp.player.wX + gp.player.sX;
        int sY = wY - gp.player.wY + gp.player.sY;


        if(wX + GamePanel.tileSize >   gp.player.wX - gp.player.sX &&
                wX - GamePanel.tileSize <   gp.player.wX + gp.player.sX &&
                wY + GamePanel.tileSize >   gp.player.wY - gp.player.sY &&
                wY - GamePanel.tileSize <   gp.player.wY + gp.player.sY) {

            g2.drawImage(image, sX, sY, GamePanel.tileSize, GamePanel.tileSize, null);
            System.out.println("drawen");
        }
        
    }
}
