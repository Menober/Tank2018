package game.engine;

public class Launcher {
    public static void main(String [] args){
        Handler handler=new Handler();
        handler.setTitle("Tank 2018");
        handler.setWidth(800);
        handler.setHeight(600);
        Game game = new Game(handler);
        handler.setGame(game);
        handler.getGame().start();


    }
}
