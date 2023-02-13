import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int tileSize = 64;
    int col = 30;
    int row = 18;

    GamePanel(){
        this.setPreferredSize(new Dimension(col*tileSize,row*tileSize));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void run(){
        act();
        repaint();
    }

        Thread gameThread;

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    //Map GameMap = Map(this);



    public void act(){}

    public void paintCompoent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
    };

}
