package game.world;

import game.assets.Assets;
import game.engine.Handler;
import game.tiles.Tile;

import java.awt.*;

public class Map {

    int xCount=7,yCount=7;
    int [][] tiles={    {0,0,0,0,0,0,0},
                        {0,3,1,1,1,1,0},
                        {0,1,2,2,2,1,0},
                        {0,1,2,1,2,1,0},
                        {0,1,2,3,2,1,0},
                        {0,1,1,1,1,1,0},
                        {0,0,0,0,0,0,0}
    };
    Handler handler;
    public Map(Handler handler){
        this.handler=handler;
    }


    public Tile getTile(int x, int y){
        if(x < 0 || y < 0 || x >= handler.getWidth() || y >= handler.getHeight())
            return Tile.grassTile;

        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
            return Tile.dirtTile;
        return t;
    }

    public void render(Graphics graphics){
        for(int i=0;i<yCount;i++)
            for(int j=0;j<xCount;j++)
                switch(tiles[i][j]){
                    case 0:graphics.drawImage(Assets.brick,64*j,64*i,64,64,null);break;
                    case 1:graphics.drawImage(Assets.grass,64*j,64*i,64,64,null);break;
                    case 2:graphics.drawImage(Assets.water,64*j,64*i,64,64,null);break;
                    case 3:graphics.drawImage(Assets.stone,64*j,64*i,64,64,null);break;
                }
    }
}
