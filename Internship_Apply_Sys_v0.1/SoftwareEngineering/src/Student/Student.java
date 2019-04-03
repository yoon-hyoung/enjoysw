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

	/* �л��� �⺻������ ��� �ִ� ������ */
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
	//����� ������ �޾ƿͼ� SET ���ִ� private �޼ҵ�
	private void read_info() throws IOException {
		File file;
		FileReader filereader = null;
		BufferedReader bufreader;
		//
		file = new File("./Student/"+ID+"/info.txt");// Student/ID ���丮�� info.txt�� �ҷ��´�.
		try {
			filereader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("[System] ��ϵ��� ���� ������Դϴ�. \n");
		}
		// �Է� ��Ʈ�� ����
		bufreader = new BufferedReader(filereader); // �Է� ���� ����

		setName(bufreader.readLine());
		setAge(Integer.parseInt(bufreader.readLine()));
		setStudentID(bufreader.readLine());
		setAcYear(Integer.parseInt(bufreader.readLine()));
		setMajor(bufreader.readLine());
		setInter_Country(bufreader.readLine());
		setInter_Term(Integer.parseInt(bufreader.readLine()));
		setInter_Company(bufreader.readLine());

		bufreader.close();
		evaluationItem = new EvaluationItem(ID); // EvaluationItem���� �л� ID�� �ѱ��.
		evaluationItem.Evaluation_regist(); 	// ������ ����Ѵ�.
	}

	public void print_info() throws IOException { // +�������� ���

		System.out.println("");
		System.out.println("--------------------------�������� ��� �޴��Դϴ�---------------------------");
		System.out.println("[1] "+ID+"�� �⺻ ����");
		System.out.println("�̸� : "+getName());
		System.out.println("���� : "+getAge());
		System.out.println("�й� : "+getStudentID());
		System.out.println("�̼� �б� : "+getAcYear());
		System.out.println("���� : "+getMajor());
		System.out.println("���ɺо�(����/����) : "+getInter_Country());
		System.out.println("���ɺо�(�Ⱓ/����) : "+getInter_Term());
		System.out.println("���ɺо�(���) : "+getInter_Company());
		System.out.println("\n[2] "+ID+"�� �߰� ����");
		evaluationItem.Evaluation_print();
	}
	
	

	public void edit_info() { // +�������� ����
		File file = new File("./Student/"+ID+"/info.txt");
		File intfile = new File("./Student/"+ID+"/Interested.txt");
		Scanner input = new Scanner(System.in);

		int editInt;
		String editString;

		int num;
		System.out.println("");
		System.out.println("--------------------------�������� ���� �޴��Դϴ�---------------------------");
		System.out.println("[�̸� : 1]  [���� : 2]  [�й� : 3]  [�̼� �б� : 4]  [���� : 5]");
		System.out.println("[���ɺо�(����) : 6]  [���ɺо�(�Ⱓ) : 7]  [���ɺо�(���) : 8]");
		System.out.print("���� ������ �׸��� ��ȣ�� �Է����ּ���. (0�� �Է� �� SKIP) >>>> ");
		num = input.nextInt();

		switch(num) {
		case 0:
			return;
		case 1:{
			System.out.print("���� �̸� : "+getName());
			System.out.print("\n������ �̸� �Է� : ");
			editString = input.next();
			setName(editString);

			// ���Ͽ� ���� ����.
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
				System.err.print("[System] ������ �����Ͽ����ϴ�. ���� ������ Ȯ���� �ֽʽÿ�.");
			}
			System.out.println("���������� �̸��� "+getName()+"(��)�� �����Ǿ����ϴ�");
			break;
		}
		case 2:{
			System.out.println("���� ���� : "+getAge());
			System.out.print("������ ���� �Է� : ");
			editInt = input.nextInt();
			setAge(editInt);
			// ���Ͽ� ���� ����.
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
				System.err.print("[System] ������ �����Ͽ����ϴ�. ���� ������ Ȯ���� �ֽʽÿ�.");
			}
			System.out.println("���������� ���̰� "+getAge()+"(��)�� �����Ǿ����ϴ�");
			break;
		}
		case 3:{
			System.out.println("���� �й� : "+getStudentID());
			System.out.print("������ �й� �Է� : ");
			editString = input.next();
			setStudentID(editString);

			// ���Ͽ� ���� ����.
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
				System.err.print("[System] ������ �����Ͽ����ϴ�. ���� ������ Ȯ���� �ֽʽÿ�.");
			}
			System.out.println("���������� �й��� "+getStudentID()+"(��)�� �����Ǿ����ϴ�");
			break;
		}
		case 4:{
			System.out.println("���� �̼� �б� : "+getAcYear());
			System.out.print("������ �̼� �б� �Է� : ");
			editInt = input.nextInt();
			setAcYear(editInt);
			System.out.println("���������� �̼� �бⰡ "+getAcYear()+"(��)�� �����Ǿ����ϴ�");
			// ���Ͽ� ���� ����.
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
				System.err.print("[System] ������ �����Ͽ����ϴ�. ���� ������ Ȯ���� �ֽʽÿ�.");
			}
			System.out.println("���������� �̼� �бⰡ "+getAcYear()+"(��)�� �����Ǿ����ϴ�");
			break;
		}
		case 5:{
			System.out.println("���� ���� : "+getMajor());
			System.out.print("������ ���� �Է� : ");
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
				System.err.print("[System] ������ �����Ͽ����ϴ�. ���� ������ Ȯ���� �ֽʽÿ�.");
			}
			System.out.println("���������� ������ "+getMajor()+"(��)�� �����Ǿ����ϴ�");
			break;
		}
		case 6:{
			System.out.println("���� ���ɺо�(����) : "+getInter_Country());
			System.out.print("������ ���� ���� �Է� : ");
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
				intpw.println(getInter_Term() + "����");
				intpw.println(getInter_Company());
				pw.close();
				intpw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("[System] ������ �����Ͽ����ϴ�. ���� ������ Ȯ���� �ֽʽÿ�.");
			}
			System.out.println("���������� ���� �о߰� "+getInter_Country()+"(��)�� �����Ǿ����ϴ�");
			break;
		}
		case 7:{
			System.out.println("���� ���ɺо�(�Ⱓ) : "+getInter_Term());
			System.out.print("������ ���� �Ⱓ �Է� : ");
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
				intpw.println(getInter_Term()+ "����");
				intpw.println(getInter_Company());
				pw.close();
				intpw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("[System] ������ �����Ͽ����ϴ�. ���� ������ Ȯ���� �ֽʽÿ�.");
			}
			System.out.println("���������� ���� �Ⱓ�� "+getInter_Term()+"(��)�� �����Ǿ����ϴ�");
			break;
		}
		case 8:{
			System.out.println("���� ���ɺо�(���) : "+getInter_Company());
			System.out.print("������ ���� ��� �Է� : ");
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
				intpw.println(getInter_Term()+ "����");
				intpw.println(getInter_Company());
				pw.close();
				intpw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("[System] ������ �����Ͽ����ϴ�. ���� ������ Ȯ���� �ֽʽÿ�.");
			}
			System.out.println("���������� ���� ����� "+getInter_Company()+"(��)�� �����Ǿ����ϴ�");
			break;

		}
		}

	}

	public void reg_personInfo() {

	}

	public void apply_intern() { // +���Ͻ� ��û

		Scanner input = new Scanner(System.in);
		String InternshipName;
		String internship_file;
		System.out.println("");
		System.out.println("---------------------------���Ͻ� ��û �޴��Դϴ�----------------------------");
		System.out.println("--------------------[���� �ý��ۿ� ��ϵ� ���Ͻ� ��ü ���]--------------------\n");
		// -> ���� ��ϵǾ� �ִ� ���Ͻ� ��ϵ� ��� ���

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
		System.out.printf("%s %s %s %s %s %s %s %s %s %s\n", "[INDEX]","[���Ͻ� �̸�]","[���Ͻ� �����]", "[���� ���]", "[���Ͻ� �Ⱓ]",
				"[���� ����]", "[���� �ο�]", "[���� ����]", "[���� ����]", "[����ó]");
		for(int j= 0; j<i; j++) {
			/*System.out.printf(" [%d] %s / %d / %s / %s / %s / %s / %s / %s / %s\n",
					j+1, internship[j].getname(),internship[j].getdate(),internship[j].getcompany(),
					internship[j].getperiod(),internship[j].getrec_date(),internship[j].getselect_num(),
					internship[j].getnation(),internship[j].getmajor(),internship[j].gethost());*/
			System.out.printf("[%d]",j+1);
			internship[j].printAll();
					
		}
		System.out.println("");

		// -> ��û�ϰ��� �ϴ� ���Ͻ� �̸� �Է�
		System.out.print("���� ��û�� ���Ͻ��� INDEX ��ȣ�� �Է��� �ּ���. (0�� �Է� �� SKIP) >>>> ");

		indexNum = input.nextInt();
		if (indexNum == 0)
			return ;
		else if(indexNum > i) {
			System.out.print("[System] ��Ͽ� ���� INDEX�� �Է��ϼ̽��ϴ�.\n");
			return;
		}

		applicationForInternship = new ApplicationForInternship(getID(),internship[indexNum-1].getname());
		// ApplicationForInternship Ŭ������ ���� �α��� ���� ID��, �Է¹��� ���Ͻ��� ������ �ѱ��.
		applicationForInternship.apply(); // file set

	}

	public void setting_intern() { // +���Ͻ� �����ϱ�
		String InternshipName;
		String internInfoPath;
		int i=0;
		int indexNum;
		File dir = new File("./Student/"+ID+"/"+"AppliedInternship");
		String files[] = dir.list(); // [0], [1], [2],....
		Scanner input = new Scanner(System.in);

		System.out.println("");
		System.out.println("------------------------���Ͻ� ��û ���� �޴��Դϴ�--------------------------");
		// ��û�Ǿ� �ִ� ���Ͻ� ���
		
		if(files.length == 0) {
			System.out.println("[System] ������ ���Ͻ��� �����ϴ�. (���Ͻ� ��û ���� ����)");
			return;
		}

		else {
			Internship[] internship = new Internship[10];

			while(i<files.length) {
				internInfoPath = "./Internship/"+files[i]+"/"+files[i]+".txt";
				internship[i] = new Internship(internInfoPath);
				i++;
			}
			System.out.println("----------------------------- ���� ���� ��û�� ���Ͻ� ��� -----------------------------");
			System.out.println("[���Ͻ� �̸�]  [���Ͻ� �����]  [���� ���]  [���Ͻ� �Ⱓ]  [���� ����]  [�����ο�]  [��������]   [��������]  [����ó]");
			for(int j= 0; j<i; j++) {
				System.out.printf("[%d] %s / %d / %s / %s / %s / %s / %s / %s / %s\n",
						j+1, internship[j].getname(),internship[j].getdate(),internship[j].getcompany(),
						internship[j].getperiod(),internship[j].getrec_date(),internship[j].getselect_num(),
						internship[j].getnation(),internship[j].getmajor(),internship[j].gethost());
			}

			System.out.print("\n���� ����� ���Ͻ��� INDEX ��ȣ�� �Է��� �ּ���. (0�� �Է� �� SKIP) >>>> ");
			indexNum = input.nextInt();
			if (indexNum == 0)
				return ;
			else if(indexNum > i) {
				System.out.print("[System] ��Ͽ� ���� INDEX�� �Է��ϼ̽��ϴ�.\n");
				return;
			}
			
			applicationForInternship = new ApplicationForInternship(getID(),internship[indexNum-1].getname());
			// ApplicationForInternship Ŭ������ ���� �α��� ���� ID��, �Է¹��� ���Ͻ��� ������ �ѱ��.
			applicationForInternship.cancel(); // file set
		}

	}

	public void apply_Simulation_intern() throws IOException { // +���Ͻ� ��������
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
		//System.out.println("--------------------------���Ͻ� ���� ���� �޴��Դϴ�.----------------------");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("[�ȳ�] �ش� ���Ͻ��� �۳� �հ� ������ ���ϰ� ���� �պ� ���θ� �Ǵ��Ͽ� ����� �帳�ϴ�.  ");
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
		
		
		System.out.printf("%s %s %s %s %s %s %s %s %s %s\n", "[INDEX]","[���Ͻ� �̸�]","[���Ͻ� �����]", "[���� ���]", "[���Ͻ� �Ⱓ]",
				"[���� ����]", "[���� �ο�]", "[���� ����]", "[���� ����]", "[����ó]\n");
		for(int j= 0; j<i; j++) {
			/*System.out.printf(" [%d] %s / %d / %s / %s / %s / %s / %s / %s / %s\n",
					j+1, internship[j].getname(),internship[j].getdate(),internship[j].getcompany(),
					internship[j].getperiod(),internship[j].getrec_date(),internship[j].getselect_num(),
					internship[j].getnation(),internship[j].getmajor(),internship[j].gethost());*/
			System.out.printf("  [%d]",j+1);
			internship[j].printAll();
		}
		System.out.println("");

		System.out.print("���� ���������� ���Ͻ��� INDEX �� �Է��� �ּ���. (0�� �Է� �� SKIP) >>> ");
		indexNum = input.nextInt();
		if (indexNum == 0)
			return ;
		else if(indexNum > i) {
			System.out.print("[System] ��Ͽ� ���� INDEX�� �Է��ϼ̽��ϴ�.\n");
			return;
		}

		file = new File("./Internship/"+internship[indexNum-1].getname()+"/LastPassCondition.txt");
		try {
			filereader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("[System] �۳� �հ������� �ҷ����µ� �����Ͽ����ϴ�. \n");
		}
		BufferedReader bufreader = new BufferedReader(filereader);

		// ���������� �Ϸ��� �Է��� ���Ͻ��� LastPassCondition.txt ������ ���� ���̴�.
		System.out.println("\n�� ���������� ���Ͻ� �̸� : "+internship[indexNum-1].getname());
		// ���ϱ�
		System.out.println("\n				<       ���� ����� ����          >   //   <       �۳� �հ��� ����          >");
		last_Grade = bufreader.readLine();
		System.out.println("[	(1)����	]				"+evaluationItem.getGrade()+"						"+last_Grade);
		last_TOEIC = Integer.parseInt(bufreader.readLine());
		System.out.println("[	(2)����	]				"+evaluationItem.getTOEIC()+"						"+last_TOEIC);
		last_langSch = Integer.parseInt(bufreader.readLine());
		System.out.println("[(3)���п� ��������  ]				"+evaluationItem.getLangSch()+"						"+last_langSch);
		last_cert = bufreader.readLine();
		System.out.println("[(4)��ǻ�� �ڰ���    ]			"+evaluationItem.getCert()+"		  "+last_cert);
		last_oversea_exp = Integer.parseInt(bufreader.readLine());
		System.out.println("[(5)�ؿܰ���(��ȯ�л�,���Ͻ�)]  		"+evaluationItem.getOversea_exp()+"						"+last_oversea_exp);
		System.out.println("");

		if(Double.parseDouble(evaluationItem.getGrade()) < Double.parseDouble(last_Grade)) { // �۳� ������ �� ������
			System.out.println("[COMMENT] �۳��� �հ� �������� ������� ������ �����ϴ�.");
			passCount++;
		}
		if(Double.parseDouble(evaluationItem.getGrade()) >= Double.parseDouble(last_Grade))  // �۳� �������� ������
			System.out.println("[COMMENT] �۳��� �հ� �������� ������� ������ ���ų� �����ϴ�.");

		if(evaluationItem.getTOEIC() < last_TOEIC) {  // �۳� �������� ������
			System.out.println("[COMMENT] �۳��� �հ� ������������ ������� ���������� �����ϴ�.");
			passCount++;
		}
		if(evaluationItem.getTOEIC() >= last_TOEIC) // �۳� �������� ������
			System.out.println("[COMMENT] �۳��� �հ� ������������ ������� ���������� ���ų� �����ϴ�.");

		if(evaluationItem.getLangSch() == 1 && last_langSch == 1)
			System.out.println("[COMMENT] �۳� �հ��ڴ� ���п��� �����߰�, ����ڵ� �����Ͽ����ϴ�.");
		if(evaluationItem.getLangSch() == 1 && last_langSch == 0)
			System.out.println("[COMMENT] �۳� �հ��ڴ� ���п��� �������� �ʾ�����, ����ڴ� �����Ͽ����ϴ�.");
		if(evaluationItem.getLangSch() == 0 && last_langSch == 1)
			System.out.println("[COMMENT] �۳� �հ��ڴ� ���п��� ����������, ����ڴ� �������� �ʾҽ��ϴ�.");
		if(evaluationItem.getLangSch() == 0 && last_langSch == 0)
			System.out.println("[COMMENT] �۳� �հ��ڴ� ���п��� �������� �ʾҰ�, ����ڵ� �������� �ʾҽ��ϴ�.");

		if(evaluationItem.getOversea_exp() == 1 && last_oversea_exp == 1)
			System.out.println("[COMMENT] �۳� �հ��ڴ� �ؿ� ������ �־���, ����ڵ� �ؿ� ������ �ֽ��ϴ�.");
		if(evaluationItem.getLangSch() == 1 && last_oversea_exp == 0)
			System.out.println("[COMMENT] �۳� �հ��ڴ� �ؿ� ������ ��������, ����ڴ� �ؿ� ������ �ֽ��ϴ�.");
		if(evaluationItem.getLangSch() == 0 && last_oversea_exp == 1)
			System.out.println("[COMMENT] �۳� �հ��ڴ� �ؿ� ������ �־�����, ����ڴ� �ؿ� ������ �����ϴ�.");
		if(evaluationItem.getLangSch() == 0 && last_oversea_exp == 0)
			System.out.println("[COMMENT] �۳� �հ��ڴ� �ؿ� ������ ������, ����ڵ� �ؿ� ������ �����ϴ�.");

		if(passCount == 0)
			System.out.println("**[RESULT]** ���� ������ �� ��, "+ID+" ���� �۳� �հ����� �������� [�հ�] �̽ʴϴ�!");
		else if(passCount != 0)
			System.out.println("**[RESULT]** ���� ������ �� ��, "+ID+" ���� �۳� �հ����� ���غ��� ���� �����ʴϴ�.");

	}

}
