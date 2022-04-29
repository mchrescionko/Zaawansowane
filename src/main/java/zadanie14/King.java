package zadanie14;

public class King extends Citizen{
    public King(String imie) {
        super(imie);
    }

    @Override
    public boolean canVote() {
        return false;
    }
}
