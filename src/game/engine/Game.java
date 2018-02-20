package game.engine;

import game.assets.Assets;
import game.display.Display;
import game.input.KeyManager;
import game.states.GameState;
import game.states.MenuState;
import game.states.State;

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
    private KeyManager keyManager;
    public int tankColor;

    Game(Handler handler) {
        this.handler=handler;
        this.display=new Display(handler.getTitle(),handler.getWidth(),handler.getHeight());
        keyManager=new KeyManager();
        handler.setKeyManager(keyManager);
    }

    private void init(){
        display=new Display(handler.getTitle(),handler.getWidth(),handler.getHeight());
        display.getFrame().addKeyListener(keyManager);
        tankColor=0;
        Assets.init();
        currentState=new MenuState(handler);

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
        keyManager.update();
    }


    public void setCurrentState(State state){
        currentState=state;
    }

    @Override
    public void run() {
        init();

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

    private synchronized void stop(){

        System.exit(1);

    }

    public void setRunning(boolean running) {
        this.isRunning=running;
    }

    public void changeTankColor() {
        tankColor++;
        if(tankColor>3)
            tankColor=0;
    }

    public void startNewGame() {
        GameState newGame=new GameState(handler);
        setCurrentState(newGame);
    }
}
