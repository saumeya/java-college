package SwingProject;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DeleteButtonUI extends JFrame
{
	private JTextField rollField1;
	private JLabel label;
	private JButton button,BACK;
	int roll;

	public DeleteButtonUI()
	{
		super("Delete Record");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setResizable(false);
		BACK = new JButton("BACK");
		setLocationRelativeTo(null);	// center on screen
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setVisible(true);
		// creates the GUI
		
		rollField1 = new JTextField(20);
		label = new JLabel("Enter roll number to be deleted: ");
		button = new JButton("Delete");
		
		button.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent evt) 
			{

				roll = Integer.parseInt(rollField1.getText());
				new MyClient(4,roll,null,0,0,0,0,0);
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