package SwingProject;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainWindow extends JFrame
{
	private static final long serialVersionUID = 1L;

	public MainWindow()
    {
		super("STUDENT MARKSHEET");

		
		MainWindowUI action = new MainWindowUI("Add Record","Display Record","Search Record","Delete Record","Fail Students","Topper Student");
		
		// add the component to the frame
		add(action);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,300);
		setResizable(false);
		setLocationRelativeTo(null);	// center on screen
	}
	
	public static void main(String[] args) 
    {
		SwingUtilities.invokeLater(new Runnable() 
        {
			@Override
			public void run() 
            {
				new MainWindow().setVisible(true);
			}
		});
	}
}
