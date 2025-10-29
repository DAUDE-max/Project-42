package Tiles.InteractiveTiles.Types.NPC;

import Tiles.InteractiveTiles.InteractiveTile;
import main.GamePanel;

public class NPC extends InteractiveTile {

    protected String name;
    int chatIndex = 0;
    int maxChatIndex;
    public NPC(int wX,int wY,GamePanel gp, String[] args) {
        super(wX,wY,gp);
        collision = true;
        maxChatIndex = Integer.parseInt(args[1]);
        getImg("/npc/"+ args[0]+".png");
        this.name = args[0];

    }

    public void act1(){}
    public void act2(){}


    @Override
    public void action() {
        if(chatIndex < maxChatIndex) {
            gp.chatBox.setMessageByKey(name + chatIndex);
            chatIndex++;
            act1();
        }
        else {
            act2();
            gp.chatBox.setMessageByKey(name + chatIndex);
            chatIndex = 0;

        }

    }
}
