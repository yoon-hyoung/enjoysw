package Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;// array to string �빊�뮆�젾占쎈퓠 占쎈툡占쎌뒄
import java.util.Iterator;// iterator import

import Document.Document;
import Internship.ApplicationForInternship;

public class Student implements Serializable{

	/* 占쎈린占쎄문占쎌뵠 疫꿸퀡�궚占쎌읅占쎌몵嚥∽옙 占쎈굶�⑨옙 占쎌뿳占쎈뮉 占쎌젟癰귣�諭� */
	private String ID;
	private String name;
	private String major;
	private String age;
	private String studentID;
	
	private ArrayList<String> ApplyInternshipName=new ArrayList<String>(); // 占쎈솁占쎌뵬占쎈퓠占쎄퐣 占쎌뵭占쎈선占쏙옙占쎈튊占쎈쭡
	private ApplicationForInternship application; //apply 占쎈뻻筌랃옙 占쎄텢占쎌뒠占쎈릭疫꿸퀡釉ｈ눧紐꾨퓠 占쎌뵭占쎈선占쎌궞 占쎈툡占쎌뒄 x
	private Document Docu; //占쎈솁占쎌뵬占쎈퓠占쎄퐣 占쎌뵭占쎈선占쏙옙占쎈튊占쎈쭡
	

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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	public void setApplyInternshipName(){
		
		File applydir;
		int i;
		ApplyInternshipName=new ArrayList<String>();
		
		applydir = new File("./Student/"+ID+"/AppliedInternship");// Student/ID 占쎈탵占쎌젂占쎈꽅�뵳�딆벥 info.txt�몴占� �겫�뜄�쑎占쎌궔占쎈뼄.
		if (applydir.exists() == false)
			System.out.println("[System] .");

		else {
			String[] applyList=applydir.list(); //InterstingInternship 占쎈쨨占쎈쐭占쎌벥 [0] [1] [2] ....
			
			for(i=0;i<applyList.length;i++) {
				ApplyInternshipName.add(applyList[i]);
			}
			
		}
	}
	
	public ArrayList getApplyInternshipName(){
		return ApplyInternshipName;
	}
	public void setApplicationForInternship(String internship) {
		application = new ApplicationForInternship(this.ID , internship);
		
	}
	public ApplicationForInternship getApplicationForInternship() {
		return application;
		
	}
	
	public Document getDocu() {
		return this.Docu; //占쎈솁占쎌뵬占쎈퓠占쎄퐣 占쎌뵭占쎈선占쏙옙占쎈튊占쎈쭡
	}
	
	/* * * * Getter & Setter * * * */
	
	public Student(String ID) throws IOException { //揶쏆뮇�뵥占쎌젟癰귨옙 占쎈쾻嚥∽옙  constructor 嚥∽옙 占쎈뼄占쎈뻻筌띾슢諭얏묾占�// docu �겫占쏙옙苑� 占쎈뼄占쎈뻻筌띾슢諭얏묾占�
		
		File infofile; // student info 揶쏉옙 占쎈굶占쎈선占쎌뿳占쎈뮉 txt file
		FileReader filereader = null;
		BufferedReader bufreader;
		File applydir; //apply internship 占쎌벥 directory
		int i; // applylist 占쎌벥 揶쏅�れ뱽 setapplylist 占쎈맙占쎈땾嚥∽옙 占쎌겱占쎌삺 占쎄깻占쎌삋占쎈뮞占쎌벥 member占쎈퓠 揶쏅�れ뱽 筌욌쵐堉깍옙苑붹묾占� 占쎌맄占쎈퉸 占쎄텢占쎌뒠
		
		
		setID(ID); //占쎌뿯占쎌젾獄쏆룇占� ID �몴占� 疫꿸퀣占쏙옙�몵嚥∽옙 Student 揶쏆빘猿� 占쎄문占쎄쉐
		infofile = new File("./Student/"+ID+"/info.txt");// Student/ID 占쎈탵占쎌젂占쎈꽅�뵳�딆벥 info.txt�몴占� �겫�뜄�쑎占쎌궔占쎈뼄.
		try {
			filereader = new FileReader(infofile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}
		// 占쎌뿯占쎌젾 占쎈뮞占쎈뱜�뵳占� 占쎄문占쎄쉐
		
	
		bufreader = new BufferedReader(filereader); // 占쎌뿯占쎌젾 甕곌쑵�쓠 占쎄문占쎄쉐
		setName(bufreader.readLine());
		setAge(bufreader.readLine());
		setStudentID(bufreader.readLine());
		setMajor(bufreader.readLine());
		bufreader.close(); 
		// 疫꿸퀡�궚占쎌읅占쎌뵥 student info 占쎌뿯占쎌젾

		applydir = new File("./Student/"+ID+"/AppliedInternship");// Student/ID 占쎈탵占쎌젂占쎈꽅�뵳�딆벥 info.txt�몴占� �겫�뜄�쑎占쎌궔占쎈뼄.
		if (applydir.exists() == false)
			System.out.println("[System] 占쎈뻿筌ｏ옙占쎈립 占쎌뵥占쎄쉘占쎈뤊占쎌뵠 占쎈씨占쎈뮸占쎈빍占쎈뼄.");

		else {
			String[] applyList=applydir.list(); //InterstingInternship 占쎈쨨占쎈쐭占쎌벥 [0] [1] [2] ....
			
			for(i=0;i<applyList.length;i++) {
				ApplyInternshipName.add(applyList[i]);
			}
			
		}
		//apply list info 占쎌뿯占쎌젾
			
		Docu=new Document("Student", this.ID);
		
		//Document;
		
	}

	public void print_info() { // +揶쏆뮇�뵥占쎌젟癰귨옙 �빊�뮆�젾

		System.out.println("");
		System.out.println("--------------------------揶쏆뮇�뵥占쎌젟癰귨옙 �빊�뮆�젾 筌롫뗀�뤀占쎌뿯占쎈빍占쎈뼄---------------------------");
		System.out.println("[1] "+ID+"占쎈뻷 疫꿸퀡�궚 占쎌젟癰귨옙");
		System.out.println("占쎌뵠�뵳占� : "+getName());
		System.out.println("占쎄돌占쎌뵠 : "+getAge());
		System.out.println("占쎈린甕곤옙 : "+getStudentID());
		System.out.println("占쎌읈�⑨옙 : "+getMajor());
		//System.out.println("\n[2] "+ID+"占쎈뻷 �빊遺쏙옙 占쎌젟癰귨옙");
	}
	

	public void print_apply_internship() {
		Iterator apply_list=getApplyInternshipName().iterator(); //apply list 占쎌뵬占쎈뮉 iterator占쎈퓠 占쎈뻿筌ｏ옙占쎈립 占쎌뵥占쎄쉘占쎈뤊 筌뤴뫖以됵옙�뱽 占쏙옙占쎌뿯占쎈릭占쎈연 占쎄텢占쎌뒠
		
		System.out.print("占쎈뻿筌ｏ옙占쎈립 占쎌뵥占쎄쉘占쎈뤊 筌뤴뫖以� :");
		while(apply_list.hasNext()) {
			System.out.println(apply_list);
		}
	}


}



