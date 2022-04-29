package enumy;

public enum Strona {

    POLNOC(0, 0), POLUDNIE(180), WSCHOD(90), ZACHOD(270);
    private int degrees;
    private int degrees2;

    Strona(int degrees) {
        this.degrees = degrees;
    }
    Strona(int degrees, int degrees2) {
        this.degrees = degrees;
        this.degrees2 = degrees2;
    }

    public int getDegrees() {
        return degrees;
    }
}

