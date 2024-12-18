import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MainPane extends BorderPane {
    private BouncePane bouncePane;
    private Button addBallButton;
    private Button scrambleButton;
    private Button exitButton;

    public MainPane() {
        // Initialize BouncePane and add it to the center of MainPane
        bouncePane = new BouncePane();
        setCenter(bouncePane);

        // Initialize the buttons
        addBallButton = new Button("Add Ball");
        scrambleButton = new Button("Scramble");
        exitButton = new Button("Exit");

        // Add buttons to HBox
        HBox buttonBox = new HBox(10, addBallButton, scrambleButton, exitButton);
        setBottom(buttonBox);

        // Set up button actions
        addButtonActions();
    }

    private void addButtonActions() {
        // Add Ball button action
        addBallButton.setOnAction(e -> bouncePane.addNewBall());

        // Scramble button action
        scrambleButton.setOnAction(e -> bouncePane.scramble());

        // Exit button action
        exitButton.setOnAction(e -> System.exit(0));
    }
}
