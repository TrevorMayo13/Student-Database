package main;

import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Locale;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StudentPage extends View {
	static Stage window;
	static Label firstNameLabel, lastNameLabel, streetLabel, cityLabel, stateLabel, countryLabel, postCodeLabel,
			dobLabel, genderLabel, empty;
	static TextField firstNameInput, lastNameInput, streetInput, cityInput, stateInput, countryInput, postCodeInput,
			dobInput, genderInput;
	static Pane spring;
	static Button createButton;
	static Student newStudent;

	public static void display(Student student) {
		newStudent = student;
		window = View.getPrimaryStage();
		GridPane grid = new GridPane();
		// Overall padding from edge of scene
		grid.setPadding(new Insets(10, 10, 10, 10));
		// Cell padding
		grid.setVgap(8);
		grid.setHgap(10);
		initLabels();
//		passInput.setPromptText("password");
		
		Button backButton = new Button("Go back");
		backButton.setOnAction(e -> {
			window.setScene(SearchStudentPage.getScene());
		});
		GridPane.setConstraints(backButton, 0, 9);

		grid.getChildren().addAll(backButton, firstNameLabel, lastNameLabel, streetLabel, cityLabel,
				stateLabel, countryLabel, postCodeLabel, dobLabel, genderLabel);
		
		

//		BorderPane borderPane = new BorderPane();
//		borderPane.setCenter(layout1);
//		borderPane.setTop(topBox);

		Scene newStudentScene = new Scene(grid, 300, 200);
		window.setScene(newStudentScene);
	}

	static void initLabels() {
		firstNameLabel = new Label("First Name: " + newStudent.getFirstName());
		lastNameLabel = new Label("Last Name: " + newStudent.getLastName());
		dobLabel = new Label("Date of Birth: " + newStudent.getDob());
		genderLabel = new Label("Gender: " + newStudent.getGender());
		streetLabel = new Label("Street: " + newStudent.getStreet());
		cityLabel = new Label("City: " + newStudent.getCity());
		stateLabel = new Label("State: " + newStudent.getState());
		countryLabel = new Label("Country: " + newStudent.getCountry());
		postCodeLabel = new Label("Zip Code: " + newStudent.getPostCode());
		GridPane.setConstraints(firstNameLabel, 0, 0);
		GridPane.setConstraints(lastNameLabel, 0, 1);
		GridPane.setConstraints(streetLabel, 0, 4);
		GridPane.setConstraints(cityLabel, 0, 5);
		GridPane.setConstraints(stateLabel, 0, 6);
		GridPane.setConstraints(countryLabel, 0, 7);
		GridPane.setConstraints(postCodeLabel, 0, 8);
		GridPane.setConstraints(dobLabel, 0, 2);
		GridPane.setConstraints(genderLabel, 0, 3);
	}
}
