package game.assets;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 32, height = 32;


    public static BufferedImage grass, stone, water,win;
    public static BufferedImage[] tank;

    public static void init(){
       // grass=new SpriteSheet(ImageLoader.loadImage("/grass.png")).crop(0,0,32,32);
        tank=new BufferedImage[4];
        tank[0]=new SpriteSheet(ImageLoader.loadImage("/textures/tank.png")).crop(0,0,32,32); //up
        tank[1]=new SpriteSheet(ImageLoader.loadImage("/textures/tank.png")).crop(32,0,32,32); //down
        tank[2]=new SpriteSheet(ImageLoader.loadImage("/textures/tank.png")).crop(0,32,32,32);//left
        tank[3]=new SpriteSheet(ImageLoader.loadImage("/textures/tank.png")).crop(32,32,32,32);//right
    }



}
