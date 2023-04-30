import main.GamePanel;

public class Map {

    GamePanel panel;


    public Map(GamePanel panel){
        this.panel = panel;
        buildMap();
    }

    public void buildMap(){
        int c = GamePanel.columns;
        int r = GamePanel.rows;
        int img = 0;

        for(int x = 0;x<c;x++){
            for(int y = 0; y<r; y++){
                new Tile(x* GamePanel.tileSize,y* GamePanel.tileSize,img);
            }
        }
    }
}
