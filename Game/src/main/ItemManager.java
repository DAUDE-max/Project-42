package main;

import Items.CoinItem;
import Items.Item;

public class ItemManager {
    //Interface
    GamePanel gp;
    //Constructor
    public ItemManager(GamePanel gp){
        this.gp = gp;
    }

    //Array of all Items and the index
    public Item[] obj = new Item[10];
    int index = 0;



    public void summon(int wX, int wY, String id){
        switch(id){
            case "coin" ->{
                obj[index] = new CoinItem();
                obj[index].wX = wX * GamePanel.tileSize;
                obj[index].wY = wY * GamePanel.tileSize;
                index++;
            }
        }
    }
}
