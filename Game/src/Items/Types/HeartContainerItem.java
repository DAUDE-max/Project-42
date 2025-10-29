package Items.Types;

import Items.Item;
import main.GamePanel;

// in development
public class HeartContainerItem extends Item {
    //Constructor
    public HeartContainerItem(){
        getImg("/Items/heartContainer.png");
        this.id = 4;
    }
    //Action
    @Override
    public boolean interact(GamePanel gp) {
        gp.inventory.addItem(this);
        gp.chatBox.setMessageByKey("heartContainer");
        return true;


    }
}
