import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        DataOutputStream out;
        try (ServerSocket server = new ServerSocket(8282)){
            System.out.println("Staring...");
            System.out.println("W8 fo client...");
            Socket socket = server.accept();
            System.out.println("Connected");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            String line = "";
            while (!line.equals("HVATET!")) {
                try {
                    line = dataInputStream.readUTF();
                    System.out.println("Mesedg prinyat, beckaiy...");
                    out.writeUTF("kek");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Diablo II Disconnected");
            dataInputStream.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}