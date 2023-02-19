package main;

import Entitys.Entity;

public class Collision {

    GamePanel gp;

    public Collision(GamePanel gp){
        this.gp = gp;
    }

    public int[] checkTile(Entity e){
//Hitbox Rand xY
        int l = e.wX + e.hitBox.x;
        int r = e.wX + e.hitBox.x + e.hitBox.width;
        int t = e.wY + e.hitBox.y;
        int b = e.wY + e.hitBox.y + e.hitBox.height;
        // Hitbox rand Col row
        int lc = (l)/gp.tileSize ;
        int rc = (r)/gp.tileSize ;
        int tr = (t)/gp.tileSize ;
        int br = (b)/gp.tileSize ;




        int tN1, tN2;
        int[] blockings = new int[5];

        for(int i = 1; i < 5; i++) {

            switch (i) {


                case 1 -> {
                    int ntr = (t - e.speed) / gp.tileSize;
                    tN1 = gp.tm.mTN[lc][ntr];
                    tN2 = gp.tm.mTN[rc][ntr];
                    if (gp.tm.tile[tN1].collision || gp.tm.tile[tN2].collision) {
                        blockings[0]= 1;
                    }
                }



                case 2 -> {
                    int nbr = (b + e.speed) / gp.tileSize;
                    tN1 = gp.tm.mTN[lc][nbr];
                    tN2 = gp.tm.mTN[rc][nbr];
                    if (gp.tm.tile[tN1].collision || gp.tm.tile[tN2].collision) {
                        blockings[1]= 2;
                    }
                }


                case 3 -> {
                    int nlc = (l - e.speed) / gp.tileSize;
                    tN1 = gp.tm.mTN[nlc][tr];
                    tN2 = gp.tm.mTN[nlc][br];
                    if (gp.tm.tile[tN1].collision || gp.tm.tile[tN2].collision) {
                        blockings[2]= 3;
                    }
                }


                case 4 -> {
                    int nrc = (r + e.speed) / gp.tileSize;
                    tN1 = gp.tm.mTN[nrc][tr];
                    tN2 = gp.tm.mTN[nrc][br];
                    if (gp.tm.tile[tN1].collision || gp.tm.tile[tN2].collision) {
                        blockings[3]= 4;
                    }
                }
            }

        }
        return blockings;

    }
}
