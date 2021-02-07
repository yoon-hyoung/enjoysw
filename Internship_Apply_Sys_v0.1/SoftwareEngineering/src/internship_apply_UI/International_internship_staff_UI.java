package internship_apply_UI;

import java.io.*;
import java.lang.Object;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

import Document.Document;
import Internship.ApplicationForInternship;
import Internship.Internship;
import Internship.Review;
import Student.Student;



public class International_internship_staff_UI {

	Internship[] internship = new Internship[20];

	
	public International_internship_staff_UI(String Student) throws IOException {
		int i=0;
		String dirName = "./Internship/";
		File dir = new File(dirName);
		String internInfoPath;
		String files[] = dir.list(); //[0]Apple [1]Google [2]Samsung
		

		while(i<files.length) {
			internInfoPath = "./Internship/"+files[i]+"/"+files[i]+".txt";
			internship[i] = new Internship(internInfoPath);
			i++;
		}
	}
	//constructor
	public void setInternship() {
		
		int i=0;
		String dirName = "./Internship/";
		File dir = new File(dirName);
		String internInfoPath;
		String files[] = dir.list(); //[0]Apple [1]Google [2]Samsung
		

		while(i<files.length) {
			internInfoPath = "./Internship/"+files[i]+"/"+files[i]+".txt";
			internship[i] = new Internship(internInfoPath);
			i++;
		}
		
	}
	//get set 함수
	
	public void sign_Intern(String intern_file_path) {
		
			if(intern_file_path.equals("0"))return;
			
			file_read_write(intern_file_path);
			setInternship();//internship 배열 초기화 intern file path 에서 뽑아내기엔 너무 역부족
				
	}
	public void print_internship() {
		
		int i;
		
		for (i=0;i<internship.length;i++) {
			internship[i].printname();
		}
		
	}
	
	public void del_intern(String del_internship) {
		
		
		String del_intern_name="";
		File intern_fold=new File("./Internship");
		int i=0;
		
		File[] del_list=intern_fold.listFiles();
	
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
	
	private int file_read_write(String intern_file_path)  {
		
		
		
		internship[internship.length]=new Internship(intern_file_path);
		//file path 정확하게 읽어야됨
		Internship cur_internship=internship[internship.length-1];
		
		String path_internship=new String("Internship/");
		String path_internship_dir=new String("./"+path_internship+cur_internship.getname());
		path_internship="./"+path_internship+cur_internship.getname()+"/"+cur_internship.getname()+".txt";
		
		File new_signed_intern=new File(path_internship);
		File new_signed_internship_dir=new File(path_internship_dir);
		File new_signed_internship_dir_review=new File(path_internship_dir+"/Review");
		File new_signed_internship_dir_docu=new File(path_internship_dir+"/Document");
		//new_signed_intern file 만들어주기
		
		 if(!new_signed_internship_dir.exists()) 
		 {
			 new_signed_internship_dir.mkdirs();
			
		}
		 new_signed_internship_dir_review.mkdirs();
		 new_signed_internship_dir_docu.mkdirs();
		 try{
			 FileWriter filewriter =new FileWriter(new_signed_intern);
			 BufferedWriter w_buffer = new BufferedWriter(filewriter);
			 PrintWriter pw=new PrintWriter(w_buffer);
		
			 pw.println(cur_internship.getname());
		
			 pw.println(cur_internship.getdate());
		
			 pw.println(cur_internship.getcompany());
		
			 pw.println(cur_internship.getperiod());
	
			 pw.println(cur_internship.getrec_date());
	
			 pw.println(cur_internship.getselect_num());
	
			 pw.println(cur_internship.getmajor());
		
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
		 
		 if(cur_internship.getmajor()==null) {
				return 0;
			}
		
		System.out.println("");
		
		
		
		// document 어떻게 등록할지 회의
		
		
		return 1;
		
	
	}
	
	public void del_review(String InternshipName,String del_object) {
		int i;
		ArrayList review_list;
		
		for(i=0;i<internship.length;i++) {
			if(internship[i].getname().equals(InternshipName));
			break;
		}

		review_list=internship[i].getreview().getreviewName();
		Iterator it = review_list.iterator();
		while(it.hasNext()) {
			if(it.next().equals(del_object)) {
				internship[i].getreview().delete_review(del_object);
				System.out.print("삭제완료");
			}
		}
		
		
	}

	
}

