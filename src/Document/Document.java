package Document;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Document {

	String path;
	ArrayList list = new ArrayList();
	
	public Document() {
		this.path = null;
	}
	
	public Document(String Definition, String name) {
		this.path = "." + "/" + Definition + "/" + name + "/" + "Document" ;
	}
	
	public ArrayList GetList() {
		return this.list;
	}
	
	public void SetList() {
		this.list = new ArrayList();
		File folder = new File(this.path);
		File[] list = folder.listFiles();
		for(File file : list) {
			this.list.add(file.getName());
		}
	}
	public void NonRegistDocument(String Internship) {
		SetList();
		String InternPath = "." + "/" + "Internship" + "/" + Internship + "/" + "Document" ;
		File folder = new File(InternPath);
		ArrayList InternDocu = new ArrayList();
		File[] list = folder.listFiles();
		for(File file : list) {
			if(file.isFile())
				InternDocu.add(file.getName());
		}
		
		for(Object sub : this.list){
		for(Object object : InternDocu) {	
				if(((String)sub).equals((String)object)) {
					InternDocu.remove(object);
					break;
				}
			}
		}
		System.out.println(InternDocu);
		
	}
	
	public void AddDocument() {
		Scanner input1 = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		while(true) {
		System.out.print("추가할 서류의 경로를 입력하시오 >> 종료시 <0>" );
		System.out.println("\n 예시) c:/ User/user/내문서");
		String filepath = input1.nextLine();
		if(filepath.equals("0"))
			return;
		System.out.print("추가할 서류의 이름을 입력하시오 >> ");
		String filename = input2.nextLine();
		fileCopy(filepath + "\\" + filename, this.path + "\\" + filename);
		this.list.add(filename);
		System.out.println("서류등록이 완료되었습니다.");
		}
	}
	
	public void DelDocument() {
		Scanner input1 = new Scanner(System.in, "euc-kr");
		System.out.print("삭제할 서류이름을 입력하시오 >> ");
		String filename = input1.nextLine();
		fileDelete(this.path + "\\" + filename);
		this.list.remove(filename);
		System.out.println("서류 삭제가 완료되었습니다.");
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
	
	public void SetPath(String Definition, String name) {
		this.path = "." + "/" + Definition + "/" + name + "/" + "Document" ;
	}
	
	public String GetPath() {
		return this.path;
	}
	
	public void MakeStorage() {
		File file = new File(this.path);
		if(!file.exists())
			file.mkdirs();
	}
	
	public void PrintDocumentList() {
		SetList();
		System.out.println(this.list);
	}

	
}