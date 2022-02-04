package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;
import java.lang.reflect.Type;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class main extends Application {
	private static String[] args;

	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
//            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException, ParseException {
		readIn();
		launch(args);
	};

	public static void startProgram() throws IOException {

	}

	public static void print(String n) {
		System.out.println("Student Name is " + n);
	}

	public static void readIn() throws IOException, ParseException {
		URL url = new URL("https://randomuser.me/api/?results=10&nat=us");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		int status = con.getResponseCode();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();

		con.disconnect();
//		System.out.println(content.toString());

		String jsonString = content.toString();
		/**/

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);

		// get an array from the JSON object
		JSONArray results = (JSONArray) jsonObject.get("results");

		Iterator i = results.iterator();
		while (i.hasNext()) {

			JSONObject info = (JSONObject) i.next();
			System.out.println(info);

			JSONObject nameObject = (JSONObject) info.get("name");
			String firstName = (String) nameObject.get("first");
			String lastName = (String) nameObject.get("last");

//            JSONObject locationObject = (JSONObject) info.get("location");
//
//            JSONObject streetObject = (JSONObject) locationObject.get("street");
////            String address = (String) streetObject.get("number") + " " + (String) streetObject.get("name");
//            String city = (String) locationObject.get("city");
//            String state = (String) locationObject.get("state");
//            String country = (String) locationObject.get("country");
//            String postCode = (String) locationObject.get("postcode");

//            Student x = new Student(firstName, lastName, );

			System.out.println(firstName);

		}
	}
}