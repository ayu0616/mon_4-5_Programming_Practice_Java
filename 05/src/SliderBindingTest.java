import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class SliderBindingTest extends Application {
    public void start(Stage stage) {
        Label labelSliderTop = new Label("Top slider");
        Slider sliderTop = new Slider(-5.0, 5.0, 0.0);
        labelSliderTop.textProperty()
                .bind(sliderTop.valueProperty().asString("Top slider value is %1.2f"));

        Label labelSliderBottom = new Label("Bottom slider");
        Slider sliderBottom = new Slider(-5.0, 5.0, 0.0);
        labelSliderBottom.textProperty()
                .bind(sliderBottom.valueProperty().asString("Bottom slider value is %1.2f"));

        GridPane root = new GridPane();
        root.getColumnConstraints().add(new ColumnConstraints(600));
        root.getRowConstraints().add(new RowConstraints(50));
        root.getRowConstraints().add(new RowConstraints(100));
        root.getRowConstraints().add(new RowConstraints(50));
        root.getRowConstraints().add(new RowConstraints(100));
        root.add(labelSliderTop, 0, 0);
        root.add(sliderTop, 0, 1);
        root.add(labelSliderBottom, 0, 2);
        root.add(sliderBottom, 0, 3);
        root.setStyle("-fx-font-size: 32pt");

        Scene scene = new Scene(root);
        stage.setTitle("Binding Test");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
