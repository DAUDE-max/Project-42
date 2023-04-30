package main;

import Entities.*;
import Tiles.InteractiveTile;


public class Collision {
    //Interface
    GamePanel gp;
    //Constructor
    public Collision(GamePanel gp){
        this.gp = gp;
    }

    /**checks for collisions with Tiles*/
    public int[] checkTile(Entity e){
//Hitbox Rand xY
        int l = e.wX + e.hitBox.x;
        int r = e.wX + e.hitBox.x + e.hitBox.width;
        int t = e.wY + e.hitBox.y;
        int b = e.wY + e.hitBox.y + e.hitBox.height;
        // Hitbox rand Col row
        int lc = (l)/ GamePanel.tileSize;
        int rc = (r)/ GamePanel.tileSize;
        int tr = (t)/ GamePanel.tileSize;
        int br = (b)/ GamePanel.tileSize;




        int tN1, tN2;
        int[] blockings = new int[5];

        for(int i = 1; i < 5; i++) {

            switch (i) {


                case 1 -> {
                    int ntr = (t - e.speed) / GamePanel.tileSize;
                    tN1 = gp.tileManager.mTN[lc][ntr];
                    tN2 = gp.tileManager.mTN[rc][ntr];
                    if (gp.tileManager.tile[tN1].collision || gp.tileManager.tile[tN2].collision) {
                        blockings[0]= 1;
                    }
                }



                case 2 -> {
                    int nbr = (b + e.speed) / GamePanel.tileSize;
                    tN1 = gp.tileManager.mTN[lc][nbr];
                    tN2 = gp.tileManager.mTN[rc][nbr];
                    if (gp.tileManager.tile[tN1].collision || gp.tileManager.tile[tN2].collision) {
                        blockings[1]= 2;
                    }
                }


                case 3 -> {
                    int nlc = (l - e.speed) / GamePanel.tileSize;
                    tN1 = gp.tileManager.mTN[nlc][tr];
                    tN2 = gp.tileManager.mTN[nlc][br];
                    if (gp.tileManager.tile[tN1].collision || gp.tileManager.tile[tN2].collision) {
                        blockings[2]= 3;
                    }
                }


                case 4 -> {
                    int nrc = (r + e.speed) / GamePanel.tileSize;
                    tN1 = gp.tileManager.mTN[nrc][tr];
                    tN2 = gp.tileManager.mTN[nrc][br];
                    if (gp.tileManager.tile[tN1].collision || gp.tileManager.tile[tN2].collision) {
                        blockings[3]= 4;
                    }
                }
            }

        }
        return blockings;

    }
    /**checks for collision with InteractiveTile and returns it*/
    public InteractiveTile checkIT(Entity e, boolean p){
        InteractiveTile of = null;

        for(InteractiveTile i :gp.interactiveTileManager.its){
            if(i != null){

                //Coords e und obj vergleichen
                e.hitBox.x = e.wX + e.hitBox.x;
                e.hitBox.y = e.wY + e.hitBox.y;

                i.hitBox.x = i.wX + i.hitBox.x;
                i.hitBox.y = i.wY + i.hitBox.y;

                switch (e.direction) {
                    case "up" -> {
                        e.hitBox.y -= e.speed;
                        if (e.hitBox.intersects(i.hitBox)) {

                            if(i.collision){
                                e.collision = true;
                            }
                            if(p){
                                of = i;
                            }
                        }
                    }
                    case "down" -> {
                        e.hitBox.y += e.speed;
                        if (e.hitBox.intersects(i.hitBox)) {
                            if(i.collision){
                                e.collision = true;
                            }
                            if(p){
                                of = i;
                            }
                        }
                    }
                    case "right" -> {
                        e.hitBox.x += e.speed;
                        if (e.hitBox.intersects(i.hitBox)) {
                            if(i.collision){
                                e.collision = true;
                            }
                            if(p){
                                of = i;
                            }
                        }
                    }
                    case "left" -> {
                        e.hitBox.x -= e.speed;
                        if (e.hitBox.intersects(i.hitBox)) {
                            if(i.collision){
                                e.collision = true;
                            }
                            if(p){
                                of = i;
                            }
                        }
                    }
                }
                e.hitBox.x = e.hitBoxX;
                e.hitBox.y = e.hitBoxY;
                i.hitBox.x = i.hitBoxX;
                i.hitBox.y = i.hitBoxY;

            }
        }



        return of;
    }
    /**checks for collision with Items and returns its array index*/
    public int checkItems(Entity e, boolean p){
        int index = 404;

        for(int i = 0; i < gp.obj.length;i++){
            if(gp.obj[i] != null){

                //Coords e und obj vergleichen
                e.hitBox.x = e.wX + e.hitBox.x;
                e.hitBox.y = e.wY + e.hitBox.y;

                gp.obj[i].hitBox.x = gp.obj[i].wX + gp.obj[i].hitBox.x;
                gp.obj[i].hitBox.y = gp.obj[i].wY + gp.obj[i].hitBox.y;

                switch (e.direction) {
                    case "up" -> {
                        e.hitBox.y += e.speed;
                        if (e.hitBox.intersects(gp.obj[i].hitBox)) {

                            if(gp.obj[i].collision){
                                e.collision = true;
                            }
                            if(p){
                                index = i;
                            }
                        }
                    }
                    case "down" -> {
                        e.hitBox.y -= e.speed;
                        if (e.hitBox.intersects(gp.obj[i].hitBox)) {
                            if(gp.obj[i].collision){
                                e.collision = true;
                            }
                            if(p){
                                index = i;
                            }
                        }
                    }
                    case "right" -> {
                        e.hitBox.x += e.speed;
                        if (e.hitBox.intersects(gp.obj[i].hitBox)) {
                            if(gp.obj[i].collision){
                                e.collision = true;
                            }
                            if(p){
                                index = i;
                            }
                        }
                    }
                    case "left" -> {
                        e.hitBox.x -= e.speed;
                        if (e.hitBox.intersects(gp.obj[i].hitBox)) {
                            if(gp.obj[i].collision){
                                e.collision = true;
                            }
                            if(p){
                                index = i;
                            }
                        }
                    }
                }
                e.hitBox.x = e.hitBoxX;
                e.hitBox.y = e.hitBoxY;
                gp.obj[i].hitBox.x = gp.obj[i].hitBoxX;
                gp.obj[i].hitBox.y = gp.obj[i].hitBoxY;

            }
        }



        return index;
    }


}
