package Servermanagement;

import java.io.IOException;
import java.util.Scanner;

import Server_contents.*;

public class Servermanagement {
	Student_Server[] client=new Student_Server[5] ;
	Staff_Server manager ;
	
	
	public Servermanagement() throws IOException{
		int flag;
		
		Scanner input =new Scanner(System.in) ;
		
		flag = input.nextInt();
		
		switch(flag) {
		case 1:
			client[0]=new Student_Server("jino1996");
			client[0].apply_internship("Google");
			break;
		case 2:
		
		}
		
	}
}