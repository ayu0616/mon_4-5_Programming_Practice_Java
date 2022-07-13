import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SecondDice extends Dice {
    private static final double W = 200;
    private static final double H = 200;

    public void start(Stage stage) {
        int fontSize = 32;

        DiceCanvas diceCanvas = new DiceCanvas(W, H);

        RollButton rollButton = new RollButton(fontSize);
        rollButton.minWidthProperty().bind(diceCanvas.widthProperty());
        rollButton.setOnAction(e -> diceCanvas.display(roll()));

        BorderPane root = new BorderPane();
        root.setTop(diceCanvas);
        root.setBottom(rollButton);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Dice 2");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
