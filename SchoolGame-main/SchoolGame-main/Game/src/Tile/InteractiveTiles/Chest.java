package Tile.InteractiveTiles;

import Tile.InteractiveTile;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Chest extends InteractiveTile {

    boolean opened = false;

    public Chest(){
        collision=true;
        try{
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tile/chest_closed.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void action() {

        if(!opened){
            try{
                img = ImageIO.read(getClass().getResourceAsStream("/Tile/chest_open.png"));
            }catch (Exception e){
                e.printStackTrace();
            }
            //weiß Gott was
        }
    }
}
