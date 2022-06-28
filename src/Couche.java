public abstract class Couche {

    protected Couche upCouche;
    protected Couche downCouche;

    public void setUpCouche(Couche upCouche){
        this.upCouche = upCouche;
    }

    public void setDownCouche(Couche downCouche) {
        this.downCouche = downCouche;
    }

    public abstract void recevoirUp(byte[] Data);
}
