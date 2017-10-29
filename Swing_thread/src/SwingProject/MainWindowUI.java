package SwingProject;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindowUI extends JPanel
{
	private String buttonLabel;
	private String buttonLabel1;
	private String buttonLabel2;
	private String buttonLabel3;
	private String buttonLabel4;
	private String buttonLabel5;
	
	private JLabel label;
	private JButton button;
	private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
	
	public MainWindowUI(String buttonLabel, String buttonLabel1,String buttonLabel2, String buttonLabel3,String buttonLabel4,String buttonLabel5) 
	{
		this.buttonLabel = buttonLabel;
		this.buttonLabel1 = buttonLabel1;
		this.buttonLabel2 = buttonLabel2;
		this.buttonLabel3 = buttonLabel3;
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// creates the GUI
		label = new JLabel("STUDENT MARKSHEET");
		button = new JButton(buttonLabel);
		button1 = new JButton(buttonLabel1);
		button2 = new JButton(buttonLabel2);
		button3 = new JButton(buttonLabel3);
		button4 = new JButton(buttonLabel4);
		button5 = new JButton(buttonLabel5);
		
		button.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent evt) 
			{
				 new AddButtonUI();
			}
		});
		
		button1.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent evt) 
			{
				new MyClient (2,0,null,0,0,0,0,0);
			}
		});
		
		button2.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent evt) 
			{		
				 new SearchButtonUI();
			}
		});
		
        button3.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				new DeleteButtonUI();
			}
            
        });
        button4.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				new MyClient (5,0,null,0,0,0,0,0);
			}
            
        });
        button5.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				new MyClient (6,0,null,0,0,0,0,0);
			}
            
        });
        add(label);
		add(button);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
	}

}
