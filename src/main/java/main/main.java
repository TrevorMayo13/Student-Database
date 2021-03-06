package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;
import java.lang.reflect.Type;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import org.json.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class main extends View {
	private static ArrayList<Student> studentList;

	private static String[] args;

//	public void start(Stage primaryStage) {
//		try {
//			primaryStage.setTitle("My First JavaFX App");
//	        
//	        Label label = new Label("Hello World, JavaFX !");
//	        Scene scene = new Scene(label, 400, 200);
//	        primaryStage.setScene(scene);
//	        
//	        primaryStage.show();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public static void main(String[] args) throws IOException {
		readIn();
		View v = new View();
		v.launch(args);
	}

	public static void startProgram() throws IOException {

	}

	public static void print(String n) {
		System.out.println("Student Name is " + n);
	}

	public static void addStudent(Student student) {
		studentList.add(student);
	}

	public static void printList() {
		for (int j = 0; j < studentList.size(); j++) {
			System.out.println(studentList.get(j));
		}
	}
	
	public static ArrayList<Student> getStudentList(){
		return studentList;
	}

	public static void generateRandomStudents() throws IOException {
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

		JSONObject jsonObject = new JSONObject(jsonString);

		// get an array from the JSON object
		JSONArray results = (JSONArray) jsonObject.get("results");

		Iterator i = results.iterator();
		while (i.hasNext()) {

			JSONObject info = (JSONObject) i.next();

			JSONObject nameObject = (JSONObject) info.get("name");
			String firstName = (String) nameObject.get("first");
			String lastName = (String) nameObject.get("last");
			JSONObject locationObject = (JSONObject) info.get("location");
			JSONObject streetObject = (JSONObject) locationObject.get("street");

			StringBuilder sb = new StringBuilder();
			String tempName = String.valueOf(streetObject.get("number"));
			sb.append(tempName);
			sb.append(" ");
			sb.append((String) streetObject.get("name"));
			String street = sb.toString();

			String city = (String) locationObject.get("city");
			String state = (String) locationObject.get("state");
			String country = (String) locationObject.get("country");
			String postCode = String.valueOf(locationObject.get("postcode"));
			JSONObject dobObject = (JSONObject) info.get("dob");
			String dob = (String) dobObject.get("date");
			long age = Long.valueOf(dobObject.get("age").toString());
			String gender = (String) info.get("gender");

//            JSONObject locationObject = (JSONObject) info.get("location");
//
//            JSONObject streetObject = (JSONObject) locationObject.get("street");
////            String address = (String) streetObject.get("number") + " " + (String) streetObject.get("name");
//            String city = (String) locationObject.get("city");
//            String state = (String) locationObject.get("state");
//            String country = (String) locationObject.get("country");
//            String postCode = (String) locationObject.get("postcode");

//            Student x = new Student(firstName, lastName, );
			studentList.add(new Student(firstName, lastName, street, city, state, country, postCode, dob, age, gender));
		}
		printList();
	}
	
	public static void closeList() {
		//Saves student list to a json file
		GsonBuilder builder = new GsonBuilder(); 
		builder.setPrettyPrinting(); 
		Gson gson = builder.create();
		Student[] studentArray = new Student[studentList.size()];
		studentList.toArray(studentArray);
		String jsonString = gson.toJson(studentArray);
		System.out.println(jsonString);
		
		try {
	         FileWriter file = new FileWriter("C:/Users/trevo/eclipse-workspace/studentDatabase/test.json");
	         file.write(jsonString);
	         file.close();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	}

	public static void readIn() throws IOException {
		studentList = new ArrayList<Student>();
		BufferedReader in = new BufferedReader(new FileReader("C:/Users/trevo/eclipse-workspace/studentDatabase/test.json"));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
//		System.out.println(content.toString());

		String jsonString = content.toString();
		/**/

//		JSONObject jsonObject = new JSONObject(jsonString);
//		JSONArray jsonArray = new JSONArray(jsonString);

		// get an array from the JSON object
		JSONArray results = new JSONArray(jsonString);

		Iterator i = results.iterator();
		while (i.hasNext()) {

			JSONObject info = (JSONObject) i.next();
			String firstName = (String) info.get("firstName");
			String lastName = (String) info.get("lastName");
			String street = (String) info.get("street");
			String city = (String) info.get("city");
			String state = (String) info.get("state");
			String country = (String) info.get("country");
			String postCode = (String) info.get("postCode");
			String dob = (String) info.get("dob");
			long age = Long.valueOf(info.get("age").toString());
			String gender = (String) info.get("gender");

//            JSONObject locationObject = (JSONObject) info.get("location");
//
//            JSONObject streetObject = (JSONObject) locationObject.get("street");
////            String address = (String) streetObject.get("number") + " " + (String) streetObject.get("name");
//            String city = (String) locationObject.get("city");
//            String state = (String) locationObject.get("state");
//            String country = (String) locationObject.get("country");
//            String postCode = (String) locationObject.get("postcode");

//            Student x = new Student(firstName, lastName, );
			studentList.add(new Student(firstName, lastName, street, city, state, country, postCode, dob, age, gender));
		}
	}
}