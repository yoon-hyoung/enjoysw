package Foundation;

import internship_apply_UI.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import Student.Student;

public class Main {
	static int status; //학생인지 관리자인지 상태를 Login 으로부터 받아서 여기에 담을 것임
	static String ID; //로그인한 사용자의 아이디
	private static Login login;
	public static int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public static String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		while(true) {
			login=new Login();
			Notification noti = new Notification();
			
			login.Login_execute();
		if ( status == 0 ) {// 학생이면
			// Student UI 로 넘어가라.
			noti.AllNoti(getID());
			Student student = new Student(getID());
			StudentUI ui = new StudentUI(student); // UI 객체 생성 및 UI 불러오기
			
		}
		else if ( status == 1 ) { // 관리자이면
			International_internship_staff_UI hi=new International_internship_staff_UI(status);
			// staff UI로 넘어가라.
		}
		}
	}

}
