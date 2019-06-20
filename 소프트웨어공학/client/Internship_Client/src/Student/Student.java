package Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;// array to string 異쒕젰�뿉 �븘�슂
import java.util.Iterator;// iterator import

import Document.Document;
import Internship.ApplicationForInternship;

public class Student implements Serializable{

	/* �븰�깮�씠 湲곕낯�쟻�쑝濡� �뱾怨� �엳�뒗 �젙蹂대뱾 */
	private String ID;
	private String name;
	private String major;
	private String age;
	private String studentID;
	
	private ArrayList<String> ApplyInternshipName=new ArrayList<String>(); // �뙆�씪�뿉�꽌 �씫�뼱���빞�맖
	private ApplicationForInternship application; //apply �떆留� �궗�슜�븯湲곕븣臾몄뿉 �씫�뼱�삱 �븘�슂 x
	private Document Docu; //�뙆�씪�뿉�꽌 �씫�뼱���빞�맖
	

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
		
		applydir = new File("./Student/"+ID+"/AppliedInternship");// Student/ID �뵒�젆�넗由ъ쓽 info.txt瑜� 遺덈윭�삩�떎.
		if (applydir.exists() == false)
			System.out.println("[System] �떊泥��븳 �씤�꽩�돺�씠 �뾾�뒿�땲�떎.");

		else {
			String[] applyList=applydir.list(); //InterstingInternship �뤃�뜑�쓽 [0] [1] [2] ....
			
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
		return this.Docu; //�뙆�씪�뿉�꽌 �씫�뼱���빞�맖
	}
	
	/* * * * Getter & Setter * * * */
	
	public Student(String ID) throws IOException { 

		setID(ID); //�엯�젰諛쏆� ID 瑜� 湲곗��쑝濡� Student 媛앹껜 �깮�꽦
	}

	public void print_info() { // +媛쒖씤�젙蹂� 異쒕젰

		System.out.println("");
		System.out.println("--------------------------개인정보 출력 메뉴입니다---------------------------");
		System.out.println("[1] "+ID+"님 기본 정보");
		System.out.println("이름 : "+getName());
		System.out.println("나이 : "+getAge());
		System.out.println("학번 : "+getStudentID());
		System.out.println("전공 : "+getMajor());
		//System.out.println("\n[2] "+ID+"님 추가 정보");
	}
	

	public void print_apply_internship() {
		Iterator apply_list=getApplyInternshipName().iterator(); //apply list �씪�뒗 iterator�뿉 �떊泥��븳 �씤�꽩�돺 紐⑸줉�쓣 ���엯�븯�뿬 �궗�슜
		
		System.out.print("Internship:");
		while(apply_list.hasNext()) {
			System.out.println(apply_list.next());
			
		}
	}


}



