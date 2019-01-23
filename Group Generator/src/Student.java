import java.util.ArrayList;

public class Student 
{
private String firstName;
private String lastName;
private ArrayList<Student> students;

public Student(String fn, String ln, ArrayList<Student> s)
{
	firstName = fn;
	lastName = ln;
	students = s;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public ArrayList<Student> getStudents() {
	return students;
}

public void setStudents(ArrayList<Student> students) {
	this.students = students;
}


}
