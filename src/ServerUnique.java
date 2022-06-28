import java.io.*;

public class ServerUnique {

    int port;

    Physique physique;

    public ServerUnique(int port) throws IOException {
        this.port = port;
        ServerUniqueBuild(port);
    }

    public void ServerUniqueBuild(int port) throws IOException {
        physique = new Physique("localhost",port);
        Liaison liaison = new Liaison();
        Transport transport = new Transport();
        physique.setUpCouche(liaison);
        liaison.setDownCouche(physique);
        liaison.setUpCouche(transport);
        transport.setDownCouche(liaison);
    }

    public void Start(){
        System.out.println("Server running");
        physique.start();
    }
}
