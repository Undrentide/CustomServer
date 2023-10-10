import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8282);
             DataInputStream input = new DataInputStream(System.in);
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())){
            System.out.println("Connected");
            String line = "";
            while (!line.equals("HVATET!")) {
                try {
                    line = input.readLine();
                    out.writeUTF(line);
                    String incoming = dataInputStream.readUTF();
                    if (incoming.equals("HVATET!")) {
                        System.out.println("Atybaus((");
                    } else {
                        System.out.println(incoming);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}