/*Server side Client-server 3-tier implementation for student mark sheet storing data in the database */
package SwingProject;

import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

public class MyServer implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	int port;
	ServerSocket ss= null;
	Socket s =null;
	Operations obj = null;
	ExecutorService pool =null;
	
	public MyServer(int port)
	{
		this.port=port;
		obj=new Operations();
		pool = Executors.newFixedThreadPool(5);
				/*Creates a thread pool that reuses a fixed 
				 * number of threads operating off a shared unbounded queue*/
	}
	public void startServer()
	{
		try
		{
			ss = new ServerSocket(5000);
			while(true)
			{
				System.out.println("Server is Waiting for Client ...  ");
				s = ss.accept();
				
				System.out.println("\nHey I Got One Client Online .. \n");
				System.out.println("\nCreating Thread for this Client !\n");
				pool.execute(new ServerThreadBody(s,obj));
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		new MyServer(5000).startServer();
	}	
 }


class ServerThreadBody implements Runnable,Serializable
{
	private static final long serialVersionUID = 1L;
	Socket s;
	Operations op;
	ResultSet rs = null;
	ServerThreadBody()
	{
		s = null;
		op = null;
	}
	ServerThreadBody(Socket s,Operations op)
	{
		this.s = s;
		this.op = op;
	}
	@Override
	public void run() 
	{
	   //Here we are catching the input sent from client
	   try
	   {		   
		   System.out.println("..........Welcome to server side..........");
	
		   ObjectOutputStream soos  = new ObjectOutputStream(s.getOutputStream());
		   ObjectInputStream  sois  = new ObjectInputStream(s.getInputStream());

		   DataOutputStream sdos = new DataOutputStream(s.getOutputStream());
		   DataInputStream  sdis = new DataInputStream(s.getInputStream());
		   
		   //send message to client that server successfully started
		   sdos.writeInt(1);
		   System.out.println("..........CONNECTTION ESTABLISHED WITH THE CLIENT SUCCESSULLY.......... ");
	
		   String ans;
		   int choice;
		   int key;
		   do
		   {
			   //Object sent to server from client
			   choice = sdis.readInt();
			   sdos.writeInt(choice);
			   //Choice written back to client !!
			   switch(choice)
			   {
			   case 1:		
				   	 Student st	 =(Student) sois.readObject();					//object read in 'op' from client side
					 op.addRecord(st);
					 System.out.println("\nRecord added and Database modified !!");
					 //Object sent to client from server	 		
					 soos.writeObject(st);								//object 'op' written to client side
					 System.out.println("\nData sent back to client !!");	 		
					 break;
			   case 2:
				   	 sdis.readInt();
				   	 System.out.println("Hey ! wait i am Collecting Data to send to Client ");
				   	 soos.writeObject(new ServerThreadBody());						
					 System.out.println("\nData sent back to client !!");			 
					 break;
			   case 3:
				     key = sdis.readInt();
			 		 Student ssrch = op.getRecordByNo(key);
					 soos.writeObject(ssrch);								//object 'op' written to client side
					 System.out.println("\nData sent to client !!");	 		
			 		 break;						
			   case 4:
				     key = sdis.readInt();
					 sdos.writeBoolean(op.deleteRecordByNo(key));
					 break;
			   case 5:
				     int countFail = op.countFail();
					 sdos.writeInt(countFail);
					 System.out.println("\nData of failed students sent to client !!");	
					 break;
			   case 6:
				   	 choice=sdis.readInt();
				   	 Student stop=op.findTopper();
				   	 soos.writeObject(stop);
				   	 break;
			   default:
				     System.out.println("\nYou entered valid choice !!");							   
			   }		
			   ans = sdis.readUTF();
			   sdos.writeUTF(ans);
		   }while(ans.charAt(0)=='y');
	   }
	   catch(SocketException e)
	   {
		   System.out.println("\nClient Detached !");
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
		
	}
	public String toString()
	{
	   	rs = new Operations().displayAllRecords();
	   	String output="",output1="";
	   	ArrayList<String> arr = new ArrayList<String>();
		System.out.println("IntoString");
	   	try 
	   	{
			if(!rs.next())
			{
				System.out.println("Database is empty !");
			}
			else
			{
				rs.previous();
				while(rs.next())
				{
					String s = rs.getString("name");
					int r = rs.getInt("rollno");
					int m1 = rs.getInt("marks0");
					int m2 = rs.getInt("marks1");	
					int m3 = rs.getInt("marks2");	
					int m4 = rs.getInt("marks3");
					int m5 = rs.getInt("marks4");
					int percentage = rs.getInt("percentage");
					String status = rs.getString("status");
			
					output = "\n    Name : "+s+"    Roll Number : "+r+"    Marks 1 : "+m1+"    Marks 2 : "+m2+"    Marks 3 : "+m3+"    Marks 4 : "+m4+"    Marks 5 : "+m5+"    Percentage : "+percentage+"    S: "+status+"\n\n"
							+"__________________________________________________________________________________________\n";
					output1 += output;
					
					arr.add(output);
					System.out.println("__________________________________________________________________________________________");
					System.out.print("Name : "+s);
					System.out.print("    Roll Number : "+r);
					System.out.print("    Marks 1 : "+m1);
					System.out.print("    Marks 2: "+m2);
					System.out.print("    Marks 3: "+m3);
					System.out.print("    Marks 4: "+m4);
					System.out.print("    Marks 5: "+m5);
					System.out.print("    Percentage : "+percentage);
					System.out.print("    S: "+status);				
					System.out.println("\n________________________________________________________________________________________");
				}
			}
		} 
	   	catch (SQLException e) 
	   	{
			e.printStackTrace();
		}
		return output1;
	}

	
}
