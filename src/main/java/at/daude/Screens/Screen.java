package at.daude.Screens;

import at.daude.core.GamePanel;
import javafx.scene.canvas.GraphicsContext;

public interface Screen {
    void draw(GraphicsContext gc);
    default void act() {};
    default void update() {};
    default void switchScreen() {};
}
