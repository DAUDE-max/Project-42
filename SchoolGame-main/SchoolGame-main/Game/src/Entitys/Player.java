package Entitys;

import main.GamePanel;
import main.KeyManager;

import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;

public class Player extends Entity{

    GamePanel gp;
    KeyManager kM;

    public Player(GamePanel gp, KeyManager kM){
        this.gp = gp;
        this.kM = kM;
        sDV();
    }

    public void sDV(){
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update(){

        if(kM.upPressed){
            y-=speed;
        }
        else if (kM.downPressed) {
            y+=speed;
        }

        if (kM.leftPressed) {
            x-=speed;
        }
        else if (kM.rightPressed) {
            x+=speed;
        }

    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
            g2.fillRect(x,y,gp.tileSize,gp.tileSize);
    }
}
