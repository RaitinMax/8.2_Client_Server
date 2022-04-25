import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket("netology.homework", 8080);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println(in.readLine());
            out.println("Maxim");
            System.out.println(in.readLine());
            out.println("no");
            System.out.println(in.readLine());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}