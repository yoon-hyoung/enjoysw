package ClientConsole;
// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import server.*;
import server.AbstractServer;
import server.ConnectionToClient;

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
	  MessageHandler recv_message = (MessageHandler)msg;
	  MessageHandler send_message =new MessageHandler();
	  System.out.printf("%s,%s",recv_message.getID(),recv_message.getPassword());
    if(recv_message.getID().equals("jino1996")&& recv_message.getPassword().equals("1234")) {
    	send_message.setoptNumber(13);
    	send_message.setLogin_state(1);
    	this.sendToAllClients(send_message);
    }
    else {
    	send_message.setoptNumber(13);
    	send_message.setLogin_state(0);
    	this.sendToAllClients(send_message);
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
