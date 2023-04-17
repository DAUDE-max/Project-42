import main.GamePanel;

public class Map {

    GamePanel panel;


    public Map(GamePanel panel){
        this.panel = panel;
        buildMap();
    }

    public void buildMap(){
        int c = panel.mcol;
        int r = panel.mrow;
        int img = 0;

        for(int x = 0;x<c;x++){
            for(int y = 0; y<r; y++){
                new Tile(x*panel.tileSize,y*panel.tileSize,img);
            }
        }
    }
}
