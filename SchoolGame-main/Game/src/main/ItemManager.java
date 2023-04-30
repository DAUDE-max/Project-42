package main;

import Items.CoinItem;

public class ItemManager {

    GamePanel gp;

    public ItemManager(GamePanel gp){
        this.gp = gp;

    }

    public void setObject(){

        gp.obj[1] = new CoinItem();
        gp.obj[1].wX = 3300;
        gp.obj[1].wY = 3000;
    }
}
