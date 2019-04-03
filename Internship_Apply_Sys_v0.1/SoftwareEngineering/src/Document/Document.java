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
		System.out.print("�߰��� ������ ��θ� �Է��Ͻÿ� >> ����� <0>" );
		System.out.println("\n ����) c:/ User/user/������");
		String filepath = input1.nextLine();
		if(filepath.equals("0"))
			return;
		System.out.print("�߰��� ������ �̸��� �Է��Ͻÿ� >> ");
		String filename = input2.nextLine();
		fileCopy(filepath + "\\" + filename, this.path + "\\" + filename);
		this.list.add(filename);
		System.out.println("��������� �Ϸ�Ǿ����ϴ�.");
		}
	}
	
	public void DelDocument() {
		Scanner input1 = new Scanner(System.in, "euc-kr");
		System.out.print("������ �����̸��� �Է��Ͻÿ� >> ");
		String filename = input1.nextLine();
		fileDelete(this.path + "\\" + filename);
		this.list.remove(filename);
		System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
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