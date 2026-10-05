import javax.sound.sampled.ReverbType;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost",5000);
        System.out.println("Connected to Server");

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        Scanner scanner = new Scanner(System.in);

        Thread receiverThread = new Thread(()->{
            try{
                while(true) {
                    String msg = dataInputStream.readUTF();
                    System.out.println("Server:" + msg);
                }
            }
            catch (Exception e){
                System.out.println("Server Disconnected.");
                System.exit(0);
            }
        });
        receiverThread.start();

        while(true){
            String myMsg = scanner.nextLine();
            dataOutputStream.writeUTF(myMsg);
            dataOutputStream.flush();
        }


//        String msg = dataInputStream.readUTF();

//        System.out.println("Server sent :"+msg);


    }
}
