package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class View extends Application {
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("My First JavaFX App");

			Label label = new Label("Hello World, JavaFX !");
			Scene scene = new Scene(label, 400, 200);
			primaryStage.setScene(scene);

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public View() {

	}
}
