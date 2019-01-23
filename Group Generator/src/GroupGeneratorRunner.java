import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.util.ArrayList;
import java.io.*;


@SuppressWarnings("serial")
public class GroupGeneratorRunner extends JPanel
{
	static ArrayList<Student> directory = new ArrayList<Student>();
	static JFrame frame;
	static JLabel lbl2;
	static String fileName;
	static JPanel panel;
	static JSpinner s1, s2;
	
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
					  for(Student s: directory)
						  {
							  System.out.println(s.getFirstName()+" "+s.getLastName());
						  }
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
		
		JLabel lbl2 = new JLabel("Amount in Groups");
		lbl2.setBounds(10, 100, 120, 20);
		panel.add(lbl2);
		
		JLabel lbl3 = new JLabel("Amount of Groups");
		lbl3.setBounds(270, 100, 120, 20);
		panel.add(lbl3);
		
		s1 = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
		s1.setBounds(40, 130, 35, 25);
		panel.add(s1);
		
		s2 = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
		s2.setBounds(310, 130, 35, 25);
		panel.add(s2);
		
		
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 250);
		frame.setLocation(400, 200);
		frame.setVisible(true);
		frame.repaint();
	}
	public static void generateGroups()
	{
		
	}

	

}
