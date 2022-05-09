import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class GoodbyeButtonHandler implements EventHandler<ActionEvent> {
    Label label;
    String message;

    public GoodbyeButtonHandler(Label label, String message) {
        this.label = label;
        this.message = message;
    }

    public void handle(ActionEvent event) {
        label.setText(message);
    }
}
