package Tiles.InteractiveTiles;

import Tiles.InteractiveTile;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Chest extends InteractiveTile {

    boolean opened = false;


    public Chest(){
        collision=true;
        try{
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/chest_closed.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
        hitBox.x = 1;
        hitBox.y = 14;
        hitBox.width = 63;
        hitBox.height = 46;
    }
    @Override
    public void action() {

        if(!opened){
            try{
                img = ImageIO.read(getClass().getResourceAsStream("/Tiles/chest_open.png"));
            }catch (Exception e){
                e.printStackTrace();
            }
            //weiß Gott was
        }
    }
}
