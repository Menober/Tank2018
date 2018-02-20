package game.engine;

public class Launcher {
    public static void main(String [] args){
        Handler handle=new Handler();
        handle.setTitle("Tank 2018");
        handle.setWidth(800);
        handle.setHeight(600);
        Game game = new Game(handle);
        handle.setGame(game);
        handle.getGame().start();

    }
}
