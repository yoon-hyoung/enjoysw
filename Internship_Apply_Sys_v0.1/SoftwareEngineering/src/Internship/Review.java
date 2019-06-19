package Internship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Review {

   // error 상황을 좀 더 구체적으로 throw 해야 함.
	
	 private String path;// 리뷰를 저장할 폴더파일.
	 private ArrayList reviewName= new ArrayList();
	   
	
	 public Review(String InternshipName)
	   {
	      File file= new File("./Internship/"+InternshipName+"/Review");
	      this.path ="./Internship/"+InternshipName+"/Review";
	      
	      if(file.exists()==false)
	      {file.mkdirs();}
	      
	      String[] fileList = file.list();
	      int i; //iterator
			
	      for(i=0;i<fileList.length;i++) {
	    	  this.reviewName.add(fileList[i]);
	      }
	      
	   } // internship 추가할 때 새로 폴더 만들어야 될 수 도 있으니  생성자에 집어넣어놓음
	   //constructor
	 
   public String getpath() {
	   return path;
   }
   public void setpath(String path) {
	   this.path=path;
   }
   public ArrayList getreviewName() {
	   return reviewName;
   }
   public void setreviewName() {
	   File file= new File(path);
	   String[] fileList = file.list();
	   int i; //iterator
		
	   reviewName= new ArrayList();
	   
	   for(i=0;i<fileList.length;i++) {
		   this.reviewName.add(fileList[i]);
	   }
   }
   
   //Get Set 함수
  
   
   public void show_review_list()
   {
	   Iterator it = reviewName.iterator();
	   
	   if(it.hasNext())
		   while(it.hasNext())
			   System.out.println(it.next());
	   else{
		   System.out.printf("현재는 인턴십이 등록돼 있지 않습니다.\n");
	   }
   }
   
   public void write_review(String writeReview, String contents)
   {
	 
      reviewName.add(writeReview);
      Scanner input=new Scanner(System.in);
	  String context;
      
       try{
          FileWriter fw = new FileWriter(path+"/"+writeReview+".txt");
          System.out.print("적을 내용을 입력하세요.\n");
          context=contents;
          fw.write(context);
          fw.close();
       }catch(IOException e) {
          e.printStackTrace();
       }
       
       
   }
   
   public void delete_review(String delReview) 
   {
      
       File file = new File(path+"/"+delReview+".txt"); // 인턴쉽 폴더 주소
       if( file.exists() ){
            if(file.delete()){
                System.out.println("파일삭제 성공");
                setreviewName();
            }else{
                System.out.println("파일삭제 실패");
            }
        }else{
            System.out.println("파일이 존재하지 않습니다.");
        }
       
   }
   
   
  
   public void print_review(String printReview)
   {
      
      
       File file = new File(path+"/"+printReview+".txt"); // 인턴쉽 폴더 주소
       try{
          Scanner scan = new Scanner(file);
          System.out.print("\n[리뷰 내용] ");
          while(scan.hasNextLine())
          {
             System.out.println(scan.nextLine());
          }
       }catch(IOException e) {
          e.printStackTrace();
       }
       System.out.println("");
   }

}
