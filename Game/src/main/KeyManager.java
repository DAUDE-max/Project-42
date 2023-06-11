package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

    // set interface
    final GamePanel gp;
    // Constructor
    KeyManager(GamePanel gp) {
this.gp = gp;    }

    // public boolean values to check for other classes
    public boolean upPressed, downPressed, leftPressed, rightPressed, ePressed;


    //checks fpr typed Key
    @Override
    public void keyTyped(KeyEvent e) {
    }

    //Checks for pressed Key
    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_W -> upPressed = true;
            case KeyEvent.VK_S -> downPressed = true;
            case KeyEvent.VK_A -> leftPressed = true;
            case KeyEvent.VK_D -> rightPressed = true;
            case KeyEvent.VK_E -> gp.interactiveTileManager.update();
            case KeyEvent.VK_1 -> gp.inventory.selectSlot(0);
            case KeyEvent.VK_2 -> gp.inventory.selectSlot(1);
            case KeyEvent.VK_3 -> gp.inventory.selectSlot(2);
            case KeyEvent.VK_4 -> gp.inventory.selectSlot(3);
            case KeyEvent.VK_5 -> gp.inventory.selectSlot(4);
            case KeyEvent.VK_6 -> gp.inventory.selectSlot(5);
            case KeyEvent.VK_7 -> gp.inventory.selectSlot(6);
            case KeyEvent.VK_8 -> gp.inventory.selectSlot(7);
            case KeyEvent.VK_9 -> gp.inventory.selectSlot(8);
            case KeyEvent.VK_SPACE -> gp.start.act();
        }
    }
    //Checks for released key
    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_W -> upPressed = false;
            case KeyEvent.VK_S -> downPressed = false;
            case KeyEvent.VK_A -> leftPressed = false;
            case KeyEvent.VK_D -> rightPressed = false;

        }



    }

}