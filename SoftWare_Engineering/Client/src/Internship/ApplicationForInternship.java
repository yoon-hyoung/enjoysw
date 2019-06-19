package Internship;

import java.io.File;
import java.util.Scanner;

import Document.Document;

public class ApplicationForInternship {

	private Internship internship;
	private String InternshipName; // 신청하고자 하는 인턴쉽의 이름이 저장된다.
	private String ID; // 로그인 중인 학생의 ID가 넘어온다.


	public Internship getInternship() {
		return internship;
	}

	public void setInternship(Internship internship) {
		this.internship = internship;
	}

	public String getInternshipName() {
		return InternshipName;
	}

	public void setInternshipName(String internshipName) {
		InternshipName = internshipName;
	}

	public ApplicationForInternship(String ID, String InternshipName) {
		this.ID = ID;
		this.InternshipName = InternshipName;
	}

	public void apply() { //+ 인턴쉽 지원하기( set file )
		Document docu = new Document("Student", this.ID);
		File dir = new File("./Student/"+ID+"/"+"AppliedInternship");
		Scanner input = new Scanner(System.in);
		
		if(dir.exists() == false) {
			dir.mkdir(); 
		}
		
		// Student/ID/ 밑에, AppliedInternship 폴더를 만든다. (없을 경우에만)
		// 그 안에, 입력한 InternshipName 으로 된 폴더를 만든다.
		File inputDir = new File("./Student/"+ID+"/AppliedInternship/"+InternshipName);
		if(inputDir.exists() == false) {
			inputDir.mkdir(); 
			System.out.println("[System] 정상적으로 "+InternshipName+" 인턴쉽 신청이 완료되었습니다.");
		}
		else {
			System.out.println("[System] 이미 신청되어 있는 인턴쉽입니다.");
		}
		
		docu.NonRegistDocument(this.InternshipName);

	}
	public void cancel() { //+ 인턴쉽 지원취소
		File dir = new File("./Student/"+ID+"/"+"AppliedInternship/"+InternshipName);
		if(dir.exists()==true) {
			dir.delete(); // 경로에서 삭제한다.
			System.out.println("[System] 정상적으로 신청 정보를 삭제하였습니다.");
		}
	}

	public void print_applying() {//+ 신청한 인턴쉽 출력

	}
}
