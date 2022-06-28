import java.io.*;
import java.net.*;

public class PhysicalThread extends Thread {

    protected DatagramSocket socket = null;
    protected BufferedReader in = null;
    protected boolean running = true;

    private Physique parent;

    public PhysicalThread(Physique parent,int port) throws IOException {
        super("Physical Thread");
        socket = new DatagramSocket(port);
        this.parent = parent;
    }

    public void run() {

        while(running){

            try {
                byte[] buf = new byte[200];

                // receive request
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                parent.recevoirDown(packet.getData());

            } catch (IOException e ) {
                running = false;
                socket.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        socket.close();
    }
}