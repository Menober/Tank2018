package game.states;

import game.engine.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends State {

    private Handler handler;
    private int option;
    private String[] strings={"START","COLOR","EXIT"};
    public MenuState(Handler handler){
        this.handler=handler;
        option=0;
    }

    @Override
    public void update() {
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP)&&option!=0)
            option--;
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN)&&option!=2)
            option++;
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER))
            switch(option){
                case 0:handler.getGame().startNewGame();break;
                case 1:handler.getGame().changeTankColor();break;
                case 2:handler.getGame().setRunning(false);break;
            }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(20,20,800-40,600-40);
        g.setFont(new Font("TimesRoman",Font.BOLD,60));
        for(int i=0;i<3;i++){
            if(i==option)
                g.setColor(Color.BLACK);
            else
                g.setColor(Color.WHITE);
            g.drawString(strings[i],50,100+i*80);
        }




    }
}
