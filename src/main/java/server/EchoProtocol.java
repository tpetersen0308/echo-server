package server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class EchoProtocol {
  Client client;
  PrintWriter out;
  BufferedReader in;

  public EchoProtocol(Client client) {
    this.client = client;
    this.out = client.getOutputStreamWriter();
    this.in = client.getInputStreamReader();
  }

  public void execute() {
    try {
      String clientMessage;
      while ((clientMessage = in.readLine()) != null) {
        out.println(clientMessage);
      }
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}