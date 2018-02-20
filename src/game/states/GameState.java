package game.states;

import game.assets.Assets;
import game.engine.Handler;

import java.awt.*;

public class GameState extends State {

    private Handler handler;
    public GameState(Handler handler){
        this.handler=handler;
    }
    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(200,0,0));
        g.fillRect(0,0,handler.getWidth(),handler.getHeight());
        g.drawImage(Assets.tankYellow[0],20,20,64,64,null);

    }
}
