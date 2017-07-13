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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Table extends Application{

    private GameController controller = new GameController();
    private Stage stage;
    private HBox dealerBox;
    private HBox playerBox;
    private boolean started = false;
    private String template = "Total: ";
    private int windowSize = 400;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setResizable(false);
        buildApp();
    }

    private void buildApp() {
        stage.setTitle("BLACKJACK");
        stage.setScene(buildMenu());
        stage.show();
    }

    private Scene buildMenu() {
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.BASELINE_CENTER);
        pane.getChildren().add(addMenuButtons());
        return new Scene(pane,windowSize,windowSize);
    }

    private HBox addMenuButtons(){
        Button start = new Button("Start");
        start.setOnAction(event -> transitionToGame());

        HBox startBox = new HBox(start);
        paddingMaster(startBox);

        Button exit = new Button("Exit");
        exit.setOnAction(event -> controller.exit());

        HBox exitBox = new HBox(exit);
        paddingMaster(exitBox);

        return new HBox(startBox,exitBox);
    }

    private void paddingMaster(Pane pane){ pane.setPadding(new Insets(5 , 5, 5, 5)); }

    private void transitionToGame(){
        stage.setScene(buildGameSceneRoot());
        stage.show();
    }

    private Scene buildGameSceneRoot() {
        FlowPane pane = new FlowPane(buildNavMenu() , addGameButtons());
        pane.setAlignment(Pos.BASELINE_CENTER);
        return new Scene(pane,windowSize,windowSize);
    }

    private HBox addGameButtons() {
        Button deal = new Button("Deal");
        deal.setOnAction(event -> getHandsFromController() );
        HBox temp = new HBox(deal);
        paddingMaster(temp);
        return temp;
    }

    private void getHandsFromController(){
        if(!started){
            controller.start();
            started = true;
        }

        addDealerCards();
        addPlayerCards();
        addTotals();
        showHands();
    }

    private void showHands() {
        stage.setScene(new Scene(new VBox(buildNavMenu(), dealerBox, playerBox, buildGameButtons()),windowSize,windowSize));
        stage.show();
    }

    private void displayFinalHands(){
        addDealerFinalCards();
        addPlayerCards();
        addEndTotals();
        showHands();
    }

    private void addDealerFinalCards() {
        dealerBox = new HBox();
        for(Card c: controller.getDealer().getHand().getCards() ) { dealerBox.getChildren().add( new CardBuilder(c).getCardImg() ); }
    }

    private void addPlayerCards() {
        playerBox = new HBox();
        for(Card c: controller.getPlayer().getHand().getCards() ){ playerBox.getChildren().add( new CardBuilder(c).getCardImg() ); }
    }

    private void addDealerCards() {
        dealerBox = new HBox();
        for(int i = 0; i < controller.getDealer().getHand().getCards().size() ; i++) {
            Card c = controller.getDealer().getHand().getCards().get(i);
            if(i == 0){ dealerBox.getChildren().add( new CardBuilder(c).getBackImg() ); }
            else { dealerBox.getChildren().add( new CardBuilder(c).getCardImg() ); }
        }
    }

    private void addTotals() {
        playerBox.getChildren().add(new Label(template + controller.getPlayer().getHand().getTotal()));
        dealerBox.getChildren().add(new Label( template + controller.getDealer().getHand().getFirstDealTotal()));
    }

    private void addEndTotals(){
        playerBox.getChildren().add(new Label(template + controller.getPlayer().getHand().getTotal()));
        dealerBox.getChildren().add(new Label( template + controller.getDealer().getHand().getTotal()));
    }

    private HBox buildNavMenu(){
        Button back = new Button("Menu");
        back.setOnAction(event -> buildApp());
        HBox temp = new HBox(back);
        paddingMaster(temp);
        return temp;
    }

    private HBox addActionButtons() {
        Button hit = new Button("Hit");
        Button stand = new Button("Stand");

        hit.setOnAction(event -> takePlayerTurn());
        stand.setOnAction(event -> takeDealerTurn());

        HBox temp = new HBox(hit,stand);
        temp.setAlignment(Pos.CENTER);
        paddingMaster(temp);

        return temp;
    }

    private void takeDealerTurn() {
        controller.stand();
        displayFinalHands();
    }

    private void takePlayerTurn() {
        controller.hit();
        getHandsFromController();
        if(!controller.checkForBust(controller.getPlayer().getHand().getTotal())) {
            controller.endRound();
        }
    }

    private VBox buildGameButtons(){
        HBox hBox = addActionButtons();
        VBox vBox = new VBox(hBox);
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        return vBox;
    }

}