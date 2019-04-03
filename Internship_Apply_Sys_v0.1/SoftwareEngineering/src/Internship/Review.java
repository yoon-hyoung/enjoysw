package Internship;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Review {

   // error ��Ȳ�� �� �� ��ü������ throw �ؾ� ��.
   Scanner input= new Scanner(System.in); 
   String name; // ���Ͻ��� �̸��� �޾ƿ;���.
   String name2; // ������ �̸�
   File file;// ���並 ������ ��������.
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
      System.out.println("---------------���� ���Ͻ� ���--------------");
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
   }
   public int show_review_list(String name)
   {
      System.out.println("--------���� ������ ���Ͻ��� ���� ���----------");
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
         System.out.printf("����� ���Ͻ� ���䰡 ��ϵ� ���� �ʽ��ϴ�.\n");
      }
      return file_list.length;
   }
   public void write_review()
   {
      int size;
      
      System.out.println("[���� ���]�� �����ϼ̽��ϴ�.");
      show_internship_list();
       System.out.println("���� ������ ���Ͻ��� ������. (���� �Է�) >>> ");
       name = input.nextLine();
       make_Review_folder(name);
       size = show_review_list(name);
       size=size+1;
       try{
          fw = new FileWriter("./Internship/"+name+"/Review/review"+size+".txt");
          System.out.print("���� ������ �Է��ϼ���.\n");
          context=input.nextLine();
          fw.write(context);
          fw.close();
       }catch(IOException e) {
          e.printStackTrace();
       }
       
       
   }
   public void rewrite_review()
   {
      System.out.println("[���� ����]�� �����ϼ̽��ϴ�.");
      show_internship_list();
       System.out.print("���� ������ ���Ͻ��� ������.(���� �Է�) >>> ");
       name = input.nextLine();
       show_review_list(name); 
       System.out.print("���� ������ ���並 �Է��ϼ���.(���ϸ� �Է�) >>> ");
       name2=input.nextLine();
       file = new File("./Internship/"+name+"/Review/"+name2+".txt"); // ���Ͻ� ���� �ּ�
       try{
          fw = new FileWriter(file);
          System.out.print("������ ������ �ٽ� �Է��Ͻÿ�.\n");
          context=input.nextLine();
          fw.write(context);
          fw.close();
       }catch(IOException e) {
          e.printStackTrace();
       }
   }
   public void print_review()
   {
      System.out.println("[���� ���]�� �����ϼ̽��ϴ�.");
      show_internship_list();
       System.out.print("���� ������ ���Ͻ��� ������.(���� �Է�) >>> ");
       name = input.nextLine();
       show_review_list(name); 
       System.out.print("���� ������ ���並 �Է��ϼ���.(���ϸ� �Է�) >>> ");
       name2=input.nextLine();
       file = new File("./Internship/"+name+"/Review/"+name2+".txt"); // ���Ͻ� ���� �ּ�
       try{
          Scanner scan = new Scanner(file);
          System.out.print("\n[���� ����] ");
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
      System.out.println("[���� ����]�� �����ϼ̽��ϴ�.");
      show_internship_list();
       System.out.print("���� ������ ���Ͻ��� ������.(���� �Է�) >>> ");
       name = input.nextLine();
       show_review_list(name); 
       System.out.print("���� ������ ���並 �Է��ϼ���.(���ϸ� �Է�) >>> ");
       name2=input.nextLine();
       file = new File("./Internship/"+name+"/Review/"+name2+".txt"); // ���Ͻ� ���� �ּ�
       if( file.exists() ){
            if(file.delete()){
                System.out.println("���ϻ��� ����");
            }else{
                System.out.println("���ϻ��� ����");
            }
        }else{
            System.out.println("������ �������� �ʽ��ϴ�.");
        }

   }
   
   public void review_execute()
   {
      String check;
      Scanner input2= new Scanner(System.in); // Scanner

      boolean loop1 = true;
         
      while(loop1){
         System.out.println("");
         System.out.println("-------------------------------���� ���� �޴��Դϴ�---------------------------");
         System.out.println("----------------------------------------------------------------------------");
          System.out.print("                   [�ȳ�]    h�� �Է��Ͻø� �ٽ� �޴� ���� UI�� ���ư��ϴ�                 \n");
          System.out.println("----------------------------------------------------------------------------");
         // System.out.print("----------------------------------------------------------------------------\n");
          System.out.print("[������ : 1]  [������� : 2]  [������� : 3] >>> ");
          
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