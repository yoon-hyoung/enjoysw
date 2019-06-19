// This file contains material supporting section 3.8 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package server;


import java.net.*;
import java.util.*;
import java.io.*;


public abstract class AbstractServer implements Runnable
{
  // INSTANCE VARIABLES *********************************************


  private ServerSocket serverSocket = null;

  private Thread connectionListener;

  private int port;

  private int timeout = 500;

  private int backlog = 10;

  private ThreadGroup clientThreadGroup;

  private boolean readyToStop = false;


// CONSTRUCTOR ******************************************************

  public AbstractServer(int port)
  {
    this.port = port;

    this.clientThreadGroup =
      new ThreadGroup("ConnectionToClient threads")
      {
        public void uncaughtException(
          Thread thread, Throwable exception)
        {
          clientException((ConnectionToClient)thread, exception);
        }
      };
  }


// INSTANCE METHODS *************************************************

  final public void listen() throws IOException
  {
    if (!isListening())
    {
      if (serverSocket == null)
      {
        serverSocket = new ServerSocket(getPort(), backlog);
      }

      serverSocket.setSoTimeout(timeout);
      readyToStop = false;
      connectionListener = new Thread(this);
      connectionListener.start();
    }
  }

  final public void stopListening()
  {
    readyToStop = true;
  }


  final synchronized public void close() throws IOException
  {
    if (serverSocket == null)
      return;
      stopListening();
    try
    {
      serverSocket.close();
    }
    finally
    {
      // Close the client sockets of the already connected clients
      Thread[] clientThreadList = getClientConnections();
      for (int i=0; i<clientThreadList.length; i++)
      {
         try
         {
           ((ConnectionToClient)clientThreadList[i]).close();
         }
         // Ignore all exceptions when closing clients.
         catch(Exception ex) {}
      }
      serverSocket = null;
      serverClosed();
    }
  }


  public void sendToAllClients(Object msg)
  {
    Thread[] clientThreadList = getClientConnections();

    for (int i=0; i<clientThreadList.length; i++)
    {
      try
      {
        ((ConnectionToClient)clientThreadList[i]).sendToClient(msg);
      }
      catch (Exception ex) {}
    }
  }


// ACCESSING METHODS ------------------------------------------------

  final public boolean isListening()
  {
    return (connectionListener != null);
  }

  synchronized final public Thread[] getClientConnections()
  {
    Thread[] clientThreadList = new
      Thread[clientThreadGroup.activeCount()];

    clientThreadGroup.enumerate(clientThreadList);

    return clientThreadList;
  }

  final public int getNumberOfClients()
  {
    return clientThreadGroup.activeCount();
  }

  final public int getPort()
  {
    return port;
  }

  final public void setPort(int port)
  {
    this.port = port;
  }

  final public void setTimeout(int timeout)
  {
    this.timeout = timeout;
  }

  final public void setBacklog(int backlog)
  {
    this.backlog = backlog;
  }

// RUN METHOD -------------------------------------------------------

  final public void run()
  {
    serverStarted();

    try
    {
      while(!readyToStop)
      {
        try
        {
          Socket clientSocket = serverSocket.accept();

          synchronized(this)
          {
            ConnectionToClient c = new ConnectionToClient(
              this.clientThreadGroup, clientSocket, this);
          }
        }
        catch (InterruptedIOException exception)
        {
        	
        }
      }

      serverStopped();
    }
    catch (IOException exception)
    {
      if (!readyToStop)
      {
        listeningException(exception);
      }
      else
      {
        serverStopped();
      }
    }
    finally
    {
      readyToStop = true;
      connectionListener = null;
    }
  }


// METHODS DESIGNED TO BE OVERRIDDEN BY CONCRETE SUBCLASSES ---------


  protected void clientConnected(ConnectionToClient client) {}


  synchronized protected void clientDisconnected(
    ConnectionToClient client) {}


  synchronized protected void clientException(
    ConnectionToClient client, Throwable exception) {}

  protected void listeningException(Throwable exception) {}

  protected void serverStarted() {}

  protected void serverStopped() {}

  protected void serverClosed() {}

  protected abstract void handleMessageFromClient(
    Object msg, ConnectionToClient client);


// METHODS TO BE USED FROM WITHIN THE FRAMEWORK ONLY ----------------


  final synchronized void receiveMessageFromClient(
    Object msg, ConnectionToClient client)
  {
    this.handleMessageFromClient(msg, client);
  }
}
// End of AbstractServer Class
