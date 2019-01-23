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
	static JFrame frame = new JFrame("Group Generator");
	static JLabel lbl2;
	static String fileName;
	
	public static void main(String[] args) 
	{
		displayJFrame();
	}
	
	public static void displayJFrame()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel lbl = new JLabel("Choose a FIle");
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
				  }
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
					  JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
					  
					  int r = j.showSaveDialog(null);
					  
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

	

}
