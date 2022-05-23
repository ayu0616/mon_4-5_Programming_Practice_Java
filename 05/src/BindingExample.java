import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class BindingExample extends Application {
    public void start(Stage stage) {
        Label label = new Label("No typing yet");
        TextField textField = new TextField("Type here");

        label.textProperty().bind(textField.textProperty());

        GridPane root = new GridPane();
        root.getColumnConstraints().add(new ColumnConstraints(600));
        root.getRowConstraints().add(new RowConstraints(100));
        root.getRowConstraints().add(new RowConstraints(100));
        root.add(label, 0, 0);
        root.add(textField, 0, 1);
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
