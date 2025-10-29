package Items.Types;

import Items.Item;
import main.GamePanel;

public class KeyItem extends Item {
    //Constructor
    public KeyItem(){

        getImg("/Items/key.png");
        this.id = 2;
    }
    //Action
    @Override
    public boolean interact(GamePanel gp) {
        gp.inventory.addItem(this);
        gp.chatBox.setMessageByKey("key");
        return true;


    }
}