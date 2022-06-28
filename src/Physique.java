import java.io.*;
import java.net.*;

public class Physique extends Couche {
    InetAddress address = null;

    protected PhysicalThread threadPerso;

    int port = 0;


    public Physique(String address, int port) throws IOException {
        this.address = InetAddress.getByName(address);
        this.port = port;
        this.threadPerso = new PhysicalThread(this,port);
    }

    public void start() {
        threadPerso.running = true;
        threadPerso.start();
    }

    public void setPort(int port){
        this.port = port;
    }

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
            Thread.sleep(5);
        }catch (IOException | InterruptedException error){

        }
    }

    @Override
    protected void recevoirDown(byte[] PDU) throws Exception {
        envoyerUp(PDU);
    }
}