package server;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class EchoClient {
  Socket socket;

  public EchoClient(Socket socket) {
    this.socket = socket;
  }

  public BufferedReader createInputStreamReader() throws IOException {
    return new BufferedReader(new InputStreamReader(socket.getInputStream()));
  }

  public PrintWriter createOutputStreamWriter() throws IOException {
    return new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
  }
}