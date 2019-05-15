package server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class EchoProtocol {
  BufferedReader in;
  PrintWriter out;

  public EchoProtocol(BufferedReader in, PrintWriter out) {
    this.in = in;
    this.out = out;
  }

  public void execute() {
    try {
      out.println(in.readLine());
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}