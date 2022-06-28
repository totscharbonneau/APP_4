import java.io.*;
import java.net.*;
import java.util.*;

public class PhysiqueClient extends Couche {
    InetAddress address = null;


    protected PhysicalThread threadPerso;


    public PhysiqueClient(String address) throws IOException {
        this.address = InetAddress.getByName(address);
        this.threadPerso = new PhysicalThread(this);
    }




//    public static void main(String[] args) throws IOException {
//
//        if (args.length != 1) {
//            System.out.println("Usage: java QuoteClient <hostname>");
//            return;
//        }
//
//        // get a datagram socket
//        DatagramSocket socket = new DatagramSocket();
//
//        // send request
//        byte[] buf = new byte[256];
//        InetAddress address = InetAddress.getByName(args[0]);
//        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
//        socket.send(packet);
//
//        // get response
//        packet = new DatagramPacket(buf, buf.length);
//        socket.receive(packet);
//
//        // display response
//        String received = new String(packet.getData(), 0, packet.getLength());
//        System.out.println("Quote of the Moment: " + received);
//
//        socket.close();
//    }
//    public void ajouterTread() throws IOException {
//       threadPerso = new PhysicalThread(this);
//    }

    @Override
    protected void recevoirUp(byte[] PDU) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
        } catch (SocketException error) {
        }
        DatagramPacket packet = new DatagramPacket(PDU, PDU.length, address, 4445);

        try {
            socket.send(packet);
            Thread.sleep(50);
        }catch (IOException | InterruptedException error){

        }
    }

    @Override
    protected void recevoirDown(byte[] PDU) throws Exception {
        envoyerUp(PDU);
    }
}