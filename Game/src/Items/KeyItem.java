package Items;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class KeyItem extends Item {
    //Constructor
    public KeyItem(){

        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Items/key.png")));
        }catch (IOException e){
            e.printStackTrace();

        }
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