package stud;

import java.io.Serializable;

public class Student implements Serializable{
	public int rollNo;
	public String name;
	public double marks;

	public Student(int rollNo, String name, double marks) {
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	}
	public void display(){
		System.out.println( rollNo + name + marks );
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks="
				+ marks + "]";
	}
}
