package Tiles.InteractiveTiles.Types.NPC.Types;

import Tiles.InteractiveTiles.Types.NPC.NPC;
import main.GamePanel;

//Npc als Erklärbär für die Stroyline (potentiell funktionierender Händler)
public class Bib extends NPC {
    public Bib(int wX,int wY,GamePanel gp, String[] args) {
        super(wX,wY,gp, args);
    }

    @Override
   public void act1(){
        //show tutorials
        gp.player.controlsLocked = true;
    }

    @Override
    public void act2() {
        //clos tutorials
        gp.player.controlsLocked = false;
    }
}

