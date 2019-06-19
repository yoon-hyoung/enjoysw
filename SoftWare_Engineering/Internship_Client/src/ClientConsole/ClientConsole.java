package ClientConsole;
// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import client.*;
import common.*;
import Student.*;
import Internship.*;

/**
 * This class constructs the UI for a chat client.  It implements the
 * chat interface in order to activate the display() method.
 * Warning: Some of the code here is cloned in ServerConsole 
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge  
 * @author Dr Robert Lagani&egrave;re
 * @version July 2000
 */
public class ClientConsole implements ChatIF 
{
  final public static int DEFAULT_PORT = 5555;

  ChatClient client;
  MessageHandler recv_from_message;
  boolean flag=false;
  
  Student student;
  Internship[] internship;
  
  MessageHandler msg=new MessageHandler() ;
  
  public ClientConsole(String host, int port) {
    try 
    {
      client= new ChatClient(host, port, this);
    } 
    catch(IOException exception) 
    {
      System.out.println("Error: Can't setup connection!"
                + " Terminating client.");
      System.exit(1);
    }
  }
  
  public void accept() {
	  int state;
	  int inputNum;
	  
    try{
      BufferedReader fromConsole = 
        new BufferedReader(new InputStreamReader(System.in));

      while(true) {
  		System.out.println("Login\n1 : Student\n2 : Staff");
  		inputNum = Integer.parseInt(fromConsole.readLine());
  		if(inputNum==1) {
  			state=login();
  			break;
  		}else if(inputNum==2) {
  			state=login();
  			break;
  			
  		}else {
  			System.out.println("Invalid Menu COMMAND");
  		}
  	 }
      
      
      msg.setoptNumber(0);
      client.handleMessageFromClientUI(msg);
      while(true) {
		  if(flag==true)
			  break;
		  }
	  flag=false;
	  
	  student = msg.getStudent();
	  internship = msg.getInternship();
	  
	  System.out.println(msg.getStudent().getID());
      while(true) {
      if(state == 1) {
    	  System.out.println("1. Student Information");
    	  System.out.println("2. Internship");
    	  System.out.println("3. Document");
    	  System.out.println("4. Review of Internship");
    	  inputNum = Integer.parseInt(fromConsole.readLine());
    	  
    	  switch(inputNum) {
          case 1:{
             System.out.println("1. Print Private Information");
             System.out.println("2. Print Applied Intership");
             System.out.print("Select Menu : ");
             inputNum = Integer.parseInt(fromConsole.readLine());
             if(inputNum==1)
                student.print_info(); // 1번일 경우
             else if(inputNum==2)
                student.print_apply_internship();
             else
                System.out.println("Invalid Menu COMMAND");
             break;
          }
          case 2:{
             System.out.println("1. Print Detail of Intership");
             System.out.println("2. Apply Intership");
             System.out.println("3. Cancel Intership");
             System.out.print("Select Menu : ");
             inputNum = Integer.parseInt(fromConsole.readLine());
             if(inputNum==1)
                student.print_apply_internship();
             else if(inputNum==2)
                //인턴쉽 신청
            	 ;
             else if(inputNum==3)
                //인턴쉽 취소
            	 ;
             else
                System.out.println("Invalid Menu COMMAND");
             break;
          }
          case 3:{
             System.out.println("1. Register Document");
             System.out.println("2. Delete Document");
             System.out.println("3. Print Document List");
             System.out.print("Select Menu : ");
             inputNum = Integer.parseInt(fromConsole.readLine());
             if(inputNum==1)
                //student.addDocu(inFileName, outFileName);
            	 ;
             else if(inputNum==3)
                //student.delDocu(del_file);
            	 ;
             else if(inputNum==3)
                //student.printDocu();
            	 ;
             else
                System.out.println("Invalid Menu COMMAND");
             break;
          }
          case 4:{
             System.out.println("1. Write Review");
             System.out.println("2. Print Review List");
             System.out.println("3. Print Detail of Review");
             System.out.print("Select Menu : ");
             inputNum = Integer.parseInt(fromConsole.readLine());
             if(inputNum==1)
               // student.write_review(review_internship, write_review_name);
            	 ;
             else if(inputNum==2)
               // student.print_review_All(review_internship, print_review);
            	 ;
             else if(inputNum==3)
               // student.print_review_All(review_internship, print_review);
            	 ;
             else
                System.out.println("Invalid Menu COMMAND");
             break;
          }
          default:{
             System.out.println("Invalid Menu COMMAND");
             break;
          }
      }
      }
      }
    }
    catch (Exception ex) {
      System.out.println
        ("Unexpected error while reading from console!");
    }
  }
  
  public int login() throws IOException {
	  BufferedReader fromConsole = 
		        new BufferedReader(new InputStreamReader(System.in));
	  String id;
	  String password;
	  
	  msg.setoptNumber(12);
	  System.out.printf("ID : ");
	  id = fromConsole.readLine();
	  System.out.printf("password : ");
	  password = fromConsole.readLine();
	  msg.setID(id);
	  msg.setPassword(password);
	  
	  client.handleMessageFromClientUI(msg);
	  while(true) {
		  if(flag==true) {
			  break;
		  }
	  }
	  flag=false;
	  
	  msg = recv_from_message;
	  
	  System.out.println(msg.getLogin_state());
	  System.out.println(msg.getID());
	  if(msg.getLogin_state()==0) {
		  System.out.println("실패!");
		  return 0;
	  }else if(msg.getLogin_state()==1) {
		  System.out.println("성공!");
		  return 1;
	  }else {
		  System.out.println("성공!");
		  return 2;
	  }
  }
  
  public void display(String message) {
    System.out.println("> " + message);
  }
  public void messageFromServer(Object message) {
	  this.recv_from_message=(MessageHandler)message;
	  this.flag=true;
  }
  
  public static void main(String[] args){
    String host = "";
    int port = 0;  //The port number

    try
    {
      host = args[0];
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
      host = "localhost";
    }
    ClientConsole chat= new ClientConsole(host, DEFAULT_PORT);
    chat.accept();
  }
  
  public void socket_wait() {
	  while(true) {
		  if(flag==true)
			  break;
		  }
	  flag=false;
  }
}
