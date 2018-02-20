package game.engine;

import game.display.Display;
import game.game.states.MenuState;
import game.game.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    private boolean isRunning;
    private Thread thread;
    private Handler handler;
    private Display display;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private static State currentState;

    public Game(Handler handler) {
        this.handler=handler;
        this.display=new Display(handler.getTitle(),handler.getWidth(),handler.getHeight());
        currentState=new MenuState();
    }

    private void render(){
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if(bufferStrategy==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();

        graphics.clearRect(0,0,handler.getWidth(),handler.getHeight());

        if(currentState!=null)
            currentState.render(graphics);


        bufferStrategy.show();
        graphics.dispose();
    }

    private void update() {
        currentState.update();
    }



    @Override
    public void run() {
       // init();

        int fps=60;
        double timePerUpdate=1000000000/fps;
        double delta=0;
        long now;
        long lastTime=System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(isRunning){
            now=System.nanoTime();
            delta +=(now-lastTime)/timePerUpdate;
            timer+=now-lastTime;
            lastTime=now;

            if(delta>=1){
                update();
                render();
                ticks++;
                delta--;
            }

            if(timer>=1000000000){
                System.out.println("Ticks and frames: "+ticks);
                ticks=0;
                timer=0;
            }


        }
        stop();
    }


    public synchronized void start(){
        if(isRunning)
            return;
        isRunning=true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!isRunning)
            return;
        isRunning =false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
