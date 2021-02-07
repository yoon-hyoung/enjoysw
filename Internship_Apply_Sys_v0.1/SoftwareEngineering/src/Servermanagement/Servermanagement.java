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
		Login client_status;
		client_status = new Login("jino1996","a1234");
		System.out.print(client_status.getLogin_status());
		
		if(client_status.getLogin_status()==1) {
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
}