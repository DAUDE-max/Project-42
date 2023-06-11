package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class WinScreen {
    public void draw(Graphics2D g2){
        BufferedImage backG = null;
        BufferedImage imgWin = null;
        try {
             backG = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/hud/chatBox.png")));
             imgWin = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/hud/imgWin.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(backG, 0, 0, AppSettings.desktopWidth, AppSettings.desktopHight, null);
        g2.drawImage(imgWin,AppSettings.desktopWidth/4,AppSettings.desktopHight/4,AppSettings.desktopWidth/2,AppSettings.desktopHight/4, null);

    }
}
