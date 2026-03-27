package at.daude.Managers.IO;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;


public class InputRouter {

    private final InputManager input;

    // Key events
    private Map<KeyCode, Runnable> keyPressedContext = new HashMap<>();
    private Map<KeyCode, Runnable> keyDownContext = new HashMap<>();
    private Map<KeyCode, Runnable> keyReleasedContext = new HashMap<>();

    // Mouse events
    private Map<MouseButton, Runnable> mousePressedContext = new HashMap<>();
    private Map<MouseButton, Runnable> mouseDownContext = new HashMap<>();
    private Map<MouseButton, Runnable> mouseReleasedContext = new HashMap<>();

    // Scroll (mit Richtung)
    private Consumer<Double> scrollAction  = d -> {};

    // Mausbewegung
    private BiConsumer<Double, Double> mouseMoveAction = (dx, dy) -> {};

    public InputRouter(InputManager input) {
        this.input = input;
    }

        // -----------------------------
    // Kontext setzen
    // -----------------------------
    public void setKeyPressedContext(Map<KeyCode, Runnable> ctx) {
        this.keyPressedContext = new HashMap<>(ctx);
    }

    public void setKeyDownContext(Map<KeyCode, Runnable> ctx) {
        this.keyDownContext = new HashMap<>(ctx);;
    }

    public void setKeyReleasedContext(Map<KeyCode, Runnable> ctx) {
        this.keyReleasedContext = new HashMap<>(ctx);;
    }

    public void setMousePressedContext(Map<MouseButton, Runnable> ctx) {
        this.mousePressedContext = new HashMap<>(ctx);;
    }

    public void setMouseDownContext(Map<MouseButton, Runnable> ctx) {
        this.mouseDownContext = new HashMap<>(ctx);;
    }

    public void setMouseReleasedContext(Map<MouseButton, Runnable> ctx) {
        this.mouseReleasedContext = new HashMap<>(ctx);;
    }

    public void setScrollAction(Consumer<Double> action) {
        this.scrollAction = action;
    }

    public void setMouseMoveAction(BiConsumer<Double, Double> action) {
        this.mouseMoveAction = action;
    }

    // -----------------------------
    // Kontext löschen
    // -----------------------------
    public void clearAll() {
        keyPressedContext.clear();
        keyDownContext.clear();
        keyReleasedContext.clear();

        mousePressedContext.clear();
        mouseDownContext.clear();
        mouseReleasedContext.clear();

        scrollAction = d -> {};
        mouseMoveAction = (dx, dy) -> {};
    }

    // -----------------------------
    // Update
    // -----------------------------
    public void update() {

        // Key pressed
        for (var entry : keyPressedContext.entrySet()) {
            if (input.wasPressed(entry.getKey())) {
                entry.getValue().run();
            }
        }

        // Key down
        for (var entry : keyDownContext.entrySet()) {
            if (input.isDown(entry.getKey())) {
                entry.getValue().run();
            }
        }

        // Key released
        for (var entry : keyReleasedContext.entrySet()) {
            if (input.wasReleased(entry.getKey())) {
                entry.getValue().run();
            }
        }

        // Mouse pressed
        for (var entry : mousePressedContext.entrySet()) {
            if (input.wasMousePressed(entry.getKey())) {
                entry.getValue().run();
            }
        }

        // Mouse down
        for (var entry : mouseDownContext.entrySet()) {
            if (input.isMouseDown(entry.getKey())) {
                entry.getValue().run();
            }
        }

        // Mouse released
        for (var entry : mouseReleasedContext.entrySet()) {
            if (input.wasMouseReleased(entry.getKey())) {
                entry.getValue().run();
            }
        }

        // Scroll
        double scroll = input.getScrollDelta();
        if (scroll != 0) {
            scrollAction.accept(scroll);
        }

        // Mouse movement
        double dx = input.getMouseDX();
        double dy = input.getMouseDY();

        if (dx != 0 || dy != 0) {
            mouseMoveAction.accept(dx, dy);
        }

    }

}
