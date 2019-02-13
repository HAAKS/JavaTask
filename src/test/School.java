package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import comparator.SortGrade;
import comparator.SortName;

public class School {
	public static ArrayList<Student> students;


	public static void main(String[]args) throws IOException, ParseException {
//		ReadFileCSV();
		ReadFileJSON();
//		WriteCSVFileName();
//		WriteCSVFileGrade();
		WriteJSONFileName();
		WriteJSONFileGrade();
	}

	//sorts the arraylist by grade then writes the output to json file
	public static void WriteJSONFileGrade() throws IOException {
		sortbygrade();
		String jsonpath="src/students-grade.json";
		FileWriter file = new FileWriter(jsonpath);
		//using gson library
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String str =gson.toJson(students);
		file.write(str);
		file.flush();
		file.close();
		System.out.println("Successfully Copied Student Grades to CSV File");
		}
		
	//sorts the arraylist by name then writes the output to json file
	public static void WriteJSONFileName() throws JsonIOException, IOException {
		sortbyname();
		String jsonpath="src/students-name.json";
		FileWriter file = new FileWriter(jsonpath);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String str =gson.toJson(students);
		file.write(str);
		file.flush();
		file.close();
		System.out.println("Successfully Copied Student Names to JSON File");

	}

	//sorts the arraylist by grade then writes the output to csv file
	public static void WriteCSVFileGrade() throws IOException {
		sortbygrade();
		String csvpath="src/students-grade.csv";
		BufferedWriter br = new BufferedWriter(new FileWriter(csvpath));
		StringBuilder sb = new StringBuilder();
		// appending the string together
		sb.append("name,grade");
		sb.append('\n'); //place a new line
		for (Student element : students) {
		 sb.append(element.getName());
		 sb.append(",");
		 sb.append(element.getGrade());
		 sb.append('\n');
		}
		br.write(sb.toString());
		br.close();
		System.out.println("Successfully Copied Student Grades to CSV File");
	}

	//sorts the arraylist by name then writes the output to csv file
	public static void WriteCSVFileName() throws IOException {
		sortbyname();
		String csvpath="src/students-name.csv";
		BufferedWriter br = new BufferedWriter(new FileWriter(csvpath));
		StringBuilder sb = new StringBuilder();
		sb.append("name,grade");
		sb.append('\n');
		// Append strings from array
		for (Student element : students) {
		 sb.append(element.getName());
		 sb.append(",");
		 sb.append(element.getGrade());
		 sb.append('\n');
		}

		br.write(sb.toString());
		br.close(); //bufferedwriter is closed
		System.out.println("Successfully Copied Student Names to CSV File");
	}

	//utilizes the use of collections to use the .sort method
	public static void sortbyname() {
		Collections.sort(students, new SortName());
	}

	public static void sortbygrade() {
		Collections.sort(students, new SortGrade());
	}

	//Reading JSON file using JSONParser
	 public static void ReadFileJSON() throws IOException, ParseException {
		String jsonpath="src/students.json";
		students = new ArrayList<Student>();
        JSONParser parser = new JSONParser();
        JSONArray jsonarr = (JSONArray) parser.parse(new FileReader(
                jsonpath));
        for(Object o:jsonarr) {
          JSONObject jsonLineItem = (JSONObject) o;
          Double grade = (Double) jsonLineItem.get("grade");
          String name = (String) jsonLineItem.get("name");
  	      students.add(new Student(name,grade));
        }
	}

	//Reading csv file using BufferedReader
	 public static void ReadFileCSV() throws IOException {
		String csvpath="src/students.csv";
	    String line = "";
	    students = new ArrayList<Student>();
	    BufferedReader br = new BufferedReader(new FileReader(csvpath));
	    br.readLine();// put try and catch
	    while ((line = br.readLine()) != null) {
	    String[] studentdata = line.split(",");
	    double grade = Double.parseDouble(studentdata[1]);
	    students.add(new Student(studentdata[0],grade));
	}
	    br.close();
	}
}
