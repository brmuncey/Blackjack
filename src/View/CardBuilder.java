package View;

import Model.Card;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

class CardBuilder {

    private Card card;
    private Image suitImg;

    CardBuilder(Card card){
        this.card = card;
        build();
    }

    private void build(){
        String path;
        switch (card.getSuit()) {
            case DIAMONDS: path = "/Img/Diamonds.png";
                break;
            case CLUBS: path = "/Img/Clubs.png";
                break;
            case HEARTS: path = "/Img/Hearts.png";
                break;
            default: path = "/Img/Spades.png";
                break;
        }
        suitImg = new Image(path);
    }

    private ImageView setSuit() {
        ImageView iv = new ImageView(suitImg);
        iv.setFitHeight(20);
        iv.setFitWidth(20);
        return iv;
    }

    VBox getCardImg(){
        FlowPane pane = new FlowPane(new Label(card.getCard()));
        pane.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(pane,setSuit());
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }

}
