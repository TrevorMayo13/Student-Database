package main;

import main.Student;

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

public class main {
	public static void main(String[] args) {
		try {
			startProgram();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void startProgram() throws IOException {
		try {
			// create Gson instance
		    Gson gson = new Gson();

		    // create a reader
		    Reader reader = Files.newBufferedReader(Paths.get("test.json"));

		    Data data = gson.fromJson(reader,Data.class);

		    // print user object
		    System.out.println(data);

		    for (int i=0; i<10; i++) {
		    	String first = data.getResults()[i].getName().getFirst();
			    String last = data.getResults()[i].getName().getLast();
			    String title = data.getResults()[i].getName().getTitle();
			    System.out.println(title + " " + first + " " + last);
		    }
		    // close reader
		    reader.close();

		} catch (Exception ex) {
		    ex.printStackTrace();
		}

		// create JSON String from Object
//		String jsonEmp = gson.toJson(emp);
//		System.out.print(jsonEmp);
		//readIn();
	}
	
	public static void print(String n)
    {
        System.out.println("Student Name is " + n);
    }

	public static void readIn() throws IOException {
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
		System.out.println(content.toString());

		String jsonString = content.toString();
		/**/

		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();

		Gson gson = builder.create();
//		Student student = gson.fromJson(jsonString, Student.class);
//		System.out.println(student);
//		jsonString = gson.toJson(student);
//		System.out.println(jsonString);
		
		TypeToken<ArrayList<Student>> studentToken = new TypeToken<ArrayList<Student>>() {};
		Type studentType = studentToken.getType();
		ArrayList<Student> studentList = gson.fromJson(jsonString, studentType);
	}
}
