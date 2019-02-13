package comparator;

import java.util.Comparator;

import test.Student;

public class SortName implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return (o1.getName().compareTo(o2.getName()));
	}

}
