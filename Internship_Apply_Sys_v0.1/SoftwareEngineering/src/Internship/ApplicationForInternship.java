package Internship;

import java.io.File;
import java.util.Scanner;

import Document.Document;

public class ApplicationForInternship {

	private Internship internship;
	private String InternshipName; // ��û�ϰ��� �ϴ� ���Ͻ��� �̸��� ����ȴ�.
	private String ID; // �α��� ���� �л��� ID�� �Ѿ�´�.


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

	public void apply() { //+ ���Ͻ� �����ϱ�( set file )
		Document docu = new Document("Student", this.ID);
		File dir = new File("./Student/"+ID+"/"+"AppliedInternship");
		Scanner input = new Scanner(System.in);
		
		if(dir.exists() == false) {
			dir.mkdir(); 
		}
		
		// Student/ID/ �ؿ�, AppliedInternship ������ �����. (���� ��쿡��)
		// �� �ȿ�, �Է��� InternshipName ���� �� ������ �����.
		File inputDir = new File("./Student/"+ID+"/AppliedInternship/"+InternshipName);
		if(inputDir.exists() == false) {
			inputDir.mkdir(); 
			System.out.println("[System] ���������� "+InternshipName+" ���Ͻ� ��û�� �Ϸ�Ǿ����ϴ�.");
		}
		else {
			System.out.println("[System] �̹� ��û�Ǿ� �ִ� ���Ͻ��Դϴ�.");
		}
		
		docu.NonRegistDocument(this.InternshipName);

	}
	public void cancel() { //+ ���Ͻ� �������
		File dir = new File("./Student/"+ID+"/"+"AppliedInternship/"+InternshipName);
		if(dir.exists()==true) {
			dir.delete(); // ��ο��� �����Ѵ�.
			System.out.println("[System] ���������� ��û ������ �����Ͽ����ϴ�.");
		}
	}

	public void print_applying() {//+ ��û�� ���Ͻ� ���

	}
}