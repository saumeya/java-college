package data;
import java.util.*;
public class Admin {

	ArrayList <Student>s  = new ArrayList<Student>();
	public void addrecord()
	{
		int flag = 0;
		Student obj=new Student();
		flag = obj.input(s);
		if(flag == 1)
			s.add(obj);
	}
	
	
	public void dis(){
		 Collections.sort(s);
		 System.out.println("\n\tRoll\tName\tM2\tDM\tDSA\tCO\tOOP\tPercent\tGrade");
		   for(Student str: s){
				System.out.println(str);
		   }
	}
	
	
	public void displayall()
	{
		Student obj=new Student();
		System.out.println("\n\tRoll\tName\tM2\tDM\tDSA\tCO\tOOP\tPercent\tGrade");
		Iterator<Student> itr=s.iterator();  
		  while(itr.hasNext()){  
			obj = itr.next();  
	        obj.display();
		}
	}
	
    
    public int search(int r)
	{
		Student obj=new Student();
		
		int flag=0;
		Iterator<Student> itr=s.iterator();  
		  while(itr.hasNext())
		  {  
			 obj = itr.next();  
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
		int flag=0;
		Iterator<Student> itr=s.iterator();  
		  while(itr.hasNext())
		  {  
			obj = itr.next();  
	        if(r==obj.roll)
	        {
	        	System.out.println("\nRecord deleted!");
	        	s.remove(obj);
	        	flag=1;
	        	break;
	        }        	
		  }
		return flag;
	}
	
	public void fail()
	{
		Student obj=new Student();
		System.out.println("\n\tRoll\tName\tM2\tDM\tDSA\tCO\tOOP\tPercent\tGrade");
		Iterator<Student> itr=s.iterator();  
		  while(itr.hasNext())
		  {  
			obj = itr.next();  
	        if(obj.grade=='F')
	        {
	         obj.display();	
	        }        	
		 }
	}
}