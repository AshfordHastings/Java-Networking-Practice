import java.net.*;
import java.io.*;
import java.util.*;
 
/**
 * This program demonstrates a simple TCP/IP socket client.
 *
 * @author www.codejava.net
 */
public class TimeClient {
 
    public static void main(String[] args) {
        if (args.length < 2) return;
 
        String hostname = args[0];
        int port = Integer.parseInt(args[1]);
 
        try (Socket socket = new Socket(hostname, port)) {
 
            DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToServer = new DataOutputStream(socket.getOutputStream());

            System.out.println("Enter radius: ");
            Scanner console = new Scanner(System.in);
            double radius = Double.parseDouble(console.nextLine());

            outputToServer.writeDouble(radius);
            outputToServer.flush();

            double area = inputFromServer.readDouble();
            System.out.println("Area of circle: " + area);




           // BufferedReader reader = new BufferedReader(new InputStreamReader(input));
 
           // String time = reader.readLine();
 
           // System.out.println(time);
 
 
        } catch (UnknownHostException ex) {
 
            System.out.println("Server not found: " + ex.getMessage());
 
        } catch (IOException ex) {
 
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}