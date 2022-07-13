import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;;

public class FirstDice extends Dice {
    public void start(Stage stage) {
        int labelWidth = 150;
        int labelHeight = 100;
        int fontSize = 32;
        String initialDiceValue = "1";

        Label numberLabel = new Label(initialDiceValue);
        numberLabel.setPrefSize(labelWidth, labelHeight);
        numberLabel.setStyle(
                "-fx-alignment: center; -fx-text-alignment: center; -fx-font-size: " + fontSize);
        numberLabel.minWidthProperty().bind(stage.widthProperty());

        RollButton rollButton = new RollButton(fontSize);
        rollButton.maxWidthProperty().bind(numberLabel.widthProperty());
        rollButton.setOnAction(e -> numberLabel.setText(rollString()));

        BorderPane root = new BorderPane();
        root.setTop(numberLabel);
        root.setBottom(rollButton);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Dice 1");
        stage.show();
    }

    public String rollString() {
        return String.valueOf(roll());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
