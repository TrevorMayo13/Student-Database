package main;

import javafx.event.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class View extends Application {

	Button searchButton, newStudentButton, homeButton, newhomeButton;
	Stage window;
	Scene homeScene, newStudentScene, searchScene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Student Database");

		Label label1 = new Label("Would you like to create or search for Students?");
		searchButton = new Button("Search for Student");
		searchButton.setOnAction(e -> {
			window.setScene(searchScene);
		});
		newStudentButton = new Button("Create New Student");
		newStudentButton.setOnAction(e -> {
			window.setScene(newStudentScene);
		});
		homeButton = new Button("Return to home page");
		homeButton.setOnAction(e -> {
			window.setScene(homeScene);
		});
		newhomeButton = new Button("Return to home page");
		newhomeButton.setOnAction(e -> {
			window.setScene(homeScene);
		});

		// Home screen
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, searchButton, newStudentButton);
		homeScene = new Scene(layout1, 200, 200);

		// Search screen
		StackPane layoutSearch = new StackPane();
		layoutSearch.getChildren().add(newhomeButton);
		searchScene = new Scene(layoutSearch, 200, 200);

		// New Student screen
		StackPane layoutNewStudent = new StackPane();
		layoutNewStudent.getChildren().add(homeButton);
		newStudentScene = new Scene(layoutNewStudent, 200, 200);


		primaryStage.setScene(homeScene);
		primaryStage.show();

	}

//	@Override
//	public void handle(ActionEvent event) {
//		if (event.getSource() == searchButton) {
//			System.out.println("search Button pressed");
//		}
//		if (event.getSource() == newStudentButton) {
//			System.out.println("new student");
//		}
//	}

	public View() {

	}
}
