import java.io.*;
import java.net.*;
import java.util.*;

public class PhysicalThread extends Thread {

    protected DatagramSocket socket = null;
    protected BufferedReader in = null;
    protected boolean running = true;

    private PhysiqueClient parent;

    public PhysicalThread(PhysiqueClient parent) throws IOException {
        super("Physical Thread");
        socket = new DatagramSocket(4445);
        this.parent = parent;
    }

    public void run() {

        while(running){
            try {
                byte[] buf = new byte[256];

                // receive request
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                parent.recevoirDown(packet.getData());

//                // figure out response
//                String dString = null;
//                if (in == null)
//                    dString = new Date().toString();
//                else
//                    dString = getNextQuote();
//
//                buf = dString.getBytes();
//
//                // send the response to the client at "address" and "port"
//                InetAddress address = packet.getAddress();
//                int port = packet.getPort();
//                packet = new DatagramPacket(buf, buf.length, address, port);
//                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
                running = false;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        socket.close();
    }
}