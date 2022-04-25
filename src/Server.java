import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Write you name");
            final String name = in.readLine();
            //System.out.println(1);
            out.println("Are you child? (yes/no)");
            String areYouChild = in.readLine();
            if (areYouChild.equalsIgnoreCase("yes")) {
                out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
            } else if (areYouChild.equalsIgnoreCase("no")) {
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            } else {
                out.println("Incorrect answer!");
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}