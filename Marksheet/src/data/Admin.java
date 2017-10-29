package data;
import java.util.*;
public class Admin {

	Vector v = new Vector();
	Enumeration vEnum;
	
	public void addrecord()
	{
		int flag = 0;
		Student obj=new Student();
		flag = obj.input(v);
		if(flag == 1)
			v.add(obj);
	}

	public void displayall()
	{
		Student obj=new Student();
		System.out.println("\n\tRoll\tName\tM2\tDM\tDSA\tCO\tOOP\tPercent\tGrade");
		vEnum = v.elements();
		while(vEnum.hasMoreElements())
		{
			obj = (Student)vEnum.nextElement();
	        obj.display();
		}
	}
	
     public int search(int r)
	 {
		Student obj=new Student();
		vEnum = v.elements();
		int flag=0;
		while(vEnum.hasMoreElements())
		{
			obj = (Student)vEnum.nextElement();
	        if(r==obj.roll)
	        {
	        	flag = 1;
	        	System.out.println("\n\tRoll\tName\tM2\tDM\tDSA\tCO\tOOP\tPercent\tGrade");
	        	obj.display();
	        	break;
	        }        	
		}
			return flag;
	  }
	
     
    public int delete(int r)
	{
		Student obj=new Student();
		vEnum = v.elements();
		int flag=0;
		while(vEnum.hasMoreElements())
		{
			obj = (Student)vEnum.nextElement();
	        if(r==obj.roll)
	        {
	        	System.out.println("\nRecord deleted!");
	        	v.remove(obj);
	        	flag=1;
	        	break;
	        }        	
		}
		return flag;
	}
	
    public void topper()
	{
		Student obj=new Student();
		vEnum = v.elements();
		float top=0;
		String n = "";
		while(vEnum.hasMoreElements())
		{
			obj = (Student)vEnum.nextElement();
	        if(obj.percent>top)
	        {
	        	top=obj.percent;
	        	n = new String(obj.name);
	        }        	
		}
		System.out.println("\t\tTopper : "+n+" Percentage : " +top);
	}
    
	public void fail()
	{
		Student obj=new Student();
		vEnum = v.elements();
		System.out.println("\n\tRoll\tName\tM2\tDM\tDSA\tCO\tOOP\tPercent\tGrade");
		while(vEnum.hasMoreElements())
		{
			obj = (Student)vEnum.nextElement();
	        if(obj.grade=='F')
	        {
	         obj.display();	
	        }        	
		}
	}
   
}