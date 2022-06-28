public class Liaison extends Couche{
    @Override
    protected void recevoirUp(byte[] PDU) {
    envoyerDown(PDU);
    }

    @Override
    protected void recevoirDown(byte[] PDU) throws Exception {
        envoyerUp(PDU);
    }
}
