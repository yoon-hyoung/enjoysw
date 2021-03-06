package ClientConsole;

import Student.*;
import Document.*;
import Internship.*;
import java.io.Serializable;

public class MessageHandler implements Serializable{

	int optNumber;
	/*
	0 초기화 // Student_Server에서는 Student 객체하나와 Internship 전체보내기
	1 Internship 초기화 // 서류를 수정해주고
	2 인턴쉽 신청
	3. 인턴쉽 신청 취소
	4. 서류 등록
	5. 서류 삭제
	6. 리뷰 등록
	7. 리뷰 세부 내용 요청

	Staff 영역
	8 인턴쉽 초기화
	9. 인턴쉽 등록
	10 인턴쉽 삭제
	11 리뷰 삭제 요청
	
	login 영역
	12 ID ,Password 비교
	13 state 발송 0 error 1 student 2 staff
	 */
	private Student student_temp;
	private Internship[] internship;
	private String ID;
	private String Password;
	private int login_state;
	
	
	public void setoptNumber(int optNumber) {
		this.optNumber=optNumber;
	}
	public void setInternship(Internship[] internship) {
		this.internship=internship;
	}
	public void setID(String ID) {
		this.ID=ID;
	}
	public void setPassword(String Password) {
		this.Password=Password;
	}
	public void setStudent(Student student) {
		this.student_temp=student;
	
	}
	public void setLogin_state(int login_state) {
		this.login_state=login_state;
	}
	public Student getStudent() {
		return student_temp;
	}
	public Internship[] getInternship() {
		return internship;
	}
	public String getID() {
		return ID;
	}
	public String getPassword() {
		return Password;
	}
	public int getLogin_state() {
		return login_state;
	}
	
}
