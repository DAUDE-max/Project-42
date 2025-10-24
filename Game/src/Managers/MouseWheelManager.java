package Managers;

import main.GamePanel;

import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class MouseWheelManager implements MouseWheelListener {
    final GamePanel gp;

    public MouseWheelManager(GamePanel gp) {
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
