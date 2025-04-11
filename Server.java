
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5050); //just accepting request don't process it
            Socket socket = serverSocket.accept(); //for process request and also used to send data

            while (true) {
                Scanner sc = new Scanner(System.in);
                DataInputStream din = new DataInputStream(socket.getInputStream());
                String data = din.readUTF();
                System.out.println(data);

                if (data.trim().endsWith("bye")) {
                    break;
                }

                DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                System.out.print("Server: ");
                String message = sc.nextLine();
                dout.writeUTF("Server : " + message);

                sc.close();
            }
            serverSocket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
