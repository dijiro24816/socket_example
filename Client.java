import java.io.*;
import java.net.*;

public class Client {
    static String req = "GET / HTTP/1.0\r\n"
                      + "Host: www.google.com\r\n"
                      + "Connection: close\r\n"
                      + "\r\n";
    public static void main(String[] args) throws UnknownHostException, IOException {
        // www.google.com 172.217.25.164
        InetAddress addr = InetAddress.getByName("www.google.com");
        Socket sock = new Socket(addr, 80);

        PrintWriter out = new PrintWriter(sock.getOutputStream());
        InputStream in = sock.getInputStream();

        out.print(req);
        out.flush();

        BufferedWriter w = new BufferedWriter(new FileWriter("index.html"));
        int ch;
        while ((ch = in.read()) > 0) {
            w.write(ch);
        }
    }

}