package test;

import java.util.Objects;

public class Student {
	private String name;
	private double grade;

public Student(String name, double grade) {
	this.name=name;
	this.grade=grade;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getGrade() {
	return grade;
}

public void setGrade(double grade) {
	this.grade = grade;
}

@Override
public int hashCode() {
    return Objects.hash(name,grade);
}

@Override
public boolean equals(final Object obj) {
	Student stud = (Student) obj;
	return(Objects.equals(this.grade,stud.grade) && Objects.equals(this.name,stud.name));
}

}
