package Document;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Document {
	
	private ArrayList docuList = new ArrayList();
	
	private String type;
	private String destination;
	// type : internship, student  destination : 세부폴더
	
	public Document(String type, String destination) { 
		this.type=type;
		this.destination=destination;
		
		String path="./" + type + "/" + destination + "/Document" ;
		File docuDir = new File(path);
		String[] fileList = docuDir.list();
		int i; //iterator
		
		for(i=0;i<fileList.length;i++) {
			this.docuList.add(fileList[i]);
		}
	}
	
	public ArrayList GetdocuList() {
		return this.docuList;
	}
	
	public void SetList() { //파일에서 set 하는것, 다 읽어오는것.
		
		
		String path="./" + type + "/" + destination + "/Document" ;
		File docuDir = new File(path);
		String[] fileList = docuDir.list();
		int i; //iterator
		
		for(i=0;i<fileList.length;i++) {
			this.docuList.add(fileList[i]);
		}
		
	}
	

	public void AddDocument(String docuList,String inFileName,String outFileName) { //파일등록
		this.docuList.add(docuList);
		fileCopy(inFileName,outFileName);
	}
	
	public void DelDocument(String del_file) { //파일삭제
	//	Scanner input1 = new Scanner(System.in, "euc-kr");
	//	System.out.print("삭제할 서류이름을 입력하시오 >> ");
	//	String filename = input1.nextLine();
		String path="./" + type + "/" + destination + "/Document" ;
		
		fileDelete(path + "/" + del_file);
		this.docuList.remove(del_file);
		
	}
	
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
	
	public void PrintDocumentList(String type, String destination) {
		SetList();
		System.out.println(this.docuList);
	}

	
}