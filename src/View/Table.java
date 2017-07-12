package View;

import Controller.GameController;
import Model.Card;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Table extends Application{

    private GameController controller = new GameController();
    private Stage stage;
    private HBox dealerBox;
    private HBox playerBox;
    private boolean started = false;

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
        FlowPane pane = new FlowPane(buildNavMenu() , addGameButtons());
        pane.setAlignment(Pos.BASELINE_CENTER);
        return new Scene(pane,400,400);
    }

    private HBox addGameButtons() {
        Button deal = new Button("Deal");
        deal.setOnAction(event -> displayHands() );

        return new HBox(deal);
    }

    private void displayHands(){
        if(!started){
            controller.start();
            started = true;
        }

        dealerBox = new HBox();
        playerBox = new HBox();

        for(Card c : controller.getDealer().getHand().getCards() ){ dealerBox.getChildren().add( new CardBuilder(c).getCardImg() ); }
        for(Card c: controller.getPlayer().getHand().getCards() ){ playerBox.getChildren().add( new CardBuilder(c).getCardImg() ); }
        addTotals();

        stage.setScene(new Scene(new VBox(buildNavMenu(), dealerBox, playerBox, addActionButtons()),400,400));
        stage.show();
    }

    private void addTotals() {
        String template = "Total: ";
        playerBox.getChildren().add(new Label(template + controller.getPlayer().getHand().getTotal()));
        dealerBox.getChildren().add(new Label( template + controller.getDealer().getHand().getTotal()));
    }

    private HBox buildNavMenu(){
        Button back = new Button("Menu");
        back.setOnAction(event -> buildApp());
        return new HBox(back);
    }

    private HBox addActionButtons() {
        Button hit = new Button("Hit");
        Button stand = new Button("Stand");

        hit.setOnAction(event -> distributeCard());
        stand.setOnAction(event -> controller.stand());

        return new HBox(hit,stand);
    }

    private void distributeCard() {
        controller.hit();
        displayHands();
    }
}
