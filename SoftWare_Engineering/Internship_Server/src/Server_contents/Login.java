package Server_contents;

import Foundation.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Login {

	private int login_status; // 값이 0이면 error, 1이면 student로 정한다.2 staff

	public Login(String ID,String Password) {
		String path="./login_info/";
		File loginDir = new File(path);
		File loginFile;
		String[] fileList = loginDir.list();
		int flag=0; // 해당하는 ID 찾았는지 여부
		int i; //iterator
		
		String PW = null; // 파일 내에서 읽는 비밀번호
		
		
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
				System.out.print("[System] 등록되지 않은 ID입니다. \n");
				setLogin_status(0);
				return ;
			}
			bufreader = new BufferedReader(filereader); // 입력 버퍼 생성
			
			String job = "";
			try {
				job = bufreader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("[System] 등록된 내용이 없습니다. ");
				System.exit(1);
			} // 파일 내에서 student인지, admin인지 다시 한번 첫 줄로부터 받는다.
			// 종류 읽기
			try {
				PW = bufreader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("[System] 등록된 내용이 없습니다. ");
				System.exit(1);
			}
			// 비밀번호 읽기
			
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
				
				System.out.print("[System] 등록되지 않은 PW입니다. \n");
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