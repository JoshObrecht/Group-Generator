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
	String[] tempName = line.split(" ");
    GroupGeneratorRunner.directory.add(new Student(tempName[0], tempName[1], new ArrayList<Student>()));
 	}
	
	br.close();
	}
	catch(Exception e)
	{
		System.out.println("bet");
	}
	}
	
}
