import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColoredGUI extends Application {
    public int[] get_color_info() throws FileNotFoundException {
        String filePath = "./color_info.txt";
        Scanner scanner = new Scanner(new File(filePath));
        String line = scanner.nextLine();
        String[] values = line.split("\\s+");
        int[] color_info = new int[3];
        for (int i = 0; i < values.length; i++) {
            color_info[i] = Integer.valueOf(values[i]);
        }
        return color_info;
    }

    public void start(Stage stage) throws FileNotFoundException {
        int width = 800, height = 600;
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int[] color_info = get_color_info();
        gc.setFill(Color.rgb(color_info[0], color_info[1], color_info[2]));
        gc.fillRect(0, 0, width, height);

        GridPane root = new GridPane();
        root.add(canvas, 0, 0);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Test Display");
        stage.show();
    }

    public static void main(String[] args) throws FileNotFoundException {
        launch(args);
    }
}
