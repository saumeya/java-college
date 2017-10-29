package data;
import java.util.*;

public class Student {
	
	int s1,s2,s3,s4,s5;
	int roll,total,ch;
	float percent;
	String name;
	char grade;
	Enumeration vEnum;
	Scanner sc = new Scanner(System.in);
	
  int input(Vector v){
		System.out.print("\n\tEnter Roll No. : ");
		roll = sc.nextInt();
		int flag = 1;
		Student obj=new Student();
		vEnum = v.elements();
		
		while(vEnum.hasMoreElements())
		{
			obj = (Student)vEnum.nextElement();
		
	        if(roll==obj.roll)
	        {
	        	flag =  0;
	        	break;
	        }
		}
	  if(flag==1)
	  {
		  	sc.nextLine();
			System.out.print("\n\tEnter Name : ");
			name = sc.nextLine();
			System.out.print("\n\tEnter  M2 marks : ");
			s1 = sc.nextInt();
			System.out.print("\n\tEnter DM marks : ");
			s2 = sc.nextInt();
			System.out.print("\n\tEnter DSA marks : ");
			s3 = sc.nextInt();
			System.out.print("\n\tEnter CO marks : ");
			s4 = sc.nextInt();
			System.out.print("\n\tEnter OOP marks : ");
			s5 = sc.nextInt();
			total = 0;
	   
	    if(s1<40||s2<40||s3<40||s4<40||s5<40)
			 {
				grade = 'F';
				total = 000;
				percent = 000;
			 }
		else
			 {
				total = s1+s2+s3+s4+s5;
				percent = total/5;
		
	
			   if(percent>79){
							grade = 'O';
					 }
			   else if(percent>69&&percent<80)
			   		 {
						grade = 'A';
					 }
			   else if(percent>59&&percent<70)
			   		{
						grade = 'B';
					}
			   else if(percent>49&&percent<60)
			   		{
						grade = 'C';
					}
			   else if(percent>39&&percent<50)
			   		{
						grade = 'D';
					}
			   else
			   		{
						grade = 'F';
			   		}
			 }
		}
	  else
	  		{
		  			System.out.println("Identical Roll Nos. not allowed");
	  		}
	       
			return flag;
			
	}
	
	void display()
	{
		System.out.println("\t"+roll  + "\t" + name + "\t" + s1+ "\t" + s2 + "\t" + s3 + "\t" + s4+ "\t" + s5+ "\t"+ percent + "\t" + grade );
	}
	
	
}



	