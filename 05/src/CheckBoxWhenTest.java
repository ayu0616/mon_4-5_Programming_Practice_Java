import javafx.application.Application;
import javafx.beans.binding.When;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CheckBoxWhenTest extends Application {
    public void start(Stage stage) {
        Label labelSelection = new Label("No selection yet");
        Label labelTop = new Label("Selected");
        CheckBox checkBoxTop = new CheckBox();

        labelSelection.textProperty().bind(new When(checkBoxTop.selectedProperty()).then("Selected")
                .otherwise("Not Selected"));

        checkBoxTop.setSelected(true);
        GridPane root = new GridPane();
        root.getColumnConstraints().add(new ColumnConstraints(100));
        root.getColumnConstraints().add(new ColumnConstraints(300));
        root.add(labelSelection, 0, 0, 2, 1);
        root.add(checkBoxTop, 0, 1);
        root.add(labelTop, 1, 1);
        root.setStyle("-fx-font-size: 32pt");
        Scene scene = new Scene(root);
        stage.setTitle("CheckBox Test");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
