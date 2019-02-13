package comparator;

import java.util.Comparator;

import test.Student;

public class SortGrade implements Comparator<Student> {

@Override
public int compare(Student o1, Student o2) {
	return (int) (o2.getGrade()-o1.getGrade());
}

}
