package myClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import stud.Student;

public class Client {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try {
			Socket cs = new Socket("localhost", 5000);
			DataOutputStream dout = new DataOutputStream(cs.getOutputStream());
			DataInputStream din = new DataInputStream(cs.getInputStream());

			ObjectOutputStream oout = new ObjectOutputStream(
					cs.getOutputStream());
			ObjectInputStream oin = new ObjectInputStream(cs.getInputStream());
			int ch;
			String name;
			int rollNo;
			double marks;

			// Student class of Client
			Student st = null;
			while (true) {
				System.out.print("\nMAIN MENU\n");
				System.out.println("\n\t1. Add \n\t2.Delete\n\t3.Search\n\t4.Failed Student\n\t5.List\n\t6.Exit");
				System.out.print("\nEnter choice: ");
				ch = sc.nextInt();
				dout.writeInt(ch);
				switch (ch) {
				case 1:
					System.out.print("\nEnter Roll No - ");
					rollNo = sc.nextInt();
					System.out.print("\nEnter Name - ");
					name = sc.next();
					System.out.print("\nEnter Marks - ");
					marks = sc.nextDouble();
					st = new Student(rollNo, name, marks);
					oout.writeObject(st);

					System.out.print("\nAdded Succesfully " );
					
					break;
				case 2:
					System.out.print("\nEnter rollNo to be deleted : ");
					rollNo = sc.nextInt();
					dout.writeInt(rollNo);
					System.out.print("\nDeleted Succesfully ");
					break;
				case 3:
					System.out.print("\nEnter rollNo to be searched : ");
					rollNo = sc.nextInt();
					dout.writeInt(rollNo);
					Student s = (Student) oin.readObject();
					if (s != null) {
						System.out.print("\nSearched Student -> " + s);
					} else {
						System.out.println("User not found !!!");
					}

					break;
				case 4:
					System.out.print("\nEnter passing marks : ");
					double pm = sc.nextDouble();
					dout.writeDouble(pm);
					System.out.print("\nFailed List !!!\n" + din.readUTF());
					break;
				}
				if (ch == 5) {
					System.out.println(din.readUTF());
					break;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
