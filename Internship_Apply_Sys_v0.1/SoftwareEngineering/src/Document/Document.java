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

	
	public ArrayList GetdocuList() {
		return this.docuList;
	}
	
	public void SetList() { //파일에서 set 하는것, 다 읽어오는것.
		
		
		String path="./" + type + "/" + destination + "/Document" ;
		File docuDir = new File(path);
		String[] fileList = docuDir.list();
		int i; //iterator
		docuList= new ArrayList();
		
		for(i=0;i<fileList.length;i++) {
			this.docuList.add(fileList[i]);
		}
		
	}
	
	//get set 함수
	
	public Document(String type, String destination) { 
		this.type=type;
		this.destination=destination;
		
		String path="./" + type + "/" + destination + "/Document" ;
		File docuDir = new File(path);
		
	    if(docuDir.exists()==false)
	    {docuDir.mkdirs();}
	    // docu 는 review 와 같이 internship 이 등록 될 때 새로 만들어 질 수 있으므로 constructor 에 디렉토리생성
		String[] fileList = docuDir.list();
		int i; //iterator
		
		for(i=0;i<fileList.length;i++) {
			this.docuList.add(fileList[i]);
		}
	}
	//constructor

	public void AddDocument(String inFileName,String outFileName) { 
		String path="./" + type + "/" + destination + "/Document" ;//파일등록
		this.docuList.add(outFileName);
		fileCopy(inFileName,path+"/"+outFileName+".txt");
	}
	
	public void DelDocument(String del_file) { //파일삭제

		String path="./" + type + "/" + destination + "/Document" ;
		
		fileDelete(path + "/" + del_file+".txt");
		this.docuList.remove(del_file);
		
	}
	//추가 삭제
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
	// file 관련함수
	public void PrintDocumentList() {
		SetList();
		System.out.println(this.docuList);
	}
	//print
	
}