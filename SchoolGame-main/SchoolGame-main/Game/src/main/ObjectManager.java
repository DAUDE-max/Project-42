package main;

import Objects.OBJ_Coin;

public class ObjectManager {

    GamePanel gp;

    public ObjectManager(GamePanel gp){
        this.gp = gp;

    }

    public void setObject(){

        gp.obj[1] = new OBJ_Coin();
        gp.obj[1].wX = 3300;
        gp.obj[1].wY = 3000;
    }
}
