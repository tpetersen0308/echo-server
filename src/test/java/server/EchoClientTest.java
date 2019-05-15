package server;

import server.EchoClient;
import static org.junit.Assert.*;
import org.junit.Test;
import java.net.Socket;
import java.io.*;

class SocketStub extends Socket {
  private OutputStream outputStream;

  public SocketStub() {
    this.outputStream = new ByteArrayOutputStream();
  }

  @Override
  public InputStream getInputStream() {
    return new ByteArrayInputStream("echo".getBytes());
  }

  @Override
  public OutputStream getOutputStream() {
    return outputStream;
  }
}

public class EchoClientTest {
  @Test
  public void canRead() throws IOException {
    SocketStub socket = new SocketStub();
    EchoClient client = new EchoClient(socket);
    BufferedReader reader = client.createInputStreamReader();
    assertEquals("echo", reader.readLine());
  }

  @Test
  public void canWrite() throws IOException {
    SocketStub socket = new SocketStub();
    EchoClient client = new EchoClient(socket);

    PrintWriter writer = client.createOutputStreamWriter();
    writer.println("echo");
    assertEquals("echo\n", socket.getOutputStream().toString());
  }
}