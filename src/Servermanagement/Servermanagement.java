package Servermanagement;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Server_contents.*;

public class Servermanagement {
	Student_Server[] student=new Student_Server[5] ;
	Staff_Server staff ;
	Login login;
	private String path;
	
	
	public Servermanagement() throws IOException{
		int flag = 0,mode=0;
		String ID,PW;
		// Select Mode...
		while(true) {
			System.out.print("-----------Select mode----------\n");
			System.out.print("1: Student mode\n");
			System.out.print("2: Staff mode\n");
			Scanner input1 =new Scanner(System.in);
			try {
				mode=input1.nextInt();
			}
			catch(Exception e) {
			}
			
			if(mode==1) {
				System.out.print("----------Student mode----------\n");
				//login.setLogin_status(1);
				break;
			}
			else if(mode==2) {
				System.out.print("----------Staff mode----------\n");
				//login.setLogin_status(2);
				break;
			}
		}
		
		while(true) {
			System.out.print("-------------Login--------------\n");
			System.out.print("ID:");
			Scanner input2 =new Scanner(System.in);
			ID=input2.next();
			File file= new File("./Student/"+ID);
			this.path ="./Student/"+ID;  
			
			// ID 파일 안에 존재유무 
			if(file.exists()==true) {
				flag=1;
				System.out.print("----------login success---------\n");
			}
			// Login ...
			if(flag==1) {
				student[0]=new Student_Server(ID);
				break;
			}
			else if(flag==0){
				System.out.print("-----------Login fail-----------\n");
			}
		}
		
	}
}