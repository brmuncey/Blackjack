package View;

import Controller.GameController;
import Model.Card;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Table extends Application{

    private GameController controller = new GameController();
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setResizable(false);
        buildApp();
    }

    private void buildApp() {
        stage.setTitle("BRMUNCEY BLACKJACK");
        stage.setScene(buildMenu());
        stage.show();
    }

    private Scene buildMenu() {
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.BASELINE_CENTER);
        pane.getChildren().add(addMenuButtons());
        return new Scene(pane,400,400);
    }

    private HBox addMenuButtons(){
        Button start = new Button("Start");
        start.setOnAction(event -> transitionToGame());

        HBox startBox = new HBox(start);
        startBox.setPadding(new Insets(5 , 5, 5, 5));

        Button exit = new Button("Exit");
        exit.setOnAction(event -> controller.exit());

        HBox exitBox = new HBox(exit);
        exitBox.setPadding(new Insets(5 , 5, 5, 5));

        return new HBox(startBox,exitBox);
    }

    private void transitionToGame(){
        stage.setScene(buildGameScene());
        stage.show();
    }

    private Scene buildGameScene() {
        FlowPane pane = new FlowPane(addGameButtons());
        pane.setAlignment(Pos.CENTER);
        return new Scene(pane,400,400);
    }

    private HBox addGameButtons() {
        Button deal = new Button("Deal");
        deal.setOnAction(event -> displayHands() );
        return new HBox(deal);
    }

    private void displayHands(){
        controller.start();

        HBox dealer = new HBox();
        for(Card c : controller.getDealer().getCards() ){
            CardBuilder cb = new CardBuilder(c);
            dealer.getChildren().add( cb.getCardImg() );

            //dealer.getChildren().add(new Label(c.getCard()));
        }

        HBox player = new HBox();
        for(Card c: controller.getPlayer().getCards() ){
            CardBuilder cb = new CardBuilder(c);
            player.getChildren().add( cb.getCardImg() );

            //player.getChildren().add(new Label(c.getCard()));
        }

        VBox vBox = new VBox(dealer,player);
        stage.setScene(new Scene(vBox,400,400));
        stage.show();
    }
}
