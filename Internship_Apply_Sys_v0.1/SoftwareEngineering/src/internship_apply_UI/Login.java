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

	private int login_status; // ���� 0�̸� stduent, 1�̸� staff�� ���Ѵ�.

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

		String inputID; // ����ڷκ��� �Է¹޴� ID
		String PW = null; // ���� ������ �д� ��й�ȣ
		String inputPW; // ����ڷκ��� �Է¹޴� PW
		boolean loop = true;
		
		boolean loop2 = true;

		while(loop) {
			System.out.print("\n����������������������������������������������������������������������������������\n");
			System.out.printf("%65s\n", "�� ȭ���� �Ҽ� �� (7��) ^0^�� ");
			System.out.printf("%60s\n", "�ڡ� �ؿ����Ͻ� ��û �ý��� �ڡ�");
			System.out.print("����������������������������������������������������������������������������������\n");
			System.out.printf("%45s","[�ȳ�] ���α׷��� �����Ͻ÷��� X �� �Է��ϼ���.\n");
			System.out.print("====================================================================\n");
			System.out.print("����  [�л��α��� : 0 �Է�]  [�����α��� : 1 �Է�] >>>> ");
			cnt = input.next();
			
			if(cnt.equals("X")) System.exit(0);
			
			setLogin_status(Integer.parseInt(cnt));
			
			if (login_status == 0) // �л��α����� ���
			{
				while(loop2) {
					
					System.out.println("---------------------------------------------------------------------------");
					System.out.println("[System] �л��α����� �����ϼ̽��ϴ�. (ó������ ���ư����� X �Է�)");
					System.out.println("====================================================================");
					System.out.print("���� ���̵� �Է��� �ּ���. >>>> ");

					inputID = input.next();
					
					/*   home���� �ǵ��ư��� �ڵ�(����)   */
					if(inputID.equals("X")) break;
					/*        /////////////       */
					
					file = new File("./login_info/"+inputID+".txt");// login_info ���丮 ���� ID.txt�� �д´�.
					try {
						filereader = new FileReader(file);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.print("[System] ��ϵ��� ���� ID�Դϴ�. \n");
						continue; // ���̵� �Է��ϴ� ������ �����϶�.
					} // �Է� ��Ʈ�� ����


					bufreader = new BufferedReader(filereader); // �Է� ���� ����

					String job = "";
					try {
						job = bufreader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.err.print("[System] ��ϵ� ������ �����ϴ�. ");
						System.exit(1);
					} // ���� ������ student����, admin���� �ٽ� �ѹ� ù �ٷκ��� �޴´�.


					if ( !job.equals("student") ) {
						System.out.println("[System] �л����� ��ϵ� ID�� �ƴմϴ�.");
						continue;
					}

					else { // ���� ������ �ٽ� �� �� �л����� Ȯ�εǾ�����
						try {
							PW = bufreader.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.err.print("[System] ��ϵ� ������ �����ϴ�. ");
							System.exit(1);
						}

						System.out.print("���� ��й�ȣ�� �Է��� �ּ���. >>>> ");
						inputPW = input.next(); // ����ڷκ��� �н����带 �Է¹޴´�.
						
						/*   home���� �ǵ��ư��� �ڵ�(����)   */
						if(inputPW.equals("h")) break;
						/*        /////////////       */

						if ( !inputPW.equals(PW) ) { // ���Ͽ� ��ϵ� ��й�ȣ�� ������
							System.out.println("[System] ��й�ȣ�� Ʋ���ϴ�. �ٽ� ID ���Է��� ��û�մϴ�.\n");
							continue;	
						}
						else {
							System.out.print("\n[Loading] ��");
							Thread.sleep(100);
							System.out.print("��");
							Thread.sleep(100);
							System.out.print("��");
							Thread.sleep(100);
							System.out.print("��");
							Thread.sleep(100);
							System.out.print("��");
							Thread.sleep(80);
							System.out.print("��");
							Thread.sleep(80);
							System.out.print("��");
							Thread.sleep(70);
							System.out.print("��");
							Thread.sleep(60);
							System.out.print("��");
							Thread.sleep(50);
							System.out.print("��");
							Thread.sleep(40);
							System.out.print("��");
							Thread.sleep(30);
							System.out.println(" - [100%] \n");
							
							System.out.println("[System] �α��ο� �����Ͽ����ϴ�. " + inputID +"�� ȯ���մϴ�!");
							main.setID(inputID); // ID �Ѱ��ֱ�
							main.setStatus(0); // status �Ѱ��ֱ�
							loop = false;
							loop2 = false;
						}

					}
				}
			}

			else if (login_status == 1) // �����α����� ���
			{
				while(loop2) {
					
					System.out.println("---------------------------------------------------------------------------");
					System.out.println("[System] �����α����� �����ϼ̽��ϴ�. (ó������ ���ư����� X �Է�)");
					System.out.println("====================================================================");
					System.out.print("���� ���̵� �Է��� �ּ���. >>> ");

					inputID = input.next();
					
					/*   home���� �ǵ��ư��� �ڵ�(����)   */
					if(inputID.equals("X")) break;
					/*        /////////////       */
					
					file = new File("./login_info/"+inputID+".txt");// login_info ���丮 ���� ID.txt�� �д´�.
					try {
						filereader = new FileReader(file);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.print("[System] ��ϵ��� ���� ID�Դϴ�. \n");
						continue; // ���̵� �Է��ϴ� ������ �����϶�.
					} // �Է� ��Ʈ�� ����


					bufreader = new BufferedReader(filereader); // �Է� ���� ����

					String job = "";
					try {
						job = bufreader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.err.print("[System] ��ϵ� ������ �����ϴ�. ");
						System.exit(1);
					} // ���� ������ student����, admin���� �ٽ� �ѹ� ù �ٷκ��� �޴´�.


					if ( !job.equals("admin") ) {
						System.out.println("�����ڷ� ��ϵ� ID�� �ƴմϴ�.");
						continue;
					}

					else { // ���� ������ �ٽ� �� �� ���������� Ȯ�εǾ�����
						try {
							PW = bufreader.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.err.print("[System] ��ϵ� ������ �����ϴ�. ");
							System.exit(1);
						}

						System.out.print("���� ��й�ȣ�� �Է��� �ּ���. >>> ");
						inputPW = input.next(); // ����ڷκ��� �н����带 �Է¹޴´�.
						
						/*   home���� �ǵ��ư��� �ڵ�(����)   */
						if(inputPW.equals("h")) break;
						/*        /////////////       */

						if ( !inputPW.equals(PW) ) { // ���Ͽ� ��ϵ� ��й�ȣ�� ������
							System.out.print("[System] ��й�ȣ�� Ʋ���ϴ�. �ٽ� ID ���Է��� ��û�մϴ�.\n");
							continue;	
						}
						else {
							System.out.print("\n[Loading] ��");
							Thread.sleep(100);
							System.out.print("��");
							Thread.sleep(100);
							System.out.print("��");
							Thread.sleep(100);
							System.out.print("��");
							Thread.sleep(100);
							System.out.print("��");
							Thread.sleep(80);
							System.out.print("��");
							Thread.sleep(80);
							System.out.print("��");
							Thread.sleep(70);
							System.out.print("��");
							Thread.sleep(60);
							System.out.print("��");
							Thread.sleep(50);
							System.out.print("��");
							Thread.sleep(40);
							System.out.print("��");
							Thread.sleep(30);
							System.out.println(" - [100%] \n");
							System.out.println("[System] �α��ο� �����Ͽ����ϴ�. ������ ��带 �����մϴ�.");
							main.setID(inputID); // ID �Ѱ��ֱ�
							main.setStatus(1); // status �Ѱ��ֱ�
							loop = false;
							loop2 = false;
						}

					}
				}
				
				
			}


		}

	} // end login_execute()

}
