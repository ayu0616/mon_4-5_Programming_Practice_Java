import javafx.scene.control.Button;

public class RollButton extends Button {
    public RollButton(int fontSize) {
        super("Roll");
        this.setStyle("-fx-font-size: " + fontSize);
    }
}
