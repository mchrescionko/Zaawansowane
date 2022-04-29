package enumy;

public class Drogowskaz {

    private Strona strona;

    public Drogowskaz(Strona strona) {
        this.strona = strona;
    }

    public String toString(){
        return strona.toString();
    }

    public Strona getStrona() {
        return strona;
    }
}
