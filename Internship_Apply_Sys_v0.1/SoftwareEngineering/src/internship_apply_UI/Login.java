package internship_apply_UI;

import Foundation.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Login {

	private int login_status; // 값이 0이면 stduent, 1이면 staff로 정한다.

	public int getLogin_status() {
		return login_status;
	}

	public void setLogin_status(int login_status) {
		this.login_status = login_status;
	} 
	
	public void Login_execute() throws InterruptedException{
		Main main = new Main();
		
		File file;
		FileReader filereader = null;
		BufferedReader bufreader;
		Scanner input = new Scanner(System.in);
		String cnt;

		String inputID; // 사용자로부터 입력받는 ID
		String PW = null; // 파일 내에서 읽는 비밀번호
		String inputPW; // 사용자로부터 입력받는 PW
		boolean loop = true;
		
		boolean loop2 = true;

		while(loop) {
			System.out.print("\n┌───────────────────────────────────────┐\n");
			System.out.printf("%65s\n", "★ 화목한 소설 팀 (7조) ^0^★ ");
			System.out.printf("%60s\n", "★★ 해외인턴쉽 신청 시스템 ★★");
			System.out.print("└───────────────────────────────────────┘\n");
			System.out.printf("%45s","[안내] 프로그램을 종료하시려면 X 를 입력하세요.\n");
			System.out.print("====================================================================\n");
			System.out.print("▶▶  [학생로그인 : 0 입력]  [직원로그인 : 1 입력] >>>> ");
			cnt = input.next();
			
			if(cnt.equals("X")) System.exit(0);
			
			setLogin_status(Integer.parseInt(cnt));
			
			if (login_status == 0) // 학생로그인일 경우
			{
				while(loop2) {
					
					System.out.println("---------------------------------------------------------------------------");
					System.out.println("[System] 학생로그인을 선택하셨습니다. (처음으로 돌아가려면 X 입력)");
					System.out.println("====================================================================");
					System.out.print("▶▶ 아이디를 입력해 주세요. >>>> ");

					inputID = input.next();
					
					/*   home으로 되돌아가는 코드(공통)   */
					if(inputID.equals("X")) break;
					/*        /////////////       */
					
					file = new File("./login_info/"+inputID+".txt");// login_info 디렉토리 밑의 ID.txt를 읽는다.
					try {
						filereader = new FileReader(file);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.print("[System] 등록되지 않은 ID입니다. \n");
						continue; // 아이디를 입력하는 곳부터 시작하라.
					} // 입력 스트림 생성


					bufreader = new BufferedReader(filereader); // 입력 버퍼 생성

					String job = "";
					try {
						job = bufreader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.err.print("[System] 등록된 내용이 없습니다. ");
						System.exit(1);
					} // 파일 내에서 student인지, admin인지 다시 한번 첫 줄로부터 받는다.


					if ( !job.equals("student") ) {
						System.out.println("[System] 학생으로 등록된 ID가 아닙니다.");
						continue;
					}

					else { // 파일 내에서 다시 한 번 학생임이 확인되었으면
						try {
							PW = bufreader.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.err.print("[System] 등록된 내용이 없습니다. ");
							System.exit(1);
						}

						System.out.print("▶▶ 비밀번호를 입력해 주세요. >>>> ");
						inputPW = input.next(); // 사용자로부터 패스워드를 입력받는다.
						
						/*   home으로 되돌아가는 코드(공통)   */
						if(inputPW.equals("h")) break;
						/*        /////////////       */

						if ( !inputPW.equals(PW) ) { // 파일에 등록된 비밀번호와 같으면
							System.out.println("[System] 비밀번호가 틀립니다. 다시 ID 재입력을 요청합니다.\n");
							continue;	
						}
						else {
							System.out.print("\n[Loading] ■");
							Thread.sleep(100);
							System.out.print("■");
							Thread.sleep(100);
							System.out.print("■");
							Thread.sleep(100);
							System.out.print("■");
							Thread.sleep(100);
							System.out.print("■");
							Thread.sleep(80);
							System.out.print("■");
							Thread.sleep(80);
							System.out.print("■");
							Thread.sleep(70);
							System.out.print("■");
							Thread.sleep(60);
							System.out.print("■");
							Thread.sleep(50);
							System.out.print("■");
							Thread.sleep(40);
							System.out.print("■");
							Thread.sleep(30);
							System.out.println(" - [100%] \n");
							
							System.out.println("[System] 로그인에 성공하였습니다. " + inputID +"님 환영합니다!");
							main.setID(inputID); // ID 넘겨주기
							main.setStatus(0); // status 넘겨주기
							loop = false;
							loop2 = false;
						}

					}
				}
			}

			else if (login_status == 1) // 직원로그인일 경우
			{
				while(loop2) {
					
					System.out.println("---------------------------------------------------------------------------");
					System.out.println("[System] 직원로그인을 선택하셨습니다. (처음으로 돌아가려면 X 입력)");
					System.out.println("====================================================================");
					System.out.print("▶▶ 아이디를 입력해 주세요. >>> ");

					inputID = input.next();
					
					/*   home으로 되돌아가는 코드(공통)   */
					if(inputID.equals("X")) break;
					/*        /////////////       */
					
					file = new File("./login_info/"+inputID+".txt");// login_info 디렉토리 밑의 ID.txt를 읽는다.
					try {
						filereader = new FileReader(file);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.print("[System] 등록되지 않은 ID입니다. \n");
						continue; // 아이디를 입력하는 곳부터 시작하라.
					} // 입력 스트림 생성


					bufreader = new BufferedReader(filereader); // 입력 버퍼 생성

					String job = "";
					try {
						job = bufreader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.err.print("[System] 등록된 내용이 없습니다. ");
						System.exit(1);
					} // 파일 내에서 student인지, admin인지 다시 한번 첫 줄로부터 받는다.


					if ( !job.equals("admin") ) {
						System.out.println("관리자로 등록된 ID가 아닙니다.");
						continue;
					}

					else { // 파일 내에서 다시 한 번 관리자임이 확인되었으면
						try {
							PW = bufreader.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.err.print("[System] 등록된 내용이 없습니다. ");
							System.exit(1);
						}

						System.out.print("▶▶ 비밀번호를 입력해 주세요. >>> ");
						inputPW = input.next(); // 사용자로부터 패스워드를 입력받는다.
						
						/*   home으로 되돌아가는 코드(공통)   */
						if(inputPW.equals("h")) break;
						/*        /////////////       */

						if ( !inputPW.equals(PW) ) { // 파일에 등록된 비밀번호와 같으면
							System.out.print("[System] 비밀번호가 틀립니다. 다시 ID 재입력을 요청합니다.\n");
							continue;	
						}
						else {
							System.out.print("\n[Loading] ■");
							Thread.sleep(100);
							System.out.print("■");
							Thread.sleep(100);
							System.out.print("■");
							Thread.sleep(100);
							System.out.print("■");
							Thread.sleep(100);
							System.out.print("■");
							Thread.sleep(80);
							System.out.print("■");
							Thread.sleep(80);
							System.out.print("■");
							Thread.sleep(70);
							System.out.print("■");
							Thread.sleep(60);
							System.out.print("■");
							Thread.sleep(50);
							System.out.print("■");
							Thread.sleep(40);
							System.out.print("■");
							Thread.sleep(30);
							System.out.println(" - [100%] \n");
							System.out.println("[System] 로그인에 성공하였습니다. 관리자 모드를 시작합니다.");
							main.setID(inputID); // ID 넘겨주기
							main.setStatus(1); // status 넘겨주기
							loop = false;
							loop2 = false;
						}

					}
				}
				
				
			}


		}

	} // end login_execute()

}
