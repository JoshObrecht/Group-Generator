import java.util.ArrayList;

public class Student 
{
private String name;
private ArrayList<Student> students;

public Student(String n, ArrayList<Student> s)
{
	name=n;
	students = s;
}

public String getName()
	{
		return name;
	}



public void setName(String name)
	{
		this.name = name;
	}

public ArrayList<Student> getStudents() {
	return students;
}

public void setStudents(ArrayList<Student> students) {
	this.students = students;
}


}
