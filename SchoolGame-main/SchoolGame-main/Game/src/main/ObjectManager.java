package main;

import Objects.OBJ_Chest;
import Objects.OBJ_Coin;

public class ObjectManager {

    GamePanel gp;

    public ObjectManager(GamePanel gp){
        this.gp = gp;

    }

    public void setObject(){

        gp.obj[0] = new OBJ_Chest();
        gp.obj[0].wX = 3000;
        gp.obj[0].wY = 3000;
    }
}
