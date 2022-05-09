import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SceneGraphExample2 extends Application {
    public void start(Stage stage) {
        Font fontBig = new Font(32);

        Label topLabel = new Label("top");
        Label bottomCenterLabel = new Label("center");
        Label bottomLeftLabel = new Label("left");
        Label bottomRightLabel = new Label("right");
        topLabel.setFont(fontBig);
        bottomCenterLabel.setFont(fontBig);
        bottomLeftLabel.setFont(fontBig);
        bottomRightLabel.setFont(fontBig);

        HBox topBox = new HBox(topLabel);
        HBox bottomBox = new HBox(50, bottomLeftLabel, bottomCenterLabel, bottomRightLabel);

        GridPane root = new GridPane();
        root.add(topBox, 0, 0);
        root.add(bottomBox, 0, 1);
        topBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
