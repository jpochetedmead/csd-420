// Julio Pochet
// CSD-420 Module 1: JavaFX Programming Assignment
// Purpose: Display 4 centered random cards with a refresh button using Lambda and JavaFX.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Pochet_Module1_Cards extends Application {

    private final HBox cardBox = new HBox(10); // Card row
    private static final int CARD_COUNT = 52;
    private static final String CARD_PATH = "cards/";

    @Override
    public void start(Stage primaryStage) {
        updateCards(); // Load first set of 4 cards

        // Create button
        Button refreshButton = new Button("Refresh Cards");
        refreshButton.setOnAction(e -> updateCards()); // Lambda expression

        // Center the cards and button using VBox
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        cardBox.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(cardBox, refreshButton);

        // Scene setup
        Scene scene = new Scene(layout, 600, 300);
        primaryStage.setTitle("JavaFX Card Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateCards() {
        cardBox.getChildren().clear();

        List<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= CARD_COUNT; i++) {
            deck.add(i);
        }
        Collections.shuffle(deck);

        for (int i = 0; i < 4; i++) {
            String filePath = CARD_PATH + deck.get(i) + ".png";
            Image img = new Image(filePath);
            ImageView view = new ImageView(img);
            view.setFitHeight(140); // Control card size
            view.setPreserveRatio(true);
            cardBox.getChildren().add(view);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}