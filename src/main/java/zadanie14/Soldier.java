package zadanie14;

public class Soldier extends Citizen{
    public Soldier(String imie) {
        super(imie);
    }

    @Override
    public boolean canVote() {
        return true;
    }
}
