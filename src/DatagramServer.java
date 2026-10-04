import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramServer {
    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket();
        String msg ="haha";
        InetAddress ip = InetAddress.getByName("localhost");

        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(),msg.length(),ip,5000);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
