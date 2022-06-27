import java.net.*;
import java.io.*;


public class PhysiqueClient {

    // get a datagram socket
    DatagramSocket socket = new DatagramSocket();

    // send request
    byte[] buf = new byte[256];
    InetAddress address = InetAddress.getByName(args[0]);
    DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
        socket.send(packet);

    // get response
    packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

    // display response
    String received = new String(packet.getData(), 0, packet.getLength());

    public PhysiqueClient() throws SocketException {
    }
        System.out.println("Quote of the Moment: " + received);

        socket.close();
}
