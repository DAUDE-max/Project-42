package Tile;

import Tile.InteractiveTiles.Chest;
import Tile.InteractiveTiles.Door;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TM {

    GamePanel gp;
    public Tile[] tile;
   public int[][] mTN;


    public TM(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        gti();
        mTN = new int[gp.mWC][gp.mWR];
        loadMap("/maps/map1.txt");
    }


    public void gti() {

        try {

            tile[0] = new Tile();
            tile[0].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tile/tree.png")));
            tile[0].collision = true;

            tile[1] = new Tile();
            tile[1].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tile/wall.png")));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tile/wood.png")));


            tile[3]= new Tile();
            tile[3].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tile/grass.png")));





        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String url){

    try {
        InputStream is = getClass().getResourceAsStream(url);
        assert is != null;
        BufferedReader r = new BufferedReader(new InputStreamReader(is));

        int col = 0;
        int row = 0;

        while(col < gp.mWC && row < gp.mWR){

            String line = r.readLine();
            while(col < gp.mWR){
                String[] numbers = line.split(" ");
                int num = Integer.parseInt(numbers[col]);
                mTN[col][row] = num;
                col++;
            }
            if(col == gp.mWR){
                col = 0;
                row++;
            }

        }

    }catch (Exception e){
        e.printStackTrace();
    }
    }

    public void draw(Graphics2D g2) {

        int wcol = 0;
        int wrow = 0;


        while (wcol < gp.mWC && wrow < gp.mWR) {

            int tN = mTN[wcol][wrow];

            int wX = wcol * gp.tileSize;
            int wY = wrow * gp.tileSize;

            //screen coordinaten berechnen bei Unklaheit fragen -Daude

            int sX = wX - gp.player.wX + gp.player.sX;
            int sY = wY - gp.player.wY + gp.player.sY;


            if(wX + gp.tileSize >   gp.player.wX - gp.player.sX &&
               wX - gp.tileSize <   gp.player.wX + gp.player.sX &&
               wY + gp.tileSize >   gp.player.wY - gp.player.sY &&
               wY - gp.tileSize <   gp.player.wY + gp.player.sY) {

                g2.drawImage(tile[tN].img, sX, sY, gp.tileSize, gp.tileSize, null);
            }
            wcol++;


            if (wcol == gp.mWC) {
                wcol = 0;
                wrow++;
            }
        }
    }
}
