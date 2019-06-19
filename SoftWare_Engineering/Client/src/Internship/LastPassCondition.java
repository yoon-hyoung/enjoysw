package Internship;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import Student.EvaluationItem;
import Student.Student;

public class LastPassCondition { // 지난 합격정보(=EvaluationItem) 를 토대로 비교한다.
	
	private EvaluationItem evaluationItem;
	private Student student;
	private String InternshipName;
	
	// (1) 
	
	public LastPassCondition(String InternshipName) {
		this.InternshipName = InternshipName;
	}

	public void apply() { // 특정 인턴쉽에 지난 합격정보를 등록한다. 해당 인턴쉽 폴더 내에 파일로 등록될 것이다.
		// StaffUI에서 인턴쉽을 등록할 때, 지난 합격 정보도 같이 등록해야 한다.
		// 따라서 StaffUI에서 LastPassCondition 을 객체로 만들고 apply() 메소드를 이용해야 한다.
		// LastPassCondition.txt 에 등록한다.
		evaluationItem = new EvaluationItem();
		
		Scanner Input = new Scanner(System.in);
		System.out.println("-------------------------------------------------------------------");
		System.out.println("------------"+InternshipName+" 인턴쉽에 지난 합격 정보를 등록합니다.--------------");
		System.out.print("▶▶ 학점 입력 >>> ");
		evaluationItem.setGrade(Input.next());
		
		System.out.print("▶▶ 토익 점수 입력 >>> ");
		evaluationItem.setTOEIC(Input.nextInt());
		
		System.out.print("▶▶ 어학원 수업 여부 입력(0 또는 1) >>> ");
		evaluationItem.setLangSch(Input.nextInt());
		
		System.out.print("▶▶ 컴퓨터 관련 자격증 이름 입력 >>> ");
		evaluationItem.setCert(Input.next());
		
		System.out.print("▶▶ 해외경험(교환학생,인턴쉽..) 여부 입력(0 또는 1) >>> ");
		evaluationItem.setOversea_exp(Input.nextInt());

		File file = new File("./Internship/"+InternshipName+"/LastPassCondition.txt");
			try {
		    	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				pw.println(evaluationItem.getGrade());
				pw.println(evaluationItem.getTOEIC());
				pw.println(evaluationItem.getLangSch());
				pw.println(evaluationItem.getCert());
				pw.println(evaluationItem.getOversea_exp());
				pw.close();
				
				System.out.println("정상적으로 지난 합격 정보를 등록하였습니다.");
				System.out.print("-------------------------------------------------------------------");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("[System] 지난 합격정보 등록에 실패하였습니다.");
			}
	}
	

}
