package zadanie14;

import zaawansowane.Car;

public class Peasant extends Citizen {
    public Peasant(String imie) {
        super(imie);

    }

    @Override
    public boolean canVote(){
        return false;
    };
}
