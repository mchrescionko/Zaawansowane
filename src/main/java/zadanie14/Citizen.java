package zadanie14;

public abstract class Citizen {

    private String imie;

    public Citizen(String imie) {
        this.imie = imie;
    }

    public abstract boolean canVote();

    public String toString(){
        return imie;
    }


}
