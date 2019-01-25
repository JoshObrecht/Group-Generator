import java.io.*;
import java.util.ArrayList;

public class ReadFile 
{

	public static void readFile()
	{
		
	String line = null;	
	try
	{
	FileReader fr = new FileReader(GroupGeneratorRunner.fileName);
	BufferedReader br = new BufferedReader(fr);
	
	while((line = br.readLine()) != null) 
 	{
    GroupGeneratorRunner.directory.add(new Student(line, new ArrayList<Student>()));
 	}
	
	br.close();
	}
	catch(Exception e)
	{
		System.out.println("bet");
	}
	}
	
}
