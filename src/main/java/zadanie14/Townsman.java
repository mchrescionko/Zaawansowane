package zadanie14;

public class Townsman extends Citizen{


    public Townsman(String imie) {
        super(imie);
    }

    @Override
    public boolean canVote() {
        return true;
    }
}
