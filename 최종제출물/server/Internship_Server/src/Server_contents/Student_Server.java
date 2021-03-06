package Server_contents;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import Internship.Internship;
import Student.Student;
public class Student_Server implements Serializable{

	Student managed_student;
	Internship[] internship;
	
	public Student_Server(String student) throws IOException {

		this.managed_student = new Student(student);
		
		int i=0;
		String dirName = "./Internship/";
		File dir = new File(dirName);
		String internInfoPath;
		String files[] = dir.list(); //[0]Apple [1]Google [2]Samsung
		
		internship=new Internship[files.length];
		
		//System.out.print("file length"+files.length);
		while(i<files.length) {
			internInfoPath = "./Internship/"+files[i]+"/"+files[i]+".txt";
			System.out.print(internInfoPath);
			internship[i] = new Internship(internInfoPath);
			i++;
		}
	}
	
	public void setInternship() {
		
		int i=0;
		String dirName = "./Internship/";
		File dir = new File(dirName);
		String internInfoPath;
		String files[] = dir.list();
		internship = new Internship[20];
	
		while(i<files.length) {
			internInfoPath = "./Internship/"+files[i]+"/"+files[i]+".txt";
			internship[i] = new Internship(internInfoPath);
			i++;
		}
		
	}


	
	
	public void addDocu(String inFileName,String outFileName) { //
		
		managed_student.getDocu().AddDocument(inFileName, outFileName);
		
	}
	
	public void delDocu(String del_file) { //
		
		managed_student.getDocu().DelDocument(del_file);
		
	}
	
	public void printDocu() {
		managed_student.getDocu().PrintDocumentList();
	}
	
	
	public void print_student_info() {
		
		managed_student.print_info();
	}
	public void print_apply_internship() {
		
		managed_student.print_apply_internship();
	}
	
	
	public void print_internship_list() {
		int i=0;
		for(i=0;i<internship.length;i++) {
			internship[i].printname();
		}
	}
	public void print_internship_All() {
		int i=0;
		for(i=0;i<internship.length;i++) {
			internship[i].printAll();
		}
	}
	
	public void apply_internship(String apply_internship) {
		
		managed_student.setApplicationForInternship(apply_internship);
		managed_student.getApplicationForInternship().apply();
		managed_student.setApplyInternshipName();// 占쎈뻿筌ｏ옙占쎈립 占쎌뵥占쎄쉘占쎈뤊 占쎌삺 占쎄쉭占쎈샒
		
	}
	public void cancel_apply_internship(String cancel_internship) {
		
		managed_student.setApplicationForInternship(cancel_internship);
		managed_student.getApplicationForInternship().cancel();
		managed_student.setApplyInternshipName();// 占쎈뻿筌ｏ옙占쎈립 占쎌뵥占쎄쉘占쎈뤊 占쎌삺 占쎄쉭占쎈샒
		
	}
	
	public void write_review(String review_internship,String write_review_name) {
		int i;
		for(i=0;i<internship.length;i++) {
			if(review_internship.equals(internship[i].getname())) {
				internship[i].getreview().write_review(write_review_name);
				break;
			}
		}
		
	}
	public void print_review_name(String review_internship) {
		int i;
		for(i=0;i<internship.length;i++) {
			if(review_internship.equals(internship[i].getname())) {
				internship[i].getreview().show_review_list();
				break;
			}
		}
	}
	public void print_review_All(String review_internship,String print_review) {
		int i;
		for(i=0;i<internship.length;i++) {
			if(review_internship.equals(internship[i].getname())) {
				internship[i].getreview().print_review(print_review);
				break;
			}
		}
	}
	public Student getStudent() {
		return this.managed_student;
	}
	public Internship[] getInternship() {
		return internship;
		
	}

}