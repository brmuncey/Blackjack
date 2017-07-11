package View;

import Controller.GameController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Table extends Application{

    private GameController controller = new GameController();
    private HBox buttonBox;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("BRMUNCEY BLACKJACK");
        primaryStage.setScene(buildMenu());
        primaryStage.show();
    }

    private Scene buildMenu() {
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.BASELINE_CENTER);
        setupButtons();
        pane.getChildren().add(buttonBox);
        return new Scene(pane,400,400);
    }

    private void setupButtons(){
        Button start = new Button("Start");
        start.setOnAction(event -> controller.start());

        HBox startBox = new HBox(start);
        startBox.setPadding(new Insets(5 , 5, 5, 5));

        Button exit = new Button("Exit");
        exit.setOnAction(event -> controller.exit());

        HBox exitBox = new HBox(exit);
        exitBox.setPadding(new Insets(5 , 5, 5, 5));

        buttonBox = new HBox(startBox,exitBox);
    }
}
