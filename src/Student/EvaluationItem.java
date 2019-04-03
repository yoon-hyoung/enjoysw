package Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EvaluationItem { // 평가에 필요한 항목 정보

	private String grade; // 학점
	private int TOEIC; // 토익점수
	private int langSch; // 어학원 수업 여부 - 0이면 false, 1이면 true
	private String cert; // 컴퓨터 관련 자격증 정보
	private int oversea_exp; // 해외 경험(교환학생, 인턴쉽, ..) 여부 - 0이면 f, 1이면 t
	private String ID; // Student로부터 현재 학생의 ID를 저장하기 위함


	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getTOEIC() {
		return TOEIC;
	}

	public void setTOEIC(int tOEIC) {
		TOEIC = tOEIC;
	}

	public int getLangSch() {
		return langSch;
	}

	public void setLangSch(int langSch) {
		this.langSch = langSch;
	}

	public String getCert() {
		return cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
	}

	public int getOversea_exp() {
		return oversea_exp;
	}

	public void setOversea_exp(int oversea_exp) {
		this.oversea_exp = oversea_exp;
	}

	//생성자
	public EvaluationItem() {
		
	}
	public EvaluationItem(String ID) {
		this.ID = ID;
	}

	public void Evaluation_regist() throws IOException { // Evaluation 관련 정보를 등록하고 수정하는 메소드
		File file;
		FileReader filereader = null;
		BufferedReader bufreader;
		file = new File("./Student/"+ID+"/evaluationitem.txt");
		// Student/ID 디렉토리의 evaluationn.txt를 불러온다.
		try {
			filereader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("[System] 등록되지 않은 사용자입니다. \n");
		}
		// 입력 스트림 생성
		bufreader = new BufferedReader(filereader); // 입력 버퍼 생성
		// 파일로부터 읽어오기
		setGrade(bufreader.readLine());
		setTOEIC(Integer.parseInt(bufreader.readLine()));
		setLangSch(Integer.parseInt(bufreader.readLine()));
		setCert(bufreader.readLine());
		setOversea_exp(Integer.parseInt(bufreader.readLine()));

	}

	public void Evaluation_print() { // Evaluation 관련 정보를 출력한다.

		System.out.println("학점 : "+getGrade());
		System.out.println("토익 : "+getTOEIC()+"점");

		if(getLangSch()==0)
			System.out.println("어학원 수업 여부 : YES");
		else
			System.out.println("어학원 수업 여부 : NO");

		System.out.println("컴퓨터 관련 자격증 : "+getCert());

		if(getOversea_exp()==0)
			System.out.println("해외 경험(교환학생,인턴쉽 등) : YES");
		else
			System.out.println("해외 경험(교환학생,인턴쉽 등) : NO");
	}

}
