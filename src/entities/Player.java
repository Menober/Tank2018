package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    BufferedImage[] skins;
    int x, y;
    double speed;
    int skinIndex;

    public Player(BufferedImage[] skins, int x, int y){
        this.skins=skins;
        this.x=x;
        this.y=y;
        speed=2;
        skinIndex=0;
    }

    public void update(){

    }
    public void moveUp(){
        y-=speed;
        skinIndex=0;
    }
    public void moveDown(){
        y+=speed;
        skinIndex=1;
    }
    public void moveLeft(){
        x-=speed;
        skinIndex=2;
    }
    public void moveRight(){
        x+=speed;
        skinIndex=3;
    }

    public void render(Graphics g){
        g.drawImage(skins[skinIndex],x,y,64,64,null);
    }

}
