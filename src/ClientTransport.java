import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.lang.System.arraycopy;
import static java.util.Arrays.fill;

public class ClientTransport extends Couche{

    private int letterOffset = 1;
    private int positionOffset = 6;
    private int tailleOffset = 3;

    private byte[] positionHeader = new byte[positionOffset];

    private byte[] tailleHeader = new byte[tailleOffset];
    private int Offset = letterOffset + positionOffset +tailleOffset;
    private byte[][] PDU;
    @Override
    public void recevoirUp(byte[] Data) {
        int nbPackets = (int) Math.ceil(Data.length/190);

        PDU = new byte[nbPackets][200];

        for (int i = 0; i < nbPackets; i ++){
            if( i != nbPackets-1){
                arraycopy(Data, i * 190, PDU[i], Offset , 190);
                if (i == 0) {
                    PDU[i][0] = (byte) 's'; // code debut
                }
                //            Header de la taille
                fill(tailleHeader,(byte) '0');
                byte[] byteTaille = Integer.toString(190).getBytes(StandardCharsets.US_ASCII);
                arraycopy(byteTaille,0,tailleHeader,tailleOffset-byteTaille.length,byteTaille.length);
                arraycopy(tailleHeader,0,PDU[i],letterOffset+positionOffset,tailleOffset);
            }
            else{
                arraycopy(Data, i * 190, PDU[i], Offset , Data.length%190);
                PDU[i][0] = (byte) 'e'; // code fin
                //            Header de la taille
                fill(tailleHeader,(byte) '0');
                byte[] byteTaille = Integer.toString(Data.length%190).getBytes(StandardCharsets.US_ASCII);
                arraycopy(byteTaille,0,tailleHeader,tailleOffset-byteTaille.length,byteTaille.length);
                arraycopy(tailleHeader,0,PDU[i],letterOffset+positionOffset,tailleOffset);
            }
//            Header de la position
            fill(positionHeader, (byte) 0);
            byte[] byteI = (Integer.toString(i)).getBytes(StandardCharsets.US_ASCII);
            arraycopy(byteI,0,positionHeader,positionOffset- byteI.length,byteI.length);
            arraycopy(positionHeader,0,PDU[i],letterOffset,positionOffset);

            envoyerDown(PDU[i]);
        }
        System.out.println("fin de la transmission de tout les packets packets.");
    }

    @Override
    protected void recevoirDown(byte[] PDU) throws Exception {

    }
}
