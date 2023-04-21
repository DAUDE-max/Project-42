package Tile.InteractiveTiles;

import Tile.InteractiveTile;

import javax.imageio.ImageIO;

public class Chest extends InteractiveTile {

    boolean opened = false;

    public Chest(){
        System.out.println("Eyoooo");
        collision=true;
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/Objects/chest_closed.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void action() {

        if(!opened){
            try{
                img = ImageIO.read(getClass().getResourceAsStream("/Objects/chest_open.png"));
            }catch (Exception e){
                e.printStackTrace();
            }
            //weiß Gott was
        }
    }
}
