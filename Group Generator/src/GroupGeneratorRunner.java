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
	static String loadedFileName= "";
	static int selectedVal=0;
	static boolean load=false;
	static File userFile = new File("file");
	static boolean mullen = false;
	
	public static void main(String[] args) 
	{
//		createMullenGroups();
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
				  
				  
				
					  try
						{
							SaveClass.loadFile();
						} 
					  catch (InterruptedException e1)
						{
							e1.printStackTrace();
						}
					  load=true;
					  frame.setVisible(false);
					  displayOptions();
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
						  frame.setVisible(false);
						  displayOptions();
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
	 ArrayList<Student> gc = new ArrayList<Student>();
	 
     if(mullen)
    	 {
    		 selectedVal=5;
    	 }
	 
	 for(int i=0; i<selectedVal; i++)
	 {
		 groups.add(new ArrayList<Student>());
	 }
	 
	 int counter=0;
	 int counter3=0;
	 
	 while(directory.size()>0)
	 {
		int random = (int)(Math.random()*directory.size());
		int counter2=0;
		
		for(Student s: groups.get(counter))
			{
				if(s.getStudents().contains(directory.get(random)))
					{
						counter2++;
					}
			}
		
		if(counter2==0)
			{
				groups.get(counter).add(directory.get(random));
				gc.add(directory.get(random));
				directory.remove(directory.get(random));
				counter++;
			}
		
		if(counter==groups.size())
			{
				counter=0;
			}
		
		if(counter3==10000)
			{
				for(Student s: gc)
					{
						directory.add(s);
					}
				for(ArrayList<Student> g: groups)
					{
						g.clear();
					}
				gc.clear();
				counter3=0;
			}
		
		counter3++;
		
	 }
	 
	 for(int i=0; i<groups.size(); i++)
		 {
			 for(int j=0; j<groups.get(i).size(); j++)
				 {
					 for(int x=0; x<groups.get(i).size(); x++)
						 {
							 groups.get(i).get(j).getStudents().add(groups.get(i).get(x));
						 }
					
				 }
		 }
	 
	 
	 for(int i=0; i<groups.size(); i++)
		 {
			 for(Student s: groups.get(i))
				 {
					 directory.add(s);
				 }
		 }
	 
	 try
	   {
		  JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
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
		  frame.setVisible(false);
		
	   }
	 catch(Exception e)
	   {
		System.out.println("bet");	 
	   }
	 if(load==true)
		 {
			 try
				{
					SaveClass.saveFile();
				} 
			 catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			 frame.setVisible(false);
			 displayJFrame();
		 }
	 else
		 {
	 saveCreatedClass();
		 }
	 
	 groups.clear();
	}
	
	public static void saveCreatedClass()
	{
		frame = new JFrame("Group Generator");
		panel = new JPanel();
		panel.setLayout(null);
		
		JLabel lbl = new JLabel("Save Class?");
		lbl.setBounds(110, 5, 150, 20);
		panel.add(lbl);
		
		JButton btn = new JButton("YES");
		btn.setBounds(40 , 45, 75, 50);
		panel.add(btn);
		
		JButton btn2 = new JButton("NO");
		btn2.setBounds(170, 45, 75, 50);
		panel.add(btn2);
		
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 150);
		frame.setLocation(400, 200);
		frame.setVisible(true);
		frame.repaint();
		
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				try
					{
						SaveClass.saveFile();
					} catch (InterruptedException e1)
					{
						e1.printStackTrace();
					}
				frame.setVisible(false);
				displayJFrame();
				
			}
			
		});
		
		btn2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
				displayJFrame();
			}
			
		});
		
	}
	public static void createMullenGroups()
	{
		ArrayList<ArrayList<Student>> groups = new ArrayList<ArrayList<Student>>();
		
		directory.add(new Student("Burke Bradley", new ArrayList<Student>()));
		directory.add(new Student("Hector Rodriguez", new ArrayList<Student>()));
		directory.add(new Student("Andrew Shine", new ArrayList<Student>()));
		directory.add(new Student("Coco Yu", new ArrayList<Student>()));
		directory.add(new Student("Scott Zhou", new ArrayList<Student>()));
		
		directory.add(new Student("Caleb Coit", new ArrayList<Student>()));
		directory.add(new Student("Daniel Dominguez", new ArrayList<Student>()));
		directory.add(new Student("Bo Kulbacki", new ArrayList<Student>()));
		directory.add(new Student("Elena Oman", new ArrayList<Student>()));
		directory.add(new Student("Dunham Perry", new ArrayList<Student>()));
		
		directory.add(new Student("Calvin Farrell", new ArrayList<Student>()));
		directory.add(new Student("Jeffer Ng", new ArrayList<Student>()));
		directory.add(new Student("Eric Rapp", new ArrayList<Student>()));
		directory.add(new Student("Kenny Sun", new ArrayList<Student>()));
		
		directory.add(new Student("Meagan Compton", new ArrayList<Student>()));
		directory.add(new Student("Blake Good", new ArrayList<Student>()));
		directory.add(new Student("Taylor Nielsen", new ArrayList<Student>()));
		directory.add(new Student("Liam Shaw", new ArrayList<Student>()));
		
		directory.add(new Student("Amelia Brown", new ArrayList<Student>()));
		directory.add(new Student("Angel Chen", new ArrayList<Student>()));
		directory.add(new Student("Josh Obrecht", new ArrayList<Student>()));
		directory.add(new Student("Carlos Reyes", new ArrayList<Student>()));
		
		for(int i=0; i<5; i++)
			{
				groups.add(new ArrayList<Student>());
			}
		
		int counter=0;
		for(int i=0; i<groups.size(); i++)
			{
				if(i<2)
					{
						for(int j=0; j<5; j++)
							{
								groups.get(i).add(directory.get(counter));
								counter++;
							}
					}
				else
					{
						for(int j=0; j<4; j++)
							{
								groups.get(i).add(directory.get(counter));
								counter++;
							}
					}
				
			}
		 for(int i=0; i<groups.size(); i++)
			 {
				 for(int j=0; j<groups.get(i).size(); j++)
					 {
						 for(int x=0; x<groups.get(i).size(); x++)
							 {
								 groups.get(i).get(j).getStudents().add(groups.get(i).get(x));
							 }
						
					 }
			 }
		 displayOptions();
	}

	

}
