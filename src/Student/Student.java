package Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;// array to string 출력에 필요
import java.util.Iterator;// iterator import

import Document.Document;
import Internship.ApplicationForInternship;

public class Student {

	/* 학생이 기본적으로 들고 있는 정보들 */
	private String ID;
	private String name;
	private String major;
	private String age;
	private String studentID;
	
	private ArrayList<String> ApplyInternshipName=new ArrayList<String>(); // 파일에서 읽어와야됨
	private ApplicationForInternship application; //apply 시만 사용하기때문에 읽어올 필요 x
	private Document Docu; //파일에서 읽어와야됨
	

	/* * * *           * * * */
	/* * * * Getter & Setter * * * */
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	public void setApplyInternshipName(){
		
		File applydir;
		int i;
		ApplyInternshipName=new ArrayList<String>();
		
		applydir = new File("./Student/"+ID+"/AppliedInternship");// Student/ID 디렉토리의 info.txt를 불러온다.
		if (applydir.exists() == false)
			System.out.println("[System] 신청한 인턴쉽이 없습니다.");

		else {
			String[] applyList=applydir.list(); //InterstingInternship 폴더의 [0] [1] [2] ....
			
			for(i=0;i<applyList.length;i++) {
				ApplyInternshipName.add(applyList[i]);
			}
			
		}
	}
	
	public ArrayList getApplyInternshipName(){
		return ApplyInternshipName;
	}
	public void setApplicationForInternship(String internship) {
		application = new ApplicationForInternship(this.ID , internship);
		
	}
	public ApplicationForInternship getApplicationForInternship() {
		return application;
		
	}
	
	public Document getDocu() {
		return this.Docu; //파일에서 읽어와야됨
	}
	
	/* * * * Getter & Setter * * * */
	
	public Student(String ID) throws IOException { //개인정보 등록  constructor 로 다시만들기// docu 부터 다시만들기
		
		File infofile; // student info 가 들어있는 txt file
		FileReader filereader = null;
		BufferedReader bufreader;
		File applydir; //apply internship 의 directory
		int i; // applylist 의 값을 setapplylist 함수로 현재 클래스의 member에 값을 집어넣기 위해 사용
		
		
		
		setID(ID); //입력받은 ID 를 기준으로 Student 객체 생성
		infofile = new File("./Student/"+ID+"/info.txt");// Student/ID 디렉토리의 info.txt를 불러온다.
		try {
			filereader = new FileReader(infofile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("[System] 등록되지 않은 사용자입니다. \n");
		}
		// 입력 스트림 생성
		
		
		bufreader = new BufferedReader(filereader); // 입력 버퍼 생성
		setName(bufreader.readLine());
		setAge(bufreader.readLine());
		setStudentID(bufreader.readLine());
		setMajor(bufreader.readLine());
		bufreader.close(); 
		// 기본적인 student info 입력
		
		applydir = new File("./Student/"+ID+"/AppliedInternship");// Student/ID 디렉토리의 info.txt를 불러온다.
		if (applydir.exists() == false)
			System.out.println("[System] 신청한 인턴쉽이 없습니다.");

		else {
			String[] applyList=applydir.list(); //InterstingInternship 폴더의 [0] [1] [2] ....
			
			for(i=0;i<applyList.length;i++) {
				ApplyInternshipName.add(applyList[i]);
			}
			
		}
		//apply list info 입력
		
		
			
		Docu=new Document("Student", this.ID);
		
		
		//Document;
		
	}

	public void print_info() { // +개인정보 출력

		System.out.println("");
		System.out.println("--------------------------개인정보 출력 메뉴입니다---------------------------");
		System.out.println("[1] "+ID+"님 기본 정보");
		System.out.println("이름 : "+getName());
		System.out.println("나이 : "+getAge());
		System.out.println("학번 : "+getStudentID());
		System.out.println("전공 : "+getMajor());
		//System.out.println("\n[2] "+ID+"님 추가 정보");
	}
	

	public void print_apply_internship() {
		Iterator apply_list=getApplyInternshipName().iterator(); //apply list 라는 iterator에 신청한 인턴쉽 목록을 대입하여 사용
		
		System.out.print("신청한 인턴쉽 목록 :");
		while(apply_list.hasNext()) {
			System.out.println(apply_list);
		}
	}


}



