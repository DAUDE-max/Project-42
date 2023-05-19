package Items;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class HeartContainerItem extends Item {
    //Constructor
    public HeartContainerItem(){

        try {
            img = ImageIO.read(getClass().getResourceAsStream("/Items/heartContainer.png"));
        }catch (IOException e){
            e.printStackTrace();

        }
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
