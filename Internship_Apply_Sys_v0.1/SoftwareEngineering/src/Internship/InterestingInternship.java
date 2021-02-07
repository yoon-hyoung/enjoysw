package Internship;

import java.io.File;
import java.util.Scanner;

public class InterestingInternship {
	String ID; // 현재 로그인한 학생의 ID
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
	
	public void Intersting_apply() { // 관심인턴쉽 등록
		File file = new File("./Student/"+ID+"/InterestingInternship");
		if(file.exists() == false) {
			file.mkdir();
		}
		
		File interested = new File("./Student/"+ID+"/InterestingInternship/"+internshipName);
		if(interested.exists()==false) {
			interested.mkdir();
			System.out.printf("[System] 정상적으로 관심인턴쉽 등록이 완료되었습니다. (%d번 - %s)\n",indexNum, internshipName);
		}
		else {
			System.out.println("[System] 이미 관심인턴쉽으로 등록한 인턴쉽입니다.");
		}
		
	}
	
	public int Intersting_print() {
		int i=0;
		String internInfoPath;	
		File dir = new File("./Student/"+ID+"/InterestingInternship/");
		if (dir.exists() == false)
			System.out.println("[System] 관심 인턴쉽으로 등록된 인턴쉽이 없습니다.");

		else {
			String files[] = dir.list(); //InterstingInternship 폴더의 [0] [1] [2] ....
			
			if(files.length == 0) {
				System.out.println("[System] 관심 인턴쉽으로 등록된 인턴쉽이 없습니다.");
				return 0;
			}
			
			Internship[] internship = new Internship[10];

			while(i<files.length) {
				internInfoPath = "./Internship/"+files[i]+"/"+files[i]+".txt";
				internship[i] = new Internship(internInfoPath);
				i++;
			}
			System.out.println("\n--------------------관심 인턴쉽으로 등록한 인턴쉽 목록-----------------------");
			System.out.println("[인턴쉽 이름]  [인턴쉽 등록일]  [시행 기업]  [인턴쉽 기간]  [선발 일자]  [모집인원]  [모집국가]   [모집전공]  [시행처]");
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
	
	public void Intersting_delete() { // 관심인턴쉽 삭제
		int i=0;
		Scanner input = new Scanner(System.in);
		int inputIndex;
		File dir = new File("./Student/"+ID+"/InterestingInternship/");
		File delDir;
		String internInfoPath;
		String deleteDir;
		if (dir.exists() == false)
			System.out.println("[System] 관심 인턴쉽으로 등록된 인턴쉽이 없습니다.");
		else {
			
			String files[] = dir.list(); //InterstingInternship 폴더의 [0] [1] [2] ....
			Internship[] internship = new Internship[10];
			
			while(i<files.length) {
				internInfoPath = "./Internship/"+files[i]+"/"+files[i]+".txt";
				internship[i] = new Internship(internInfoPath);
				i++;
			}
			System.out.print("\n▶▶ 삭제할 관심 인턴쉽의 Index 번호를 입력하세요. (0을 입력 시 SKIP) >>> ");
			
			inputIndex = input.nextInt();
			if(inputIndex == 0)
				return;
			else if(indexNum > i) {
				System.out.print("[System] 목록에 없는 INDEX를 입력하셨습니다.\n");
				return;
			}
			
			delDir = new File("./Student/"+ID+"/InterestingInternship/"+internship[inputIndex-1].getname());
			if (delDir.exists() == true) {
				delDir.delete();
				System.out.println("[System] 정상적으로 해당 인턴쉽을 관심인턴쉽 목록에서 삭제하였습니다.");
			}
			
		}
	}


}
