import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class Ball extends Circle {
    private double dx, dy;
    private double speed;

    public Ball() {
        // Initial size of the ball
        setRadius(15);
        setFill(Color.BLUE);
    }

    // Set the speed of the ball
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    // Set the direction of the ball
    public void setDirection(double dx, double dy) {
        this.dx = dx * speed;
        this.dy = dy * speed;
    }

    // Move the ball
    public void move(double width, double height) {
        // Bounce off the walls by reversing direction if the ball hits a wall
        if (getCenterX() + dx < 0 || getCenterX() + dx > width) {
            dx = -dx;
        }
        if (getCenterY() + dy < 0 || getCenterY() + dy > height) {
            dy = -dy;
        }

        // Move the ball
        setCenterX(getCenterX() + dx);
        setCenterY(getCenterY() + dy);
    }

    // Set the ball's color
    public void setColor(Color color) {
        setFill(color);
    }
}
