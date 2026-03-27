package at.daude.Managers;

import at.daude.Entities.Entity;
import at.daude.Entities.NPCs.Shopkeeper;
import at.daude.Entities.NPCs.Wanderer;
import at.daude.Entities.Player;
import at.daude.core.GamePanel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class EntityManager {
    GamePanel gp;
    private final Player player;
    public final List<Entity> entities = new CopyOnWriteArrayList<>();

    public EntityManager(GamePanel gp) {
        this.gp = gp;
        this.player = new Player(gp);
    }

    public void summon(int wX, int wY, String id, String[] args) {
        switch (id){
            case "wanderer" -> {
                wX *= GamePanel.tileSize;
                wY *= GamePanel.tileSize;
                entities.add(new Wanderer(wX,wY,gp, args));
            }
            case "shopkeeper" -> {
                wX *= GamePanel.tileSize;
                wY *= GamePanel.tileSize;
                entities.add(new Shopkeeper(wX,wY,gp, args));
            }

        }
    }

    public void updateAll() {

        // 1. NPCs updaten + Kollision gegen andere Entities/Player
        for (Entity e : entities) {
            //e.update();
        }

    }

    public void entityCollision(Entity entity){
        Entity hit = gp.collision.checkEntity(entity);
        if(hit != null) {
            hit.setActualspeed(0);
            entity.setActualspeed(0);
        }
    }

    public void draw(GraphicsContext gc){
        player.draw(gc);
        for(Entity entity : entities)entity.draw(gc);
    }

    public Player getPlayer(){
        return player;
    }

    // Triggered on "E" or by Entity AI
    public void handlePlayerInteraction(Player player) {

        gp.itemManager.interact(player);

        gp.interactiveTileManager.interact(player);

        playerEntityInteraction();
    }


    public  void playerEntityInteraction(){
        for(Entity entity : entities){
            if(isInFrontOfPlayer(entity)){
                preventMovement();
                entity.interact();
            }
        }
    }

    private boolean inDialog;
    void preventMovement(){
        inDialog = !inDialog;
        if(inDialog){
            gp.inputRouter.setKeyDownContext(new HashMap<>());
        }
        else {
            Map<KeyCode, Runnable> down = Map.of(
                    KeyCode.W, () -> player.move("up"),
                    KeyCode.S, () -> player.move("down"),
                    KeyCode.A, () -> player.move("left"),
                    KeyCode.D, () -> player.move("right")
            );
            gp.inputRouter.setKeyDownContext(down);
        }
    }

    boolean isInFrontOfPlayer(Entity entity){
        return switch (player.direction) {
            case "right" -> entity.wX > player.wX + 32 && entity.wX < player.wX + 96 &&
                            entity.wY > player.wY - 32 && entity.wY < player.wY + 96;
            case "left" ->  entity.wX > player.wX - 96 && entity.wX < player.wX + 32 &&
                            entity.wY > player.wY - 32 && entity.wY < player.wY + 96;
            case "up" ->    entity.wX > player.wX - 32 && entity.wX < player.wX + 96 &&
                            entity.wY > player.wY - 64 && entity.wY < player.wY;
            case "down" ->  entity.wX > player.wX - 32 && entity.wX < player.wX + 96 &&
                            entity.wY > player.wY + 32 && entity.wY < player.wY + 96;
            default -> false;
        };
    }
}
