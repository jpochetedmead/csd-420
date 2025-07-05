// Julio Pochet 
// 07/04/2025
// Assignment: Module 7 – JavaFX Circles with CSS
// Purpose: Display four styled circles using CSS and test that the layout works as expected.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Pochet_Module7_Circles extends Application {

    @Override
    public void start(Stage stage) {

        // Create 4 circles with radius 40
        Circle circle1 = new Circle(40);
        Circle circle2 = new Circle(40);
        Circle circle3 = new Circle(40);
        Circle circle4 = new Circle(40);

        // Add class to white circles
        circle1.getStyleClass().add("plaincircle");
        circle2.getStyleClass().add("plaincircle");

        // Set IDs for red and green circles
        circle3.setId("redcircle");
        circle4.setId("greencircle");

        // Wrap the first circle in a VBox with a dashed border
        VBox dashedBox = new VBox(circle1);
        dashedBox.getStyleClass().add("circleborder");

        // Put all 4 circles into a row
        HBox circleRow = new HBox(20, dashedBox, circle2, circle3, circle4);
        circleRow.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Outer box with solid border
        VBox borderedBox = new VBox(circleRow);
        borderedBox.getStyleClass().add("border");

        // Set up the scene
        Scene scene = new Scene(borderedBox, 500, 200);
        scene.getStylesheets().add("mystyle.css");

        // Show the window
        stage.setTitle("Module 7 Circles");
        stage.setScene(scene);
        stage.show();

        // Simple test to check if the circles and IDs are in place
        runTests(scene);
    }

    // Test that checks if the layout contains the correct circles and IDs
    public static void runTests(Scene scene) {
        VBox root = (VBox) scene.getRoot();
        HBox hbox = (HBox) root.getChildren().get(0);

        // Get circles
        Circle circle1 = (Circle) ((VBox) hbox.getChildren().get(0)).getChildren().get(0);
        Circle circle3 = (Circle) hbox.getChildren().get(2);
        Circle circle4 = (Circle) hbox.getChildren().get(3);

        // Simple checks (run with: java -ea Pochet_Module7_Circles)
        assert circle1 != null : "First circle is missing";
        assert "redcircle".equals(circle3.getId()) : "Red circle ID is missing";
        assert "greencircle".equals(circle4.getId()) : "Green circle ID is missing";

        System.out.println("✅ Layout test passed.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}