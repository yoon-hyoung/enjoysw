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
  MessageHandler recv_from_message = new MessageHandler() ;
  MessageHandler write_to_message = new MessageHandler() ;
  
  Student student;
  Internship[] internship;
  
  boolean status = false;

  
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
     int state = 0;
     int inputNum = 0;
     
     BufferedReader fromConsole = 
              new BufferedReader(new InputStreamReader(System.in));
     
     
    try{
      while(true) {
        System.out.println("Login\n1 : Student\n2 : Staff");
        inputNum = Integer.parseInt(fromConsole.readLine());
        if(inputNum==1) {
           state=login();
           if(state!=0) 
              break;
        }else if(inputNum==2) {
           state=login();
           break;
           
        }else {
           System.out.println("Invalid Menu COMMAND");
        }
      }
    }
    catch (Exception ex) {
      System.out.println
        ("Unexpected error while reading from console!");
    }
      
      
      write_to_message.setoptNumber(0);
      client.handleMessageFromClientUI((Object)write_to_message);
      try {
        Thread.sleep(2000);
     } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     }
     recv_from_message.check = false;
      
     student = recv_from_message.getStudent();
     internship = recv_from_message.getInternship();
     
     System.out.println(recv_from_message.getStudent().getID());
        
      while(true) {
      if(state == 1) {
         System.out.println("1. Student Information");
         System.out.println("2. Internship");
         System.out.println("3. Document");
         System.out.println("4. Review of Internship");
         try {
         inputNum = Integer.parseInt(fromConsole.readLine());
      } catch (NumberFormatException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
         
         switch(inputNum) {
         
         
          case 1:{
             System.out.println("1. Print Private Information");
             System.out.println("2. Print Applied Intership");
             System.out.print("Select Menu : ");
             try {
            inputNum = Integer.parseInt(fromConsole.readLine());
         } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
             if(inputNum==1)
                student.print_info(); // 1甕곕뜆�뵬 野껋럩�뒭
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
             try {
            inputNum = Integer.parseInt(fromConsole.readLine());
         } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
             if(inputNum==1)
                student.print_apply_internship();
             else if(inputNum==2)
                //占쎌뵥占쎄쉘占쎈뤊 占쎈뻿筌ｏ옙
                ;
             else if(inputNum==3)
                //占쎌뵥占쎄쉘占쎈뤊 �뿆�뫁�꺖
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
             try {
            inputNum = Integer.parseInt(fromConsole.readLine());
         } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
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
             try {
            inputNum = Integer.parseInt(fromConsole.readLine());
         } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
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
  
  public int login() throws IOException {
     BufferedReader fromConsole = 
              new BufferedReader(new InputStreamReader(System.in));
     String id;
     String password;
     
     write_to_message.setoptNumber(12);
     System.out.printf("ID : ");
     id = fromConsole.readLine();
     System.out.printf("password : ");
     password = fromConsole.readLine();
     write_to_message.setID(id);
     write_to_message.setPassword(password);
     write_to_message.check = true;
     client.handleMessageFromClientUI((Object)write_to_message);
     try {
      Thread.sleep(2000);
   } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
     recv_from_message.check = false;
     
     System.out.println(recv_from_message.getLogin_state());
     System.out.println(recv_from_message.getID());
     System.out.println(recv_from_message.getPassword());
     if(recv_from_message.getLogin_state()==0) {
        System.out.println("Failed OTL...");
        return 0;
     }else if(recv_from_message.getLogin_state()==1) {
        System.out.println("Success Student");
        return 1;
     }else {
        System.out.println("Success Staff!");
        return 2;
     }
  }
  
  public void display(String message) {
    System.out.println("> " + message);
  }
  public void messageFromServer(Object message) {
     this.recv_from_message=(MessageHandler)message;
     this.status = true;
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
  
}