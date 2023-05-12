package Entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    //Default values
    public int wX, wY;
    public static int speed;
    public String direction;
    public BufferedImage up1, up2, down1, down2, right1, right2, left1, left2;
    public boolean collision=false;
    public Rectangle hitBox;
    public int hitBoxX, hitBoxY;

    //Animation variables
    public int eC = 0;
    public int eN = 1;

    //method to check for and element of an array; used in TileCollision
    public boolean contains(final int[] array, final int key) {
        for (final int i : array) {
            if (i == key) {
                return false;
            }
        }
        return true;
    }

}
