import java.io.DataInputStream;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost",5000);

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        String msg = dataInputStream.readUTF();

        System.out.println("Server sent :"+msg);


    }
}
