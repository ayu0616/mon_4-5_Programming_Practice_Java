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

public class DiskMoveHorizon extends Application {
    int count = 0;

    public void DrawOnCanvas(GraphicsContext gc, int width, int height) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, width, height);
        double centerX = count * 20;
        double centerY = height - 100;
        gc.setFill(Color.RED);
        gc.setStroke(Color.GREEN);
        gc.fillOval(centerX, centerY, 50, 50);
        gc.strokeOval(centerX, centerY, 50, 50);
        count++;
    }

    public void start(Stage stage) {
        int width = 800, height = 600;
        Canvas canvas = new Canvas(width, height);

        Button drawButton = new Button("Draw");
        drawButton.setFont(new Font(32));
        drawButton.setOnAction(e -> DrawOnCanvas(canvas.getGraphicsContext2D(), width, height));

        Button quitButton = new Button("Quit");
        quitButton.setFont(new Font(32));
        quitButton.setOnAction(e -> javafx.application.Platform.exit());

        HBox buttonBox = new HBox(50, drawButton, quitButton);

        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setBottom(buttonBox);
        buttonBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root);
        stage.setTitle("Drawing Test");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
