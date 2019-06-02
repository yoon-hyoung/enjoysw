package Internship;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import Document.Document;

public class Internship {
	String name;
	int date;
	String company;
	String period;
	String rec_date;
	String select_num;
	String nation;
	String major;
	String host;
	Document Document_list=null;
	LastPassCondition Condition=null;
	Review review_list=null;
	
	
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
					
					if((date=Integer.parseInt(r_buffer.readLine()))<0) {
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
					
					if((rec_date=r_buffer.readLine())==null) {
						System.out.println("선발날짜가 제대로 입력되지 않았습니다.제대로 입력 후 다시 하십시오.");
						r_buffer.close();
						return ;
					}
					if((select_num=r_buffer.readLine())==null) {
						System.out.println("선발인원이 제대로 입력되지 않았습니다.제대로 입력 후 다시 하십시오.");
						r_buffer.close();
						return ;
					}
					
					if((nation=r_buffer.readLine())==null) {
						System.out.println("나라가 제대로 입력되지 않았습니다.제대로 입력 후 다시 하십시오.");
						r_buffer.close();
						return ;
					}
					
					if((major=r_buffer.readLine())==null) {
						System.out.println("전공이 제대로 입력되지 않았습니다.제대로 입력 후 다시 하십시오.");
						r_buffer.close();
						return ;
					}
					
					if((host=r_buffer.readLine())==null) {	
						System.out.println("호스트가 제대로 입력되지 않았습니다.제대로 입력 후 다시 하십시오.");
						r_buffer.close();
						return ;
					}
					r_buffer.close();
					
					
					
				}
				catch(FileNotFoundException e) {
					System.out.println("no File to Sign up list");
				}
				catch(IOException e) {
					System.out.println("no File to Sign up list");
				}
					
			}
		
		
	}
	
	
	public void printAll() {
		System.out.printf(" %s / %d / %s / %s / %s / %s / %s / %s / %s\n",
		name,date,company,
		period,rec_date,select_num,
		nation,major,host);
		return ;
		
	}
	public void printname() {
		
		System.out.println(name);
		return ;
	}
	
	public void setCondition(LastPassCondition condition) {
		this.Condition=condition;
		
	}
	
	public void setname(String name) {
		this.name=name;
		return ;
		
	}
	public void setdate(int date) {
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
	public void setrec_date(String rec_date) {
		this.rec_date=rec_date;
		return ;
	}
	public void setselect_num(String select_num) {
		this.select_num=select_num;
		return ;
	}
	public void setnation(String nation) {
		this.nation=nation;
		return ;
	}
	public void setmajor(String major) {
		this.major=major;
		return ;
	}
	public void sethost(String host) {
		this.host=host;
		return ;
	}
	
	public LastPassCondition getCondition() {
		return Condition;
		
	}
	
	public String getname() {
		
		return name;
		
	}
	public int getdate() {
		return date;
	}
	public String getcompany() {
		return company;
		
	}
	public String getperiod() {
		return period;
	}
	public String getrec_date() {
		return rec_date;
	}
	public String getselect_num() {
		return select_num;
	}
	public String getnation() {
		return nation;
		
	}
	public String getmajor() {
		return major;
	}
	public String gethost() {
		return host;
	}

}