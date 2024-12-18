import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the MainPane and set it as the scene's root
        MainPane mainPane = new MainPane();
        Scene scene = new Scene(mainPane, 600, 400); // Set the initial size of the window

        // Set the stage title and scene
        primaryStage.setTitle("Multiple Bouncing Balls");
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
