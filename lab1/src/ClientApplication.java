import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ClientApplication {
    private byte[] fichierBytes;
    private String fichierRef = "one-liners.txt";
    public ClientApplication() throws IOException
    {
        File fichier = new File(fichierRef);
        FileInputStream fichierStream = new FileInputStream(fichier);
        fichierBytes = new byte[(int)fichier.length()];
        fichierStream.read(fichierBytes);
        fichierStream.close();
    }
}
