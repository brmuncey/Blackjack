package Controller;

import Model.Game;

public class GameController {

    private Game game = new Game();

    public GameController(){
        game.setup();
    }

    public void start(){ game.play(); }

    public void exit(){ System.exit(0); }

}
