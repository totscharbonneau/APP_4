import java.util.Arrays;

public class ClientTransport extends Couche{


    @Override
    public void recevoirUp(byte[] Data) {
        int nbPackets = (int) Math.ceil(Data.length/200);



    }
}
