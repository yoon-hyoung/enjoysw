package Internship;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Review {

   // error 상황을 좀 더 구체적으로 throw 해야 함.
   Scanner input= new Scanner(System.in); 
   String name; // 인턴쉽의 이름을 받아와야함.
   String name2; // 리뷰의 이름
   File file;// 리뷰를 저장할 폴더파일.
   File[] file_list;
   FileWriter fw;
   String context;
   
   public void make_Review_folder(String name)
   {
      file= new File("./Internship/"+name+"/Review");
      if(file.exists()==false)
      {file.mkdirs();}
   }
   
   public void show_internship_list()
   {
      System.out.println("---------------현재 인턴쉽 목록--------------");
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
   }
   public int show_review_list(String name)
   {
      System.out.println("--------현재 선택한 인턴쉽의 리뷰 목록----------");
      file= new File("./Internship/"+name+"/Review");
      file_list=file.listFiles();
      
      if(file_list.length>=1)
      {
         for(int i=0; i<file_list.length; i++)
         {
            System.out.printf("%s\n",file_list[i].getName());
         }
      }
      else{
         System.out.printf("현재는 인턴쉽 리뷰가 등록돼 있지 않습니다.\n");
      }
      return file_list.length;
   }
   public void write_review()
   {
      int size;
      
      System.out.println("[리뷰 등록]을 선택하셨습니다.");
      show_internship_list();
       System.out.println("▶▶ 선택할 인턴쉽을 고르세요. (제목 입력) >>> ");
       name = input.nextLine();
       make_Review_folder(name);
       size = show_review_list(name);
       size=size+1;
       try{
          fw = new FileWriter("./Internship/"+name+"/Review/review"+size+".txt");
          System.out.print("적을 내용을 입력하세요.\n");
          context=input.nextLine();
          fw.write(context);
          fw.close();
       }catch(IOException e) {
          e.printStackTrace();
       }
       
       
   }
   public void rewrite_review()
   {
      System.out.println("[리뷰 수정]을 선택하셨습니다.");
      show_internship_list();
       System.out.print("▶▶ 선택할 인턴쉽을 고르세요.(제목 입력) >>> ");
       name = input.nextLine();
       show_review_list(name); 
       System.out.print("▶▶ 선택할 리뷰를 입력하세요.(파일명만 입력) >>> ");
       name2=input.nextLine();
       file = new File("./Internship/"+name+"/Review/"+name2+".txt"); // 인턴쉽 폴더 주소
       try{
          fw = new FileWriter(file);
          System.out.print("수정할 내용을 다시 입력하시오.\n");
          context=input.nextLine();
          fw.write(context);
          fw.close();
       }catch(IOException e) {
          e.printStackTrace();
       }
   }
   public void print_review()
   {
      System.out.println("[리뷰 출력]을 선택하셨습니다.");
      show_internship_list();
       System.out.print("▶▶ 선택할 인턴쉽을 고르세요.(제목 입력) >>> ");
       name = input.nextLine();
       show_review_list(name); 
       System.out.print("▶▶ 선택할 리뷰를 입력하세요.(파일명만 입력) >>> ");
       name2=input.nextLine();
       file = new File("./Internship/"+name+"/Review/"+name2+".txt"); // 인턴쉽 폴더 주소
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
   public void delete_review() 
   {
      System.out.println("[리뷰 삭제]를 선택하셨습니다.");
      show_internship_list();
       System.out.print("▶▶ 선택할 인턴쉽을 고르세요.(제목 입력) >>> ");
       name = input.nextLine();
       show_review_list(name); 
       System.out.print("▶▶ 선택할 리뷰를 입력하세요.(파일명만 입력) >>> ");
       name2=input.nextLine();
       file = new File("./Internship/"+name+"/Review/"+name2+".txt"); // 인턴쉽 폴더 주소
       if( file.exists() ){
            if(file.delete()){
                System.out.println("파일삭제 성공");
            }else{
                System.out.println("파일삭제 실패");
            }
        }else{
            System.out.println("파일이 존재하지 않습니다.");
        }

   }
   
   public void review_execute()
   {
      String check;
      Scanner input2= new Scanner(System.in); // Scanner

      boolean loop1 = true;
         
      while(loop1){
         System.out.println("");
         System.out.println("-------------------------------리뷰 관리 메뉴입니다---------------------------");
         System.out.println("----------------------------------------------------------------------------");
          System.out.print("                   [안내]    h를 입력하시면 다시 메뉴 선택 UI로 돌아갑니다                 \n");
          System.out.println("----------------------------------------------------------------------------");
         // System.out.print("----------------------------------------------------------------------------\n");
          System.out.print("[리뷰등록 : 1]  [리뷰수정 : 2]  [리뷰출력 : 3] >>> ");
          
          check=input2.nextLine();
          if(check.equals("h"))
             {break;}
          else if(check.equals("1"))
               write_review();
          else if(check.equals("2"))
             rewrite_review();
          else if(check.equals("3"))
             print_review();
      }
   }


}