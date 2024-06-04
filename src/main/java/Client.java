import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static String localhost = "127.0.0.1";

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(localhost, Server.port);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {
            out.println("GET / HTTP/1.1\n" +
                    "Host: netology.ru\n\n\n");
            String resp = in.readLine();
            System.
                    out.println(resp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
