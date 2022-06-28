import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ServerApplication extends Couche{
    @Override
    protected void recevoirUp(byte[] PDU){}

    @Override
    protected void recevoirDown(byte[] PDU){
        String titre = new String(Arrays.copyOfRange(PDU, 0, 200), StandardCharsets.US_ASCII).trim();
        byte[] infoPDU = Arrays.copyOfRange(PDU, 200, PDU.length);
        try {
            String pathFichier = new File("").getAbsolutePath();
            File fichierNouv = new File(pathFichier + titre);
            if(fichierNouv.exists())
                fichierNouv.delete();
            try (FileOutputStream fos = new FileOutputStream(fichierNouv.getPath())) {
                fos.write(infoPDU);
            }
        } catch (Exception e) {
            System.out.println("Erreur dans ls creation du fichier");
            e.printStackTrace();
        }
    }

}
