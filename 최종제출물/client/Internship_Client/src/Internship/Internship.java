package Internship;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import Document.Document;

public class Internship implements Serializable{
	String name;
	String date;
	String company;
	String period;
	String select_date;
	String select_num;
	String region;
	String major;

	Document Docu;
	Review review;
	
	
	public Internship(String Filename) {

			
			File new_intern = new File(Filename);
			
			
		
			if(new_intern.exists()) {
				
				try{
					
					FileReader filereader = new FileReader(new_intern);
					BufferedReader r_buffer=new BufferedReader(filereader);
					
					if((name=r_buffer.readLine())==null){
						System.out.println("이름이 제대로 입력되지 않았습니다.제대로 입력 후 다시 하십시오.");
						r_buffer.close();
						return ;
					};
					
					if((date=r_buffer.readLine())==null) {
						System.out.println("날짜가 제대로 입력되지 않았습니다.제대로 입력 후 다시 하십시오.");
						r_buffer.close();
						return ;
					}
					if((company=r_buffer.readLine())==null){
						System.out.println("회사가 제대로 입력되지 않았습니다.제대로 입력 후 다시 하십시오.");
						r_buffer.close();
						return ;
					}
					
					if((period=r_buffer.readLine())==null) {
						System.out.println("기간이 제대로 입력되지 않았습니다.제대로 입력 후 다시 하십시오.");
						r_buffer.close();
						return ;
					}
					
					if((select_date=r_buffer.readLine())==null) {
						System.out.println("선발날짜가 제대로 입력되지 않았습니다.제대로 입력 후 다시 하십시오.");
						r_buffer.close();
						return ;
					}
					if((select_num=r_buffer.readLine())==null) {
						System.out.println("선발인원이 제대로 입력되지 않았습니다.제대로 입력 후 다시 하십시오.");
						r_buffer.close();
						return ;
					}
					
					if((region=r_buffer.readLine())==null) {
						System.out.println("지역이 제대로 입력되지 않았습니다.제대로 입력 후 다시 하십시오.");
						r_buffer.close();
						return ;
					}
					
					if((major=r_buffer.readLine())==null) {
						System.out.println("전공이 제대로 입력되지 않았습니다.제대로 입력 후 다시 하십시오.");
						r_buffer.close();
						return ;
					}
					
					r_buffer.close();
					review=new Review(name);
					Docu=new Document("Internship", this.name);
					
				}
				catch(FileNotFoundException e) {
					System.out.println("no File to Sign up list");
				}
				catch(IOException e) {
					System.out.println("no File to Sign up list");
				}
					
			}
			
		
		
	}
	//constructor
	public void setname(String name) {
		this.name=name;
		return ;
	}
	public void setdate(String date) {
		this.date=date;
		return ;
	}
	public void setcompany(String company) {
		this.company=company;
		return ;
		
	}
	public void setperiod(String period) {
		this.period=period;
		return ;
	}
	public void setrec_date(String select_date) {
		this.select_date=select_date;
		return ;
	}
	public void setselect_num(String select_num) {
		this.select_num=select_num;
		return ;
	}
	public void setnation(String region) {
		this.region=region;
		return ;
	}
	public void setmajor(String major) {
		this.major=major;
		return ;
	}
	
	public String getname() {
		
		return name;
		
	}
	public String getdate() {
		return date;
	}
	public String getcompany() {
		return company;
		
	}
	public String getperiod() {
		return period;
	}
	public String getrec_date() {
		return select_date;
	}
	public String getselect_num() {
		return select_num;
	}
	public String getregion() {
		return region;
		
	}
	public String getmajor() {
		return major;
	}
	public Review getreview() {
		return review;
	}
	public Document getDocu() {
		return Docu;
	}
	//get set
	public void printAll() {
		System.out.printf(" %s / %s / %s / %s / %s / %s / %s / %s \n",
		name,date,company,
		period,select_date,select_num,
		region,major);
		return ;
		
	}
	public void printname() {
		
		System.out.println(name);
		return ;
	}
	

	
	//print 함수

}