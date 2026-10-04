import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramClient {
    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(5000);
        byte[] buffer = new byte[1024];

        DatagramPacket datagramPacket = new DatagramPacket(buffer,buffer.length);
        datagramSocket.receive(datagramPacket);

        String msg = new String(datagramPacket.getData(),0,datagramPacket.getLength());
        System.out.println(msg);

        datagramSocket.close();
    }
}
