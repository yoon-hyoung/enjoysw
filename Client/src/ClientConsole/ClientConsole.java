package ClientConsole;
// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import client.*;
import common.*;

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
  int flag=0;
  
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
    try{
      BufferedReader fromConsole = 
        new BufferedReader(new InputStreamReader(System.in));
      String message;

      while (true) {
    	while(true) {
    		System.out.println("Login\n1 : Student\n2 : Staff");
    		message = fromConsole.readLine();
    		if(message.contentEquals("1")) {
    			login();
    		}
            
    		break;
    	}
    	
      }
    } 
    catch (Exception ex) {
      System.out.println
        ("Unexpected error while reading from console!");
    }
  }
  
  public void login() throws IOException {
	  BufferedReader fromConsole = 
		        new BufferedReader(new InputStreamReader(System.in));
	  String id;
	  String password;
	  MessageHandler message=new MessageHandler() ;
	  
	  message.setoptNumber(12);
	  System.out.printf("ID : ");
	  id = fromConsole.readLine();
	  System.out.printf("password : ");
	  password = fromConsole.readLine();
	  message.setID(id);
	  message.setPassword(password);
	  
	  client.handleMessageFromClientUI(message);
	  while(true) {
	  if(flag==1)break;}
	  message = recv_from_message;
	  if(message.getLogin_state()==0) {
		  System.out.print(message.getLogin_state());
		  System.out.println("실패!");
	  }else if(message.getLogin_state()==1) {
		  System.out.print(message.getLogin_state());
		  System.out.println("성공!");
	  }else {
		  System.out.println("성공!");
	  }
	  
	  
  }
  
  public void display(String message) {
    System.out.println("> " + message);
  }
  public void messageFromServer(Object message) {
	  this.recv_from_message=(MessageHandler)message;
	  this.flag=1;
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
