import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ThirdDice extends Dice {
    private static final double W = 200;
    private static final double H = 200;

    public void start(Stage stage) {
        DiceCanvas diceCanvas = new DiceCanvas(W, H);
        diceCanvas.setOnMouseClicked(e -> diceCanvas.display(roll()));

        diceCanvas.setOnMouseEntered(e -> diceCanvas.writeLineAround());
        diceCanvas.setOnMouseExited(e -> diceCanvas.removeLineAround());

        Pane root = new Pane(diceCanvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Dice 3");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
