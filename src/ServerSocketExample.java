import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketExample {
    public static void main(String[] args)throws Exception{
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server Listening at 5000....");

        Socket socket = serverSocket.accept();
        System.out.println("Connection Established");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        Thread receiveThread = new Thread(() ->{
           try{
                while(true){
                    String msg = dataInputStream.readUTF();
                    System.out.println("Client:"+msg);
                }
           }
           catch (Exception e){
               System.out.println("Client Disconnected.");
               System.exit(0);
           }
        });
        receiveThread.start();

        while(true){
            String myMsg = scanner.nextLine();
            dataOutputStream.writeUTF(myMsg);
            dataOutputStream.flush();
        }

//        dataOutputStream.writeUTF("Yooo!!");
//        dataOutputStream.flush();
//        dataOutputStream.close();

    }
}
