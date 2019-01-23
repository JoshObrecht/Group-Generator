import java.io.*;

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
     System.out.println(line);
 	}
	
	br.close();
	}
	catch(Exception e)
	{
		System.out.println("bet");
	}
	}
	
}
