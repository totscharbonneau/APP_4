import java.util.Arrays;

import static java.lang.System.arraycopy;

public class ClientTransport extends Couche{

    private int letterOffset = 1;
    private int positionOffset = 6;
    private int tailleOffset = 3;

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
            }
            else{
                arraycopy(Data, i * 190, PDU[i], Offset , Data.length%190);
                PDU[i][0] = (byte) 'e'; // code fin
            }


        }



    }
}
