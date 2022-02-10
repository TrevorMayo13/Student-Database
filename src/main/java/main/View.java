package main;

import javafx.event.*;
import javafx.geometry.Insets;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class View extends Application {

	Button searchButton, newStudentButton, homeButton, newhomeButton, confirmButton, closeButton, randomStudentsButton;
	static Stage window;
	static Scene homeScene;
	Scene newStudentScene;
	Scene searchScene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Student Database");

		Label label1 = new Label("Would you like to create or search for Students?");
		Label label2 = new Label("Would you like to close program?");
		searchButton = new Button("Search for Student");
		searchButton.setOnAction(e -> {
			SearchStudentPage.display();
		});
		newStudentButton = new Button("Create New Student");
		newStudentButton.setOnAction(e -> {
			CreateStudentPage.display();
		});
		window.setOnCloseRequest(e -> {
			// take over event handler
			e.consume();
			main.closeList();
			closeProgram();
		});
		randomStudentsButton = new Button("Generate Random Students");
		randomStudentsButton.setOnAction(e -> {
			try {
				main.generateRandomStudents();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		// Home screen
		VBox layout1 = new VBox();
		layout1.getChildren().addAll(label1, searchButton, newStudentButton);

		HBox topBox = new HBox();
		topBox.getChildren().addAll(randomStudentsButton);

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(layout1);
		borderPane.setTop(topBox);

//		homeScene = new Scene(grid, 300, 200);
		homeScene = new Scene(borderPane, 300, 200);


		window.setScene(homeScene);
		window.show();

	}

	public static void closeProgram() {
		System.out.println("Save program");
		boolean answer = ConfirmBox.display("Title", "Are you sure you want to exit");
		if (answer)
			window.close();
	}

	public static void setHome() {
		window.setScene(homeScene);
	}

	public static Stage getPrimaryStage() {
		return window;
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
