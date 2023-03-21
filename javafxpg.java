// Import the necessary classes
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// Define the main class that extends Application
public class Main extends Application {

    // Override the start method
    @Override
    public void start(Stage primaryStage) {

        // Create a pane to hold the rectangle and the button
        Pane pane = new Pane();

        // Create a rectangle with width 200 and height 100
        Rectangle rectangle = new Rectangle(200, 100);

        // Set the stroke color to black and the fill color to null (transparent)
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(null);

        // Set the layout position of the rectangle
        rectangle.setLayoutX(100);
        rectangle.setLayoutY(50);

        // Add the rectangle to the pane
        pane.getChildren().add(rectangle);

        // Create a button with text "Fill"
        Button button = new Button("Fill");

        // Set the layout position of the button
        button.setLayoutX(200);
        button.setLayoutY(200);

        // Add an action listener to the button
        button.setOnAction(e -> {
            // Fill the rectangle with blue color when clicked
            rectangle.setFill(Color.RED);
        });

        // Add the button to the pane
        pane.getChildren().add(button);

        // Create a scene with width 400 and height 300 and add it to the stage
        Scene scene = new Scene(pane, 400, 300);
        
		// Set title for stage 
		primaryStage.setTitle("Rectangle Demo");
		
		// Add scene to stage 
		primaryStage.setScene(scene); 

		// Display stage 
		primaryStage.show(); 
    }

    // Launch the application from main method
    public static void main(String[] args) {
        
       launch(args); 
    }
}