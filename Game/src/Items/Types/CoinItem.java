package Items.Types;

import Items.Item;
import main.GamePanel;

public class CoinItem extends Item {
    //Constructor
    public CoinItem(){
        getImg("/Items/coin.png");
        this.id = 1;
    }
    //Action
    @Override
    public boolean interact(GamePanel gp) {
        gp.inventory.addItem(this);
        gp.chatBox.setMessageByKey("coin");
        return true;


    }
}
