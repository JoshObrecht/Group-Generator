import java.awt.Component;
import javax.swing.*;
import java.util.ArrayList;


public class GroupGeneratorRunner 
{
	static ArrayList<Student> directory = new ArrayList<Student>();
	static JFrame frame = new JFrame("Group Generator");

	public static void main(String[] args) 
	{
		displayJFrame();
	}
	
	public static void displayJFrame()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 150);
		frame.setLocation(430, 100);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.add(panel);
		
		JLabel lbl = new JLabel("Choose a FIle");
		lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panel.add(lbl);
		
		String [] choices = {"Temperature", "Metric", "Currency", "Time Zones", "Imperial"};
		
		final JComboBox<String> cb = new JComboBox<String>(choices);
		
		cb.setMaximumSize(cb.getPreferredSize()); 
		cb.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panel.add(cb);
		
		JButton btn = new JButton("OK");
		btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btn);
		
		frame.setVisible(true);
	}

}
