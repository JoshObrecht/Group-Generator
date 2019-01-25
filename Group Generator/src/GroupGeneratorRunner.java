import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.util.ArrayList;
import java.io.*;
import java.nio.file.Files;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class GroupGeneratorRunner extends JPanel
{
	static ArrayList<Student> directory = new ArrayList<Student>();
	static JFrame frame;
	static JLabel lbl2;
	static String fileName;
	static JPanel panel;
	static JSpinner s1;
	static int selectedVal=0;
	
	public static void main(String[] args) 
	{
		displayJFrame();
	}
	
	public static void displayJFrame()
	{
		frame = new JFrame("Group Generator");
		panel = new JPanel();
		panel.setLayout(null);
		
		JLabel lbl = new JLabel("Choose a File");
		lbl.setBounds(150, 5, 100, 20);
		panel.add(lbl);
		
		JButton btn = new JButton("Load Existing Class");
		btn.setBounds(20 , 40, 150, 50);
		panel.add(btn);
		
		JButton btn2 = new JButton("Create New Class");
		btn2.setBounds(215, 40, 150, 50);
		panel.add(btn2);
		
		JFileChooser f1 = new JFileChooser();
		lbl2 = new JLabel("no file selected");
		
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 150);
		frame.setLocation(400, 200);
		frame.setVisible(true);
		frame.repaint();
		

		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{		 
				  JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				  
				  int r = j.showOpenDialog(null);
				  
				  if(r == JFileChooser.APPROVE_OPTION)
				  {
					  lbl2.setText(j.getSelectedFile().getAbsolutePath());
					  File file = j.getSelectedFile();
					  fileName = file.toString();
					  ReadFile.readFile();
					  frame.setVisible(false);
					  displayOptions();
					  
				  }
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
					  JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
					  
					  int r = j.showOpenDialog(null);
					  
					  if(r == JFileChooser.APPROVE_OPTION)
					  {
						  lbl2.setText(j.getSelectedFile().getAbsolutePath());
						  File file = j.getSelectedFile();
						  fileName = file.toString();
						  ReadFile.readFile();
					  }
				  
				
			}
			
		});
	}

	public static void displayOptions()
	{
		frame = new JFrame("Group Generator");
		panel = new JPanel();
		panel.setLayout(null);
		
		JLabel lbl = new JLabel("Set Group Parameters");
		lbl.setBounds(130, 5, 150, 20);
		panel.add(lbl);
		
		JLabel lbl3 = new JLabel("Amount of Groups");
		lbl3.setBounds(145, 50, 120, 20);
		panel.add(lbl3);
		
		s1 = new JSpinner(new SpinnerNumberModel(1, 1, directory.size(), 1));
		s1.setBounds(180, 80, 35, 25);
		panel.add(s1);
		
		JButton btn = new JButton("CREATE");
		btn.setBounds(120 , 125, 150, 50);
		panel.add(btn);
		
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 250);
		frame.setLocation(400, 200);
		frame.setVisible(true);
		frame.repaint();
		
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
			 selectedVal = (int)s1.getValue();
			 generateGroups();
			}
		});
	}
	public static void generateGroups()
	{
	 ArrayList<ArrayList<Student>> groups = new ArrayList<ArrayList<Student>>();
	 
	 for(int i=0; i<selectedVal; i++)
	 {
		 groups.add(new ArrayList<Student>());
	 }
	 
	 int counter=0;
	 while(directory.size()>0)
	 {
		int random = (int)(Math.random()*directory.size());
		
		if(counter==groups.size())
			{
				counter=0;
			}
		groups.get(counter).add(directory.get(random));
		directory.remove(random);
		counter++;
	 }
	 
	 try
	   {
		  JFileChooser chooser = new JFileChooser();
		  int r = chooser.showSaveDialog(null);
		  
		  if(r==JFileChooser.APPROVE_OPTION)
			  {
				  BufferedWriter bw = new BufferedWriter(new FileWriter(chooser.getSelectedFile()+".txt"));

				  for(int i=0; i<groups.size(); i++)
					  {
						  bw.write("GROUP "+(i+1)+":");
						  bw.newLine();
						  for(Student s: groups.get(i))
							  {
								  bw.write(s.getName());
								  bw.newLine();
							  }
						  bw.newLine();
					  }
				  bw.flush();
				  bw.close();
				  
			  }
		
	   }
	 catch(Exception e)
	   {
		System.out.println("bet");	 
	   }
	 
	 for(int i=0; i<groups.size(); i++)
		 {
			 for(Student a: groups.get(i))
				 {
					 System.out.println(a.getName());
				 }
			 System.out.println("");
		 }
	 
	}

	

}
