package server;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EchoClient {
  Socket socket;
  private BufferedReader inputStreamReader;
  private PrintWriter outputStreamWriter;

  public EchoClient(Socket socket) throws IOException {
    this.socket = socket;
    this.inputStreamReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    this.outputStreamWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
  }

  public BufferedReader getInputStreamReader() {
    return inputStreamReader;
  }

  public PrintWriter getOutputStreamWriter() {
    return outputStreamWriter;
  }
}