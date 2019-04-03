package internship_apply_UI;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Document.Document;
import Foundation.*;
import Internship.InterestingInternship;
import Internship.Internship;
import Internship.Review;
import Student.Student;
public class StudentUI {

	Student s;
	Document docu;
	public StudentUI(Student student) throws IOException {
		s = student;
		docu = new Document("Student", s.getID());
		student_UI();
	}

	public void student_UI() throws IOException { // �л� UI... �޴� ���
		Main main = new Main();
		Scanner input = new Scanner(System.in);
		int input_num;
		

		while(true) {
			System.out.println("\n\n");
			System.out.println("-------------------------------< SELECT MENU >---------------------------");
			System.out.printf("%10s  %10s  %10s  %10s\n", "[�������� ��� : 1]", "[���� ���� : 2]", "[�������� ���� : 3]", "[���Ͻ� ���� ���� : 4]");
			System.out.printf("%10s  %10s  %10s  %10s\n", "[��� ���Ͻ� ��ȸ : 5]", "[���� ���Ͻ� ���� : 6]", "[���Ͻ� ��û : 7]", "[��û ���Ͻ� ���� : 8]");
			System.out.printf("[ ������� : 9]\n");
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("[�ȳ�] �α׾ƿ��� �Ͻ÷��� ���� 0 �� �Է��� �ּ���.");
			System.out.print("���� ���Ͻô� �޴��� ��ȣ�� �Է��� �ּ���. : ");
			input_num=input.nextInt();
			
			if ( input_num == 0 ) {
				return;
			}

			else if ( input_num == 1 ) { //�������� ���1
				s.print_info();
			}

			else if ( input_num == 2 ) {//���� ���1
				DocumentManager();
			}

			else if ( input_num == 3 ) {//�������� ����1
				s.edit_info();
			}

			else if ( input_num == 4 ) {//���Ͻ� ���� ����1
				//print_internship_list();
				s.apply_Simulation_intern();

			}
			else if ( input_num == 5 ) {//��� ���Ͻ� ��ȸ1
				
				add_interesting_internship();

			}
			else if ( input_num == 6 ) {//���� ���Ͻ� ����1
				print_interestingInternship();

			}
			else if ( input_num == 7 ) {//���Ͻ� ��û�ϱ�
				s.apply_intern();

			}
			else if ( input_num == 8 ) {//���Ͻ� �����ϱ�
				s.setting_intern();
			}
			else if (input_num == 9) {//�����ۼ�
				Review review = new Review();
				review.review_execute();
			}
		}

	}
	
	public void DocumentManager() {
		System.out.println("\n");
		//System.out.println("----------------------------------------------------------------------------");
		System.out.println("----------------------------���� ���� �޴��Դϴ�------------------------------");
		System.out.println("���� ������ �ִ� ���� ����Դϴ�.");
		docu.PrintDocumentList();
		System.out.print("���� ���Ͻô� �޴��� �����ϼ���. [��� : 1] [���� : 2] (0�� �Է� �� SKIP) >>> ");
		Scanner input1 = new Scanner(System.in);
		int flag = input1.nextInt();
		switch(flag){
		case 0:
			return;
		case 1:
			docu.AddDocument();
			break;
		case 2:
			docu.DelDocument();
			break;
			default :
				System.out.println("�߸��� �Է��Դϴ�.");
				
		}
	}
	
	public void print_internship_list() {
		int i=0;
		int indexNum;
		Scanner input = new Scanner(System.in);
		String dirName = "./Internship/";
		File dir = new File(dirName);
		String internInfoPath;
		String files[] = dir.list(); //[0]Apple [1]Google [2]Samsung
		Internship[] internship = new Internship[10];

		while(i<files.length) {
			internInfoPath = "./Internship/"+files[i]+"/"+files[i]+".txt";
			internship[i] = new Internship(internInfoPath);
			i++;
		}

		System.out.println("");
		System.out.println("---------------------------��� ���Ͻ��� ����մϴ�----------------------------");
		System.out.printf("%s %s %s %s %s %s %s %s %s %s\n", "[INDEX]","[���Ͻ� �̸�]","[���Ͻ� �����]", "[���� ���]", "[���Ͻ� �Ⱓ]",
					"[���� ����]", "[���� �ο�]", "[���� ����]", "[���� ����]", "[����ó]");
		for(int j= 0; j<i; j++) {
			System.out.printf(" [%d] %s / %d / %s / %s / %s / %s / %s / %s / %s\n",
					j+1, internship[j].getname(),internship[j].getdate(),internship[j].getcompany(),
					internship[j].getperiod(),internship[j].getrec_date(),internship[j].getselect_num(),
					internship[j].getnation(),internship[j].getmajor(),internship[j].gethost());
		}
		System.out.println("");
	}

	public void add_interesting_internship() {
		int i=0;
		int indexNum;
		Scanner input = new Scanner(System.in);
		String dirName = "./Internship/";
		File dir = new File(dirName);
		String internInfoPath;
		String files[] = dir.list(); //[0]Apple [1]Google [2]Samsung
		Internship[] internship = new Internship[10];

		while(i<files.length) {
			internInfoPath = "./Internship/"+files[i]+"/"+files[i]+".txt";
			internship[i] = new Internship(internInfoPath);
			i++;
		}

		System.out.println("");
		System.out.println("---------------------------��ü ���Ͻ� ����Դϴ�----------------------------");
		System.out.printf("%s %s %s %s %s %s %s %s %s %s\n", "[INDEX]","[���Ͻ� �̸�]","[���Ͻ� �����]", "[���� ���]", "[���Ͻ� �Ⱓ]",
					"[���� ����]", "[���� �ο�]", "[���� ����]", "[���� ����]", "[����ó]");
		for(int j= 0; j<i; j++) {
			System.out.printf(" [%d] %s / %d / %s / %s / %s / %s / %s / %s / %s\n",
					j+1, internship[j].getname(),internship[j].getdate(),internship[j].getcompany(),
					internship[j].getperiod(),internship[j].getrec_date(),internship[j].getselect_num(),
					internship[j].getnation(),internship[j].getmajor(),internship[j].gethost());
		}
		System.out.println("");
		System.out.print("���� ���� ���Ͻ����� ����Ϸ��� ���Ͻ��� Index ��ȣ�� �Է��ϼ���. (0�� �Է� �� ������� �ʰ� SKIP) >>> ");
		indexNum = input.nextInt();
		if (indexNum == 0)
			;
		else if(indexNum > i) {
			System.out.print("[System] ��Ͽ� ���� INDEX�� �Է��ϼ̽��ϴ�.\n");
			return;
		}
		// Student/ID/ �ؿ� InterestedInternship ������ �����Ѵ�.
		else if(indexNum != 0) {
			InterestingInternship interestingInternship =
					new InterestingInternship(s.getID(),internship[indexNum-1].getcompany(),indexNum,internship[indexNum-1].getname());
			interestingInternship.Intersting_apply();
		}
	}

	public void print_interestingInternship() {
		InterestingInternship interestingInternship = new InterestingInternship(s.getID());
		int c = interestingInternship.Intersting_print();
		if (c == 0) {
			return;

		}
		else {
			interestingInternship.Intersting_delete();
		}
	}

}
