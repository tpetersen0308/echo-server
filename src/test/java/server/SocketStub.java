package server;

import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class SocketStub extends Socket {
  private OutputStream outputStream;
  private InputStream inputStream;

  public SocketStub() {
    this.outputStream = new ByteArrayOutputStream();
    this.inputStream = new ByteArrayInputStream("echo".getBytes());
  }

  @Override
  public InputStream getInputStream() {
    return inputStream;
  }

  @Override
  public OutputStream getOutputStream() {
    return outputStream;
  }
}