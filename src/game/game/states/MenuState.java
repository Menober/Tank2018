package game.game.states;

import java.awt.*;

public class MenuState extends State {
    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(20,20,800-40,600-40);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman",Font.BOLD,60));
        g.drawString("Hello World!",50,100);
        g.setColor(Color.GREEN);
        g.fillRect(260,70,30,30);
        g.setColor(Color.RED);
        g.fillRect(265,75,20,20);
    }
}