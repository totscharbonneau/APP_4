import java.io.*;

public class ClientUnique {
    String filename;
    ClientApplication App;

    public ClientUnique(String filename, String ip_destination) throws IOException{
        this.filename = filename;
        ClientUniqueBuild(ip_destination);
    }

    public void ClientUniqueBuild(String ip_destination) throws IOException {
        App = new ClientApplication();
        ClientTransport transport = new ClientTransport();
        ClientLiaison liaison = new ClientLiaison();
        App.setDownCouche(transport);
        transport.setUpCouche(App);
        transport.setDownCouche(liaison);
        liaison.setUpCouche(transport);

    }

    public void Start() throws IOException{
        App.envoyerFichier(filename);
    }
}
