package Internship;

import java.io.File;
import java.util.Scanner;

public class InterestingInternship {
	String ID; // ���� �α����� �л��� ID
	String Company;
	int indexNum;
	String internshipName;
	private Internship internship;
	
	public InterestingInternship(String ID) {
		this.ID = ID;
	}
	
	public InterestingInternship(String ID, String Company, int indexNum, String name) {
		this.ID = ID;
		this.Company = Company;
		this.indexNum = indexNum;
		this.internshipName = name;
	}
	
	public void Intersting_apply() { // �������Ͻ� ���
		File file = new File("./Student/"+ID+"/InterestingInternship");
		if(file.exists() == false) {
			file.mkdir();
		}
		
		File interested = new File("./Student/"+ID+"/InterestingInternship/"+internshipName);
		if(interested.exists()==false) {
			interested.mkdir();
			System.out.printf("[System] ���������� �������Ͻ� ����� �Ϸ�Ǿ����ϴ�. (%d�� - %s)\n",indexNum, internshipName);
		}
		else {
			System.out.println("[System] �̹� �������Ͻ����� ����� ���Ͻ��Դϴ�.");
		}
		
	}
	
	public int Intersting_print() {
		int i=0;
		String internInfoPath;	
		File dir = new File("./Student/"+ID+"/InterestingInternship/");
		if (dir.exists() == false)
			System.out.println("[System] ���� ���Ͻ����� ��ϵ� ���Ͻ��� �����ϴ�.");

		else {
			String files[] = dir.list(); //InterstingInternship ������ [0] [1] [2] ....
			
			if(files.length == 0) {
				System.out.println("[System] ���� ���Ͻ����� ��ϵ� ���Ͻ��� �����ϴ�.");
				return 0;
			}
			
			Internship[] internship = new Internship[10];

			while(i<files.length) {
				internInfoPath = "./Internship/"+files[i]+"/"+files[i]+".txt";
				internship[i] = new Internship(internInfoPath);
				i++;
			}
			System.out.println("\n--------------------���� ���Ͻ����� ����� ���Ͻ� ���-----------------------");
			System.out.println("[���Ͻ� �̸�]  [���Ͻ� �����]  [���� ���]  [���Ͻ� �Ⱓ]  [���� ����]  [�����ο�]  [��������]   [��������]  [����ó]");
			for(int j= 0; j<i; j++) {
				System.out.printf("[%d]  %5s  / %5d / %3s / %3s / %3s / %3s / %3s / %3s / %3s\n",
						j+1, internship[j].getname(),internship[j].getdate(),internship[j].getcompany(),
								internship[j].getperiod(),internship[j].getrec_date(),internship[j].getselect_num(),
								internship[j].getnation(),internship[j].getmajor(),internship[j].gethost());
			}
			return 1;
		}
		return 0;
	}
	
	public void Intersting_delete() { // �������Ͻ� ����
		int i=0;
		Scanner input = new Scanner(System.in);
		int inputIndex;
		File dir = new File("./Student/"+ID+"/InterestingInternship/");
		File delDir;
		String internInfoPath;
		String deleteDir;
		if (dir.exists() == false)
			System.out.println("[System] ���� ���Ͻ����� ��ϵ� ���Ͻ��� �����ϴ�.");
		else {
			
			String files[] = dir.list(); //InterstingInternship ������ [0] [1] [2] ....
			Internship[] internship = new Internship[10];
			
			while(i<files.length) {
				internInfoPath = "./Internship/"+files[i]+"/"+files[i]+".txt";
				internship[i] = new Internship(internInfoPath);
				i++;
			}
			System.out.print("\n���� ������ ���� ���Ͻ��� Index ��ȣ�� �Է��ϼ���. (0�� �Է� �� SKIP) >>> ");
			
			inputIndex = input.nextInt();
			if(inputIndex == 0)
				return;
			else if(indexNum > i) {
				System.out.print("[System] ��Ͽ� ���� INDEX�� �Է��ϼ̽��ϴ�.\n");
				return;
			}
			
			delDir = new File("./Student/"+ID+"/InterestingInternship/"+internship[inputIndex-1].getname());
			if (delDir.exists() == true) {
				delDir.delete();
				System.out.println("[System] ���������� �ش� ���Ͻ��� �������Ͻ� ��Ͽ��� �����Ͽ����ϴ�.");
			}
			
		}
	}


}