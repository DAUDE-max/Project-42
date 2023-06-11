package main;

import Entities.Player;
import Tiles.*;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // Screen constants
    public static final int tileSize = 64;
    public static final int columns = AppSettings.desktopWidth/64;
    public static final int rows = AppSettings.desktopHight/64;
    public static final int fps = 60;

    // World constants
    public static final int maxColumns = 100;
    public static final int maxRows = 100;

    public boolean staticScreen;


    public  GameGraph gameGraph = new GameGraph();
    private Thread gameThread;
    private int tickLength;
    public Inventory inventory = new Inventory(this);

    public Collision collision = new Collision(this);
    public ItemManager itemManager = new ItemManager(this);
    public KeyManager keyManager = new KeyManager(this);
    public MouseWheelManager mouseWheelManager = new MouseWheelManager(this);
    public TileManager tileManager = new TileManager(this);
    public final Player player = new Player(this);
    public InteractiveTileManager interactiveTileManager = new InteractiveTileManager(this);
    public Chatbox chatBox = new Chatbox(this);
    public Shop shop;
    public StartScreen start = new StartScreen(this);



    public int getScreenWidth() {
        return AppSettings.desktopWidth;
    }

    public int getScreenHeight() {
        return AppSettings.desktopHight;
    }


    /**
     * Constructor
     */
    GamePanel() {
        this.staticScreen = true;
        this.setPreferredSize(new Dimension(AppSettings.desktopWidth, AppSettings.desktopHight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyManager);
        this.addMouseWheelListener(mouseWheelManager);
        this.setFocusable(true);
        this.tickLength = 1000_000_000 / fps;
    }

    /**
     * Implements the run method of Runnable, runs in its own thread
     * Repaints the UI every number of nanoseconds specified in tickLength
     */
    @Override
    public void run() {
        long currentTime;
        long latestTime = 0;

        // Execute only while game thread is running
        while (gameThread != null) {
            currentTime = System.nanoTime();

            // Check if it is time to repaint
            if (currentTime - latestTime >= this.tickLength) {
                latestTime = currentTime;
                this.update();
                this.repaint();
            }
        }
    }

    /**
     * Start thread for refreshing the UI
     */
    public void startGameThread() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    /**
     * Initialize game components
     */
    public void setup() {
        new Setup(this);
    }

    /**
     * Update game components, gets called periodically
     */
    public void update() {
        if(staticScreen)return;
        this.player.update();

    }

    /**
     * Overrides paintComponent method of JPanel
     * Paints all game components, e.g. tiles, objects onto screen
     */
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2d = (Graphics2D) graphics;
        if(staticScreen){
            start.draw(graphics2d);
            return;
        }
        gameGraph.draw(this, graphics2d);

        graphics2d.dispose();
    }
}
