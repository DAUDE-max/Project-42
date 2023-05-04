package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

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

    private final int margineY = 64; //fürs erste konstant
    private final int margineX = 48;

    private BufferedImage img;
    private String selectedText;
    
    //Constrctor
    public Chatbox(GamePanel gp) {
        this.gp = gp;
        this.totalWidth = AppSettings.desktopWidth/5;
        this.totalHeight = AppSettings.desktopHight/3;
        this.positionX = 0;
        this.positionY = totalHeight;
        
        try {
            this.img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/hud/chatbox.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Selects URL by a request from ouzside the class
    public void setMessageByKey (String key) {
        String filename = "/hud/chats/" + key + ".chat";
        System.out.println(filename);
        this.selectedText = loadMessageFromFile(filename);
    }
    
    // Reads the files String
    private String loadMessageFromFile(String filename) {
        StringBuilder sb = new StringBuilder();
        try{
            InputStream is = getClass().getResourceAsStream(filename);
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            sb.append(clock());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    //Gives the time when a message was sent
    public String clock() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm:ss");
        String timeString = currentTime.format(formatter);
        return " ------- " + timeString;
    }
        //Draws and looks for line breaks
    public void draw(Graphics2D g2){
        g2.drawImage(img,positionX,positionY,totalWidth,totalHeight, null );
        if(selectedText==null)return;
        int x = positionX + margineX;
        int y = positionY + margineY;
        FontMetrics fm = g2.getFontMetrics();
        String[] words = selectedText.split("\\s+");
        for (String word : words) {
            int wordWidth = fm.stringWidth(word);
            if (x + wordWidth > totalWidth - margineX) {
                x = positionX + margineX;
                y += fm.getHeight();
            }
            g2.drawString(word, x, y);
            x += wordWidth + fm.stringWidth(" ");
        }

    }
}

