package internship_apply_UI;

//import Application_for_intership;
import java.io.*;
import java.lang.Object;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

import Document.Document;
import Internship.ApplicationForInternship;
import Internship.Internship;
import Internship.LastPassCondition;
import Internship.Review;

//import applicationforintership;
//import internship;

//import student;

public class International_internship_staff_UI {
	final int MAX=100;
	private int login_status;
	Internship a;
	Document docu;
	//private (ApptIntern)Application_for_intership Application[MAX];
	//private Intership cur_intership[MAX];
	//private Student cur_student[MAX];
	
	public International_internship_staff_UI(int status){
		this.login_status=status;
		Scanner input=new Scanner (System.in);

		while(true) {
	        System.out.println("----------------------------------< ������ / SELECT MENU >----------------------------------");
			System.out.println("====================================================================================");
			System.out.println(" 0.�α׾ƿ�  1.���Ͻ����  2.���Ͻ���ȸ  3.���Ͻ�����   4.���Ͻ���������   5.�հ��� ���   6.���� ����");
			System.out.println("====================================================================================");
			System.out.print("\n ���� ���ϴ� �޴��� ��ȣ�� �Է��ϼ���. >>> ");
			int key=input.nextInt();
			if(key==0) break;
			switch(key) {
			case 1:	sign_Intern();break;
			case 2: 
				show_internship_list();
			case 3:	show_internship_list();
					del_intern();break;
			
			case 4:	show_internship_list();
					change_intern();
					break;
			case 5:sign_Pass();break;
			//del_Apptintern();
			case 6: del_review();break;
			
			}
		}
		
		
	} 
	public void sign_Intern() {
		Scanner input=new Scanner (System.in);
		while(true) {
		System.out.println("=======================================================================");
		System.out.println("         �Է��ϰ� ���� ���Ͻ��� ������ �ִ� ������ ��θ� �Է��Ͻÿ�. (0�� �Է��ϸ� ���ܰ��)");
		System.out.println("=======================================================================");
		if(login_status==1) //admin 1
		{			//Internship.setInternship("�̸�",��¥,
						//���,�Ⱓ,������¥,�����ο�,
						//����,�о�,����);
			String intern_file_path;
			intern_file_path=input.next();
			if(intern_file_path.equals("0"))return;
			if(file_read_write(intern_file_path)>0)
				break;
			
		}
		
		else {
			System.out.println("I'm not admin");
			break;
		}
		}
				
	}
	
	public void del_intern() {
		
		Scanner input=new Scanner (System.in);
		String del_intern_name="";
		File intern_fold=new File("./Internship");
		int i=0;
		
		File[] del_list=intern_fold.listFiles();
		while(true) {
		System.out.println("=======================================================================");
		System.out.println("		���� ���Ͻ� �̸��� �����ּ���(0�� �Է½� ���ܰ��)");
		System.out.println("=======================================================================");
		System.out.println("");
		System.out.println("");
		del_intern_name=input.next();
		if(del_intern_name.equals("0")){
			break;
		}
		try {
		for(i=0; i<del_list.length;i++) {
			if(del_intern_name.equals(del_list[i].getName())) {		
				FileUtils.deleteDirectory(del_list[i]);
				del_list[i].delete();
				System.out.println("=======================================================================");
				System.out.println("								�����Ϸ�");
				System.out.println("=======================================================================");
				System.out.println("");
				System.out.println("");
				break;
			}
		
		}
		
		}
		catch(IOException e){
			System.out.println("=======================================================================");
			System.out.println("		 system error ������ �о����� �ʽ��ϴ�.");
			System.out.println("=======================================================================");
			System.out.println("");
			System.out.println("");
		}
		if(i>=del_list.length) {
			System.out.println("=======================================================================");
			System.out.println("		 ��ȿ�� ���Ͻ� �̸��� �ƴմϴ�.");
			System.out.println("=======================================================================");
			System.out.println("");
			System.out.println("");
		
			}
		
		}
		
	}
	public void change_intern() {
		Scanner input=new Scanner (System.in);
		String change_intern_name="";
		int i;
		int change_thing;
		//Intership changeIntership
		while(true) {
		System.out.println("=======================================================================");
		System.out.println("		�ٲ� ���Ͻ��̸��� �����ּ���(0�� ������ ���ܰ��)");
		System.out.println("=======================================================================");
		System.out.println("");
		System.out.println("");
		change_intern_name=input.next();
		if(change_intern_name.equals("0")){
			break;
		}
		a=new Internship("Internship/"+change_intern_name+"/"+change_intern_name+".txt");
		
		System.out.println("=======================================================================");
		System.out.println("0.���ܰ�� 1.��ü 2.�̸�,��¥,ȸ��,�Ⱓ,���߳�¥,�����ο���,����,����,�ְ� 3.���⿡ �ʿ��� Document 4. �۳� �հݱ���");
		System.out.println("=======================================================================");
		System.out.println("");
		System.out.println("");
		change_thing=input.nextInt();
		while(true) {
		if(change_thing==0)break;
		switch(change_thing) {
			case 1:
				System.out.println("=======================================================================");
				System.out.println("         �Է��ϰ� ���� ���Ͻ��� ������ �ִ� ������ ��θ� �Է��Ͻÿ�. (0�� �Է��ϸ� ���ܰ��)");
				System.out.println("=======================================================================");
				System.out.println("");
				System.out.println("");
				String intern_file_path;
				intern_file_path=input.next();
				if(intern_file_path.equals("0")) {
					change_thing=0;
					break;
						};
				file_read_write(intern_file_path);
				
				break;
			case 2:
				System.out.println("=======================================================================");
				System.out.println("      0.���ܰ��  1.�̸� 2.��¥ 3.ȸ�� 4.�Ⱓ 5.���߳�¥ 6.�����ο��� 7.���� 8.���� 9.�ְ�");
				System.out.println("=======================================================================");	
				System.out.println("");
				System.out.println("");
				int select_num=input.nextInt();
				if(select_num==0) {
					change_thing=0;
					break;
				}
				switch(select_num){
				case 1:
					System.out.print("�̸��� �Է��Ͻÿ�:");
					String change1=input.next();
					a.setname(change1);
					System.out.println("");
					break;
				case 2:
					System.out.print("��¥�� �Է��Ͻÿ�:");
					int change2=input.nextInt();
					a.setdate(change2);
					System.out.println("");
					break;
				case 3:
					System.out.print("ȸ�縦 �Է��Ͻÿ�:");
					String change3=input.next();
					a.setcompany(change3);
					System.out.println("");
					break;
				case 4:
					System.out.print("�Ⱓ�� �Է��Ͻÿ�:");
					String change4=input.next();
					a.setperiod(change4);
					System.out.println("");
					break;
				case 5:
					System.out.print("���߳�¥�� �Է��Ͻÿ�:");
					String change5=input.next();
					a.setrec_date(change5);
					System.out.println("");
					break;
				case 6:
					System.out.print("�����ο����� �Է��Ͻÿ�:");
					String change6=input.next();
					a.setselect_num(change6);
					System.out.println("");
					break;
				case 7:
					System.out.print("���� �Է��Ͻÿ�:");
					String change7=input.next();
					a.setnation(change7);
					System.out.println("");
					break;
				case 8:
					System.out.print("������ �Է��Ͻÿ�:");
					String change8=input.next();
					a.setmajor(change8);
					System.out.println("");
					break;
				case 9:
					System.out.print("�ְ��� �Է��Ͻÿ�:");
					String change9=input.next();
					a.sethost(change9);
					System.out.println("");
					break;
				}
				try {
				File new_signed_intern=new File("Internship/"+change_intern_name+"/"+change_intern_name+".txt");
				FileWriter filewriter =new FileWriter(new_signed_intern);
				BufferedWriter w_buffer = new BufferedWriter(filewriter);
			    PrintWriter pw=new PrintWriter(w_buffer);
				
				pw.println(a.getname());
				
				pw.println(a.getdate());
				
				pw.println(a.getcompany());
				
				pw.println(a.getperiod());
			
				pw.println(a.getrec_date());
			
				pw.println(a.getselect_num());
			
				pw.println(a.getnation());
			
				pw.println(a.getmajor());

				pw.println(a.gethost());
		
				w_buffer.close();
				}
				catch(FileNotFoundException e) {
					System.out.println("no File to Sign up list");
				}
				catch(IOException e) {
					System.out.println("no File to Sign up list");
				}
				
				break;
			case 3:
				System.out.println("=======================================================================");
				System.out.println("                Document�� �����ϰ� ���� ���Ͻ��� �̸��� �Է��Ͻÿ�(0���Է��ϸ� ���ܰ��)");
				System.out.println("=======================================================================");
				System.out.println("");
				System.out.println("");
				String intern_name=input.next();
				if(intern_name.equals("0")) {
					change_thing=0;
					break;
						};
						
				docu=new Document("Internship",intern_name);
				
				System.out.println("=======================================================================");
				System.out.println("           0.�ƹ��͵� �߰����� ����     1. Document �߰�			2. Document ����");
				System.out.println("=======================================================================");
				System.out.println("");
				System.out.println("");
				int key=input.nextInt();
				switch(key) {
				case 1: 
					docu.AddDocument();
				case 2:
					docu.DelDocument();
				default :
						
				}
				
				
				break;
			case 4:
				LastPassCondition Condition=new LastPassCondition(a.getname());
				Condition.apply(); 
				a.setCondition(Condition);
				break;
			default : break;
			
			}
		
			}
		
		}
	
		
	}
	
	private int file_read_write(String intern_file_path)  {
		
		
		
		a=new Internship(intern_file_path);
		
		String path_internship=new String("Internship/");
		String path_internship_dir=new String("./"+path_internship+a.getname());
		path_internship="./"+path_internship+a.getname()+"/"+a.getname()+".txt";
		
		File new_signed_intern=new File(path_internship);
		File new_signed_internship_dir=new File(path_internship_dir);
		File new_signed_internship_dir_review=new File(path_internship_dir+"/Review");
		//new_signed_intern file ������ֱ�
		
		 if(!new_signed_internship_dir.exists()) 
		 {
			 new_signed_internship_dir.mkdirs();
			
		}
		 new_signed_internship_dir_review.mkdirs();
		 try{
		FileWriter filewriter =new FileWriter(new_signed_intern);
		BufferedWriter w_buffer = new BufferedWriter(filewriter);
	    PrintWriter pw=new PrintWriter(w_buffer);
		
		pw.println(a.getname());
		
		pw.println(a.getdate());
		
		pw.println(a.getcompany());
		
		pw.println(a.getperiod());
	
		pw.println(a.getrec_date());
	
		pw.println(a.getselect_num());
	
		pw.println(a.getnation());
	
		pw.println(a.getmajor());

		pw.println(a.gethost());
	
		
		w_buffer.close();
		 }
			catch(FileNotFoundException e) {
				System.out.println("no File to Sign up list");
				return 0;
			}
			catch(IOException e) {
				System.out.println("no File to Sign up list");
				return 0;
		}
		 
		 if(a.gethost()==null) {
				return 0;
				
			}
		LastPassCondition Condition=new LastPassCondition(a.getname());
		Condition.apply(); 
		a.setCondition(Condition);
		System.out.println("");
		docu = new Document("Internship", a.getname());
		docu.MakeStorage();
		
		docu.AddDocument();
		return 1;
		
	
	}
	

	
	 
	public void sign_Pass() {
		Scanner input=new Scanner (System.in);
		System.out.println("=======================================================================");
		System.out.println("              	 	� ���Ͻ��� �հ��ڸ� ����Ͻðڽ��ϱ�");
		System.out.println("=======================================================================");
		System.out.println("");
		System.out.println("");
		String intern_file_path;
		String pass_ID;
		intern_file_path=input.next();
		String path=new String("Internship/");
		path ="./"+path+intern_file_path+"/Passer.txt";
		
		System.out.println("=======================================================================");
		System.out.println("              		 �հ��� ��� ������ ��θ� �Է��Ͻÿ�.");
		System.out.println("=======================================================================");
		System.out.println("");
		System.out.println("");
		
		String sign_file_path=input.next();
		try {
		
		File sign=new File(sign_file_path);
		FileReader filereader =new FileReader(sign);
		BufferedReader r_buffer=new BufferedReader(filereader);
		
		File passer=new File(path);
		
	    
	    FileWriter filewriter =new FileWriter(passer);
		BufferedWriter w_buffer = new BufferedWriter(filewriter);
	    PrintWriter pw=new PrintWriter(w_buffer);
		while(true) {
		pass_ID=r_buffer.readLine();
		if(pass_ID==null) {
			break;
		}
		pw.println(pass_ID);
	
		}
		r_buffer.close();
		w_buffer.close();
		}catch(FileNotFoundException e) {
			System.out.println("no File to Sign up list");
		}
		catch(IOException e) {
			System.out.println("no File to Sign up list");
		}
		System.out.println("=======================================================================");
		System.out.println("			passer ��� �Ϸ�");
		System.out.println("=======================================================================");
		System.out.println("");
		System.out.println("");
	}
	
	public void del_review() {
		
		Review review=new Review();
		review.delete_review();
		
	}
	public void del_Apptintern() {
		
		String InternName;
		String userID;
		
		Scanner input=new Scanner (System.in);
		System.out.println("=======================================================================");
		System.out.println("                � ID�� � ���Ͻ� ������ �������� �Է��Ͻÿ�.(0�� �Է��ϸ� ���ܰ��)");
		System.out.println("=======================================================================");
		System.out.println("");
		System.out.println("");
		userID=input.next();
		if(userID.equals("0")){
			return ;
		}
		
		
		System.out.println("=======================================================================");
		System.out.println("                � ���Ͻ� ������ �������� �Է��Ͻÿ�. (0���Է��ϸ� �ƹ��͵� ������������)");
		System.out.println("=======================================================================");
		System.out.println("");
		System.out.println("");
		InternName=input.next();
		if(InternName.equals("0")){
			return ;
		}
		System.out.println("=======================================================================");
		ApplicationForInternship intern=new ApplicationForInternship(userID,InternName);
		intern.cancel();
		System.out.println("=======================================================================");
		System.out.println("");
		System.out.println("");
			}
	
	 private void show_internship_list()
	   {
		 File file;
		 File[] file_list;
		 System.out.println("=======================================================================");
	      file= new File("./Internship");
	      file_list=file.listFiles();
	      if(file_list.length>=1)
	      {
	         for(int i=0; i<file_list.length; i++)
	         {
	            System.out.printf("%s\n",file_list[i].getName());
	         }
	      }
	      else{
	         System.out.printf("����� ���Ͻ��� ��ϵ� ���� �ʽ��ϴ�.\n");
	      }
	      System.out.println("=======================================================================");
	      System.out.println("");
		System.out.println("");
	   }
	
}
