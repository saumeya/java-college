package myServer;

import java.util.ArrayList;

import stud.Student;

public class Operations {
	boolean addStudent(Student st) {
		boolean status = false;
		status = ServerDemo.al.add(st);
		return status;
	}
	
	boolean deleteStudent(int rollNo) {
		boolean status = false;
		
		for(Student s : ServerDemo.al){
			if(s.rollNo == rollNo){
				int index = ServerDemo.al.indexOf(s);
				ServerDemo.al.remove(index);
				status = true;
				break;
			}
		}
		return status;
	}
	
	Student searchStudent(int rollNo){
		Student st = null;
		
		for(Student s : ServerDemo.al){
			if(s.rollNo == rollNo){
				st = s;
				break;
			}
		}
		
		return st;
	}
	
	ArrayList<Student> failedStudents(double pm){
		ArrayList<Student> failed = new ArrayList<Student>();
		
		for(Student s : ServerDemo.al){
			if(s.marks < pm){
				failed.add(s);
			}
		}
		
		return failed;
	}
	
}
