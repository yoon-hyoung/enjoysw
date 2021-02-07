package internship_apply_UI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Notification {
	
	public void AllNoti(String name) {
		System.out.println("====================================================================");
		System.out.println("------------------------------[System 알림]--------------------------------");
		passer(name);
		NonRegistDocu(name);
		interNoti(name);
	}
		
	public void NonRegistDocu(String name) {
		
		File folder = new File("." + "/" + "Student" + "/" + name + "/"+"AppliedInternship");
		File[] list = folder.listFiles();
		ArrayList Applied = new ArrayList();
		for(File f : list) {
			Applied.add(f.getName());
		}

		for(Object object : Applied) {
			File file = new File("." + "/" + "Internship" + "/" + object + "/" + "Document") ;
			File[] doculist = file.listFiles();
			File myfile = new File("." + "/" + "Student" + "/" + name + "/"+"Document");
			File[] mydocu = myfile.listFiles();
			ArrayList my = new ArrayList();
			for(File tmp : mydocu)
				my.add(tmp.getName());
			ArrayList intern = new ArrayList();
			for(File temp : doculist)
				intern.add(temp.getName());
			
			for(Object sub : my){
				for(Object obj : intern) {	
					if(((String)sub).equals((String)obj)) {
						intern.remove(obj);
						break;
					}
				}
			}
			// Internship 폴더 밑에 Document 폴더로 들어가고, Stduent/ID/Document 폴더로 들어가서, 서로 비교했다.
			System.out.println("\n<System> 지원한 " + object + "에 부족한 서류 목록입니다. >>");
			System.out.println(intern);

		}	
	}
	
	public void passer(String name) {
			File folder = new File("." + "/" + "Student" + "/" + name + "/"+"AppliedInternship");
			File[] list = folder.listFiles();
			ArrayList Applied = new ArrayList();
			for(File f : list) {
				Applied.add(f.getName());
			}
			
			System.out.println("\n[System] 합격한 인턴쉽 목록입니다. >>");
			for(Object object : Applied) {
				try {
				File file = new File("." + "/" + "Internship" + "/" + object +"/" + "Passer.txt");
				FileReader filereader = new FileReader(file);
				BufferedReader bufReader = new BufferedReader(filereader);
				String line = "";
				while((line = bufReader.readLine())!= null){
					if(line.equals(name))
						System.out.println(object);
				}
				}catch(FileNotFoundException e) {
					//
				}catch(IOException e) {
					System.out.print(e);
				}
			}
	}
	
	// 관심 분야를 알려 주는 그런... (관심 인턴쉽과 다름)
	public void interNoti(String name){
		System.out.println("\n[System] 관심분야와 관련된 인턴쉽 목록입니다.>>");
		File folder = new File("." + "/" + "Internship");
		File[] list = folder.listFiles();
		ArrayList Intern = new ArrayList();
		for(File f : list)
			Intern.add(	f.getName());
		try {
		File file1 = new File("." + "/" + "Student" + "/" + name +"/" + "Interested.txt");

		FileReader filereader1 = new FileReader(file1);
		BufferedReader bufReader1 = new BufferedReader(filereader1);
		String line1 = "";
		int  count=1;
		while((line1 = bufReader1.readLine())!= null){
			switch(count) {
			case 1:
				System.out.print("[System] 지역" + "(" + line1 +") : ");
				break;
			case 2:
				System.out.print("[System] 기간" + "(" + line1 +") : ");
				break;
			case 3:
				System.out.print("[System] 기업" + "(" + line1 +") : ");
				break;
			}
			for(Object object : Intern) {
				File file2= new File("." + "/" + "Internship" + "/" + object + "/" +object + ".txt");
				FileReader filereader2 = new FileReader(file2);
				BufferedReader bufReader2 = new BufferedReader(filereader2);
				String line2 = "";
				while((line2 = bufReader2.readLine())!= null)
					if(line1.equals(line2)) {
						System.out.println(object);
						break;
					}
			}
			count++;
		}
		}catch(FileNotFoundException e) {
			//
		}catch(IOException e) {
			System.out.print(e);
		}
	}		
}
