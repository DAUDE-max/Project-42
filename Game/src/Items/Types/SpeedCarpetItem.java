package Items.Types;

import Items.Item;
import main.GamePanel;

public class SpeedCarpetItem extends Item {
    //Constructor
    public SpeedCarpetItem(){
        getImg("/Items/speedCarpet.png");
        this.id = 3;
    }
    //Action
    @Override
    public boolean interact(GamePanel gp) {
        gp.inventory.addItem(this);
        gp.chatBox.setMessageByKey("speedCarpet");
        return true;


    }

}