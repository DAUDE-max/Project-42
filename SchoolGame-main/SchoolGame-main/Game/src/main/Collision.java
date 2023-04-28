package main;

import Entitys.Entity;
import Tile.InteractiveTile;

public class Collision {

    GamePanel gp;

    public Collision(GamePanel gp){
        this.gp = gp;
    }

    // 3 Stunden Arbeit !!! Nicht anfassen
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

    public InteractiveTile checkIT(Entity e, boolean p){
        InteractiveTile of = null;

        for(InteractiveTile i :gp.itm.its){
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
                                e.colli = true;
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
                                e.colli = true;
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
                                e.colli = true;
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
                                e.colli = true;
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

    public int checkObject(Entity e, boolean p){
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
                                e.colli = true;
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
                                e.colli = true;
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
                                e.colli = true;
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
                                e.colli = true;
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
