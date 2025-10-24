package Tiles.InteractiveTiles.NPC;

import java.util.Scanner;

import Items.CoinItem;
import main.GamePanel;

public class Selector extends NPC{

    int demand = 2;

    public Selector(int wX, int wY, GamePanel gp, String[] args) {
        super(wX,wY,gp, args);
    }

    @Override
    public void act1(){
        System.out.println(name);
        if(gp.inventory.peekItem() instanceof CoinItem){
            gp.chatBox.setMessageByKey(name+"a");
            gp.inventory.retrieveItem();
            demand--;
        }
        if(demand == 0)gp.win();
    }
}
