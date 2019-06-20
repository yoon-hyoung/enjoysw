package Server_contents;

import Foundation.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;



public class Login implements Serializable{

	private int login_status; //

	public Login(String ID,String Password) {
		String path="./login_info/";
		File loginDir = new File(path);
		File loginFile;
		String[] fileList = loginDir.list();
		int flag=0; //
		int i; //iterator
		
		String PW = null; //
		
		for(i=0;i<fileList.length;i++) {
			if(fileList[i].equals(ID+".txt")) {
				flag=1;
				break;
			}
		}
		if(flag==1) {
			loginFile=new File(path+ID+".txt");
			FileReader filereader = null;
			BufferedReader bufreader;
			try {
				filereader =new FileReader(loginFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.print("[System] Hi \n");
				setLogin_status(0);
				return ;
			}
			bufreader = new BufferedReader(filereader); //
			
			String job = "";
			try {
				job = bufreader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("[System] break ");
				System.exit(1);
			} 
			try {
				PW = bufreader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("[System] Bye ");
				System.exit(1);
			}
			//
			
			if(PW.equals(Password)) {
				if(job.equals("student")) {
					setLogin_status(1);
					return ;
				}
				else if (job.equals("admin")) {
					setLogin_status(2);
					return ;
				}
			}
			
			else {
				
				System.out.print("[System] See you \n");
				setLogin_status(0);
				return ;
			}
			
			
		}
		return ;
		
	}
	
	public int getLogin_status() {
		return login_status;
	}
	
	public void setLogin_status(int login_status) {
		this.login_status = login_status;
	} 
	
	

	 // end login_execute()

}