package server;

import server.SocketStub;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.IOException;

public class EchoProtocolTest {
  @Test
  public void shouldEchoBackInputStreamMessages() throws IOException {
    SocketStub socket = new SocketStub();
    Client client = new Client(socket);
    EchoProtocol echoProtocol = new EchoProtocol(client);
    echoProtocol.execute();
    assertEquals("echo\n", socket.getOutputStream().toString());
  }
}
