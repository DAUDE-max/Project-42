package Tiles.InteractiveTiles.NPC;

import Tiles.InteractiveTile;
import main.GamePanel;
import main.Shop;

import javax.imageio.ImageIO;
import java.util.Objects;

public class NPC extends InteractiveTile {

    String name;
    int chatIndex = 0;
    int maxChatIndex;
    public NPC(int wX,int wY,GamePanel gp, String[] args) {
        super(wX,wY,gp);
        collision = true;
        maxChatIndex = Integer.parseInt(args[1]);
        try{
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/"+ args[0]+".png")));
        }catch (Exception e){
            e.printStackTrace();
        }
        this.name = args[0];

    }

    public void act1(){}
    public void act2(){};


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
