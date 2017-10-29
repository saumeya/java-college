package SwingProject;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SearchButtonUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField rollField1;
	private JLabel label;
	private JButton BACK = new JButton("BACK");
	private JButton button;
	int roll;

	public SearchButtonUI()
	{
		super("Search Record");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setResizable(false);
		setLocationRelativeTo(null);	// center on screen
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setVisible(true);
		// creates the GUI
		
		rollField1 = new JTextField(20);
		label = new JLabel("Enter roll number to be searched: ");
		button = new JButton("Search");
		
		button.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent evt) 
			{

				roll = Integer.parseInt(rollField1.getText());
				new MyClient(3,roll,null,0,0,0,0,0);
			}
		});
		BACK.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) 
			{
				new MainWindow().setVisible(true);
			}
		});
		
		add(label);
		add(rollField1);
		add(button);
		
	}
}
