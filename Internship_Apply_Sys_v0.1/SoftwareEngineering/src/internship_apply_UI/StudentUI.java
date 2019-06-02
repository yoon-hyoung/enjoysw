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

	public void student_UI() throws IOException { // 학생 UI... 메뉴 출력
		Main main = new Main();
		Scanner input = new Scanner(System.in);
		int input_num;
		

		while(true) {
			System.out.println("\n\n");
			System.out.println("-------------------------------< SELECT MENU >---------------------------");
			System.out.printf("%10s  %10s  %10s  %10s\n", "[개인정보 출력 : 1]", "[서류 관리 : 2]", "[개인정보 수정 : 3]", "[인턴쉽 모의 지원 : 4]");
			System.out.printf("%10s  %10s  %10s  %10s\n", "[모든 인턴쉽 조회 : 5]", "[관심 인턴쉽 관리 : 6]", "[인턴쉽 신청 : 7]", "[신청 인턴쉽 관리 : 8]");
			System.out.printf("[ 리뷰관리 : 9]\n");
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("[안내] 로그아웃을 하시려면 숫자 0 을 입력해 주세요.");
			System.out.print("▶▶ 원하시는 메뉴의 번호를 입력해 주세요. : ");
			input_num=input.nextInt();
			
			if ( input_num == 0 ) {
				return;
			}

			else if ( input_num == 1 ) { //개인정보 출력1
				s.print_info();
			}

			else if ( input_num == 2 ) {//서류 등록1
				DocumentManager();
			}

			else if ( input_num == 3 ) {//개인정보 수정1
				s.edit_info();
			}

			else if ( input_num == 4 ) {//인턴쉽 모의 지원1
				//print_internship_list();
				s.apply_Simulation_intern();

			}
			else if ( input_num == 5 ) {//모든 인턴쉽 조회1
				
				add_interesting_internship();

			}
			else if ( input_num == 6 ) {//관심 인턴쉽 관리1
				print_interestingInternship();

			}
			else if ( input_num == 7 ) {//인턴쉽 신청하기
				s.apply_intern();

			}
			else if ( input_num == 8 ) {//인턴쉽 관리하기
				s.setting_intern();
			}
			else if (input_num == 9) {//리뷰작성
				Review review = new Review();
				review.review_execute();
			}
		}

	}
	
	public void DocumentManager() {
		System.out.println("\n");
		//System.out.println("----------------------------------------------------------------------------");
		System.out.println("----------------------------서류 관리 메뉴입니다------------------------------");
		System.out.println("현재 가지고 있는 서류 목록입니다.");
		docu.PrintDocumentList();
		System.out.print("▶▶ 원하시는 메뉴를 선택하세요. [등록 : 1] [삭제 : 2] (0을 입력 시 SKIP) >>> ");
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
				System.out.println("잘못된 입력입니다.");
				
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
		System.out.println("---------------------------모든 인턴쉽을 출력합니다----------------------------");
		System.out.printf("%s %s %s %s %s %s %s %s %s %s\n", "[INDEX]","[인턴쉽 이름]","[인턴쉽 등록일]", "[시행 기업]", "[인턴쉽 기간]",
					"[선발 일자]", "[모집 인원]", "[모집 국가]", "[모집 전공]", "[시행처]");
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
		System.out.println("---------------------------전체 인턴쉽 목록입니다----------------------------");
		System.out.printf("%s %s %s %s %s %s %s %s %s %s\n", "[INDEX]","[인턴쉽 이름]","[인턴쉽 등록일]", "[시행 기업]", "[인턴쉽 기간]",
					"[선발 일자]", "[모집 인원]", "[모집 국가]", "[모집 전공]", "[시행처]");
		for(int j= 0; j<i; j++) {
			System.out.printf(" [%d] %s / %d / %s / %s / %s / %s / %s / %s / %s\n",
					j+1, internship[j].getname(),internship[j].getdate(),internship[j].getcompany(),
					internship[j].getperiod(),internship[j].getrec_date(),internship[j].getselect_num(),
					internship[j].getnation(),internship[j].getmajor(),internship[j].gethost());
		}
		System.out.println("");
		System.out.print("▶▶ 관심 인턴쉽으로 등록하려는 인턴쉽의 Index 번호를 입력하세요. (0을 입력 시 등록하지 않고 SKIP) >>> ");
		indexNum = input.nextInt();
		if (indexNum == 0)
			;
		else if(indexNum > i) {
			System.out.print("[System] 목록에 없는 INDEX를 입력하셨습니다.\n");
			return;
		}
		// Student/ID/ 밑에 InterestedInternship 폴더를 생성한다.
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

