package server;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class Server {
  public static void main(String[] args) throws IOException {
    int port = Integer.parseInt(args[0]);
    start(port);
  }

  private static void start(int port) throws IOException {
    ServerSocket serverSocket = new ServerSocket(port);
    Socket clientSocket = serverSocket.accept();
    EchoClient client = new EchoClient(clientSocket);
    EchoProtocol protocol = new EchoProtocol(client);
    protocol.execute();
    serverSocket.close();
  }
}