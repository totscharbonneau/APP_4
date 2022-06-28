public abstract class Couche {

    protected Couche upCouche;
    protected Couche downCouche;

    public void setUpCouche(Couche upCouche){
        this.upCouche = upCouche;
    }

    public void setDownCouche(Couche downCouche) {
        this.downCouche = downCouche;
    }

    protected abstract void recevoirUp(byte[] PDU);

    protected void envoyerUp(byte[] PDU) throws Exception {
        upCouche.recevoirDown(PDU);
    }

    protected abstract void recevoirDown(byte[] PDU) throws Exception;

    protected void envoyerDown(byte[] PDU) {
        downCouche.recevoirUp(PDU);
    }
}
