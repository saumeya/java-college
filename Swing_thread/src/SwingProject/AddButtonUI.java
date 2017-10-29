package SwingProject;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddButtonUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
	private JTextField rollField;
	private JTextField marks1Field;
	private JTextField marks2Field;
	private JTextField marks3Field;
	private JTextField marks4Field;
	private JTextField marks5Field;
	private JButton ADD,BACK;
	private JLabel nameFieldL;
	private JLabel rollField1L;
	private JLabel marks1FieldL;
	private JLabel marks2FieldL;
	private JLabel marks3FieldL;
	private JLabel marks4FieldL;
	private JLabel marks5FieldL;
	int roll=0,marks1=0,marks2=0,marks3=0,marks4=0,marks5=0;

	public AddButtonUI()
	{
		super("Add Record");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setResizable(false);
		setLocationRelativeTo(null);	// center on screen
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setVisible(true);
		// creates the GUI
		
		nameField = new JTextField(30);		
		rollField = new JTextField(30);
		marks1Field = new JTextField(30);		
		marks2Field = new JTextField(30);
		marks3Field = new JTextField(30);		
		marks4Field = new JTextField(30);
		marks5Field = new JTextField(30);
		nameFieldL = new JLabel("Name :");		
		rollField1L = new JLabel("Roll :");
		marks1FieldL = new JLabel("ADS : :");		
		marks2FieldL = new JLabel("CG :");
		marks3FieldL = new JLabel("MP :");		
		marks4FieldL = new JLabel("M3 :");
		marks5FieldL = new JLabel("PPL :");
		
		
		ADD = new JButton("ADD");
		BACK = new JButton("BACK");

		add(nameFieldL);
		add(nameField);
		add(rollField1L);
		add(rollField);
		add(marks1FieldL);
		add(marks1Field);
		add(marks2FieldL);
		add(marks2Field);
		add(marks3FieldL);
		add(marks3Field);
		add(marks4FieldL);
		add(marks4Field);
		add(marks5FieldL);
		add(marks5Field);
		add(BACK);
		add(ADD);
		ADD.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent evt) 
			{
				roll = Integer.parseInt(rollField.getText());
				marks1 = Integer.parseInt(marks1Field.getText());
				marks2 = Integer.parseInt(marks2Field.getText());
				marks3 = Integer.parseInt(marks3Field.getText());
				marks4 = Integer.parseInt(marks4Field.getText());
				marks5 = Integer.parseInt(marks5Field.getText());
				new MyClient(1,roll,nameField.getText(),marks1,marks2,marks3,marks4,marks5);
			}
		});
		BACK.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) 
			{
				new MainWindow().setVisible(true);
			}
		});
	}
}
