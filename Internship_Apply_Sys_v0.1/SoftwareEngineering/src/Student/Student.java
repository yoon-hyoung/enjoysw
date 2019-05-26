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
	private int age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public void setApplyInternshipName(String ApplyInternshipName){
		this.ApplyInternshipName.add(ApplyInternshipName);
	}
	public ArrayList getApplyInternshipName(){
		return ApplyInternshipName;
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
		setAge(Integer.parseInt(bufreader.readLine()));
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
				setApplyInternshipName(applyList[i]);
			}
			
		}
		//apply list info 입력

		
		
		
		//Document;
		
	}

	public void print_info() throws IOException { // +개인정보 출력

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
	
	public void print_document() {
		
		
	}
	public void regist_document() {
		
		
	}
	public void delete_document() {
		
		
	}
	public void apply_intern(String applyInternship) { // +인턴쉽 신청


	//  System.out.println("");
	//	System.out.println("---------------------------인턴쉽 신청 메뉴입니다----------------------------");
	//	System.out.println("--------------------[현재 시스템에 등록된 인턴쉽 전체 목록]--------------------\n");
		// -> 현재 등록되어 있는 인턴쉽 목록들 모두 출력
	
		
	/*String internshipDirName = "./Internship/"; //intership directory
		
		File internshipDir = new File(internshipDirName);
		String files[] = internshipDir.list(); //[0]Apple [1]Google [2]Samsung
	*/	
	


		/*	System.out.printf("%s %s %s %s %s %s %s %s %s %s\n", "[INDEX]","[인턴쉽 이름]","[인턴쉽 등록일]", "[시행 기업]", "[인턴쉽 기간]",
				"[선발 일자]", "[모집 인원]", "[모집 국가]", "[모집 전공]", "[시행처]");
		for(int j= 0; j<i; j++) {
			/*System.out.printf(" [%d] %s / %d / %s / %s / %s / %s / %s / %s / %s\n",
					j+1, internship[j].getname(),internship[j].getdate(),internship[j].getcompany(),
					internship[j].getperiod(),internship[j].getrec_date(),internship[j].getselect_num(),
					internship[j].getnation(),internship[j].getmajor(),internship[j].gethost());
			System.out.printf("[%d]",j+1);
			internship[j].printAll();
					
		}*/ //여기서부터는 studentUI 에서 구현하는게 맞는듯 하다.
		/*System.out.println("");

		// -> 신청하고자 하는 인턴쉽 이름 입력
		System.out.print("▶▶ 신청할 인턴쉽의 INDEX 번호를 입력해 주세요. (0을 입력 시 SKIP) >>>> ");

		indexNum = input.nextInt();
		if (indexNum == 0)
			return ;
		else if(indexNum > i) {
			System.out.print("[System] 목록에 없는 INDEX를 입력하셨습니다.\n");
			return;
		}*/
		application = new ApplicationForInternship(getID(),applyInternship);// apply 할 대상 넣어주기
		application.apply(); // file set
	
	}
	
	public void cancel_intern(String cancelInternship) {
		
		application = new ApplicationForInternship(getID(),cancelInternship);// cancel 할 대상 넣어주기
		application.cancel();
	}

}



/*public void setting_intern() { // +인턴쉽 관리하기
String InternshipName;
String internInfoPath;
int i=0;
int indexNum;
File dir = new File("./Student/"+ID+"/"+"AppliedInternship");
String files[] = dir.list(); // [0], [1], [2],....
Scanner input = new Scanner(System.in);

System.out.println("");
System.out.println("------------------------인턴쉽 신청 관리 메뉴입니다--------------------------");
// 신청되어 있는 인턴쉽 출력

if(files.length == 0) {
	System.out.println("[System] 관리할 인턴쉽이 없습니다. (인턴쉽 신청 정보 없음)");
	return;
}

else {
	Internship[] internship = new Internship[10];

	while(i<files.length) {
		internInfoPath = "./Internship/"+files[i]+"/"+files[i]+".txt";
		internship[i] = new Internship(internInfoPath);
		i++;
	}
	System.out.println("----------------------------- 현재 내가 신청한 인턴쉽 목록 -----------------------------");
	System.out.println("[인턴쉽 이름]  [인턴쉽 등록일]  [시행 기업]  [인턴쉽 기간]  [선발 일자]  [모집인원]  [모집국가]   [모집전공]  [시행처]");
	for(int j= 0; j<i; j++) {
		System.out.printf("[%d] %s / %d / %s / %s / %s / %s / %s / %s / %s\n",
				j+1, internship[j].getname(),internship[j].getdate(),internship[j].getcompany(),
				internship[j].getperiod(),internship[j].getrec_date(),internship[j].getselect_num(),
				internship[j].getnation(),internship[j].getmajor(),internship[j].gethost());
	}

	System.out.print("\n▶▶ 취소할 인턴쉽의 INDEX 번호를 입력해 주세요. (0을 입력 시 SKIP) >>>> ");
	indexNum = input.nextInt();
	if (indexNum == 0)
		return ;
	else if(indexNum > i) {
		System.out.print("[System] 목록에 없는 INDEX를 입력하셨습니다.\n");
		return;
	}
	
	applicationForInternship = new ApplicationForInternship(getID(),internship[indexNum-1].getname());
	// ApplicationForInternship 클래스로 현재 로그인 중인 ID와, 입력받은 인턴쉽의 제목을 넘긴다.
	applicationForInternship.cancel(); // file set
}

}*/
