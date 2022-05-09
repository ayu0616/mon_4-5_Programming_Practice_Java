import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloFXButton extends Application {
    public void start(Stage stage) {
        Font fontBig = new Font(32);
        Label helloLabel = new Label("Hello World!");
        helloLabel.setFont(fontBig);
        Button goodbyeButton = new Button("click");
        GoodbyeButtonHandler goodbyeButtonHandler =
                new GoodbyeButtonHandler(helloLabel, "Goodbye World!");
        goodbyeButton.setOnAction(goodbyeButtonHandler);
        goodbyeButton.setFont(fontBig);
        BorderPane root = new BorderPane();
        root.setTop(helloLabel);
        root.setBottom(goodbyeButton);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
