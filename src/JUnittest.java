import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import comparator.SortGrade;
import comparator.SortName;
import test.School;
import test.Student;

class JUnittest{

	@Test
	void testnamesort() {
	ArrayList<Student> students = new ArrayList<Student>();
	students.add(new Student("abc",98));
	students.add(new Student("efg",45.0));
	students.add(new Student("xyv",32.9));
	students.add(new Student("mno",21.1));
	ArrayList<Student> expected = new ArrayList<Student>();
	expected.add(new Student("abc",98));
	expected.add(new Student("efg",45.0));
	expected.add(new Student("mno",21.1));
	expected.add(new Student("xyv",32.9));
	Collections.sort(students, new SortName());
	assertEquals(expected,students);
	}
	
	@Test
	void testgradesort() {
	ArrayList<Student> students = new ArrayList<Student>();
	students.add(new Student("abc",98));
	students.add(new Student("efg",4.0));
	students.add(new Student("xyv",62.9));
	students.add(new Student("mno",91.1));
	ArrayList<Student> expected = new ArrayList<Student>();
	expected.add(new Student("abc",98));
	expected.add(new Student("mno",91.1));
	expected.add(new Student("xyv",62.9));
	expected.add(new Student("efg",4.0));
	Collections.sort(students, new SortGrade());
	assertEquals(expected,students);
	}
	
	@Test
	void readCSVfile() throws IOException {
	ArrayList<Student> expectedrecords = new ArrayList<Student>();
	expectedrecords.add(new Student("gary",72.6));
	expectedrecords.add(new Student("craig",51.7));
	expectedrecords.add(new Student("brenda",94.3));
	expectedrecords.add(new Student("william",11.0));
	School.ReadFileCSV();
	assertEquals(expectedrecords,School.students);
	}
	
	@Test
	void readJSONfile() throws IOException, ParseException {
	ArrayList<Student> expectedrecords = new ArrayList<Student>();
	expectedrecords.add(new Student("brian",70.5));
	expectedrecords.add(new Student("hannah",86.7));
	expectedrecords.add(new Student("alice",91.1));
	expectedrecords.add(new Student("cathy",11.0));
	School.ReadFileJSON();
	assertEquals(expectedrecords,School.students);
	}

}
