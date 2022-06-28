import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class ClientApplication extends Couche{

    ClientTransport coucheInferieur = null;
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

    public void envoyerFichier(String filein) throws IOException{
        File file = new File(filein);

        byte[] filename = file.getName().getBytes();
        Path pathFichier = file.toPath();
        byte[] fileBytes = Files.readAllBytes(pathFichier);
        byte[] test;
        test = new byte[190 + fileBytes.length];

        for(int i = 0; i < filename.length;i++){
            test[i] = filename[i];
        }
        for(int i = 190; i < fileBytes.length;i++){
            test[i] = fileBytes[i];
        }
        downCouche.recevoirUp(test);
    }

    @Override
    public void recevoirUp(byte[] Data) {
        return;
    }
}
