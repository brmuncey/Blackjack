package Controller;

import Model.Dealer;
import Model.Game;
import Model.Player;

public class GameController {

    private Game game = new Game();

    private Player player;
    private Dealer dealer;

    public GameController(){
        game.setup();
    }

    public void start(){
        game.play();
        this.dealer = game.getDealer();
        this.player = game.getPlayer();
    }

    public void exit(){ System.exit(0); }

    public Player getPlayer() { return player; }

    public Dealer getDealer() { return dealer; }

    public void stand() {}

    public void hit() { player.addCard(dealer.deal()); }
}
