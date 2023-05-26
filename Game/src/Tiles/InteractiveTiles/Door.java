package Tiles.InteractiveTiles;

import Tiles.InteractiveTile;

import javax.imageio.ImageIO;
import java.util.Objects;

import main.GamePanel;

public class Door extends InteractiveTile {

    public Door(int wX,int wY, GamePanel gp){
        super(wX,wY,gp);
        collision = true;
        try{
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/InteractiveTiles/door_closed.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void action() {
        if(collision){
            collision = false;
            try{
                img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/InteractiveTiles/door_open.png")));
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            collision = true;
            try{
                img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/InteractiveTiles/door_closed.png")));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
