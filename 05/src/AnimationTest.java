import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AnimationTest extends Application {
    private void drawFrame(GraphicsContext gc, int width, int height, int frameNumber) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, width, height);

        gc.setFill(Color.VIOLET);
        gc.setStroke(Color.WHITE);

        int centerX = frameNumber * 3 % width;
        int centerY = frameNumber * 7 % height;

        gc.fillOval(centerX - 25, centerY - 25, 50, 50);
        gc.strokeOval(centerX - 25, centerY - 25, 50, 50);

        gc.setFill(Color.RED);
        gc.setFont(new Font(16));
        gc.fillText("Frame " + frameNumber, 0, 20);
    }

    public void start(Stage stage) {
        int width = 800, height = 600;
        Canvas canvas = new Canvas(width, height);
        AnimationTimer anim = new AnimationTimer() {
            private int frameNumber;
            private long startTime = -1;
            private long previousTime;

            public void handle(long now) {
                if (startTime < 0) {
                    startTime = now;
                    previousTime = now;
                    drawFrame(canvas.getGraphicsContext2D(), width, height, 0);
                } else {
                    frameNumber++;
                    drawFrame(canvas.getGraphicsContext2D(), width, height, frameNumber);
                    previousTime = now;
                }
            }
        };

        Button startButton = new Button("Start");
        startButton.setFont(new Font(32));
        startButton.setOnAction(e -> anim.start());
        Button stopButton = new Button("Stop");
        stopButton.setFont(new Font(32));
        stopButton.setOnAction(e -> anim.stop());
        Button quitButton = new Button("Quit");
        quitButton.setFont(new Font(32));
        quitButton.setOnAction(e -> javafx.application.Platform.exit());

        HBox buttonHBox = new HBox(50, startButton, stopButton, quitButton);
        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setBottom(buttonHBox);
        buttonHBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);
        stage.setTitle(("Animation Test"));
        stage.setScene(scene);
        stage.focusedProperty().addListener((obj, oldVal, newVal) -> {
            if (newVal) {
                anim.start();
            } else {
                anim.stop();
            }
        });
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
