import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


public class Application extends Couche{

    Transport coucheInferieur = null;
    private byte[] fichierBytes;
    private String fichierRef = "one-liners.txt";
    public Application() throws IOException
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

    @Override
    protected void recevoirDown(byte[] PDU) throws Exception {
        String titre = new String(Arrays.copyOfRange(PDU, 0, 200), StandardCharsets.US_ASCII).trim();
        byte[] infoPDU = Arrays.copyOfRange(PDU, 200, PDU.length);
        try {
            String pathFichier = new File("").getAbsolutePath();
            File fichierNouv = new File(pathFichier+ "/output/"+ titre);
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
