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

		Button createButton = new Button("Create Student");
		GridPane.setConstraints(createButton, 3, 5);
		createButton.setOnAction(e -> {
			if (isValidFormat("MM/dd/yyyy", dobInput.getText(), Locale.ENGLISH)) {
				System.out.println("true");
				createStudent();
			}
			else
				System.out.println("Invalid Date Format");
		});

		grid.getChildren().addAll(backButton, createButton, firstNameLabel, lastNameLabel, streetLabel, cityLabel,
				stateLabel, countryLabel, postCodeLabel, dobLabel, genderLabel, firstNameInput, lastNameInput,
				streetInput, cityInput, stateInput, countryInput, postCodeInput, dobInput, genderInput);

//		BorderPane borderPane = new BorderPane();
//		borderPane.setCenter(layout1);
//		borderPane.setTop(topBox);

		Scene newStudentScene = new Scene(grid, 300, 200);
		window.setScene(newStudentScene);
	}
	
	public static boolean isValidFormat(String format, String value, Locale locale) {
	    LocalDateTime ldt = null;
	    DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(format, locale);

	    try {
	        ldt = LocalDateTime.parse(value, fomatter);
	        String result = ldt.format(fomatter);
	        return result.equals(value);
	    } catch (DateTimeParseException e) {
	        try {
	            LocalDate ld = LocalDate.parse(value, fomatter);
	            String result = ld.format(fomatter);
	            return result.equals(value);
	        } catch (DateTimeParseException exp) {
	            try {
	                LocalTime lt = LocalTime.parse(value, fomatter);
	                String result = lt.format(fomatter);
	                return result.equals(value);
	            } catch (DateTimeParseException e2) {
	                // Debugging purposes
	                //e2.printStackTrace();
	            }
	        }
	    }

	    return false;
	}

	private static void createStudent() {
		//Split dob to myear month day
		String[] dobArray = dobInput.getText().split("/");
		String age = getAge(Integer.parseInt(dobArray[2]),Integer.parseInt(dobArray[1]), Integer.parseInt(dobArray[0]));
		newStudent = new Student(firstNameInput.getText(), lastNameInput.getText(), streetInput.getText(), cityInput.getText(), stateInput.getText(), countryInput.getText(), postCodeInput.getText(),
				dobInput.getText(), Long.valueOf(age), genderInput.getText());
		main.addStudent(newStudent);
		main.printList();
	}
	private static String getAge(int year, int month, int day){
	    Calendar dob = Calendar.getInstance();
	    Calendar today = Calendar.getInstance();

	    dob.set(year, month, day); 

	    int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

	    if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
	        age--; 
	    }

	    Integer ageInt = (Integer) age;
	    String ageS = ageInt.toString();

	    return ageS;  
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
		dobInput.setPromptText("ex. 08/12/1954");
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
