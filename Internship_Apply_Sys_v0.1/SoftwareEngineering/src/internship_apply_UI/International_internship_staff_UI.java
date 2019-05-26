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
	        System.out.println("----------------------------------< 관리자 / SELECT MENU >----------------------------------");
			System.out.println("====================================================================================");
			System.out.println(" 0.로그아웃  1.인턴쉽등록  2.인턴쉽조회  3.인턴쉽삭제   4.인턴쉽정보수정   5.합격자 등록   6.리뷰 삭제");
			System.out.println("====================================================================================");
			System.out.print("\n ▶▶ 원하는 메뉴의 번호를 입력하세요. >>> ");
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
		System.out.println("         입력하고 싶은 인턴쉽의 정보가 있는 파일의 경로를 입력하시오. (0을 입력하면 전단계로)");
		System.out.println("=======================================================================");
		if(login_status==1) //admin 1
		{			//Internship.setInternship("이름",날짜,
						//기업,기간,모집날짜,선발인원,
						//지역,분야,구분);
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
		System.out.println("		없앨 인턴쉽 이름을 적어주세요(0을 입력시 전단계로)");
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
				System.out.println("								삭제완료");
				System.out.println("=======================================================================");
				System.out.println("");
				System.out.println("");
				break;
			}
		
		}
		
		}
		catch(IOException e){
			System.out.println("=======================================================================");
			System.out.println("		 system error 파일이 읽어지지 않습니다.");
			System.out.println("=======================================================================");
			System.out.println("");
			System.out.println("");
		}
		if(i>=del_list.length) {
			System.out.println("=======================================================================");
			System.out.println("		 유효한 인턴쉽 이름이 아닙니다.");
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
		System.out.println("		바꿀 인턴쉽이름을 적어주세요(0을 누르면 전단계로)");
		System.out.println("=======================================================================");
		System.out.println("");
		System.out.println("");
		change_intern_name=input.next();
		if(change_intern_name.equals("0")){
			break;
		}
		a=new Internship("Internship/"+change_intern_name+"/"+change_intern_name+".txt");
		
		System.out.println("=======================================================================");
		System.out.println("0.전단계로 1.전체 2.이름,날짜,회사,기간,선발날짜,선발인원수,나라,전공,주관 3.제출에 필요한 Document 4. 작년 합격기준");
		System.out.println("=======================================================================");
		System.out.println("");
		System.out.println("");
		change_thing=input.nextInt();
		while(true) {
		if(change_thing==0)break;
		switch(change_thing) {
			case 1:
				System.out.println("=======================================================================");
				System.out.println("         입력하고 싶은 인턴쉽의 정보가 있는 파일의 경로를 입력하시오. (0을 입력하면 전단계로)");
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
				System.out.println("      0.전단계로  1.이름 2.날짜 3.회사 4.기간 5.선발날짜 6.선발인원수 7.나라 8.전공 9.주관");
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
					System.out.print("이름을 입력하시오:");
					String change1=input.next();
					a.setname(change1);
					System.out.println("");
					break;
				case 2:
					System.out.print("날짜를 입력하시오:");
					int change2=input.nextInt();
					a.setdate(change2);
					System.out.println("");
					break;
				case 3:
					System.out.print("회사를 입력하시오:");
					String change3=input.next();
					a.setcompany(change3);
					System.out.println("");
					break;
				case 4:
					System.out.print("기간를 입력하시오:");
					String change4=input.next();
					a.setperiod(change4);
					System.out.println("");
					break;
				case 5:
					System.out.print("선발날짜를 입력하시오:");
					String change5=input.next();
					a.setrec_date(change5);
					System.out.println("");
					break;
				case 6:
					System.out.print("선발인원수를 입력하시오:");
					String change6=input.next();
					a.setselect_num(change6);
					System.out.println("");
					break;
				case 7:
					System.out.print("나라를 입력하시오:");
					String change7=input.next();
					a.setnation(change7);
					System.out.println("");
					break;
				case 8:
					System.out.print("전공을 입력하시오:");
					String change8=input.next();
					a.setmajor(change8);
					System.out.println("");
					break;
				case 9:
					System.out.print("주관를 입력하시오:");
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
				System.out.println("                Document를 수정하고 싶은 인턴쉽의 이름을 입력하시오(0을입력하면 전단계로)");
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
				System.out.println("           0.아무것도 추가하지 않음     1. Document 추가			2. Document 삭제");
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
		//new_signed_intern file 만들어주기
		
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
		System.out.println("              	 	어떤 인턴쉽에 합격자를 등록하시겠습니까");
		System.out.println("=======================================================================");
		System.out.println("");
		System.out.println("");
		String intern_file_path;
		String pass_ID;
		intern_file_path=input.next();
		String path=new String("Internship/");
		path ="./"+path+intern_file_path+"/Passer.txt";
		
		System.out.println("=======================================================================");
		System.out.println("              		 합격자 등록 파일의 경로를 입력하시오.");
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
		System.out.println("			passer 등록 완료");
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
		System.out.println("                어떤 ID의 어떤 인턴쉽 지원을 삭제할지 입력하시오.(0을 입력하면 전단계로)");
		System.out.println("=======================================================================");
		System.out.println("");
		System.out.println("");
		userID=input.next();
		if(userID.equals("0")){
			return ;
		}
		
		
		System.out.println("=======================================================================");
		System.out.println("                어떤 인턴쉽 지원을 삭제할지 입력하시오. (0을입력하면 아무것도 삭제하지않음)");
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
	         System.out.printf("현재는 인턴십이 등록돼 있지 않습니다.\n");
	      }
	      System.out.println("=======================================================================");
	      System.out.println("");
		System.out.println("");
	   }
	
}

