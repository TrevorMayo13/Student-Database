package main;

import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

	public static void display() {
		window = View.getPrimaryStage();
		GridPane grid = new GridPane();
		// Overall padding from edge of scene
		grid.setPadding(new Insets(10, 10, 10, 10));
		// Cell padding
		grid.setVgap(8);
		grid.setHgap(10);
		initLabels();
		initInputs();
//		passInput.setPromptText("password");

		Button backButton = new Button("Back Home");
		GridPane.setConstraints(backButton, 2, 5);
		backButton.setOnAction(e -> View.setHome());

		grid.getChildren().addAll(backButton, firstNameLabel, lastNameLabel, streetLabel, cityLabel, stateLabel, countryLabel,
				postCodeLabel, dobLabel, genderLabel, firstNameInput, lastNameInput, streetInput, cityInput, stateInput,
				countryInput, postCodeInput, dobInput, genderInput);

//		BorderPane borderPane = new BorderPane();
//		borderPane.setCenter(layout1);
//		borderPane.setTop(topBox);

		Scene newStudentScene = new Scene(grid, 300, 200);
		window.setScene(newStudentScene);
	}

	static void initLabels() {
		firstNameLabel = new Label("First Name: ");
		lastNameLabel = new Label("Last Name: ");
		dobLabel = new Label("Date of Birth: ");
		genderLabel = new Label("Gender: ");
		streetLabel = new Label("Adress: ");
		cityLabel = new Label("City: ");
		stateLabel = new Label("State: ");
		countryLabel = new Label("Country: ");
		postCodeLabel = new Label("Zip Code: ");
		GridPane.setConstraints(firstNameLabel, 0, 0);
		GridPane.setConstraints(lastNameLabel, 0, 1);
		GridPane.setConstraints(streetLabel, 3, 0);
		GridPane.setConstraints(cityLabel, 3, 1);
		GridPane.setConstraints(stateLabel, 3, 2);
		GridPane.setConstraints(countryLabel, 3, 3);
		GridPane.setConstraints(postCodeLabel, 3, 4);
		GridPane.setConstraints(dobLabel, 0, 2);
		GridPane.setConstraints(genderLabel, 0, 3);
	}

	static void initInputs() {
		firstNameInput = new TextField();
		lastNameInput = new TextField();
		streetInput = new TextField();
		cityInput = new TextField();
		stateInput = new TextField();
		countryInput = new TextField();
		postCodeInput = new TextField();
		dobInput = new TextField();
		genderInput = new TextField();
		GridPane.setConstraints(firstNameInput, 1, 0);
		GridPane.setConstraints(lastNameInput, 1, 1);
		GridPane.setConstraints(streetInput, 4, 0);
		GridPane.setConstraints(cityInput, 4, 1);
		GridPane.setConstraints(stateInput, 4, 2);
		GridPane.setConstraints(countryInput, 4, 3);
		GridPane.setConstraints(postCodeInput, 4, 4);
		GridPane.setConstraints(dobInput, 1, 2);
		GridPane.setConstraints(genderInput, 1, 3);
	}
}
