package SwingProject;

import java.net.*;
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class MyClient 
{
	public MyClient(int choice,int roll,String name,int marks1,int marks2,int marks3,int marks4,int marks5) 
	{
		//Here we are throwing the message to Server
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		try
		{	
			@SuppressWarnings("resource")
			Socket s = new Socket("localhost",5000);

			ObjectOutputStream coos  = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream cois  = new ObjectInputStream(s.getInputStream());

			DataInputStream cdis = new DataInputStream(s.getInputStream());
			DataOutputStream cdos = new DataOutputStream(s.getOutputStream());

			System.out.println("\t\t\tWelcome to Client side !");

			int x = cdis.readInt();
			if(x == 1)
			{
				System.out.println("CONNECTION ESTABLISHED WITH SERVER \n!!");

				Student st = new Student();

				int key;

                //Send the Choice to server
                cdos.writeInt(choice);
                //Come back to Client to continue from where control was left off
                choice = cdis.readInt();

                switch(choice)	
                {
                case 1:			
                        Student staccept=new Student();
                        staccept.accept(roll,name,marks1,marks2,marks3,marks4,marks5);
                        coos.writeObject(staccept);	//Student data accepted is sent to Server in order to store it in the database 

                        st =(Student)cois.readObject();	

                        System.out.println("\n\tDatabase modified !!");	
                        JOptionPane.showMessageDialog(null, "Record successfully added");
                        break;
                case 2:
                        cdos.writeInt(1);
                        System.out.println("Come-back !");
                        
                        JOptionPane.showMessageDialog(null,cois.readObject().toString());
                        break;
                case 3:
                        //sending key to server
                        cdos.writeInt(roll);
                        //reading student of specified roll number in student object
                        st =(Student)cois.readObject();
                        if(st.name==null)
                        	JOptionPane.showMessageDialog(null,"Record not found!");
                        else  
                        	JOptionPane.showMessageDialog(null,st.display());
                        break;		
                case 4:
                        cdos.writeInt(roll);
                        cdis.readBoolean();
                        JOptionPane.showMessageDialog(null,"Record will be deleted if it exists !");
                        break;
                case 5:
                        String out = "Number of Students Failed are : "+String.valueOf(cdis.readInt());
                        //Object sent to client from server
                        JOptionPane.showMessageDialog(null,out);
                        break; 
                case 6:
                        cdos.writeInt(choice);
                        Student stop=(Student)cois.readObject();
                    	JOptionPane.showMessageDialog(null,stop.display());
                        break;
                default:
                        System.out.println("\nYou entered valid choice !!");			
                }	
			}
			else
			{
				throw new java.lang.Exception();
			}
		}
		//Catch the exception if connection with server has not taken place yet
		catch(ConnectException e)
		{
			System.out.println("Connection Unsuccessfull with the Server !");
		}
		catch(SocketException e)
		{
			System.out.println("Connection Unsuccessfull with the Server !");			
		}
	    catch(EOFException e)
	    {
			 //coos.close();			//If we skip this part it throws EOFexception
			 //cois.close();			// And if I write these lines i9t throws socket closed exception
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	}
}
