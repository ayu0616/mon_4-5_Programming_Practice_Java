import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SliderTest extends Application {
    public void start(Stage stage) {
        Label labelSliderTop = new Label("Top Slider");
        Slider sliderTop = new Slider(-5.0, 5.0, 0.0);
        sliderTop.valueProperty().addListener(e -> {
            labelSliderTop
                    .setText(String.format("Top slider value is %1.2f", sliderTop.getValue()));
        });

        Label labelSliderBottom = new Label("Bottom Slider");
        Slider sliderBottom = new Slider(-5.0, 5.0, 0.0);
        sliderBottom.valueProperty().addListener(e -> {
            labelSliderBottom
                    .setText(String.format("Top slider value is %1.2f", sliderBottom.getValue()));
        });

        sliderBottom.valueProperty().addListener((obj, oldVal, newVal) -> {
            labelSliderBottom
                    .setText(String.format("Top slider value is %1.2f", sliderBottom.getValue()));
        });

        sliderBottom.setShowTickMarks(true);
        sliderBottom.setShowTickLabels(true);
        sliderBottom.setMajorTickUnit(1.0f);
        sliderBottom.setBlockIncrement(0.1f);

        GridPane root = new GridPane();
        root.getColumnConstraints().add(new ColumnConstraints(600));

        root.add(labelSliderTop, 0, 0);
        root.add(labelSliderBottom, 0, 1);

        root.add(sliderTop, 0, 2);
        root.add(sliderBottom, 0, 3);

        root.setStyle("-fx-font-size: 32pt");

        Scene scene = new Scene(root);
        stage.setTitle("Slider Test");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
