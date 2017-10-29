package myServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import stud.Student;

public class ServerDemo {

	static ArrayList<Student> al = new ArrayList<Student>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(5000);
			System.out.println("Server waiting for client....");
			Socket cs = ss.accept();

			DataOutputStream dout = new DataOutputStream(cs.getOutputStream());
			DataInputStream din = new DataInputStream(cs.getInputStream());

			ObjectOutputStream oout = new ObjectOutputStream(
					cs.getOutputStream());
			ObjectInputStream oin = new ObjectInputStream(cs.getInputStream());

			Student st = null;
			int rollNo;
			Operations obj = new Operations();

			while (true) {

				int ch = din.readInt();
				if (ch == 1) {
					// Reading com.server.Student Object from client

					st = (Student) oin.readObject();

					// Calling addStudent() of com.server.Operations class
					obj.addStudent(st);
					dout.writeUTF(al.toString());
				} else if (ch == 2) {
					// Reading rollNo from client for deleting
					rollNo = din.readInt();

					// Calling addStudent() of com.server.Operations class
					obj.deleteStudent(rollNo);
					dout.writeUTF(al.toString());
				} else if (ch == 3) {
					// Reading rollNo from client for deleting
					rollNo = din.readInt();

					// Calling addStudent() of com.server.Operations class
					st = obj.searchStudent(rollNo);
					if (st != null) {
						// Writing searched Student object back to client
						oout.writeObject(st);
					} else {
						// Writing ArrayList al object back to client
						oout.writeObject(null);
					}
				} else if (ch == 4) {
					// Reading rollNo from client for deleting
					double pm = din.readDouble();

					// Calling addStudent() of com.server.Operations class
					ArrayList<Student> failed = obj.failedStudents(pm);
					dout.writeUTF(failed.toString());
				} else if (ch == 5) {
					dout.writeUTF("Bye Bye Client from server!!! ");
					System.out.println("Socket Closed !!!s");
					cs.close();
					break;
				}
			}
			ss.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
