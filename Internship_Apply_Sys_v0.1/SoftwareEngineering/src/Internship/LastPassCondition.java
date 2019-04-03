package Internship;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import Student.EvaluationItem;
import Student.Student;

public class LastPassCondition { // ���� �հ�����(=EvaluationItem) �� ���� ���Ѵ�.
	
	private EvaluationItem evaluationItem;
	private Student student;
	private String InternshipName;
	
	// (1) 
	
	public LastPassCondition(String InternshipName) {
		this.InternshipName = InternshipName;
	}

	public void apply() { // Ư�� ���Ͻ��� ���� �հ������� ����Ѵ�. �ش� ���Ͻ� ���� ���� ���Ϸ� ��ϵ� ���̴�.
		// StaffUI���� ���Ͻ��� ����� ��, ���� �հ� ������ ���� ����ؾ� �Ѵ�.
		// ���� StaffUI���� LastPassCondition �� ��ü�� ����� apply() �޼ҵ带 �̿��ؾ� �Ѵ�.
		// LastPassCondition.txt �� ����Ѵ�.
		evaluationItem = new EvaluationItem();
		
		Scanner Input = new Scanner(System.in);
		System.out.println("-------------------------------------------------------------------");
		System.out.println("------------"+InternshipName+" ���Ͻ��� ���� �հ� ������ ����մϴ�.--------------");
		System.out.print("���� ���� �Է� >>> ");
		evaluationItem.setGrade(Input.next());
		
		System.out.print("���� ���� ���� �Է� >>> ");
		evaluationItem.setTOEIC(Input.nextInt());
		
		System.out.print("���� ���п� ���� ���� �Է�(0 �Ǵ� 1) >>> ");
		evaluationItem.setLangSch(Input.nextInt());
		
		System.out.print("���� ��ǻ�� ���� �ڰ��� �̸� �Է� >>> ");
		evaluationItem.setCert(Input.next());
		
		System.out.print("���� �ؿܰ���(��ȯ�л�,���Ͻ�..) ���� �Է�(0 �Ǵ� 1) >>> ");
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
				
				System.out.println("���������� ���� �հ� ������ ����Ͽ����ϴ�.");
				System.out.print("-------------------------------------------------------------------");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.print("[System] ���� �հ����� ��Ͽ� �����Ͽ����ϴ�.");
			}
	}
	

}
