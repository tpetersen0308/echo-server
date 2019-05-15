package server;

import server.EchoProtocol;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

public class EchoProtocolTest {
  @Test
  public void itEchosBackInputStreamMessages() {
    BufferedReader in = new BufferedReader(new StringReader("echo"));
    OutputStream bytesOut = new ByteArrayOutputStream();
    PrintWriter out = new PrintWriter(new OutputStreamWriter(bytesOut), true);
    EchoProtocol echoProtocol = new EchoProtocol(in, out);
    echoProtocol.execute();
    assertEquals("echo\n", bytesOut.toString());
  }
}
