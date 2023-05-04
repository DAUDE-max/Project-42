package main;

import Items.InventoryItem;

import java.awt.image.BufferedImage;

public class Chatbox {
    public final GamePanel gp;


    // Dimensions
    private final int totalWidth;
    private final int totalHeight;


    // Positions
    private final int positionX;
    private final int positionY;

    private BufferedImage img;

    public Chatbox(GamePanel gp) {
        this.gp = gp;
        this.totalWidth = AppSettings.screenWidth/4;
        this.totalHeight = AppSettings.screenHeight/3;
        this.positionX = 0;
        this.positionY = totalHeight/3;
        

    }
}

 */