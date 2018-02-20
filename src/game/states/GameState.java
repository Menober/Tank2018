package game.states;

import entities.Player;
import game.assets.Assets;
import game.engine.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameState extends State {

    private Handler handler;
    private Player player;
    public GameState(Handler handler){
        this.handler=handler;
        BufferedImage[] skins = null;
        switch(handler.getGame().tankColor){
            case 0:skins=Assets.tankYellow;break;
            case 1:skins=Assets.tankRed;break;
            case 2:skins=Assets.tankGreen;break;
            case 3:skins=Assets.tankGrey;break;
        }
        this.player=new Player(skins,1,1);
    }
    @Override
    public void update() {
        if(handler.getKeyManager().aUp)
            player.moveUp();
        if(handler.getKeyManager().aDown)
            player.moveDown();
        if(handler.getKeyManager().aLeft)
            player.moveLeft();
        if(handler.getKeyManager().aRight)
            player.moveRight();
        player.update();
    }

    @Override
    public void render(Graphics g) {

        player.render(g);

    }
}
