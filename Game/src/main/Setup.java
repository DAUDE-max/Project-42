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
        itemManager.summon(42, 41, "coin");
        interactiveTileManager.summon(54,46, "chest",new String[]{"false"});
        interactiveTileManager.summon(52,46, "door",new String[]{"false"});
        interactiveTileManager.summon(45,46, "door",new String[]{"false"});
        interactiveTileManager.summon(48, 41, "pot",new String[]{"true"});
        interactiveTileManager.summon(39, 71, "npc",new String[]{"jeff", "1"});
    }
}
