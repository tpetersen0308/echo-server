package server;

import server.EchoProtocol;
import server.Client;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.net.Socket;

class SocketStub extends Socket {
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

public class EchoProtocolTest {
  @Test
  public void shouldEchoBackInputStreamMessages() throws IOException {
    Socket socket = new SocketStub();
    Client client = new Client(socket);
    EchoProtocol echoProtocol = new EchoProtocol(client);
    echoProtocol.execute();
    assertEquals("echo\n", socket.getOutputStream().toString());
  }
}
