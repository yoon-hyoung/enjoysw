package ClientConsole;

import Student.*;
import Document.*;
import Internship.*;
import java.io.Serializable;

public class MessageHandler implements Serializable{

	int optNumber;
	/*
	0 珥덇린�솕 // Student_Server�뿉�꽌�뒗 Student 媛앹껜�븯�굹�� Internship �쟾泥대낫�궡湲�
	1 Internship 珥덇린�솕 // �꽌瑜섎�� �닔�젙�빐二쇨퀬
	2 �씤�꽩�돺 �떊泥�
	3. �씤�꽩�돺 �떊泥� 痍⑥냼
	4. �꽌瑜� �벑濡�
	5. �꽌瑜� �궘�젣
	6. 由щ럭 �벑濡�
	7. 由щ럭 �꽭遺� �궡�슜 �슂泥�

	Staff �쁺�뿭
	8 �씤�꽩�돺 珥덇린�솕
	9. �씤�꽩�돺 �벑濡�
	10 �씤�꽩�돺 �궘�젣
	11 由щ럭 �궘�젣 �슂泥�
	
	login �쁺�뿭
	12 ID ,Password 鍮꾧탳
	13 state 諛쒖넚 0 error 1 student 2 staff
	 */
	private static final long serialVersionUID = 1L;
	private Student student_temp;
	private Internship[] internship;
	private String ID;
	private String Password;
	private int login_state;
	boolean check=false;
	
	
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
	public int getoptNumber() {
		return this.optNumber;
	}
	
}
