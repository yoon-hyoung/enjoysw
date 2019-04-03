package Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EvaluationItem { // �򰡿� �ʿ��� �׸� ����

	private String grade; // ����
	private int TOEIC; // ��������
	private int langSch; // ���п� ���� ���� - 0�̸� false, 1�̸� true
	private String cert; // ��ǻ�� ���� �ڰ��� ����
	private int oversea_exp; // �ؿ� ����(��ȯ�л�, ���Ͻ�, ..) ���� - 0�̸� f, 1�̸� t
	private String ID; // Student�κ��� ���� �л��� ID�� �����ϱ� ����


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

	//������
	public EvaluationItem() {
		
	}
	public EvaluationItem(String ID) {
		this.ID = ID;
	}

	public void Evaluation_regist() throws IOException { // Evaluation ���� ������ ����ϰ� �����ϴ� �޼ҵ�
		File file;
		FileReader filereader = null;
		BufferedReader bufreader;
		file = new File("./Student/"+ID+"/evaluationitem.txt");
		// Student/ID ���丮�� evaluationn.txt�� �ҷ��´�.
		try {
			filereader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("[System] ��ϵ��� ���� ������Դϴ�. \n");
		}
		// �Է� ��Ʈ�� ����
		bufreader = new BufferedReader(filereader); // �Է� ���� ����
		// ���Ϸκ��� �о����
		setGrade(bufreader.readLine());
		setTOEIC(Integer.parseInt(bufreader.readLine()));
		setLangSch(Integer.parseInt(bufreader.readLine()));
		setCert(bufreader.readLine());
		setOversea_exp(Integer.parseInt(bufreader.readLine()));

	}

	public void Evaluation_print() { // Evaluation ���� ������ ����Ѵ�.

		System.out.println("���� : "+getGrade());
		System.out.println("���� : "+getTOEIC()+"��");

		if(getLangSch()==0)
			System.out.println("���п� ���� ���� : YES");
		else
			System.out.println("���п� ���� ���� : NO");

		System.out.println("��ǻ�� ���� �ڰ��� : "+getCert());

		if(getOversea_exp()==0)
			System.out.println("�ؿ� ����(��ȯ�л�,���Ͻ� ��) : YES");
		else
			System.out.println("�ؿ� ����(��ȯ�л�,���Ͻ� ��) : NO");
	}

}
