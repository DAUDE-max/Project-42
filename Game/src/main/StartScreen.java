package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Objects;

public class StartScreen {
    GamePanel gp;
    public StartScreen(GamePanel gp){
        this.gp = gp;

        try {
            this.imgStart = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/hud/start.png")));
            this.imgControls = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/hud/controls.png")));
            this.imgHead = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/hud/logo.png")));
            this.backG = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/hud/chatBox.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }

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
    BufferedImage backG;

    public void act(){
        gp.staticScreen = false;
        gp.setup();
    }

    public void draw(Graphics2D g2){
       g2.drawImage(backG, 0, 0, AppSettings.desktopWidth, AppSettings.desktopHight, null);
        g2.drawImage(imgHead,AppSettings.desktopWidth/4,AppSettings.desktopHight/4,AppSettings.desktopWidth/2,AppSettings.desktopHight/4, null);
        g2.drawImage(imgStart,AppSettings.desktopWidth/5,AppSettings.desktopHight*3/5,AppSettings.desktopWidth/5,AppSettings.desktopHight/5, null);
        g2.drawImage(imgControls,AppSettings.desktopWidth*3/5,AppSettings.desktopHight*3/5,AppSettings.desktopWidth/5,AppSettings.desktopHight/5, null);

    }



}
