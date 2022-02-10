package main;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SearchStudentPage extends View {

	private static TableView<Student> table = new TableView<Student>();
	private static ObservableList<Student> data = FXCollections.observableList(main.getStudentList());
	static Scene scene2;

	public static void display() {
		Scene scene = new Scene(new Group());
		window = View.getPrimaryStage();
		window.setTitle("Table View Sample");
		window.setWidth(450);
		window.setHeight(550);

		final Label label = new Label("Address Book");
		label.setFont(new Font("Arial", 20));

		table.setEditable(true);

		TableColumn firstNameCol = new TableColumn("First Name");
		firstNameCol.setMinWidth(100);
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));

		TableColumn lastNameCol = new TableColumn("Last Name");
		lastNameCol.setMinWidth(100);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));

//		TableColumn emailCol = new TableColumn("Email");
//		emailCol.setMinWidth(200);
//		emailCol.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));

		FilteredList<Student> flPerson = new FilteredList(data, p -> true);// Pass the data to a filtered list
		table.setItems(flPerson);// Set the table's items using the filtered list
		table.getColumns().addAll(firstNameCol, lastNameCol);

		table.setOnMousePressed(e -> {
			if (e.isPrimaryButtonDown() && e.getClickCount() == 2) {
				System.out.println(table.getSelectionModel().getSelectedItem());
				StudentPage.display(table.getSelectionModel().getSelectedItem());
			}
		});

		// Adding ChoiceBox and TextField here!
		ChoiceBox<String> choiceBox = new ChoiceBox();
		choiceBox.getItems().addAll("First Name", "Last Name", "Email");
		choiceBox.setValue("First Name");

		TextField textField = new TextField();
		textField.setPromptText("Search here!");
		textField.textProperty().addListener((obs, oldValue, newValue) -> {
			switch (choiceBox.getValue())// Switch on choiceBox value
			{
			case "First Name":
				flPerson.setPredicate(p -> p.getFirstName().toLowerCase().contains(newValue.toLowerCase().trim()));// filter
																													// table
																													// by
																													// first
																													// name
				break;
			case "Last Name":
				flPerson.setPredicate(p -> p.getLastName().toLowerCase().contains(newValue.toLowerCase().trim()));// filter
																													// table
																													// by
																													// last
																													// name
				break;
//			case "Email":
//				flPerson.setPredicate(p -> p.getEmail().toLowerCase().contains(newValue.toLowerCase().trim()));// filter
//																												// table
//																												// by
//																												// email
//				break;
			}
		});

		choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {// reset table and
																									// textfield when
																									// new choice is
																									// selected
			if (newVal != null) {
				textField.setText("");
			}
		});

		HBox hBox = new HBox(choiceBox, textField);// Add choiceBox and textField to hBox
		hBox.setAlignment(Pos.CENTER);// Center HBox
		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table, hBox);

		((Group) scene.getRoot()).getChildren().addAll(vbox);

		window.setScene(scene);
		setScene(scene);
		window.show();
		
	}
	
	public static void setScene(Scene tempScene) {
		scene2 = tempScene;
	}
	
	public static Scene getScene() {
		return scene2;
	}

	public void clickItem(MouseEvent event) {
		if (event.getClickCount() == 2) // Checking double click
		{
			System.out.println("hi");
		}
	}

}