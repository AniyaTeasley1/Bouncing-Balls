import javafx.scene.input.MouseEvent;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Random;

public class BouncePane extends Pane {
    private ArrayList<Ball> balls;

    public BouncePane() {
        balls = new ArrayList<>();

        // Start the animation timer
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                moveBalls();
            }
        }.start();

        // Add initial balls (you can change this to 2 or 3 balls)
        addNewBall();
        addNewBall();

        // Register mouse pressed handler
        setOnMousePressed(this::handleMousePressed);  // Correct method to register mouse press event
    }

    public void addNewBall() {
        Ball newBall = new Ball();
        setRandomAttributes(newBall); // Randomize ball properties
        balls.add(newBall);
        getChildren().add(newBall); // Add the ball to the pane
    }

    public void scramble() {
        for (Ball ball : balls) {
            setRandomAttributes(ball); // Randomize the properties of each ball
        }
    }

    private void setRandomAttributes(Ball ball) {
        Random rand = new Random();

        // Set random color (RGB between 0 and 255)
        ball.setColor(Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));

        // Set random radius between 5 and 30
        ball.setRadius(5 + rand.nextInt(26));

        // Set random speed between 1 and 10
        ball.setSpeed(1 + rand.nextInt(10));

        // Set random direction
        double angle = rand.nextDouble() * 2 * Math.PI;
        ball.setDirection(Math.cos(angle), Math.sin(angle));
    }

    private void moveBalls() {
        for (Ball ball : balls) {
            ball.move(getWidth(), getHeight());
        }
    }

    // Private method to check if (x, y) is within the ball
    private boolean isPointWithinBall(Ball ball, double x, double y) {
        double distance = Math.sqrt(Math.pow(x - ball.getCenterX(), 2) + Math.pow(y - ball.getCenterY(), 2));
        return distance <= ball.getRadius();
    }

    // Handle mouse pressed event to check if a ball was clicked
    private void handleMousePressed(MouseEvent event) {
        for (Ball ball : balls) {
            if (isPointWithinBall(ball, event.getX(), event.getY())) {
                setRandomAttributes(ball); // Randomize the ball properties if clicked
            }
        }
    }
}
