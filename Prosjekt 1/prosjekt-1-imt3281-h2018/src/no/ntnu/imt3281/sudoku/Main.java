package no.ntnu.imt3281.sudoku;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	

	@Override
	public void start(Stage stage) throws IOException {
		ResourceBundle messages = ResourceBundle.getBundle("I18N.messages");
		Parent root = FXMLLoader.load(getClass().getResource("sudoku.fxml"), messages);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Beste sudoku");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
