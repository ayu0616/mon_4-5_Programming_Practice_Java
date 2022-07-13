import javafx.application.Application;
import javafx.stage.Stage;

public abstract class Dice extends Application {
    public abstract void start(Stage stage);

    public int roll() {
        return (int) (Math.random() * 6 + 1);
    }
}
