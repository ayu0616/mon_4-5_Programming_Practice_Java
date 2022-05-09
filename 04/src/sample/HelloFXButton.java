package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloFXButton extends Application {

	@Override
	public void start(Stage stage) {
		Font fontBig = new Font(32);
		Label helloLabel = new Label("Hello World!");
		helloLabel.setFont(fontBig);
		Button goodbyeButton = new Button("click");
		goodbyeButton.setFont(fontBig);
		goodbyeButton.setOnAction(e -> helloLabel.setText("Goodbye World!"));

		goodbyeButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
				e -> goodbyeButton.setEffect(new DropShadow()));
		goodbyeButton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> goodbyeButton.setEffect(null));

		/*
		 * EventHandler<ActionEvent> bh = new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent event) { helloLabel.setText("Goodbye World!"); }
		 * }; goodbyeButton.setOnAction(bh);
		 */

		/*
		 * goodbyeButton.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent event) { helloLabel.setText("Goodbye World!"); }
		 * }); GoodbyeButtonHandler goodbyeButtonHandler = new GoodbyeButtonHandler(helloLabel,
		 * "Goodbye World!"); goodbyeButton.setOnAction(goodbyeButtonHandler);
		 */

		BorderPane root = new BorderPane();
		root.setTop(helloLabel);
		root.setCenter(goodbyeButton);


		Scene scene = new Scene(root, 240, 120);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
