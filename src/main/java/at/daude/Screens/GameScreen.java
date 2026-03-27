package at.daude.Screens;

import at.daude.Entities.Player;
import at.daude.Items.Item;
import at.daude.Tiles.InteractiveTiles.InteractiveTile;
import at.daude.core.GamePanel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

import java.util.Map;

public class GameScreen implements Screen{

    GamePanel gp;
    Player player;

    // Get GP
    public GameScreen(GamePanel gp){
        this.gp = gp;
        this.player = gp.entityManager.getPlayer();
        initKeyBinds();
    }

    // Let Elements draw themselves
    @Override
    public void draw(GraphicsContext gc){
        // Tiles
        gp.tileManager.draw(gc);
        gp.entityManager.draw(gc);
        gp.interactiveTileManager.draw(gc);
        gp.itemManager.draw(gc);
        gp.inventory.draw(gc);
        gp.chatBox.draw(gc);


        if(gp.shop != null)gp.shop.draw(gc);
    }
    // Switch to another screen (Win/Settings/...)
    @Override
    public void switchScreen() {
        gp.currentScreen = new WinScreen(gp);
        gp.gameLoop.stop();
    }

    public void initKeyBinds(){
        Map<KeyCode, Runnable> down = Map.of(
                KeyCode.W, () -> player.move("up"),
                KeyCode.S, () -> player.move("down"),
                KeyCode.A, () -> player.move("left"),
                KeyCode.D, () -> player.move("right")
        );
        Map<KeyCode, Runnable> pressed = Map.of(
                KeyCode.E, () -> player.interact()
        );

        gp.inputRouter.setKeyDownContext(down);
        gp.inputRouter.setKeyPressedContext(pressed);
    }
}
