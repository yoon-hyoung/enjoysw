package Document;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class Document implements Serializable{
	
	private ArrayList docuList = new ArrayList();
	
	private String type;
	private String destination;
	// type : internship, student  destination : �꽭遺��뤃�뜑

	
	public ArrayList GetdocuList() {
		return this.docuList;
	}
	
	public void SetList() { //�뙆�씪�뿉�꽌 set �븯�뒗寃�, �떎 �씫�뼱�삤�뒗寃�.
		
		
		String path="./" + type + "/" + destination + "/Document" ;
		File docuDir = new File(path);
		String[] fileList = docuDir.list();
		int i; //iterator
		docuList= new ArrayList();
		
		for(i=0;i<fileList.length;i++) {
			this.docuList.add(fileList[i]);
		}
		
	}
	
	//get set �븿�닔
	
	public Document(String type, String destination) { 
		this.type=type;
		this.destination=destination;
		
		String path="./" + type + "/" + destination + "/Document" ;
		File docuDir = new File(path);
		
	    if(docuDir.exists()==false)
	    {docuDir.mkdirs();}
	    // docu �뒗 review �� 媛숈씠 internship �씠 �벑濡� �맆 �븣 �깉濡� 留뚮뱾�뼱 吏� �닔 �엳�쑝誘�濡� constructor �뿉 �뵒�젆�넗由ъ깮�꽦
		String[] fileList = docuDir.list();
		int i; //iterator
		
		for(i=0;i<fileList.length;i++) {
			this.docuList.add(fileList[i]);
		}
	}
	//constructor

	public void AddDocument(String inFileName,String outFileName) { 
		String path="./" + type + "/" + destination + "/Document" ;//�뙆�씪�벑濡�
		this.docuList.add(outFileName);
		fileCopy(inFileName,path+"/"+outFileName+".txt");
	}
	
	public void DelDocument(String del_file) { //�뙆�씪�궘�젣

		String path="./" + type + "/" + destination + "/Document" ;
		
		fileDelete(path + "/" + del_file+".txt");
		this.docuList.remove(del_file);
		
	}
	//異붽� �궘�젣
	public static void fileDelete(String deleteFileName) { 
		  File I = new File(deleteFileName);
		  I.delete();
		 }
	
	public static void fileCopy(String inFileName, String outFileName) {
		  try {
		   FileInputStream fis = new FileInputStream(inFileName);
		   FileOutputStream fos = new FileOutputStream(outFileName);
		   
		   int data = 0;
		   while((data=fis.read())!=-1) {
		    fos.write(data);
		   }
		   fis.close();
		   fos.close();
		   
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		 }
	// file 愿��젴�븿�닔
	public void PrintDocumentList() {
		SetList();
		System.out.println(this.docuList);
	}
	//print
	
}