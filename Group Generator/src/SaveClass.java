import java.io.*;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class SaveClass
	{
		public static void saveFile() throws InterruptedException
		{
		try
			{
				
				
				if(GroupGeneratorRunner.load==true)
					{
					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(GroupGeneratorRunner.userFile));
					
					out.writeObject(GroupGeneratorRunner.directory);  
					
					out.flush();
					out.close();
					}
				else
					{
				JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int r = chooser.showSaveDialog(null);
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(chooser.getSelectedFile()+".txt"));
				
				 try
					   {
						  
						  
						  if(r==JFileChooser.APPROVE_OPTION)
							  {
							  out.writeObject(GroupGeneratorRunner.directory);  
							  }
						
					   }
					 catch(Exception e)
					   {
						System.out.println("bet");	 
					   }
				 out.flush();
				 out.close();
					}
				
				
			}
		catch(IOException ex)
			{
				System.out.println("IOException Caught.");
			}
		}
		
		@SuppressWarnings("unchecked")
		public static void loadFile() throws InterruptedException
		{
		
			ArrayList<Student> tempStudents = new ArrayList<Student>();
			JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	
			int r = chooser.showOpenDialog(null);
		
			try
				{
					ObjectInputStream in = new ObjectInputStream(new FileInputStream(chooser.getSelectedFile()));
					GroupGeneratorRunner.userFile = chooser.getSelectedFile();
					
					if(r==JFileChooser.APPROVE_OPTION)
						{
					tempStudents = (ArrayList<Student>) in.readObject();
					GroupGeneratorRunner.directory = tempStudents;
						}
					
					
					for(Student s: GroupGeneratorRunner.directory)
						{
							System.out.println(s.getName());
						}
					
					in.close();
				} 
			
			catch (IOException ex)
				{
					System.out.println("IOExcpetion Caught.");
				} 
			catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
		}
	}
