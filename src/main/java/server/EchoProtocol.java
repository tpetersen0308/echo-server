package server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class EchoProtocol {
  Client client;

  public EchoProtocol(Client client) {
    this.client = client;
  }

  public void execute() {
    try {
      PrintWriter out = client.getOutputStreamWriter();
      BufferedReader in = client.getInputStreamReader();
      out.println(in.readLine());
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}