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
        itemManager.summon(16, 26, "coin");
        itemManager.summon(16, 31, "coin");
        itemManager.summon(44, 24, "coin");
        itemManager.summon(55, 24, "coin");
        itemManager.summon(44, 32, "coin");
        itemManager.summon(55, 32, "coin");
        interactiveTileManager.summon(26, 42, "pot",new String[]{"true"});
        interactiveTileManager.summon(23,28, "door",new String[]{"false"});
        interactiveTileManager.summon(28,52, "door",new String[]{"false"});
        interactiveTileManager.summon(64,53, "door",new String[]{"false"});
        interactiveTileManager.summon(24, 61, "pot",new String[]{"true"});
        interactiveTileManager.summon(41, 47, "npc",new String[]{"jeff", "1"});
        interactiveTileManager.summon(39, 49, "npc",new String[]{"trader", "1"});

    }
}
