package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Shop {

    int totalWidth = AppSettings.desktopWidth/2;
    int totalHeight;
    int positionX = AppSettings.desktopWidth/4;
    int positionY = AppSettings.desktopHight/3;

    int offerCount;
    int margin;
    int yOffset;
    private BufferedImage slotImage;


    public Shop(String[] args){
        try {
            this.slotImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/hud/inventory_slot.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.offerCount = Integer.parseInt(args[0]);
        margin  = totalWidth/(3*offerCount+1);
        totalHeight = 4 * margin;
        yOffset = (totalHeight-2*margin)/2;
    }

    public void draw(Graphics2D g2){
        drawFrame(g2);
    }
    private void drawFrame(Graphics2D g2) {
        // Draw inventory background
        g2.setColor(AppSettings.inventoryBackgroundColor);
        g2.fillRect(this.positionX, this.positionY, this.totalWidth, this.totalHeight);

        // Render all inventory boxes
        for (int i = 0; i < offerCount; i++) {
            final int offsetX = i * 2 * margin + (i + 1) * margin;
            g2.drawImage(this.slotImage, this.positionX + offsetX, this.positionY + yOffset, 2*margin, 2*margin, null);
        }
    }
}
