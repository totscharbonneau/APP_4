import java.io.*;

public class ClientUnique {
    String filename;
    Application App;

    Physique physique;

    public ClientUnique(String filename, String ip_destination) throws IOException{
        this.filename = filename;
        ClientUniqueBuild(ip_destination);
    }

    public void ClientUniqueBuild(String ip_destination) throws IOException {
        App = new Application();
        Transport transport = new Transport();
        Liaison liaison = new Liaison();
        physique = new Physique(ip_destination,25000);
        App.setDownCouche(transport);
        transport.setUpCouche(App);
        transport.setDownCouche(liaison);
        liaison.setUpCouche(transport);
        liaison.setDownCouche(physique);
        physique.setUpCouche(liaison);

    }

    public void Start() throws IOException{
        System.out.println("Client Start");
        physique.start();
        App.envoyerFichier(filename);

    }
}
