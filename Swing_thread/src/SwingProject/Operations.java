package SwingProject;

import java.io.*;
import java.sql.*;
import java.util.*;



class Operations implements Serializable
{
	private static final long serialVersionUID = 1L;
	static int count=0;
	static int fail=0;				//To count no. of failed students
	transient Scanner sc = new Scanner(System.in);		//since Scanner is not serializable but operations is serializable thus make scanner transient
	//transient makes Scanner as Serializable
	
	Connection conn = null;
	Statement stmt = null;
	String query;
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//String DB_URL = "jdbc:mysql://172.16.1.68:3306/b6";
	
	String DB_URL="jdbc:mysql://localhost:3306/b6";
	String USER="root";
	String PASS="arun";

	ResultSet rs =null;	
	//To add a record
	void addRecord(Student s)
	{
		try
		{
			//forming connection with database
			Class.forName(JDBC_DRIVER);	//loading drivers
			conn = DriverManager.getConnection(DB_URL,USER,PASS);	//forming connection
			System.out.println("Inserting.....!");
				
			String query = "insert into Student(name,rollno,marks0,marks1,marks2,marks3,marks4,percentage,status)"+"values(?,?,?,?,?,?,?,?,?)";	
			//query to be executed by getting the dynamic values using preparedStatement
			
			PreparedStatement prep_stmt=conn.prepareStatement(query);
			prep_stmt.setString(1,s.name);
			prep_stmt.setInt(2,s.rollno);
			prep_stmt.setInt(3,s.marks[0]);
			prep_stmt.setInt(4,s.marks[1]);
			prep_stmt.setInt(5,s.marks[2]);
			prep_stmt.setInt(6, s.marks[3]);
			prep_stmt.setInt(7, s.marks[4]);
			prep_stmt.setFloat(8,s.percentage);
			prep_stmt.setString(9,s.status);
		
			prep_stmt.execute();
			conn.close();
		}
		catch (SQLIntegrityConstraintViolationException e) {
		    // Duplicate entry
		System.out.println("Duplicate Entry");
		} catch (SQLException e) {
		    // Other SQL Exception
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}

	//To display particular student record
	Student getRecordByNo(int i)
	{
		Student s = new Student();
		try
		{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt=conn.createStatement();
			query = "select * from Student where rollno = "+i;
			ResultSet rs = stmt.executeQuery(query);
			if(!rs.next())
			{
				System.out.println("Database Empty !");
			}
			else
			{
				//rs.next();
				s.name = rs.getString("name");
				s.rollno = rs.getInt("rollno");
				s.marks[0] = rs.getInt("marks0");
				s.marks[1] = rs.getInt("marks1");	
				s.marks[2] = rs.getInt("marks2");	
				s.marks[3] = rs.getInt("marks3");
				s.marks[4] = rs.getInt("marks4");
				s.percentage = rs.getFloat("percentage");
				s.status = rs.getString("status");
				conn.close();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return s;
	}
	//get the record from database by name
	Student getRecordByName(String key)
	{
		Student s = new Student();
		try
		{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt=conn.createStatement();
			query = "select * from Student where name = '"+key+"'";
			ResultSet rs = stmt.executeQuery(query);
		   	if(!rs.next())
		   	{
		   		System.out.println("Database is empty !");
		   	}
		   	else
		   	{	
				//rs.next();
				System.out.println(rs.getString("name"));
				s.name = rs.getString("name");
				s.rollno = rs.getInt("rollno");
				s.marks[0] = rs.getInt("marks0");
				s.marks[1] = rs.getInt("marks1");	
				s.marks[2] = rs.getInt("marks2");	
				s.marks[3] = rs.getInt("marks3");
				s.marks[4] = rs.getInt("marks4");
				s.percentage = rs.getFloat("percentage");
				s.status = rs.getString("status");
				conn.close();
		   	}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return s;
	}	

	//Delete a record from database
	boolean deleteRecordByNo(int i)
	{
		boolean ans = false;
		try
		{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt=conn.createStatement();
			query = "delete from Student where rollno = "+i;
			ans=stmt.execute(query);
			//System.out.println(ans);
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return ans;
	}	
	//To display all student Mark sheets
	ResultSet displayAllRecords()
	{
		try
		{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS); 
			stmt = conn.createStatement();	
			
			//formed connection with the database now we can execute the queries
			
			query = "select * from Student";
			rs = stmt.executeQuery(query);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return rs;
	}

	//To count no. of failed students
	int countFail()
	{
		int failCount=0;
		try
		{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS); 
			stmt = conn.createStatement();	
			
			//formed connection with the database now we can execute the queries
			
			query = "select * from Student";
			rs = stmt.executeQuery(query);
		   	if(!rs.next())
		   	{
		   		System.out.println("Database is empty !");
		   	}
		   	else
		   	{
		   		rs.previous();
				while(rs.next())
				{
					Student s = new Student();
					s.name = rs.getString("name");
					System.out.println(s.name+"================");
					s.rollno = rs.getInt("rollno");
					s.marks[0] = rs.getInt("marks0");
					s.marks[1] = rs.getInt("marks1");	
					s.marks[2] = rs.getInt("marks2");	
					s.marks[3] = rs.getInt("marks3");
					s.marks[4] = rs.getInt("marks4");
					float av = s.getPercent();
					if(av<40.0)
					{
						failCount++;
						System.out.println(failCount+"==================");
					}
				}
		   	}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return failCount;
	}
	
	//To find toper of the class
	Student findTopper()		
	{
		Student max=new Student();
		max.calculateAverage();
		max.isFail();
		try
		{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS); 
			stmt = conn.createStatement();	
			
			//formed connection with the database now we can execute the queries
			
			query = "select * from Student";
			rs = stmt.executeQuery(query);
		   	if(!rs.next())
		   	{
		   		System.out.println("Database is empty !");
		   	}
		   	else
		   	{
	
				while(rs.next())
				{
					Student s=new Student();
					s.name = rs.getString("name");
					s.rollno = rs.getInt("rollno");
					s.marks[0] = rs.getInt("marks0");
					s.marks[1] = rs.getInt("marks1");	
					s.marks[2] = rs.getInt("marks2");	
					s.marks[3] = rs.getInt("marks3");
					s.marks[4] = rs.getInt("marks4");
					s.percentage = rs.getFloat("percentage");
					s.status = rs.getString("status");
					if(s.percentage>max.percentage)
					{
						max=s;
					}
				}
		   	}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return max;
	}
}
//class 'Operations' ends