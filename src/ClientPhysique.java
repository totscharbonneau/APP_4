//import java.net.*;
//
//
//public class ClientPhysique extends Couche{
//
//    InetAddress address = null;
//
//    public void setAddressDestination(InetAddress address) {
//        this.address = address;
//    }
//    // get a datagram socket
//    DatagramSocket socket = new DatagramSocket();
//
//    // send request
//    byte[] buf = new byte[256];
//
//    DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
//        socket.send(packet);
//
//    // get response
//    packet = new DatagramPacket(buf, buf.length);
//        socket.receive(packet);
//
//    // display response
//    String received = new String(packet.getData(), 0, packet.getLength());
//
//    public ClientPhysique() throws SocketException {
//    }
//
//    @Override
//    protected void recevoirUp(byte[] PDU) {
//
//    }
//
//    @Override
//    protected void recevoirDown(byte[] PDU) throws Exception {
//
//    }
//        System.out.println("Quote of the Moment: " + received);
//
//        socket.close();
//}
