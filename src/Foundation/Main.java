package Foundation;

import internship_apply_UI.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import Student.Student;

public class Main {
	static int status; //�л����� ���������� ���¸� Login ���κ��� �޾Ƽ� ���⿡ ���� ����
	static String ID; //�α����� ������� ���̵�
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
		if ( status == 0 ) {// �л��̸�
			// Student UI �� �Ѿ��.
			noti.AllNoti(getID());
			Student student = new Student(getID());
			StudentUI ui = new StudentUI(student); // UI ��ü ���� �� UI �ҷ�����
			
		}
		else if ( status == 1 ) { // �������̸�
			International_internship_staff_UI hi=new International_internship_staff_UI(status);
			// staff UI�� �Ѿ��.
		}
		}
	}

}
