package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class StartScreen {
    GamePanel gp;
    public StartScreen(GamePanel gp){
        this.gp = gp;
    }

    /*
    Buttons:
    1. Links Start
    2. Rechts Controls

    Heading: Slime RPG
     */

    BufferedImage imgStart;
    BufferedImage imgControls;
    BufferedImage imgHead;

    public void act(){
        gp.setup();
        gp.staticScreen = false;
    }

    public void draw(Graphics2D g2){
        g2.drawImage(imgHead,AppSettings.desktopWidth/4,AppSettings.desktopHight/4,AppSettings.desktopWidth/2,AppSettings.desktopHight/4, null);
        g2.drawImage(imgStart,AppSettings.desktopWidth/5,AppSettings.desktopHight*3/5,AppSettings.desktopWidth/5,AppSettings.desktopHight/5, null);
        g2.drawImage(imgControls,AppSettings.desktopWidth*3/5,AppSettings.desktopHight*3/5,AppSettings.desktopWidth/5,AppSettings.desktopHight/5, null);

    }



}
