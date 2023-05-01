package main;

import Tiles.InteractiveTileManager;
public class Setup {
    /**
     * summons all Items and Interactive Tiles at the beginning of each round
     * */

    ItemManager itemManager;
    InteractiveTileManager interactiveTileManager;
    public Setup(GamePanel gp){
        this.itemManager = gp.itemManager;
        this.interactiveTileManager = gp.interactiveTileManager;
        setUp();
    }

    public void setUp() {
        itemManager.summon(50, 55, "coin");
        interactiveTileManager.summon(54,46, "chest", false);
        interactiveTileManager.summon(52,46, "door", false );
        interactiveTileManager.summon(45,46, "door", false );
        interactiveTileManager.summon(45, 50, "pot", true);
    }
}
