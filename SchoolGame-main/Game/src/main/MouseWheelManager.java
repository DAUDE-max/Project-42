package main;

import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class MouseWheelManager implements MouseWheelListener {
    final GamePanel gp;

    MouseWheelManager(GamePanel gp) {
        this.gp = gp;
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        final int steps = e.getWheelRotation();

        if (steps > 0) {
            gp.inventory.increaseSlot();
        } else {
            gp.inventory.decreaseSlot();
        }
    }
}
