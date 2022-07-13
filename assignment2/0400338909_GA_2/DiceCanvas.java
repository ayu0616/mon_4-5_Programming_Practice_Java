import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DiceCanvas extends Canvas {
    double W;
    double H;
    double dotRadius;
    GraphicsContext gc;
    private static final double LINE_WIDTH = 2;
    int diceValue;
    boolean isMouseOvered;

    public DiceCanvas(double width, double height) {
        super(width, height);
        this.W = width;
        this.H = height;
        setDotRadius();
        this.gc = this.getGraphicsContext2D();
        gc.setLineWidth(LINE_WIDTH);
        display(1);
    }

    public void display(int diceValue) {
        this.diceValue = diceValue;
        gc.clearRect(W / 8 - dotRadius, H / 8 - dotRadius, W * 6 / 8 + 2 * dotRadius,
                H * 6 / 8 + 2 * dotRadius);
        gc.setFill(Color.BLACK);
        switch (diceValue) {
            case 1:
                displayOne();
                break;
            case 2:
                displayTwo();
                break;
            case 3:
                displayThree();
                break;
            case 4:
                displayFour();
                break;
            case 5:
                displayFive();
                break;
            case 6:
                displaySix();
                break;
        }
    }

    private void drawDot(double centerX, double centerY) {
        gc.fillOval(centerX - dotRadius, centerY - dotRadius, dotRadius * 2, dotRadius * 2);
    }

    private void displayOne() {
        drawDot(W / 2, H / 2);
    }

    private void displayTwo() {
        drawDot(W / 8, H / 8);
        drawDot(W - W / 8, H - H / 8);
    }

    private void displayThree() {
        displayOne();
        displayTwo();
    }

    private void displayFour() {
        displayTwo();
        drawDot(W / 8, H - H / 8);
        drawDot(W - W / 8, H / 8);
    }

    private void displayFive() {
        displayOne();
        displayFour();
    }

    private void displaySix() {
        displayFour();
        drawDot(W / 8, H / 2);
        drawDot(W - W / 8, H / 2);
    }

    public void writeLineAround() {
        this.isMouseOvered = true;
        gc.setStroke(Color.BLACK);
        gc.strokeRect(0, 0, W, H);
    }

    public void removeLineAround() {
        this.isMouseOvered = false;
        gc.setStroke(Color.WHITE);
        gc.strokeRect(0, 0, W, H);
    }

    public void redraw() {
        this.W = this.getWidth();
        this.H = this.getHeight();
        setDotRadius();
        gc.clearRect(0, 0, W, H);
        if (isMouseOvered) {
            writeLineAround();
        }
        display(this.diceValue);
    }

    private void setDotRadius() {
        this.dotRadius = (W + H) / 2 / 32;
    }
}
