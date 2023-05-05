package Tiles.InteractiveTiles;

import Tiles.InteractiveTile;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.util.Objects;

public class NPC extends InteractiveTile {

    /* npc die man mit e ansprechen kann;
       eine chatbox erscheint mit Name von NPC, und eigenen Text, der über mehrere 'pages' geht, die man mit e skippen kann
       (Text + Name von npc in extra Datei angeben)
     */

    String name;
    public NPC(GamePanel gp, String[] args) {
        super(gp);
        collision = true;

        try{
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/npc/"+ args[0]+".png")));
        }catch (Exception e){
            e.printStackTrace();
        }
        this.name = args[0];

    }





    @Override
    public void action() {
        gp.chatBox.setMessageByKey(name);
    }
}
