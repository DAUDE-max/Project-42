package Items;

import Entities.Player;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class SpeedCarpetItem extends Item {
    //Constructor
    public SpeedCarpetItem(){

        try {
            img = ImageIO.read(getClass().getResourceAsStream("/Items/speedCarpet.png"));
        }catch (IOException e){
            e.printStackTrace();

        }
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