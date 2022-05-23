import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ResizeCanvas extends Application {
    private void redraw(GraphicsContext gc) {
        double w = gc.getCanvas().getWidth();
        double h = gc.getCanvas().getHeight();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, w, h);
        gc.setFill(Color.WHITE);
        gc.fillOval(w / 2.0 - w / 16.0, h / 2.0 - h / 16.0, w / 8.0, h / 8.0);
    }

    public void start(Stage stage) {
        Canvas canvas = new Canvas(200, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Pane root = new Pane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Resize Canvas");
        stage.setScene(scene);
        stage.show();

        canvas.widthProperty().bind(root.widthProperty());
        canvas.heightProperty().bind(root.heightProperty());
        canvas.widthProperty().addListener(e -> redraw(gc));
        redraw(gc);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
