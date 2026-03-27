package at.daude.Entities.NPCs;

import at.daude.Entities.Entity;
import at.daude.Entities.Player;
import at.daude.Physik.Hitbox;
import at.daude.core.GamePanel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

public class NPC extends Entity {

    protected String name;
    int chatIndex = 0;
    int maxChatIndex;
    Image img;
    Player player;

    public NPC(int wX, int wY, GamePanel gp, String[] args) {
        super(gp);
        this.wX = wX;
        this.wY = wY;
        collision = true;
        maxChatIndex = Integer.parseInt(args[1]);
        getImg("/npc/" + args[0] + ".png");
        this.name = args[0];
        direction = "down";  // Default direction
        hitBox = new Hitbox(6,42,50,16);
        player = gp.entityManager.getPlayer();
    }

    public void act1() {}

    public void act2() {}

    @Override
    public void interact() {
        if (chatIndex < maxChatIndex) {
            gp.chatBox.setMessageByKey(name + chatIndex);
            chatIndex++;
            act1();
        } else {
            act2();
            gp.chatBox.setMessageByKey(name + chatIndex);
            chatIndex = 0;
        }
    }

    // Add getImg method if not in Entity
    protected void getImg(String path) {
        img = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)));

    }

    @Override
    public void draw(GraphicsContext gc){

        double sX = wX - player.wX + player.sX;
        double sY = wY - player.wY + player.sY;


        if (wX + GamePanel.tileSize >   player.wX - player.sX &&
            wX - GamePanel.tileSize <   player.wX + player.sX &&
            wY + GamePanel.tileSize >   player.wY - player.sY &&
            wY - GamePanel.tileSize <   player.wY + player.sY) {

            gc.drawImage(img, sX, sY, GamePanel.tileSize, GamePanel.tileSize);
        }
    }
}
