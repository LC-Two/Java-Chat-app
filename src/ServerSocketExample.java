import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample {
    public static void main(String[] args)throws Exception{
        ServerSocket serverSocket = new ServerSocket(5000);
        Socket socket = serverSocket.accept();

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        dataOutputStream.writeUTF("Yooo!!");
        dataOutputStream.flush();
        dataOutputStream.close();

    }
}
