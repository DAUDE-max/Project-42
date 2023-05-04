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
    public NPC(GamePanel gp) {
        super(gp);
        collision = true;

        try{
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/door_closed.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @Override
    public void action() {

    }
}
