package Tile.InteractiveTiles;

import Tile.InteractiveTile;

import javax.imageio.ImageIO;

public class Door extends InteractiveTile {

    public Door(){
        collision = true;
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/Tile/door_closed.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void action() {
        if(collision){
            collision = false;
            try{
                img = ImageIO.read(getClass().getResourceAsStream("/Tile/door_open.png"));
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            collision = true;
            try{
                img = ImageIO.read(getClass().getResourceAsStream("/Tile/door_closed.png"));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
