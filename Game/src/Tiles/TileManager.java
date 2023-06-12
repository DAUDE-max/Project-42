package Tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
   public int[][] mTN;


    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[25];
        gti();
        mTN = new int[GamePanel.maxColumns][GamePanel.maxRows];
        loadMap("/maps/1.map");
    }


    public void gti() {

        try {

            tile[0] = new Tile();
            tile[0].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/grass.png")));

            tile[1] = new Tile();
            tile[1].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/path.png")));

            tile[2] = new Tile();
            tile[2].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/sand.png")));


            tile[3]= new Tile();
            tile[3].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/brick_wall.png")));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/stone_wall.png")));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/wood.png")));

            tile[6] = new Tile();
            tile[6].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/flooring_tile.png")));

            tile[7] = new Tile();
            tile[7].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/apple_tree.png")));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/tree.png")));
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/pine_tree.png")));
            tile[9].collision = true;

            tile[10] = new Tile();
            tile[10].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/bush.png")));
            tile[10].collision = true;

            tile[13] = new Tile();
            tile[13].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/bookshelf_1.png")));
            tile[13].collision = true;

            tile[14] = new Tile();
            tile[14].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/bookshelf_2.png")));
            tile[14].collision = true;

            tile[15] = new Tile();
            tile[15].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/bookshelf_3.png")));
            tile[15].collision = true;

            tile[16] = new Tile();
            tile[16].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/bookshelf_4.png")));
            tile[16].collision = true;

            tile[17] = new Tile();
            tile[17].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/stone_path.png")));

            tile[21] = new Tile();
            tile[21].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/water_well.png")));
            tile[21].collision = true;

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

        while(col < GamePanel.maxColumns && row <  GamePanel.maxRows){

            String line = r.readLine();
            while(col < GamePanel.maxRows){
                String[] numbers = line.split(";");
                int num = Integer.parseInt(numbers[col]);
                mTN[col][row] = num;
                col++;
            }
            if(col == GamePanel.maxRows){
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


        while (wcol < GamePanel.maxColumns && wrow < GamePanel.maxRows) {

            int tN = mTN[wcol][wrow];

            int wX = wcol * GamePanel.tileSize;
            int wY = wrow * GamePanel.tileSize;

            //screen coordinaten berechnen bei Unklaheit fragen -Daude

            int sX = wX - gp.player.wX + gp.player.sX;
            int sY = wY - gp.player.wY + gp.player.sY;


            if(wX + GamePanel.tileSize >   gp.player.wX - gp.player.sX &&
               wX - GamePanel.tileSize <   gp.player.wX + gp.player.sX &&
               wY + GamePanel.tileSize >   gp.player.wY - gp.player.sY &&
               wY - GamePanel.tileSize <   gp.player.wY + gp.player.sY) {

                g2.drawImage(tile[tN].img, sX, sY, GamePanel.tileSize, GamePanel.tileSize, null);
            }
            wcol++;


            if (wcol == GamePanel.maxColumns) {
                wcol = 0;
                wrow++;
            }
        }
    }
}
