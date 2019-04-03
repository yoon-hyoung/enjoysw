package Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import Document.Document;
import Internship.ApplicationForInternship;
import Internship.InterestingInternship;
import Internship.Internship;

public class Student {

	/* 학생이 기본적으로 들고 있는 정보들 */
	private String ID;
	private String name;
	private String major;
	private String studentID;
	private int acYear;
	private int age;
	private String inter_Country;
	private int inter_Term;
	private String inter_Company;

	private Internship internship;
	private ApplicationForInternship applicationForInternship;
	private Document document;
	private EvaluationItem evaluationItem;
	private InterestingInternship interestinginternship;

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
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public int getAcYear() {
		return acYear;
	}
	public void setAcYear(int acYear) {
		this.acYear = acYear;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getInter_Country() {
		return inter_Country;
	}
	public void setInter_Country(String inter_Country) {
		this.inter_Country = inter_Country;
	}
	public int getInter_Term() {
		return inter_Term;
	}
	public void setInter_Term(int inter_Term) {
		this.inter_Term = inter_Term;
	}
	public String getInter_Company() {
		return inter_Company;
	}
	public void setInter_Company(String inter_Company) {
		this.inter_Company = inter_Company;
	}
	/* * * * Getter & Setter * * * */

	//Counstructor
	public Student(String ID) {
		this.ID = ID;
		try {
			read_info();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MakeStorage();
		document = new Document("Student",ID);
		document.MakeStorage();
	}

	private void MakeStorage() {
		File file = new File("./Student/" + this.ID);
		if(!file.exists())
			file.mkdir();
	}
	//사용자 정보를 받아와서 SET 해주는 private 메소드
	private void read_info() throws IOException {
		File file;
		FileReader filereader = null;
		BufferedReader bufreader;
		//
		file = new File("./Student/"+ID+"/info.txt");// Student/ID 디렉토리의 info.txt를 불러온다.
		try {
			filereader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("[System] 등록되지 않은 사용자입니다. \n");
		}
		// 입력 스트림 생성
		bufreader = new BufferedReader(filereader); // 입력 버퍼 생성

		setName(bufreader.readLine());
		setAge(Integer.parseInt(bufreader.readLine()));
		setStudentID(bufreader.readLine());
		setAcYear(Integer.parseInt(bufreader.readLine()));
		setMajor(bufreader.readLine());
		setInter_Country(bufreader.readLine());
		setInter_Term(Integer.parseInt(bufreader.readLine()));
		setInter_Company(bufreader.readLine());

		bufreader.close();
		evaluationItem = new EvaluationItem(ID); // EvaluationItem에도 학생 ID를 넘긴다.
		evaluationItem.Evaluation_regist(); 	// 정보를 등록한다.
	}

	public void print_info() throws IOException { // +개인정보 출력

		System.out.println("");
		System.out.println("--------------------------개인정보 출력 메뉴입니다---------------------------");
		System.out.println("[1] "+ID+"님 기본 정보");
		System.out.println("이름 : "+getName());
		System.out.println("나이 : "+getAge());
		System.out.println("학번 : "+getStudentID());
		System.out.println("이수 학기 : "+getAcYear());
		System.out.println("전공 : "+getMajor());
		System.out.println("관심분야(지역/국가) : "+getInter_Country());
		System.out.println("관심분야(기간/개월) : "+getInter_Term());
		System.out.println("관심분야(기업) : "+getInter_Company());
		System.out.println("\n[2] "+ID+"님 추가 정보");
		evaluationItem.Evaluation_print();
	}
	
	

	public void edit_info() { // +개인정보 수정
		File file = new File("./Student/"+ID+"/info.txt");
		File intfile = new File("./Student/"+ID+"/Interested.txt");
		Scanner input = new Scanner(System.in);

		int editInt;
		String editString;

		int num;
		System.out.println("");
		System.out.println("--------------------------개인정보 수정 메뉴입니다---------------------------");
		System.out.println("[이름 : 1]  [나이 : 2]  [학번 : 3]  [이수 학기 : 4]  [전공 : 5]");
		System.out.println("[관심분야(지역) : 6]  [관심분야(기간) : 7]  [관심분야(기업) : 8]");
		System.out.print("▶▶ 수정할 항목의 번호를 입력해주세요. (0을 입력 시 SKIP) >>>> ");
		num = input.nextInt();

		switch(num) {
		case 0:
			return;
		case 1:{
			System.out.print("현재 이름 : "+getName());
			System.out.print("\n수정할 이름 입력 : ");
			editString = input.next();
			setName(editString);

			// 파일에 새로 쓴다.
			try {
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				pw.println(getName());
				pw.println(getAge());
				pw.println(getStudentID());
				pw.println(getAcYear());
				pw.println(getMajor());
				pw.println(getInter_Country());
				pw.println(getInter_Term());
				pw.println(getInter_Company());
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("[System] 수정에 실패하였습니다. 정보 파일을 확인해 주십시오.");
			}
			System.out.println("정상적으로 이름이 "+getName()+"(으)로 수정되었습니다");
			break;
		}
		case 2:{
			System.out.println("현재 나이 : "+getAge());
			System.out.print("수정할 나이 입력 : ");
			editInt = input.nextInt();
			setAge(editInt);
			// 파일에 새로 쓴다.
			try {
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				pw.println(getName());
				pw.println(getAge());
				pw.println(getStudentID());
				pw.println(getAcYear());
				pw.println(getMajor());
				pw.println(getInter_Country());
				pw.println(getInter_Term());
				pw.println(getInter_Company());
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("[System] 수정에 실패하였습니다. 정보 파일을 확인해 주십시오.");
			}
			System.out.println("정상적으로 나이가 "+getAge()+"(으)로 수정되었습니다");
			break;
		}
		case 3:{
			System.out.println("현재 학번 : "+getStudentID());
			System.out.print("수정할 학번 입력 : ");
			editString = input.next();
			setStudentID(editString);

			// 파일에 새로 쓴다.
			try {
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				pw.println(getName());
				pw.println(getAge());
				pw.println(getStudentID());
				pw.println(getAcYear());
				pw.println(getMajor());
				pw.println(getInter_Country());
				pw.println(getInter_Term());
				pw.println(getInter_Company());
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("[System] 수정에 실패하였습니다. 정보 파일을 확인해 주십시오.");
			}
			System.out.println("정상적으로 학번이 "+getStudentID()+"(으)로 수정되었습니다");
			break;
		}
		case 4:{
			System.out.println("현재 이수 학기 : "+getAcYear());
			System.out.print("수정할 이수 학기 입력 : ");
			editInt = input.nextInt();
			setAcYear(editInt);
			System.out.println("정상적으로 이수 학기가 "+getAcYear()+"(으)로 수정되었습니다");
			// 파일에 새로 쓴다.
			try {
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				pw.println(getName());
				pw.println(getAge());
				pw.println(getStudentID());
				pw.println(getAcYear());
				pw.println(getMajor());
				pw.println(getInter_Country());
				pw.println(getInter_Term());
				pw.println(getInter_Company());
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("[System] 수정에 실패하였습니다. 정보 파일을 확인해 주십시오.");
			}
			System.out.println("정상적으로 이수 학기가 "+getAcYear()+"(으)로 수정되었습니다");
			break;
		}
		case 5:{
			System.out.println("현재 전공 : "+getMajor());
			System.out.print("수정할 전공 입력 : ");
			editString = input.next();
			setMajor(editString);

			try {
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				pw.println(getName());
				pw.println(getAge());
				pw.println(getStudentID());
				pw.println(getAcYear());
				pw.println(getMajor());
				pw.println(getInter_Country());
				pw.println(getInter_Term());
				pw.println(getInter_Company());
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("[System] 수정에 실패하였습니다. 정보 파일을 확인해 주십시오.");
			}
			System.out.println("정상적으로 전공이 "+getMajor()+"(으)로 수정되었습니다");
			break;
		}
		case 6:{
			System.out.println("현재 관심분야(지역) : "+getInter_Country());
			System.out.print("수정할 관심 지역 입력 : ");
			editString = input.next();
			setInter_Country(editString);


			try {
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				PrintWriter intpw = new PrintWriter(new BufferedWriter(new FileWriter(intfile)));
				pw.println(getName());
				pw.println(getAge());
				pw.println(getStudentID());
				pw.println(getAcYear());
				pw.println(getMajor());
				pw.println(getInter_Country());
				pw.println(getInter_Term());
				pw.println(getInter_Company());
				intpw.println(getInter_Country());
				intpw.println(getInter_Term() + "개월");
				intpw.println(getInter_Company());
				pw.close();
				intpw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("[System] 수정에 실패하였습니다. 정보 파일을 확인해 주십시오.");
			}
			System.out.println("정상적으로 관심 분야가 "+getInter_Country()+"(으)로 수정되었습니다");
			break;
		}
		case 7:{
			System.out.println("현재 관심분야(기간) : "+getInter_Term());
			System.out.print("수정할 관심 기간 입력 : ");
			editInt = input.nextInt();
			setInter_Term(editInt);

			try {
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				PrintWriter intpw = new PrintWriter(new BufferedWriter(new FileWriter(intfile)));
				pw.println(getName());
				pw.println(getAge());
				pw.println(getStudentID());
				pw.println(getAcYear());
				pw.println(getMajor());
				pw.println(getInter_Country());
				pw.println(getInter_Term());
				pw.println(getInter_Company());
				intpw.println(getInter_Country());
				intpw.println(getInter_Term()+ "개월");
				intpw.println(getInter_Company());
				pw.close();
				intpw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("[System] 수정에 실패하였습니다. 정보 파일을 확인해 주십시오.");
			}
			System.out.println("정상적으로 관심 기간이 "+getInter_Term()+"(으)로 수정되었습니다");
			break;
		}
		case 8:{
			System.out.println("현재 관심분야(기업) : "+getInter_Company());
			System.out.print("수정할 관심 기업 입력 : ");
			editString = input.next();
			setInter_Company(editString);

			try {
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				PrintWriter intpw = new PrintWriter(new BufferedWriter(new FileWriter(intfile)));
				pw.println(getName());
				pw.println(getAge());
				pw.println(getStudentID());
				pw.println(getAcYear());
				pw.println(getMajor());
				pw.println(getInter_Country());
				pw.println(getInter_Term());
				pw.println(getInter_Company());
				intpw.println(getInter_Country());
				intpw.println(getInter_Term()+ "개월");
				intpw.println(getInter_Company());
				pw.close();
				intpw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("[System] 수정에 실패하였습니다. 정보 파일을 확인해 주십시오.");
			}
			System.out.println("정상적으로 관심 기업이 "+getInter_Company()+"(으)로 수정되었습니다");
			break;

		}
		}

	}

	public void reg_personInfo() {

	}

	public void apply_intern() { // +인턴쉽 신청

		Scanner input = new Scanner(System.in);
		String InternshipName;
		String internship_file;
		System.out.println("");
		System.out.println("---------------------------인턴쉽 신청 메뉴입니다----------------------------");
		System.out.println("--------------------[현재 시스템에 등록된 인턴쉽 전체 목록]--------------------\n");
		// -> 현재 등록되어 있는 인턴쉽 목록들 모두 출력

		int i=0;
		String dirName = "./Internship/";
		File dir = new File(dirName);
		String internInfoPath;
		String files[] = dir.list(); //[0]Apple [1]Google [2]Samsung
		Internship[] internship = new Internship[10];
		int indexNum;

		while(i<files.length) {
			internInfoPath = "./Internship/"+files[i]+"/"+files[i]+".txt";
			internship[i] = new Internship(internInfoPath);
			i++;
		}
		System.out.printf("%s %s %s %s %s %s %s %s %s %s\n", "[INDEX]","[인턴쉽 이름]","[인턴쉽 등록일]", "[시행 기업]", "[인턴쉽 기간]",
				"[선발 일자]", "[모집 인원]", "[모집 국가]", "[모집 전공]", "[시행처]");
		for(int j= 0; j<i; j++) {
			/*System.out.printf(" [%d] %s / %d / %s / %s / %s / %s / %s / %s / %s\n",
					j+1, internship[j].getname(),internship[j].getdate(),internship[j].getcompany(),
					internship[j].getperiod(),internship[j].getrec_date(),internship[j].getselect_num(),
					internship[j].getnation(),internship[j].getmajor(),internship[j].gethost());*/
			System.out.printf("[%d]",j+1);
			internship[j].printAll();
					
		}
		System.out.println("");

		// -> 신청하고자 하는 인턴쉽 이름 입력
		System.out.print("▶▶ 신청할 인턴쉽의 INDEX 번호를 입력해 주세요. (0을 입력 시 SKIP) >>>> ");

		indexNum = input.nextInt();
		if (indexNum == 0)
			return ;
		else if(indexNum > i) {
			System.out.print("[System] 목록에 없는 INDEX를 입력하셨습니다.\n");
			return;
		}

		applicationForInternship = new ApplicationForInternship(getID(),internship[indexNum-1].getname());
		// ApplicationForInternship 클래스로 현재 로그인 중인 ID와, 입력받은 인턴쉽의 제목을 넘긴다.
		applicationForInternship.apply(); // file set

	}

	public void setting_intern() { // +인턴쉽 관리하기
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

	}

	public void apply_Simulation_intern() throws IOException { // +인턴쉽 모의지원
		File file;
		FileReader filereader = null;
		String last_Grade;
		int last_TOEIC, last_langSch;
		String last_cert;
		int last_oversea_exp;

		int passCount=0;

		Scanner input = new Scanner(System.in);
		String simul_InternshipName;
		
		System.out.println("");
		//System.out.println("--------------------------인턴쉽 모의 지원 메뉴입니다.----------------------");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("[안내] 해당 인턴쉽의 작년 합격 정보와 비교하고 모의 합불 여부를 판단하여 출력해 드립니다.  ");
		System.out.println("----------------------------------------------------------------------------");

		int i=0;
		String dirName = "./Internship/";
		File dir = new File(dirName);
		String internInfoPath;
		String files[] = dir.list(); //[0]Apple [1]Google [2]Samsung
		Internship[] internship = new Internship[10];
		int indexNum;

		while(i<files.length) {
			internInfoPath = "./Internship/"+files[i]+"/"+files[i]+".txt";
			internship[i] = new Internship(internInfoPath);
			i++;
		}
		
		
		System.out.printf("%s %s %s %s %s %s %s %s %s %s\n", "[INDEX]","[인턴쉽 이름]","[인턴쉽 등록일]", "[시행 기업]", "[인턴쉽 기간]",
				"[선발 일자]", "[모집 인원]", "[모집 국가]", "[모집 전공]", "[시행처]\n");
		for(int j= 0; j<i; j++) {
			/*System.out.printf(" [%d] %s / %d / %s / %s / %s / %s / %s / %s / %s\n",
					j+1, internship[j].getname(),internship[j].getdate(),internship[j].getcompany(),
					internship[j].getperiod(),internship[j].getrec_date(),internship[j].getselect_num(),
					internship[j].getnation(),internship[j].getmajor(),internship[j].gethost());*/
			System.out.printf("  [%d]",j+1);
			internship[j].printAll();
		}
		System.out.println("");

		System.out.print("▶▶ 모의지원할 인턴쉽의 INDEX 를 입력해 주세요. (0을 입력 시 SKIP) >>> ");
		indexNum = input.nextInt();
		if (indexNum == 0)
			return ;
		else if(indexNum > i) {
			System.out.print("[System] 목록에 없는 INDEX를 입력하셨습니다.\n");
			return;
		}

		file = new File("./Internship/"+internship[indexNum-1].getname()+"/LastPassCondition.txt");
		try {
			filereader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("[System] 작년 합격정보를 불러오는데 실패하였습니다. \n");
		}
		BufferedReader bufreader = new BufferedReader(filereader);

		// 모의지원을 하려고 입력한 인턴쉽의 LastPassCondition.txt 파일을 읽을 것이다.
		System.out.println("\n☞ 모의지원한 인턴쉽 이름 : "+internship[indexNum-1].getname());
		// 비교하기
		System.out.println("\n				<       현재 사용자 정보          >   //   <       작년 합격자 정보          >");
		last_Grade = bufreader.readLine();
		System.out.println("[	(1)학점	]				"+evaluationItem.getGrade()+"						"+last_Grade);
		last_TOEIC = Integer.parseInt(bufreader.readLine());
		System.out.println("[	(2)토익	]				"+evaluationItem.getTOEIC()+"						"+last_TOEIC);
		last_langSch = Integer.parseInt(bufreader.readLine());
		System.out.println("[(3)어학원 수업여부  ]				"+evaluationItem.getLangSch()+"						"+last_langSch);
		last_cert = bufreader.readLine();
		System.out.println("[(4)컴퓨터 자격증    ]			"+evaluationItem.getCert()+"		  "+last_cert);
		last_oversea_exp = Integer.parseInt(bufreader.readLine());
		System.out.println("[(5)해외경험(교환학생,인턴쉽)]  		"+evaluationItem.getOversea_exp()+"						"+last_oversea_exp);
		System.out.println("");

		if(Double.parseDouble(evaluationItem.getGrade()) < Double.parseDouble(last_Grade)) { // 작년 학점이 더 높으면
			System.out.println("[COMMENT] 작년의 합격 학점보다 사용자의 학점이 낮습니다.");
			passCount++;
		}
		if(Double.parseDouble(evaluationItem.getGrade()) >= Double.parseDouble(last_Grade))  // 작년 학점보다 높으면
			System.out.println("[COMMENT] 작년의 합격 학점보다 사용자의 학점이 높거나 같습니다.");

		if(evaluationItem.getTOEIC() < last_TOEIC) {  // 작년 학점보다 높으면
			System.out.println("[COMMENT] 작년의 합격 토익점수보다 사용자의 토익점수가 낮습니다.");
			passCount++;
		}
		if(evaluationItem.getTOEIC() >= last_TOEIC) // 작년 학점보다 높으면
			System.out.println("[COMMENT] 작년의 합격 토익점수보다 사용자의 토익점수가 높거나 같습니다.");

		if(evaluationItem.getLangSch() == 1 && last_langSch == 1)
			System.out.println("[COMMENT] 작년 합격자는 어학원을 수강했고, 사용자도 수강하였습니다.");
		if(evaluationItem.getLangSch() == 1 && last_langSch == 0)
			System.out.println("[COMMENT] 작년 합격자는 어학원을 수강하지 않았지만, 사용자는 수강하였습니다.");
		if(evaluationItem.getLangSch() == 0 && last_langSch == 1)
			System.out.println("[COMMENT] 작년 합격자는 어학원을 수강했지만, 사용자는 수강하지 않았습니다.");
		if(evaluationItem.getLangSch() == 0 && last_langSch == 0)
			System.out.println("[COMMENT] 작년 합격자는 어학원을 수강하지 않았고, 사용자도 수강하지 않았습니다.");

		if(evaluationItem.getOversea_exp() == 1 && last_oversea_exp == 1)
			System.out.println("[COMMENT] 작년 합격자는 해외 경험이 있었고, 사용자도 해외 경험이 있습니다.");
		if(evaluationItem.getLangSch() == 1 && last_oversea_exp == 0)
			System.out.println("[COMMENT] 작년 합격자는 해외 경험이 없었지만, 사용자는 해외 경험이 있습니다.");
		if(evaluationItem.getLangSch() == 0 && last_oversea_exp == 1)
			System.out.println("[COMMENT] 작년 합격자는 해외 경험이 있었지만, 사용자는 해외 경험이 없습니다.");
		if(evaluationItem.getLangSch() == 0 && last_oversea_exp == 0)
			System.out.println("[COMMENT] 작년 합격자는 해외 경험이 없었고, 사용자도 해외 경험이 없습니다.");

		if(passCount == 0)
			System.out.println("**[RESULT]** 위의 결과들로 볼 때, "+ID+" 님은 작년 합격정보 기준으로 [합격] 이십니다!");
		else if(passCount != 0)
			System.out.println("**[RESULT]** 위의 결과들로 볼 때, "+ID+" 님은 작년 합격정보 기준보다 조금 낮으십니다.");

	}

}
