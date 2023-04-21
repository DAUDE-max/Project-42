package main;

import Entitys.Player;
import Objects.Object;
import Tile.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // ScreenKonstanten
    public final int tileSize = 64;
    public int mcol = 30;
    public int mrow = 18;

    double FPS = 60;

    //WeltKonstanten
    public final int mWC = 100;
    public final int mWR = 100;
    public final int wW = mWC * tileSize;
    public final int wH = mWR * tileSize;


    // Construktor
    GamePanel(){
        this.setPreferredSize(new Dimension(mcol*tileSize,mrow*tileSize));
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

        TM tm = new TM(this);
        KeyManager kM= new KeyManager();
        Thread gameThread;

        public Collision collison = new Collision(this);
        public ObjectManager oM = new ObjectManager(this);
        public Player player = new Player(this, kM);
    public ITM itm = new ITM(this, player);
        public Object[] obj = new Object[10];

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

   public void setUp(){
        oM.setObject();
        itm.setUP();
   }



    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //Tiles
        tm.draw(g2);
        //Objects
        for (Object o:obj) {
            if(o!=null) {
                o.draw(g2, this);
            }
        }
        for(InteractiveTile i:itm.its){
            if(i!=null){
                i.draw(g2, this);
            }
        }
        //Player
        player.draw(g2);

        g2.dispose();
    }

}
