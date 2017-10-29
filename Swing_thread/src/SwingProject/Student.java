package SwingProject;

import java.io.Serializable;
//Student class
//Member Functions : accept,display,calculateAverage,passFail
//Data Members : marks,name,rollno,percentage

//class 'Student' starts
public class Student  implements Serializable 
{
	private static final long serialVersionUID = 1L;
	int marks[]=new int[10];								//array to store student marks
	String name;
	int rollno;
	float percentage;
	String status;
	static int count = 0;
	
	//To accept student details
	void accept(int roll,String name1,int marks1,int marks2,int marks3,int marks4,int marks5)
	{
		 rollno = roll;
		 name = name1;
		 marks[0] = marks1;
		 marks[1] = marks2;
		 marks[2] = marks3;
		 marks[3] = marks4;
		 marks[4] = marks5;
	     calculateAverage();
	     isFail();
	}
	
	//To display student details in Mark sheet format
	String display()
	{
		String st,output;
		System.out.println("Name:\tRoll no:\tMarks:");
		System.out.println("---------------------------------------------------");
		System.out.println(name+"\t"+rollno+"\t\t"+marks[0]);
		for(int i=1;i<5;i++)
		System.out.print("\t\t\t"+marks[i]+"\n");
		System.out.println("Percentage : "+percentage+" %");
		boolean b = isFail();
		if(b==true)
			st = "Fail";
		else
			st = "Pass";
		output = "Name: "+name+"	Roll no: "+rollno+"		Percentage : "+percentage+" %"+"	Status: "+st;
		return output;
	}

	//To calculate average marks of each student
	void calculateAverage()
	{
		int sum=0;
		for(int i=0;i<5;i++)
			sum = sum + marks[i];
		percentage = ((float)sum/500)*100;
	}
	float getPercent()
	{
		int sum=0;
		for(int i=0;i<5;i++)
			sum = sum + marks[i];
		percentage = ((float)sum/500)*100;
		return percentage;
	}

	//To check if student passed or failed
	boolean isFail()
	{
		if(percentage < 40.0)
		{
			status = "Fail";
			return true;
		}
		else 
		{
			status = "Pass";
			return false;
		}
	}
}
