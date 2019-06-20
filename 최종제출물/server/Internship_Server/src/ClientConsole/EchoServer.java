package ClientConsole;
// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import server.*;
import server.AbstractServer;
import server.ConnectionToClient;
import Server_contents.*;
import Student.*;
import Internship.*;

public class EchoServer extends AbstractServer 
{
  //Class variables *************************************************
  

  final public static int DEFAULT_PORT = 5555;
  
  //Constructors ****************************************************
  

  public EchoServer(int port) 
  {
    super(port);
  }

  
  //Instance methods ************************************************

  public void handleMessageFromClient
    (Object msg, ConnectionToClient client)
  {
	  MessageHandler recv_message = new MessageHandler();
	 recv_message = (MessageHandler)msg;
	  MessageHandler send_message =new MessageHandler();
	  Student_Server student = null;
	  System.out.printf("%s,%s,%d",recv_message.getID(),recv_message.getPassword(),recv_message.getoptNumber());
	  
	  if(recv_message.check == true) {
			 System.out.println("\n\ntest\n\n");
	  if(recv_message.getoptNumber() == 0) {
		 
		  try {
			 
			 student = new Student_Server(recv_message.getID());
		} catch (IOException e) {
			e.printStackTrace();
		}
		  send_message.setStudent(student.getStudent());
		  send_message.setInternship(student.getInternship());
		  System.out.print("gdgd: ");
		  student.getStudent().getDocu().PrintDocumentList();
		  for(int i=0;i<student.getInternship().length;i++) {
 			 	if(student.getInternship()[i].getname()==null) {
 			 		break;
 			 	}
 			 	student.getInternship()[i].printname();
		  }
		  try {

				client.sendToClient((Object)send_message);
	
			} catch (IOException e) {
				e.printStackTrace();
			}
		  
	  }else if(recv_message.getoptNumber() == 12) {
		 String ID= recv_message.getID();
		 String PW= recv_message.getPassword();

		 Login login= new Login(ID,PW);
		 send_message.setLogin_state(login.getLogin_status());
		 send_message.setID(ID);
		 send_message.setPassword(PW);
		 send_message.check = true;
		try {
			client.sendToClient((Object)send_message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	  recv_message.check = false;
	  }
  }
    

  protected void serverStarted()
  {
    System.out.println
      ("Server listening for connections on port " + getPort());
  }
  

  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }
  
  //Class methods ***************************************************
  

  public static void main(String[] args) 
  {
    int port = 0; //Port to listen on

    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
    }
	
    EchoServer sv = new EchoServer(port);
    
    try 
    {
      sv.listen(); //Start listening for connections
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
  }
}
//End of EchoServer class
