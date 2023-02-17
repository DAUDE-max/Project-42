package main;

import Entitys.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // ScreenKonstanten
    public final int tileSize = 64;
    public int col = 30;
    public int row = 18;

    double FPS = 60;


    // Construktor
    GamePanel(){
        this.setPreferredSize(new Dimension(col*tileSize,row*tileSize));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kM);
        this.setFocusable(true);
    }

    // GameCore
    @Override
    public void run(){

        double dI = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / dI;
            lastTime = currentTime;


            if(delta >= 1) {
                update();
                repaint();
            delta--;
            }
        }
    }

    // FunktionelleKlassen
        KeyManager kM= new KeyManager();
        Thread gameThread;

        Player player = new Player(this, kM);

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    //Map GameMap = Map(this);



    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        player.draw(g2);

        g2.dispose();
    }

}
