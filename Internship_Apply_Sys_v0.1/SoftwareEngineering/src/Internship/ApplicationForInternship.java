package Internship;

import java.io.File;
import java.util.Scanner;

import Document.Document;

public class ApplicationForInternship {

	
	private String internship; // 신청하고자 하는 인턴쉽의 이름이 저장된다.
	private String studentID; // 로그인 중인 학생의 ID가 넘어온다.


	

	public ApplicationForInternship(String studentID, String internship) {
		this.studentID = studentID;
		this.internship = internship;
	}
	//Constructor 
	public String getInternship() {
		return internship;
	}

	public void setInternship(String internship) {
		this.internship = internship;
	}
	// get set part
	
	public void apply() { //+ 인턴쉽 지원하기( set file )
		Document docu = new Document("Student", this.studentID);//Document 부분수정
		File applydir = new File("./Student/"+studentID+"/"+"AppliedInternship");
		Scanner input = new Scanner(System.in);
		
		if(applydir.exists() == false) {
			applydir.mkdir(); 
		}
		
		// Student/ID/ 밑에, AppliedInternship 폴더를 만든다. (없을 경우에만)
		// 그 안에, 입력한 InternshipName 으로 된 폴더를 만든다.
		File inputDir = new File("./Student/"+studentID+"/AppliedInternship/"+internship);
		if(inputDir.exists() == false) {
			inputDir.mkdir(); 
			System.out.println("[System] 정상적으로 "+internship+" 인턴쉽 신청이 완료되었습니다.");
		}
		else {
			System.out.println("[System] 이미 신청되어 있는 인턴쉽입니다.");
		}
		
		//docu.NonRegistDocument(this.internship); //docu 수정

	}
	// apply함수를 이용해 file system 에등록
	public void cancel() { 
		
		File dir = new File("./Student/"+studentID+"/"+"AppliedInternship/"+internship);
		if(dir.exists()==true) {
			dir.delete(); // 경로에서 삭제한다.
			System.out.println("[System] 정상적으로 신청 정보를 삭제하였습니다.");
		}
	}
	// delete 함수르 통해 file system 에서 삭제

}
