package main;

import Items.InventoryItem;

import java.awt.image.BufferedImage;

public class Chatbox {
    public final GamePanel gp;

    /**
    * Soll Stings aus .chat abrufen
    * Soll Strings passen innder Box ausgeben
    */



    // Dimensions
    private final int totalWidth;
    private final int totalHeight;


    // Positions
    private final int positionX;
    private final int positionY;

    private final int margine = 10; //fürs erste konstant

    private BufferedImage img;
    private String selectedText;
    
    //Constrctor
    public Chatbox(GamePanel gp) {
        this.gp = gp;
        this.totalWidth = AppSettings.screenWidth/4;
        this.totalHeight = AppSettings.screenHeight/3;
        this.positionX = 0;
        this.positionY = totalHeight/3;
        
        try {
            this.img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/HUD/chatBox.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Selects URL by a request from ouzside the class
    public void setMessageByKey (String key) {
        String filename = "/chat/" + key + ".chat";
        this.selectedText = loadMessageFromFile(filename);
    }
    
    // Reads the files String
    private String loadMessageFromFile(String filename) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    
        //Draws and looks for line breaks
    public void draw(Graphics g){
        int x = positionX;
        int y = positionY;
        FontMetrics fm = g.getFontMetrics();
        String[] words = selectedText.split("\\s+");
        for (String word : words) {
            int wordWidth = fm.stringWidth(word);
            if (x + wordWidth > maxWidth) {
                x = positionX;
                y += fm.getHeight();
            }
            g.drawString(word, x, y);
            x += wordWidth + fm.stringWidth(" ");
        }
    }
}

 */