package Internship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class Review implements Serializable {

   // error �긽�솴�쓣 醫� �뜑 援ъ껜�쟻�쑝濡� throw �빐�빞 �븿.
	
	 private String path;// 由щ럭瑜� ���옣�븷 �뤃�뜑�뙆�씪.
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
	      
	   } // internship 異붽��븷 �븣 �깉濡� �뤃�뜑 留뚮뱾�뼱�빞 �맆 �닔 �룄 �엳�쑝�땲  �깮�꽦�옄�뿉 吏묒뼱�꽔�뼱�넃�쓬
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
   
   //Get Set �븿�닔
  
   
   public void show_review_list()
   {
	   Iterator it = reviewName.iterator();
	   
	   if(it.hasNext())
		   while(it.hasNext())
			   System.out.println(it.next());
	   else{
		   System.out.printf("�쁽�옱�뒗 �씤�꽩�떗�씠 �벑濡앸뤌 �엳吏� �븡�뒿�땲�떎.\n");
	   }
   }
   
   public void write_review(String writeReview)
   {
	 
      reviewName.add(writeReview);
      Scanner input=new Scanner(System.in);
	  String context;
      
       try{
          FileWriter fw = new FileWriter(path+"/"+writeReview+".txt");
          System.out.print("�쟻�쓣 �궡�슜�쓣 �엯�젰�븯�꽭�슂.\n");
          context=input.nextLine();
          fw.write(context);
          fw.close();
       }catch(IOException e) {
          e.printStackTrace();
       }
       
       
   }
   
   public void delete_review(String delReview) 
   {
      
       File file = new File(path+"/"+delReview+".txt"); // �씤�꽩�돺 �뤃�뜑 二쇱냼
       if( file.exists() ){
            if(file.delete()){
                System.out.println("�뙆�씪�궘�젣 �꽦怨�");
                setreviewName();
            }else{
                System.out.println("�뙆�씪�궘�젣 �떎�뙣");
            }
        }else{
            System.out.println("�뙆�씪�씠 議댁옱�븯吏� �븡�뒿�땲�떎.");
        }
       
   }
   
   
  
   public void print_review(String printReview)
   {
      
      
       File file = new File(path+"/"+printReview+".txt"); // �씤�꽩�돺 �뤃�뜑 二쇱냼
       try{
          Scanner scan = new Scanner(file);
          System.out.print("\n[由щ럭 �궡�슜] ");
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
